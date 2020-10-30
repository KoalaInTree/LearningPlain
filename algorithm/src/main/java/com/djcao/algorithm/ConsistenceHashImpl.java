package com.djcao.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/27
 */
public class ConsistenceHashImpl<V> implements ConsistenceHash<V>{
    private final TreeMap<Integer, V> nodeMapping = new TreeMap<>();
    private static final Integer MAX_SLOT = Double.valueOf(Math.pow(2,32)).intValue();
    @Override
    public void addNode(Long nodeId, V s) {
        nodeMapping.put(getHash(nodeId), s);
    }

    @Override
    public V getNode(Long key) {
        int hash = getHash(key);
        Map.Entry<Integer, V> integerVEntry = nodeMapping.ceilingEntry(hash);
        return integerVEntry == null ? nodeMapping.firstEntry().getValue() :
            integerVEntry.getValue();
    }

    @Override
    public V removeNode(Long nodeId) {
        return nodeMapping.remove(getHash(nodeId));
    }

    private int getHash(Long nodeId) {
        int hash = Objects.hash(nodeId);
        if (hash > MAX_SLOT) {
            hash = hash % MAX_SLOT;
        }
        return hash;
    }

    public static void main(String[] args) {
        ConsistenceHash<String> consistenceHash = new ConsistenceHashImpl<>();
        consistenceHash.addNode(1L, "a");
        consistenceHash.addNode(2L, "b");
        consistenceHash.addNode(3L, "c");
        consistenceHash.addNode(4L, "d");

        System.out.println(consistenceHash.getNode(3L));
    }
}
