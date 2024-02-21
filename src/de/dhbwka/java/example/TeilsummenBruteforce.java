package de.dhbwka.java.example;

import java.util.List;

public class TeilsummenBruteforce {
    public static void main(String[] args) {
        List<Integer> summanden = List.of(13, 11, 15, 12, 3, 8, 1, 16);
        List<Integer> summen = List.of(18, 10, 61, 70, 69, 77);
        for (int i = 0; i < 1 << summanden.size(); i++) {
            int sum = 0;
            for (int j = 0; j < summanden.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    sum += summanden.get(j);
                }
            }
            if (summen.contains(sum)) {
                System.out.printf("Die Summe %d ist darstellbar durch ", sum);
                for (int j = 0; j < summanden.size(); j++) {
                    if ((i & (1 << j)) != 0) {
                        System.out.print(summanden.get(j) + " ");
                    }
                }
                System.out.printf("%n");
            }
        }


    }

}
