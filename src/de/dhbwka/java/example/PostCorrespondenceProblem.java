package de.dhbwka.java.example;
import java.util.ArrayList;
import java.util.List;

public class PostCorrespondenceProblem {
    public static List<Integer> findSolution(List<Pair> pairs) {
        List<Integer> sequence = new ArrayList<>();
        if (backtrack(pairs, sequence)) {
            return sequence.subList(0, Math.min(sequence.size(), 10)); // Begrenzung auf die ersten 5 Indizes
        } else {
            return null;
        }
    }

    private static boolean backtrack(List<Pair> pairs, List<Integer> sequence) {
        if (sequence.size() >= 10) { // Abbruchbedingung nach 5 Indizes
            return false;
        }
        for (Pair pair : pairs) {
            sequence.add(pair.index);
            if (checkSequence(sequence)) {
                return true;
            }
            if (backtrack(pairs, sequence)) {
                return true;
            }
            sequence.remove(sequence.size() - 1); // Backtrack
        }
        return false;
    }

    private static boolean checkSequence(List<Integer> sequence) {
        int n = sequence.size() / 2;
        List<Integer> firstHalf = sequence.subList(0, n);
        List<Integer> secondHalf = sequence.subList(n, sequence.size());
        return firstHalf.equals(secondHalf);
    }

    public static void main(String[] args) {
        // Beispiel-Konfigurationen
        List<Pair> K1 = List.of(new Pair(0, 52), new Pair(2, 0), new Pair(2505, 25), new Pair(3, 23));
        List<Pair> K2 = List.of(new Pair(11, 0), new Pair(11, 1), new Pair(0, 11));
        List<Pair> K3 = List.of(new Pair(10, 101), new Pair(011, 11), new Pair(101, 011));
        List<Pair> K4 = List.of(new Pair(0, 0), new Pair(1, 0), new Pair(110, 1), new Pair(0, 110));
        List<Pair> K5 = List.of(new Pair(001, 0), new Pair(01, 011), new Pair(01, 101), new Pair(10, 001));

        // Lösungen für die einzelnen Probleme finden und ausgeben
        System.out.println("Lösung für K1: " + findSolution(K1));
        System.out.println("Lösung für K2: " + findSolution(K2));
        System.out.println("Lösung für K3: " + findSolution(K3));
        System.out.println("Lösung für K4: " + findSolution(K4));
        System.out.println("Lösung für K5: " + findSolution(K5));
    }
}

class Pair {
    int index;
    int[] values;

    public Pair(int... values) {
        this.values = values;
        this.index = values.length;
    }
}
