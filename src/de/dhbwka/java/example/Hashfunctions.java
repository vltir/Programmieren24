package de.dhbwka.java.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Hashfunctions {
    public static void main(String[] args) {
        aufgabe2();
    }
    public static int modHash(int x, int n){
        return x%n;
    }
    public static int mulHash(int x, int n){
        final double c = (Math.sqrt(5)-1)/2;
        return (int)(n*(c*x-((int)(c*x))));
    }
    public static int musHash(int x, int n, int a, int w){
        final int l = (int)(Math.log(n) / Math.log(2));
        return (int)((double)(((x*a)%(1<<w)))/(double) (1<<w-l));
    }

    public static void aufgabe1(){
        final int n=16;
        final int a=39;
        final int w=6;
        Set<Integer>modSet = new HashSet<>();
        Set<Integer>mulSet = new HashSet<>();
        Set<Integer>musSet = new HashSet<>();
        for (int i = 0; i < 16; i++) {
            System.out.println(musHash(i,n,a,w));
            modSet.add(modHash(i,n));
            mulSet.add(mulHash(i,n));
            musSet.add(musHash(i,n,a,w));
        }
        int[]modArray = modSet.stream().mapToInt(i->i).toArray();
        int[]mulArray = mulSet.stream().mapToInt(i->i).toArray();
        int[]musArray = musSet.stream().mapToInt(i->i).toArray();
        //Arrays.sort(modArray);
        //Arrays.sort(mulArray);
        //Arrays.sort(musArray);
        System.out.println("mod: "+Arrays.toString(modArray));
        System.out.println("mul: "+Arrays.toString(mulArray));
        System.out.println("mus: "+Arrays.toString(musArray));
    }

    public static void aufgabe2(){
        int[]werte = {68,38,80,24,35,93,4};
        int n =11;
        int[]hashTable = new int[11];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i]=-1;
        }
        for (int i : werte) {
            int hash = modHash(i, n);
            if(hashTable[hash]==-1){
                hashTable[hash]=i;
                continue;
            }
            Sondierung: for (int j = 1; j < hashTable.length-1; j++) {
                //int newPos=(hash+j)%n; //linear
                //int newPos=(hash+j*j)%n; //quadratic
                int newPos=(hash+j*hash2(i))%n;
                if(hashTable[newPos]==-1){
                    hashTable[newPos]=i;
                    break Sondierung;
                }
            }
        }
        System.out.println(Arrays.toString(hashTable));
    }
    public static int hash2(int x){
        return (x % 9)+1;
    }
}
