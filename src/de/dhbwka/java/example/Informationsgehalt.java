package de.dhbwka.java.example;

import java.util.stream.DoubleStream;

public class Informationsgehalt {
    public static void main(String[] args) {
        System.out.println(DoubleStream.of(0.26,0.15,0.09,0.18,0.29,0.03).peek(d->System.out.println(d+": "+h(d))).map(d->d*h(d)).sum());
    }
    public static double h(double a){
        return -1*Math.log(a)/Math.log(2);
    }
}
