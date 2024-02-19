package de.dhbwka.java.exercise.classes;

public class Horner {
    private final double[] koefizienten;

    public static void main(String[] args) {
        Horner horner= new Horner(1,-2,3,4.5,8,-10,3,4,2,-3,0.5);
        System.out.println(horner);
        System.out.println(horner.valueOf(1.5));
    }

    Horner(double... koefizienten) {
        this.koefizienten = koefizienten;
    }

    public double valueOf(double x){
        double result=0;
        for (int i = koefizienten.length-1; i >= 0; i--) {
            result*=x;
            result+=koefizienten[i];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder hornerString = new StringBuilder();
        for (int i = koefizienten.length-1; i >= 0; i--) {
            hornerString.append(String.format("%s%.1f*x^%d",koefizienten[i]>=0?"+":"-",Math.abs(koefizienten[i]),i));
        }
        return hornerString.toString();
    }
}
