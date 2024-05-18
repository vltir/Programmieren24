package de.dhbwka.java.probeklausur1;

import java.util.Arrays;
import java.util.Objects;

public class Player {

    private final String name;
    private int countDartsThrown = 0;

    private int visitCount = 0;
    private Visit[] visits = new Visit[Game.MAX_VISITS];

    public Player(String name) {
        this.name = name;
    }

    public int getRemainingPoints() {
        return 501 - Arrays.stream(visits).filter(Objects::nonNull).mapToInt(Visit::getValue).sum();
    }

    public boolean addVisit(Visit visit) {
        if (getRemainingPoints() - visit.getValue() < 0||visitCount>=Game.MAX_VISITS) return false;
        countDartsThrown+= (int) Arrays.stream(visit.getFields()).filter(Objects::nonNull).count();
        visits[visitCount]=visit;
        visitCount++;
        return true;

    }

    public boolean has0Points(){
        return getRemainingPoints()==0;
    }

    public String getName() {
        return name;
    }
}
