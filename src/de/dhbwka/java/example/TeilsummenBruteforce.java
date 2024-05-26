package de.dhbwka.java.example;

import java.util.List;

public class TeilsummenBruteforce {
    public static void main(String[] args) {
        List<Integer> summanden = List.of(211, 212, 424, 217, 13, 447, 473, 105);
        List<Integer> summen = List.of(876, 1674, 853, 424, 1007, 1188, 1214, 1326, 1188, 1300, 529, 746, 746);
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
