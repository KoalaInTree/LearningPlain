package com.djcao.algorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/20
 */
public class ProducerConsumer {
    static volatile int x = 1;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        long l = System.currentTimeMillis();
        Thread p = new Thread(() -> {
            int t = 100000;
            reentrantLock.lock();
            while (t > 0) {
                System.out.println("h");
                System.out.println("h");
                t--;
                if (t == 2) {
                  t=2;
                }
                condition.signalAll();
                getCondition(condition);
            }
            condition.signalAll();
            reentrantLock.unlock();
            System.out.println("A");
        },"p");
        Thread c = new Thread(() -> {
            int t = 100000;
            reentrantLock.lock();
            while (t > 0) {
                System.out.println("o");
                t--;
                if (t == 2) {
                    t=2;
                }
                condition.signalAll();
                getCondition(condition);
            }
            condition.signalAll();
            reentrantLock.unlock();
            System.out.println("B");
        },"c");

        p.start();
        c.start();
        p.join();
        c.join();
        System.out.println(System.currentTimeMillis() - l);
    }

    public static void getCondition(Condition condition) {
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
