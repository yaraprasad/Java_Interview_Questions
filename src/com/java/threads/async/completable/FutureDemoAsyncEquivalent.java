package com.java.threads.async.completable;

import java.util.concurrent.*;

public class FutureDemoAsyncEquivalent {

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            System.out.println("main method() : Executed by thread : "+Thread.currentThread().getName());

            long startTime = System.currentTimeMillis();
            FutureDemoAsyncEquivalent futureDemo = new FutureDemoAsyncEquivalent();
           // String firstName = futureDemo.getFirstName(); //blocking call consumes 2 secs -- execute as async

            //Anonymous inner classes
            Callable<String> firstName= new Callable<String>() {
                @Override
                public String call() throws Exception {
                System.out.println("getFirstName() : Executed by thread : "+Thread.currentThread().getName());
                    return futureDemo.getFirstName();
                }
            };
            // Lambda expression
            //Callable<String> firstName = futureDemo::getFirstName;

            //Anonymous inner classes
            //String lastName = futureDemo.getLastName(); //blocking call consumes 2 secs -- execute as async
            Callable<String> lastName = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("getLastName() : Executed by thread : "+Thread.currentThread().getName());
                    return futureDemo.getLastName();
                }
            };

            // Lambda expression
            //Callable<String> lastName = futureDemo::getLastName;

            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Future<String> firstNameFuture = executorService.submit(firstName);
            Future<String> lastNameFuture = executorService.submit(lastName); //code with async callable parallel.

            System.out.println("main method() 1 : Executed by thread : "+Thread.currentThread().getName());
            String completeName = firstNameFuture.get()+" "+lastNameFuture.get(); //again  2 blocking here ---> get is blocking
            System.out.println("main method() 2 : Executed by thread : "+Thread.currentThread().getName());

            System.out.println(completeName);
            System.out.println("time taken to execute these tasks : "+(System.currentTimeMillis()-startTime)+" ms");


            //Imagine a situation, if this line result we will get in 1 sec, even
            // before the previous line completes it's execution, still we have to wait
            // here to complete the line 63 execution.
            // as it's blocking in nature (get())
        }

        public String getFirstName(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  "Prasad";
        }

        public String getLastName(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  "Yara";
        }


    //CompletableFuture Approach



    //Output:
    //
//            main method() : Executed by thread : main
//            main method() 1 : Executed by thread : main
//            getFirstName() : Executed by thread : pool-1-thread-1
//            getLastName() : Executed by thread : pool-1-thread-2
//            main method() 2 : Executed by thread : main
//            Prasad Yara
//            time taken to execute these tasks : 2041 ms

    //Compare FutureDemo and FutureDemoAsyncEquivalent classes
}
