package de.dhbwka.java.exercise.ui.event.numberGuess;

import java.util.Random;

public class NumberGuess {
    public static void main(String[] args) {
        new NumberGuess();
    }
    GuessViewable guessView = new GuessView();
    Game game;
    public NumberGuess() {
        guessView.initView();
        createNewGame();
        guessView.setNewGameEvent(this::createNewGame);
        guessView.setExitEvent(()->System.exit(0));
        guessView.setEnterGuessEvent(this::makeGuess);
    }

    private int makeGuess(int guess){
        game.guesses++;
        if(game==null)return -2;
        if(guess> game.number)return 1;
        if(guess< game.number)return -1;
        guessView.notifyGameOver(game.guesses);
        game=null;
        return 0;
    }

    private void createNewGame(){
        game=new Game();
    }

    private static class Game{
        private static final Random RANDOM = new Random();
        private final int number;
        private int guesses=0;
        public Game() {
            number = RANDOM.nextInt(1000)+1;
        }
    }
}
