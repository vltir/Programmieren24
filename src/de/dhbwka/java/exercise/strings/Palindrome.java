package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        while(true){
            String input = scanner.next();
            if(input.equals("esc"))return;
            StringBuilder output = new StringBuilder();
            for (int i = input.length()-1; i>=0; i--) {
                output.append(input.charAt(i));
            }
            System.out.println(output);
            System.out.printf("%s ist %s Palindrom%n",output,output.toString().equalsIgnoreCase(input)?"ein":"kein");
        }
    }
}
