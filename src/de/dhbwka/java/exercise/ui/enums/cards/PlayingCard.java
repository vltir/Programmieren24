package de.dhbwka.java.exercise.ui.enums.cards;

import java.util.ArrayList;
import java.util.List;

public class PlayingCard implements Comparable<PlayingCard>{
    public final Farbe farbe;
    public final Wert wert;

    public PlayingCard(Farbe farbe, Wert wert) {
        this.farbe = farbe;
        this.wert = wert;
    }

    @Override
    public int compareTo(PlayingCard o) {
        int farbDif = Integer.compare(this.farbe.ordinal(),o.farbe.ordinal());
        if (farbDif!=0)return farbDif;
        return Integer.compare(this.wert.ordinal(),o.wert.ordinal());
    }

    @Override
    public String toString() {
        return farbe.toString().toLowerCase()+" "+wert.toString().toLowerCase();
    }

    public static List<PlayingCard> getAllPlayingCards(){
        List<PlayingCard>cards = new ArrayList<>();
        for (Farbe farbe : Farbe.values()) {
            for (Wert wert : Wert.values()) {
                cards.add(new PlayingCard(farbe, wert));
            }
        }
        return cards;
    }
}
