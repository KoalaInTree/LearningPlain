package com.dj.kafka;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.LongBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/29
 */
public class LogSegment {
    public class LogOffsetIndex{
        FileOutputStream fileOutputStream = new FileOutputStream("");
        FileChannel channel = fileOutputStream.getChannel();
        LongBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024).asLongBuffer();

        public LogOffsetIndex() throws IOException {}

        public class Pair{
            private Long offset;
            private Long position;

            public Long getOffset() {
                return offset;
            }

            public void setOffset(Long offset) {
                this.offset = offset;
            }

            public Long getPosition() {
                return position;
            }

            public void setPosition(Long position) {
                this.position = position;
            }
        }

        private Map<Long, Long> offsetMap = new HashMap<>();

        public void add(Long offset,Long position) throws IOException {
            offsetMap.put(offset, position);
            map.put(offset);
            map.put(position);
        }

        public void recover() {
            LongBuffer slice = map.slice();
            for (int i = 0; i < slice.capacity(); i+=2) {
                long l = slice.get(i);
                long l1 = slice.get(i + 1);
                offsetMap.put(l, l1);
            }
        }

        public Long search(Long offset) {
            return offsetMap.get(offset);
        }
    }

    public class LogTimeIndex{
        FileOutputStream fileOutputStream = new FileOutputStream("");
        FileChannel channel = fileOutputStream.getChannel();
        LongBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024).asLongBuffer();

        public LogTimeIndex() throws IOException {}

        public class Pair{
            private Long time;
            private Long position;

            public Long getTime() {
                return time;
            }

            public void setTime(Long time) {
                this.time = time;
            }

            public Long getPosition() {
                return position;
            }

            public void setPosition(Long position) {
                this.position = position;
            }
        }

        private TreeMap<Long, Long> timeMap = new TreeMap<>();

        public void add(Long time,Long position) throws IOException {
            timeMap.put(time, position);
            map.put(time);
            map.put(position);
        }

        public void recover() {
            LongBuffer slice = map.slice();
            for (int i = 0; i < slice.capacity(); i+=2) {
                long l = slice.get(i);
                long l1 = slice.get(i + 1);
                timeMap.put(l, l1);
            }
        }

        public Long search(Long time) {
            return timeMap.ceilingEntry(time).getValue();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {

    }
}
