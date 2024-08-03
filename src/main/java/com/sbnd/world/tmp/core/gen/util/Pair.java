package com.sbnd.world.tmp.core.gen.util;

import lombok.Getter;

// Because the normal one doesn't work for some reason
@Getter
public class Pair<K, V> {

    private final K key;
    private final V value;

    public Pair(K key, V value) {

        this.key = key;
        this.value = value;

    }

}