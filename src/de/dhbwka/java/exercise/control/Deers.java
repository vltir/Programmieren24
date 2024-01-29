package de.dhbwka.java.exercise.control;

public class Deers {
    public static void main(String[] args) {
        int deers = 200;
        for (int year = 1; deers<300; year++) {
            deers*=1.1;
            deers-=15;
            if(deers<=0)break;
            System.out.printf("%4d: %3d Hirsche%n",year,deers);
        }
    }
}
