package de.dhbwka.java.exercise.datatypes;

public class Round {
    public static void main(String[] args) {
        System.out.println(kaufmaennischesRunden(-0.4));
    }
    public static int kaufmaennischesRunden(double input){
        boolean positive = input>0;
        input=positive?input:-1*input;
        int floorInput = (int)input;
        int returnInt = input-floorInput>=0.5?floorInput+1:floorInput;
        return positive?returnInt:returnInt*-1;
    }
}
