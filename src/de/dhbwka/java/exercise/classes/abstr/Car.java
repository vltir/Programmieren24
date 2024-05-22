package de.dhbwka.java.exercise.classes.abstr;

public class Car extends Vehicle {
    public Car(){
        super(4,140);
    }

    @Override
    public String info() {
        return wheels+vMax+"";
    }
}
