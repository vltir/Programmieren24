package de.dhbwka.java.exercise.classes.abstr;

import java.util.List;

public class Race {
    public static void main(String[] args) {
        List<Vehicle> vehicles=List.of(new Bicycle(),new Car(),new RacingCar(),new Ambulance());
        vehicles.get(0).setSpeed(20);
        vehicles.get(1).setSpeed(150);
        vehicles.get(2).setSpeed(200);
        vehicles.get(3).setSpeed(80);
        vehicles.get(0).drive(60*4);
        ((Ambulance)vehicles.get(3)).setBlauLicht(true);
        vehicles.forEach(v->v.drive(60));
        vehicles.forEach(System.out::println);
    }
}
