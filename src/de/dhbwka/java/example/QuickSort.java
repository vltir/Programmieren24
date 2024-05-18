package de.dhbwka.java.example;

public class QuickSort {
    public static void main(String[] args) {

    }

    public static void quickSort(int[] ar, int lowerBound, int upperBound) {
        int pivot = ar.length / 2;
        int i = lowerBound;
        int j = upperBound;
        while (i <= j) {
            for (; ar[i] < ar[pivot]; i++) ;
            for (; ar[j] > ar[pivot]; j--) ;
            int temp = ar[i];
            ar[j]=ar[i];
            ar[i]=temp;
        }
    }
}
