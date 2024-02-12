package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;

public class Pascal {
    public static void main(String[] args) {
        System.out.println(formatPascal(pascal(5)));
    }

    public static String formatPascal(int[][] m) {
        String[] lines = new String[m.length];
        Arrays.fill(lines, "");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < m.length; i++) {
            for (int anInt : m[i]) {
                lines[i] += String.format("%2d", anInt);
            }
        }
        for (int i = 0; i < lines.length; i++) {
            s.append(" ".repeat(lines.length - i));
            s.append(lines[i]);
            s.append("\n");
        }
        return s.toString();
    }

    public static int[][] pascal(int size) {
        int[][] result = new int[size][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[i + 1];
            result[i][0] = 1;
            result[i][result[i].length - 1] = 1;
        }
        for (int i = 2; i < result.length; i++) {
            for (int j = 1; j < result[i].length - 1; j++) {
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
        }
        return result;
    }
}
