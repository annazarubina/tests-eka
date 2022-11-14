package org.eka.tests;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant start = Instant.now();
        allTests();
        Instant finish = Instant.now();
        Runtime rt = Runtime.getRuntime();
        System.out.println(String.format("Time elapsed: %d, Memory used: %d",
                Duration.between(start, finish).toMillis(),
                rt.totalMemory() - rt.freeMemory()));  //in millis
    }

    private static void allTests() {
        new org.eka.tests.other.bublesort.TestSolution().execute();
        new org.eka.tests.other.insertionsort.TestSolution().execute();
        new org.eka.tests.other.mergesort.TestSolution().execute();
        new org.eka.tests.other.quicksort.TestSolution().execute();
        new org.eka.tests.other.heapsort.TestSolution().execute();
        new org.eka.tests.other.stack.TestSolution().execute();
        new org.eka.tests.other.queue.TestSolution().execute();
    }
}
