package de.dhbwka.java.exercise.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CrossTotal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            int input = scanner.nextInt();
            if(input<0)return;
            System.out.println(crossTotal(input));
        }
    }

    public static int crossTotal(int inputInt){
        String input = Integer.toString(inputInt);
        int sum =0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(0)<'0'||input.charAt(0)>'9')throw new InputMismatchException();
            sum+=input.charAt(i)-'0';
        }
        return sum;
    }
}
