package de.dhbwka.java.exercise.classes;

import java.util.Arrays;
import java.util.Random;

public class Complex {
    private final double a, b;

    public static void main(String[] args) {
        Random random = new Random();
        Complex[]complexes=new Complex[10];
        for (int i = 0; i < complexes.length; i++) {
            complexes[i]=new Complex(random.nextDouble()*10,random.nextDouble()*10);
        }
        bubbleSort(complexes);
        System.out.println(Arrays.toString(complexes));
    }

    public static Complex[] bubbleSort(Complex[] complexes){
        for (int i = 0; i < complexes.length; i++) {
            for (int j = 0; j < complexes.length-1; j++) {
                if(complexes[j+1].isLess(complexes[j])){
                    Complex temp = complexes[j+1];
                    complexes[j+1]=complexes[j];
                    complexes[j]=temp;
                }
            }
        }
        return complexes;
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getMagnitude(){
        return Math.sqrt(a*a+b*b);
    }

    public boolean isLess(Complex comp){
        return getMagnitude()<comp.getMagnitude();
    }

    public Complex add(Complex comp) {
        return new Complex(getReal() + comp.getReal(), getImag() + comp.getImag());
    }

    public Complex sub(Complex comp) {
        return new Complex(getReal() - comp.getReal(), getImag() - comp.getImag());
    }

    public Complex mult(Complex comp) {
        return new Complex(getReal() * comp.getReal() - getImag() * comp.getImag(), getReal() * comp.getImag() + getImag() * comp.getReal());
    }

    public Complex div(Complex comp) {
        return new Complex((getReal() * comp.getReal() + getImag() * comp.getImag()) / (comp.getReal() * comp.getReal() + comp.getImag() * comp.getImag()), (getImag() * comp.getReal() - getReal() * comp.getImag()) / (comp.getReal() * comp.getReal() + comp.getImag() * comp.getImag()));
    }

    @Override
    public String toString() {
        return a+(b>=0?"+":"-")+Math.abs(b)+"i";
    }

    public double getReal() {
        return a;
    }

    public double getImag() {
        return b;
    }

}
