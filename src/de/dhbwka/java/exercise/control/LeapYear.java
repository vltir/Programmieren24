package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Welches Jahr soll auf Schaltjahr geprüft werden?");
            int year=scanner.nextInt();
            System.out.println(year + (isLeapYear(year)?" ist ein Schaltjahr":" ist kein Schaltjahr"));
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }
}
