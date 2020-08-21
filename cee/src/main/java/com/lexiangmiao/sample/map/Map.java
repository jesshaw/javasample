package com.lexiangmiao.sample.map;

/**
 * Created by mzxiao on 2020/8/14 13:37
 */
public interface Map<K, V> {
    V put(K k, V v);

    V get(K k);

    int size();

    interface Entry<K, V> {
        K getKey();

        V getValue();
    }
}
