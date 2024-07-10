package de.dhbwka.java.exercise.java8.soccer;

public record Player(int number, String name, String position, String birthday, String club, int games, int goals) {
    static int comparePlayerByNumber(Player player1, Player player2){
        return Integer.compare(player1.number,player2.number);
    }
    static int comparePlayerByName(Player player1, Player player2){
        return player1.name.compareToIgnoreCase(player2.name);
    }
}
