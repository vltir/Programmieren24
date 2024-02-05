package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] ar = {37,4,54,7,43,76,4,3,6,55,7,2};
        ar=bubbleSort(ar);
        System.out.println(Arrays.toString(ar));
    }

    public static int[] bubbleSort(int[] ar) {
        for (int j = 0; j < ar.length; j++) {
            for (int i = 0; i < ar.length - 1; i++) {
                if (ar[i] > ar[i + 1]) {
                    int temp = ar[i + 1];
                    ar[i + 1] = ar[i];
                    ar[i] = temp;
                }
            }
        }
        return ar;
    }
}
