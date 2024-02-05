package de.dhbwka.java.example;

import java.util.stream.IntStream;

public class Prime {
    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            if(isPrime(i)){
                if(!isPrime(6*i*i+36*i+1)){
                    System.out.println(i+"|"+(6*i*i+36*i+1));
//                    break;
                }
            }
        }
    }

    public static boolean isPrime(int number) {
        return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(n -> (number % n == 0));
    }
}
