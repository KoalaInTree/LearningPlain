package com.dj.kafka;

import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.utils.Utils;

public class KafkaUtils {
    // topic所拥有的partition总数
    private static final int PARTITION_NUMS = 20;

    public static void main(String[] args) {
        cal_partitionForKey();
    }
    /**
     * 1. 指定了Key，通过以下算法获取partition
     * 2. 没有指定Key，使用轮询
     */
    public static void cal_partitionForKey() {
        StringSerializer serializer = new StringSerializer();
        byte[] bytes = serializer.serialize("cdj", "50");
        int partition = toPositive(Utils.murmur2(bytes)) % PARTITION_NUMS;
        System.out.println(partition);
    }
  
    private static int toPositive(int number) {
        return number & 0x7fffffff;
    }
}