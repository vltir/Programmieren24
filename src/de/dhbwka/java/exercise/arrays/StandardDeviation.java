package de.dhbwka.java.exercise.arrays;

public class StandardDeviation {
    public static void main(String[] args) {
        int[] zahlen = new int[100];
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i]=(int)(10.0*Math.random());
        }
        System.out.println(average(zahlen));
        System.out.println(standardDeviation(zahlen));
    }
    public static double average(int[] ar){
        double average =0;
        for (int i : ar) {
            average+=1.0/ar.length*i;
        }
        return average;
    }

    public static double standardDeviation(int[] ar){
        double sum =0;
        double average = average(ar);
        for (int i : ar) {
            sum += Math.pow(i-average,2);
        }
        return Math.sqrt(1.0/(ar.length-1)*sum);
    }
}
