package de.dhbwka.java.probeklausur1;


import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static final int MAX_VISITS=10;
    private final Board board;
    private final Player[] players;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        visitLoop: for (int i = 0; i < Game.MAX_VISITS; i++) {
            for (Player player : players) {
                System.out.println("Player: "+player.getName()+", "+player.getRemainingPoints()+" points remaining.");
                System.out.print("Enter Visit: ");
                String input = scanner.nextLine();
                String[] inputs = input.split(" ");
                Field[] fields = new Field[inputs.length];
                for (int j = 0; j < inputs.length; j++) {
                    fields[j]=board.parseField(inputs[j]);
                }
                Visit visit = new Visit(fields);
                player.addVisit(visit);
                System.out.println("Scored: "+visit.getValue());
                System.out.println("==========================");
                if(player.has0Points()){
                    System.out.println(player.getName()+"hat gewonnen.");
                    break visitLoop;
                }
            }
        }
        if(Arrays.stream(players).noneMatch(Player::has0Points)){
            System.out.println("You're too bad for this game!");
        }
        scanner.close();
    }

//    private static void writeHighscore(Player player){
//        final Path highscorePath = Paths.get("highscore.txt");
//        try(final File file = Files.createFile(highscorePath);){
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
