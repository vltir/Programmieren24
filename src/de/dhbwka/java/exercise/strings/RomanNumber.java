package de.dhbwka.java.exercise.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumber {
    static final Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);

        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.next();
            if (input.equals("esc")) return;
            System.out.println(intOfRoman(input));
        }
    }

    public static int intOfRoman(String roman) {
        int sum = 0;
        for (int i = 0; i < roman.length(); i++) {
            if (i > 0 && map.get(roman.charAt(i)) > map.get(roman.charAt(i - 1))) {
                sum -= 2 * map.get(roman.charAt(i - 1));
            }
            sum += map.get(roman.charAt(i));
        }
        return sum;
    }
}
