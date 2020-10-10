package com.lexiangmiao.sample.seckill;

//@SpringBootApplication
//@RestController
public class SeckillApp {
    public static void main(String[] args) {
//        SpringApplication.run(SeckillApp.class, args);
        int i = 1;
        i = i++;
        int j = i++;
        System.out.println(i);
        int k = i+ ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

//    @GetMapping("/seckill")
//    public String exeSeckill() {
//
//    }

}
