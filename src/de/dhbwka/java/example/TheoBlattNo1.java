package de.dhbwka.java.example;

public class TheoBlattNo1 {
    public static void main(String[] args) {
        long y=1;
        for (int i = 0; i < 16; i++) {
            y+=y*i;
        }
        System.out.println(y);


    }
}
