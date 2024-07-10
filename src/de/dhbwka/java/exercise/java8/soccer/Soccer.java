package de.dhbwka.java.exercise.java8.soccer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Soccer {
    public static void main(String[] args) {
        try {
            List<Player>players =Files.readAllLines(Paths.get("./src/de/dhbwka/java/exercise/java8/soccer/input.txt")).stream().map(l->l.split(";")).filter(l->l.length==7).map(l->new Player(Integer.parseInt(l[0]),l[1],l[2],l[3],l[4],Integer.parseInt(l[5]),Integer.parseInt(l[6]))).toList();
            List<Player>numberSortedPlayers = players.stream().sorted(Player::comparePlayerByNumber).toList();
            List<Player>nameSortedPlayers = players.stream().sorted(Player::comparePlayerByName).toList();
            System.out.println("Alle Spieler nach Rückennummer sortiert: ");
            numberSortedPlayers.forEach(System.out::println);
            System.out.println("Alle Spieler mit weniger als 50 Toren sortiert nach Name: ");
            nameSortedPlayers.stream().filter(p->p.games()>50).forEach(System.out::println);
            System.out.println("Alle clubs:");
            players.stream().map(Player::club).distinct().forEach(System.out::println);
            System.out.printf("Anzahl der Spieler mit weniger als 5 geschossenen Toren: %d%n",players.stream().filter(p->p.goals()<5).count());
            System.out.printf("Insgesamt erzielte Tore aller Spieler: %d%n",players.stream().mapToInt(Player::goals).sum());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
