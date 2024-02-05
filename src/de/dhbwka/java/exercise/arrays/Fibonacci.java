package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int[] ar = new int[50];
        for (int i = 0; i < ar.length; i++) {
            ar[i]=betterFibonacci(i+1);
        }
        System.out.println(Arrays.toString(ar));
    }
    public static int fibonacci(int i){
        if(i<=2)return 1;
        return fibonacci(i-1)+fibonacci(i-2);
    }

    public static int betterFibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n sollte eine positive ganze Zahl sein.");
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }


}
