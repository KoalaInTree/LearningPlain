package com.djcao.algorithm;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/27
 */
public interface ConsistenceHash<V> {
    void addNode(Long nodeId,V v);

    V getNode(Long key);

    V removeNode(Long nodeId);
}
