package de.dhbwka.java.example;

import java.util.ArrayList;
import java.util.List;

public class CharCounter {
    public static void main(String[] args) {
        List<Letter> letters = new ArrayList<>();
        int[] chars = new int[256];
        String string = "this company is one of the top software companies in the world because every single employee understands that they are part of a whole";
        string.chars().forEach(c->chars[c]++);
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]!=0){
                char c = (char) i;
                System.out.println(c+": "+chars[i]);
                letters.add(new Letter(c,chars[i]));
            }
        }
        int sum=letters.stream().mapToInt(l->l.count).sum();
        //System.out.println(letters.getFirst().letter+": "+letters.getFirst().entropy(sum));
        System.out.println("Insgesamt Elemente: "+sum);
        double totalEntropy= letters.stream().mapToDouble(l->l.entropy(sum)*l.relativeFrequency(sum)).sum();
        System.out.println("Insgesmt Entropie: "+ totalEntropy);
        final int utf8Bits=8;
        double redundancy=utf8Bits-totalEntropy;
        System.out.println("Redundanz: "+ redundancy);

    }

    record Letter(char letter, int count){
        double relativeFrequency(int sum){
            return ((double)count)/sum;
        }
        double entropy(int sum){
            return -1*Math.log(relativeFrequency(sum))/Math.log(2);
        }
    }
}