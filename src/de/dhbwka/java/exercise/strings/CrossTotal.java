package de.dhbwka.java.exercise.strings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CrossTotal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.next();
            if(input.equals("esc"))return;
            int sum =0;
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(0)<'0'||input.charAt(0)>'9')throw new InputMismatchException();
                sum+=input.charAt(i)-'0';
            }
            System.out.println(sum);
        }
    }
}
