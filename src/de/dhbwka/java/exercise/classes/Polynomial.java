package de.dhbwka.java.exercise.classes;

import java.util.Arrays;

public class Polynomial {
    public double a, b, c;

    public static void main(String[] args) {
        Polynomial p1= new Polynomial(2,0,0);
        System.out.println(p1);
        Polynomial p2= new Polynomial(0,-4,1);
        System.out.println(p2);
        Polynomial p3= p1.add(p2);
        System.out.println(p3);
        p3=p3.multiply(2);
        System.out.println(p3);
        System.out.println(Arrays.toString(p3.nullStellen()));

    }

    Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Polynomial(double b, double c) {
        this(1, b, c);
    }

    public double valueOf(double x) {
        return a * x * x + b * x + c;
    }

    public Polynomial add(Polynomial polynomial) {
        return new Polynomial(a+polynomial.a,b+polynomial.b,c+polynomial.c);
    }

    public Polynomial subtract(Polynomial polynomial) {
        return new Polynomial(a-polynomial.a,b-polynomial.b,c-polynomial.c);
    }

    public Polynomial multiply(double scalar){
        return new Polynomial(a*scalar,b*scalar,c*scalar);
    }

    public double[] nullStellen(){
        double inRoot=b*b-4*a*c;
        if (inRoot<0) return new double[0];
        double root = Math.sqrt(inRoot);
        if(root==0) return new double[]{(-b+root)/(2*a)};
        return new double[]{(-b+root)/(2*a),(-b-root)/(2*a)};
    }


    @Override
    public String toString() {
        return String.format("%fx^2%s%fx%s%f", a, b >= 0 ? "+" : "-", Math.abs(b), c >= 0 ? "+" : "-", Math.abs(c));
    }


}
