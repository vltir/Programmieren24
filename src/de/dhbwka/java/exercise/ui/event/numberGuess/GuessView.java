package de.dhbwka.java.exercise.ui.event.numberGuess;

import javax.swing.*;
import java.util.function.UnaryOperator;

public class GuessView implements GuessViewable{
    JFrame frame;
    JTextField playerName;
    JTextField number;

    JButton newGame;
    JButton submit;
    JButton bestPlayer;
    JButton exit;
    JLabel output;
    @Override
    public void setEnterGuessEvent(UnaryOperator<Integer> enterGuessOperator) {
        submit.addActionListener(e->{
            try{
                int guess = Integer.parseInt(number.getText());
                int guessResult=enterGuessOperator.apply(guess);
                if(guessResult==-2){
                    output.setText("First create a game please");
                } else if (guessResult==0) {
                    output.setText(guess+ "is correct");
                }
                else {
                    output.setText(guess + "is too" + (guess>0?"high":"low"));
                }
            }catch (NumberFormatException ne){
                System.err.println("Incorrect Input");
            }

        });
    }

    @Override
    public void setExitEvent(Runnable exitRunnable) {
        exit.addActionListener(e -> exitRunnable.run());
    }

    @Override
    public void setNewGameEvent(Runnable newGameRunnable) {
        newGame.addActionListener(e -> newGameRunnable.run());
    }

    @Override
    public void initView() {
        frame=new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("GuessingGame");
        frame.setSize(400,400);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Player Name"));
        playerName = new JTextField(12);
        panel.add(playerName);
        panel.add(new JLabel("Enter Number between 1 and 1000"));
        number = new JTextField(12);
        panel.add(number);
        newGame= new JButton("New Game");
        panel.add(newGame);
        submit= new JButton("OK");
        panel.add(submit);
        bestPlayer = new JButton("Best Player");
        panel.add(bestPlayer);
        exit = new JButton("Exit");
        panel.add(exit);
        output = new JLabel();
        panel.add(output);
    }

    @Override
    public void notifyGameOver(int numberOfGuesses) {
        output.setText(output.getText()+System.lineSeparator()+"You won with the Game"+ numberOfGuesses +" attempts.");
    }
}
