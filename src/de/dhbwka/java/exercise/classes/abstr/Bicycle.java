package de.dhbwka.java.exercise.classes.abstr;

public class Bicycle extends Vehicle {
    public Bicycle(){
        super(2,30);
    }

    @Override
    public String info() {
        return wheels+vMax+"";
    }
}
