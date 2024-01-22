package de.dhbwka.java.exercise.datatypes;

public class Round {
    public static void main(String[] args) {
        System.out.println(kaufmaennischesRunden(-0.5));
//        System.out.println(rundenAberAnderst(0.4));
    }
    public static int kaufmaennischesRunden(double input){
        boolean positive = input >0;
        input*=positive?1:-1;
        int floorInput = (int)input;
        int returnInt = input-floorInput<0.5?floorInput:floorInput+1;
        returnInt*=positive?1:-1;
        return returnInt;
    }

    public static int rundenAberAnderst(double input){
        int floorInput = (int)input;
        floorInput-=input>0?0:1;
        int returnInt = input-floorInput<0.5?floorInput:floorInput+1;
        return returnInt;
    }
}
