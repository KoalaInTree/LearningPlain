package com.dj.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest {

    public static void test1() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(System.currentTimeMillis() + "runAsync start");
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "runAsync end");
            return 1;
        });
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(System.currentTimeMillis() + "runAsync2 start");
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "runAsync2 end");
            return 2;
        });

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(
                future, future1);
        Object unused = voidCompletableFuture.get(4, TimeUnit.SECONDS);
        System.out.println(unused);

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        test1();
    }
}
