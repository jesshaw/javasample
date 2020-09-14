package com.lexiangmiao.sample.container.map;

/**
 * Created by mzxiao on 2020/8/14 14:05
 */
public class MapApp {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("张三","张三");
        map.put("李四","李四");
        map.put("王五","王五");
        map.put("Jes","Jes");
        System.out.println(map.get("Jes"));
    }
}
