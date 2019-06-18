package com.bbva.selenium;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(final String[] args) {
        final long startTime = System.currentTimeMillis();
        final String[] navegadores = {"chrome", "chrome", "chrome", "chrome", "chrome", "chrome"};
        final ExecutorService executor = Executors.newFixedThreadPool(navegadores.length);
        for (int i = 0; i < navegadores.length; i++) {
            final Runnable test = new TestRunnable(navegadores[i]);
            executor.execute(test);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("TOTAL --> Procesamiento total " + ((System.currentTimeMillis() - startTime) / 1000) + " segundos");
    }

}
