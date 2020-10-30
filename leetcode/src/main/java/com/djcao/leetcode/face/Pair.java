package com.djcao.leetcode.face;

import java.util.Objects;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/22
 */
public class Pair<K,V> {
    private K k;

    private V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(k, pair.k) &&
            Objects.equals(v, pair.v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(k, v);
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
