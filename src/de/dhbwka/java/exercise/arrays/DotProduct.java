package de.dhbwka.java.exercise.arrays;

public class DotProduct {
    public static void main(String[] args) {
        System.out.println(dotProduct(new int[]{5,3,1}, new int[]{-2,4,9}));
    }

    public static int dotProduct(int[] ar1, int ar2[]) {
        if (ar1.length != ar2.length) {
            throw new IllegalArgumentException("Arrays  must have the same length");
        }
        int sum = 0;
        for (int i = 0; i < ar1.length; i++) {
            sum += ar1[i] * ar2[i];
        }
        return sum;
    }
}
