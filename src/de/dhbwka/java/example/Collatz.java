package de.dhbwka.java.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collatz {
    public static void main(String[] args) {
        System.out.println("Part 1:");
        System.out.println(search(3,1,25));
        System.out.println("Part 2:");
        System.out.println(notInL());
        System.out.println("better Part 2:");
        System.out.println(part2());

    }

    private static List<Integer> part2() {
        List<Integer>notInCollatz=new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            if(!isInParametririzedCollatz(3,7,i)){
                notInCollatz.add(i);
                System.out.println(i*5+"%");
            }
        }
        return notInCollatz;
    }

    private static boolean isInParametririzedCollatz(int a, int b, int n){
        Set<Integer>previousElements=new HashSet<>();
        while(!(previousElements.contains(n)||previousElements.contains(1))){
            previousElements.add(n);
            n=collatz(a,b,n);
        }
        return previousElements.contains(1);
    }

    public static boolean inL(int n){
        try{
            int k=search(3,7,n);
        }catch (RuntimeException e){
            return false;
        }
        return true;
    }

    public static List<Integer> notInL(){
        List<Integer> found= new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            if(!inL(i)){
                found.add(i);
            }
        }
        return found;
    }

    public static int search(int a, int b, int n){
        int counter =0;
        while (n!=1){
            n=collatz(3,1,n);
            counter++;
            if(counter<0){
                throw new RuntimeException();
            }
        }
        return counter;
    }

    public static int collatz(int a, int b, int n){
        if(n%2==0){
            return n/2;
        }
        return a+n+b;
    }
}
