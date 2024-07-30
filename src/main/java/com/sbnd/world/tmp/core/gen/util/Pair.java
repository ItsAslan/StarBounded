package com.sbnd.world.tmp.core.gen.util;

// Because the normal one doesn't work for some reason
public class Pair<K, V> {

    private final K key;
    private final V value;

    public Pair(K key, V value) {

        this.key = key;
        this.value = value;

    }

    public K getKey() {

        return key;

    }

    public V getValue() {

        return value;

    }

}