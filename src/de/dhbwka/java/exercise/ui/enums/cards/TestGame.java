package de.dhbwka.java.exercise.ui.enums.cards;

public class TestGame {
    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.shuffle();
        PlayingCard herz7 = new PlayingCard(Farbe.HERZ,Wert.SIEBEN);
        for (int i = 0; i < 10; i++) {
            PlayingCard card=game.get();
            System.out.printf("%s ist %s als %s%n",card,card.compareTo(herz7)==0?"gleich":(card.compareTo(herz7)<0?"kleiner":"größer"),herz7);
        }
        game.sortieren();
        game.all().forEach(System.out::println);
    }
}
