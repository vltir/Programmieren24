package de.dhbwka.java.example;

import java.util.Random;

public class Statistics {
    public static void main(String[] args) {
        Random random = new Random();
        int tries = 10000000;
        int result =0;
        for (int i = 0; i < tries; i++) {
            result++;
            for (;random.nextFloat()>0.45;result++);
        }
        System.out.println(result/(float)tries);
        gpt();
    }

    public static void gpt() {
        Random random = new Random();
        int tries = 10000000;
        int result = 0;

        for (int i = 0; i < tries; i++) {
            int currentTries = 0;

            while (random.nextFloat() > 0.45) {
                currentTries++;
            }

            result += currentTries + 1; // Add 1 for the successful attempt
        }

        float averageTries = (float) result / tries;
        System.out.println("Durchschnittliche Anzahl der Anwendungen: " + averageTries);
    }
}
