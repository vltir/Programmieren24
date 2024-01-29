package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Quadratics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double[]input = new double[3];
        for (char parameter='a';parameter<='c';parameter++){
            System.out.println(parameter+"= ");
            input[parameter-'a']=scanner.nextDouble();
        }
        System.out.println(quadraticEquation(input[0],input[1],input[2]));
    }

    public static String quadraticEquation(double a,double b,double c){
        if(a==0){
            if(b==0) return "Die Gleichung ist degeneriert.";
            return ""+-c/b;
        }
        double d=b*b-4*a*c;
        if(d>=0) return "x1= "+(-b+Math.sqrt(d))/(2*a)+", x2= "+(-b-Math.sqrt(d))/(2*a);
        return "Die Lösung ist konjugiert komplex.";
    }

    public static String weilWirJaNochKeineMethodenBenutzenSollen(double a, double b, double c){
        String returnString;
        if(a==0){
            if(b==0)returnString="DieGleichung ist degeneriert";
            else returnString=""+-c/b;
        }else{
            double d=b*b-4*a*c;
            if(d>=0){
                returnString = "x1= "+(-b+Math.sqrt(d))/(2*a)+", x2= "+(-b-Math.sqrt(d))/(2*a);
            }else returnString = "Die Lösung ist konjugiert komplex.";
        }
        return returnString;
    }
}
