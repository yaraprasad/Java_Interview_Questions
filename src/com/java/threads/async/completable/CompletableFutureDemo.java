package com.java.threads.async.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureDemo completableFuture = new CompletableFutureDemo();
        System.out.println("main() start : Executed by thread : "+Thread.currentThread().getName());
        /*CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("get() : Executed by thread : " + Thread.currentThread().getName());
                return completableFuture.getName();
            }
        });*/
        //Lambda expression
        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(completableFuture::getName);
        String value= stringCompletableFuture1.get();

        CompletableFuture.supplyAsync(completableFuture::getName)
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println);


       // String value= stringCompletableFuture2.get();

       // String value= stringCompletableFuture.join(); // stringCompletableFuture.get()
        System.out.println(value);
        System.out.println("main() end : Executed by thread : "+Thread.currentThread().getName());
        System.out.println("done");
        Thread.sleep(5000);
    }

    public String getName(){
        System.out.println("getName() : Executed by thread : "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return  "Prasad Yara";
    }

    //Output;
            //   main() start : Executed by thread : main
            //   getName() : Executed by thread : ForkJoinPool.commonPool-worker-1
            //   Prasad Yara
            //   main() end : Executed by thread : main
            //   done

}
