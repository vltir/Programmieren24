package de.dhbwka.java.exercise.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Eratostenes {
    public static void main(String[] args) {
        System.out.println(erastostenes(100));

    }

    public static List<Integer> erastostenes(int n) {
        List<Integer> sieve = new ArrayList<>(n - 1);
        List<Integer> primes = new ArrayList<>();
        IntStream.range(2, n + 1).forEach(sieve::add);
        while (!sieve.isEmpty()) {
            int e = sieve.getFirst();
            primes.add(e);
            for (int i = 0; i < sieve.size(); i++) {
                if (sieve.get(i) % e == 0) {
                    sieve.remove(i);
                    i--;
                }
            }
        }
        return primes;
    }
}
