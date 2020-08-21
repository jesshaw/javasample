package sample.concurrent.create;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mzxiao on 2020/7/24 16:17
 */
public class MyCallableThread implements Callable<String> {
    private final String s;

    public MyCallableThread(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int taskSize = 10;
        System.out.println("main thread id is " + Thread.currentThread().getId());
        MyCallableThread myRunnableThread = new MyCallableThread("s");
        ExecutorService executorService = Executors.newFixedThreadPool(taskSize);
        Future<String> future = executorService.submit(myRunnableThread);
        System.out.println(future.get());


        // multi return values
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallableThread(i + " ");
            Future f = executorService.submit(c);
            list.add(f);
        }
        executorService.shutdown();
        for (Future f : list) {
            System.out.println("res：" + f.get().toString());
        }
    }

    @Override
    public String call() throws Exception {
        System.out.println("MyCallableThread thread id is " + Thread.currentThread().getId());
        return s;
    }
}
