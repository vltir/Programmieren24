package de.dhbwka.java.exercise.arrays;

public class Norm {
    public static void main(String[] args) {
        int[] ar = {1,2,4};
        System.out.println(norm(ar));
    }

    public static double norm(int[] ar){
        int sum =0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i]*ar[i];
        }
        return Math.sqrt(sum);
    }
}
