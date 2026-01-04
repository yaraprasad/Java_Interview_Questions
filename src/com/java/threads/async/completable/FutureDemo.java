package com.java.threads.async.completable;

public class FutureDemo {

    public static void main(String[] args) {
        FutureDemo futureDemo = new FutureDemo();
        String firstName = futureDemo.getFirstName();
        String lastName = futureDemo.getLastName();
        String completeName = firstName+" "+lastName;
        System.out.println(completeName);


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
}
