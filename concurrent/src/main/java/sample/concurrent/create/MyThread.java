package sample.concurrent.create;

/**
 * Created by mzxiao on 2020/7/24 15:51
 */
public class MyThread extends Thread {
    public static void main(String[] args) {

        System.out.println("main thread id is "+Thread.currentThread().getId());
        MyThread thread = new MyThread();
//        thread.run();
        thread.start();

    }

    @Override
    public void run() {
        System.out.println("MyThread thread id is "+Thread.currentThread().getId());
    }
}
