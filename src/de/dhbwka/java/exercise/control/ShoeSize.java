package de.dhbwka.java.exercise.control;

public class ShoeSize {
    public static void main(String[] args) {
        for (int i = 30; i <=49; i++) {
            System.out.printf("%5.2f - %5.2f | %2d%n",(i-1)/1.5,i/1.5,i);
        }
    }
}
