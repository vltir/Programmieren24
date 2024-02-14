package de.dhbwka.java.exercise.arrays;

import java.util.Random;

public class MatrixSubtraction {
    public static void main(String[] args) {
        int[][] m1 = {
                {47, 29, 73, 2},
                {67, 42, 93, 9},
                {6, 4, 36, 86},
                {70, 57, 18, 43}
        };
        int[][] m2 = {
                {90, 58, 97, 96},
                {6, 60, 0, 46},
                {46, 11, 55, 96},
                {33, 95, 71, 7}
        };
        m1=randomMatrix(4);
        m2=randomMatrix(4);

        System.out.println(formatMatrix(subtractMatrix(m1, m2)));

    }

    public static int[][] randomMatrix(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Größe muss positiv sein.");
        }
        Random random = new Random();
        int[][] m = new int[size][size];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j]=random.nextInt(100);
            }
        }
        return m;
    }

    public static String formatMatrix(int[][] m) {
        String s = "";
        for (int[] ints : m) {
            for (int anInt : ints) {
                s += String.format("%4d", anInt);
            }
            s += "\n";
        }
        return s;
    }

    public static int[][] subtractMatrix(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            throw new IllegalArgumentException("Matritzen müssen die selbe Größe haben.");
        }
        int[][] result = new int[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                result[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return result;
    }
}
