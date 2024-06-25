package de.dhbwka.java.exercise.ui.enums.cards;

import java.util.Collections;
import java.util.List;

public class CardGame {
    private final List<PlayingCard> stapel=PlayingCard.getAllPlayingCards();

    public void shuffle(){
        Collections.shuffle(stapel);
    }

    public void sortieren(){
        Collections.sort(stapel);
    }

    public PlayingCard get(){
        return stapel.removeFirst();
    }

    public List<PlayingCard> all(){
        return stapel;
    }
}
