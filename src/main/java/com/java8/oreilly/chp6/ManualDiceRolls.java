package com.java8.oreilly.chp6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ManualDiceRolls {
    private static final int N = 100000000;
    private final double fraction;
    private final Map<Integer,Double> results;
    private final int numberOfThreads;
    private final ExecutorService executor;
    private final int workPerThread;

    public static void main(String[] args) {
        ManualDiceRolls rolls = new ManualDiceRolls();
        rolls.simulateDiceRoles();
    }

    private void simulateDiceRoles() {
        List<Future<?>> futures = submitJobs();
        awaitCompletion(futures);
        printResults();
    }

    private void printResults() {
        results.entrySet().forEach(System.out::println);
    }

    private void awaitCompletion(List<Future<?>> futures) {
        futures.forEach(future -> {
            try {
                future.get();
            }catch (InterruptedException|ExecutionException e){
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }

    private List<Future<?>> submitJobs() {
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            futures.add(executor.submit(makeJob()));
        }
        return futures;
    }

    private Runnable makeJob() {
        return ()->{
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int i = 0; i < workPerThread; i++) {
                int entry = twoDiceThrows(random);
                accumulateResult(entry);
            }
        };
    }

    private void accumulateResult(int entry) {
        results.compute(entry,(key,previous)->previous==null? fraction:previous+fraction);
    }

    private int twoDiceThrows(ThreadLocalRandom random) {
        int firstThrow = random.nextInt(1,7);
        int secondThrow = random.nextInt(1,7);
        return firstThrow+secondThrow;
    }

    public ManualDiceRolls() {
        fraction = 1.0/N;
        results = new ConcurrentHashMap<>();
        numberOfThreads = Runtime.getRuntime().availableProcessors();
        executor = Executors.newFixedThreadPool(numberOfThreads);
        workPerThread = N/numberOfThreads;
    }
}
