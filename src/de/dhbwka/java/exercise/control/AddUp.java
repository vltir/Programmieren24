package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class AddUp {
    public static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        addUpWhile();
    }

    public static void addUpWhile(){
        int sum =0;
        int input;
        while ((input=scanner.nextInt())>=0){
            sum+=input;
        }
        System.out.printf("Summe: %4d",sum);
    }

    public static void addUpDoWhile(){
        int sum =0;
        int input;
        do{
            input = scanner.nextInt();
            sum+=input;
        }while(input>=0);
        System.out.printf("Summe: %4d",sum);
    }
}
