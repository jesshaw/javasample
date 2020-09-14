package com.lexiangmiao.sample.container.map;

/**
 * Created by mzxiao on 2020/8/14 13:42
 * 图表树 https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
 */
public class HashMap<K, V> implements Map<K, V> {
    int size = 0;
    Entry<K, V> table[] = null;

    public HashMap() {
        table = new Entry[16];
    }

    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            table[index] = new Entry<>(k, v, null, index);
            size++;
        } else {
            table[index] = new Entry<>(k, v, entry, index);
        }
        return table[index].getValue();
    }

    private int hash(K k) {
        int index = k.hashCode() % 16;
        return index > 0 ? index : -index;
    }

    @Override
    public V get(K k) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (entry == null || size == 0) {
            return null;
        }
        return find(k, entry);
    }

    private V find(K k, Entry<K, V> entry) {
        if (k.equals(entry.getKey())) {
            return entry.getValue();
        } else {
            if (entry.next != null) {
                return find(k, entry.next);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K, V> implements Map.Entry<K, V> {
        int hash;
        K k;
        V v;
        Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next, int hash) {
            this.hash = hash;
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
