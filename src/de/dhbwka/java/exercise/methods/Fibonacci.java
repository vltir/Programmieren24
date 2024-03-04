package de.dhbwka.java.exercise.methods;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(30));
    }

    public static int fibonacci(int n){
        int[] cache = new int[n+1];
        return fibonacci(n,cache);
    }
    public static int fibonacci(int n, int[] cache){
        if(n<=2)return 1;
        if(cache[n]==0) {
            cache[n] = fibonacci(n-1, cache)+fibonacci(n-2, cache);
        }
        return cache[n];
    }
}
