package de.dhbwka.java.example;


import java.util.Arrays;

public class Main {

    int a =99;
    int b= 98;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String string1 = "bla bla bla";
        string1.split(" +");
        int[] intArray = new int[0];
        Arrays.stream(intArray).min();
        otherMethod();
        final int b = (int) 3.14;
        double a = 3;
        float length = 1.45F;
        Integer.toString(b);
        a +=1;
        a/=1;
        a*=1;
        a-=1;
        a%=1;
        a++;
        a--;

    }

    public static void otherMethod(){
        int number;
        {
            double notANumber=Double.NaN;
            System.out.println(notANumber);
        }
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}