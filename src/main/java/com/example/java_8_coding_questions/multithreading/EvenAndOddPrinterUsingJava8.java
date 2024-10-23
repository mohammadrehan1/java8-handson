package com.example.java_8_coding_questions.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenAndOddPrinterUsingJava8 {

    private static Object object = new Object();

    private static IntPredicate eveIntPredicate = e -> e%2 == 0;
    private static IntPredicate oddIntPredicate = e -> e%2 != 0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenAndOddPrinterUsingJava8.printResults(oddIntPredicate));

        CompletableFuture.runAsync(() -> EvenAndOddPrinterUsingJava8.printResults(eveIntPredicate));

        Thread.sleep(1000);

    }

    public static void printResults(IntPredicate condition){
        IntStream.rangeClosed(1, 10)
                .filter(condition)
                .forEach(EvenAndOddPrinterUsingJava8::execute);
    }

    public static void execute(int i){

        synchronized (object) {

            try {
                System.out.println("Thread Name " + Thread.currentThread().getName() + " : " + i);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
