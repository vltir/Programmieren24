package de.dhbwka.java.exercise.classes.abstr;

public abstract class Vehicle {
    protected int wheels;
    protected double vMax,pos,velocity;

    private Vehicle(int wheels, double vMax, double pos, double velocity){
        this.wheels=wheels;
        this.vMax=vMax;
        this.pos=pos;
        setSpeed(velocity);
    }
    public Vehicle(){
        this(4,0);
    }
    public Vehicle(int wheels, double vMax){
        this(wheels,vMax,0,0);
    }

    public void setSpeed(double velocity) {
        if(velocity>vMax){
            this.velocity=vMax;
            return;
        }
        this.velocity = velocity;
    }

    public void drive(double minutes){
        if(minutes<=0)throw new IllegalArgumentException("minutes must be positive");
        this.pos+=velocity*(minutes/60);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "wheels=" + wheels +
                ", vMax=" + vMax +
                ", pos=" + pos +
                ", velocity=" + velocity +
                '}';
    }
    abstract public String info();
}
