package de.dhbwka.java.exercise.control;

public class TemperatureTable {
    public static void main(String[] args) {
        System.out.println("Fahrenheit | Celsius");
        System.out.println("-----------+--------");
        for (int i = 0; i <= 300; i += 20) {
            System.out.printf("%3d        |%5.1f%n", i, fahrenheitToCelsius(i));
        }
    }

    public static double fahrenheitToCelsius(double f) {
        return (5.0 / 9) * (f - 32);
    }
}
