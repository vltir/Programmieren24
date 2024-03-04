package de.dhbwka.java.exercise.classes.vehicles;

public class Ambulance extends Car{
    private boolean blauLicht;
    public Ambulance(){
        super();
        this.vMax=80;
    }

    public void setBlauLicht(boolean blauLicht) {
        this.blauLicht = blauLicht;
    }

    @Override
    public void drive(double minutes) {
        super.drive(minutes);
        if(blauLicht){
            System.out.println("WIIIIIUUUUUUU");
        }
    }
}
