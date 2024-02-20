package de.dhbwka.java.example;
import java.util.HashSet;
import java.util.Set;

public class CollatzGPT {
    public static int collatzFunction(int n, int alpha, int beta) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return alpha * n + beta;
        }
    }

    public static int findK(int alpha, int beta, int target) {
        int n = target;
        int k = 0;
        while (n != 1) {
            n = collatzFunction(n, alpha, beta);
            k++;
        }
        return k;
    }

    public static boolean isInLanguage(int alpha, int beta, int target) {
        int n = target;
        while (n != 1) {
            n = collatzFunction(n, alpha, beta);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public static Set<Integer> findM(int alpha, int beta, int limit) {
        Set<Integer> M = new HashSet<>();
        for (int n = 1; n <= limit; n++) {
            if (!isInLanguage(alpha, beta, n)) {
                M.add(n);
            }
        }
        return M;
    }

    public static void main(String[] args) {
        int alpha = 3;
        int beta = 1;
        int target = 27;
        int limit = 20;

        // Teilaufgabe (a)
        int k = findK(alpha, beta, target);
        System.out.println("Das kleinste k für f^k(27) = 1 ist: " + k);

        // Teilaufgabe (b)
        Set<Integer> M = findM(alpha, beta, limit);
        System.out.println("Die Menge M ist: " + M);
    }
}
