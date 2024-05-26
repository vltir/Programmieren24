package de.dhbwka.java.exercise.ui.event.numberGuess;


import java.util.function.UnaryOperator;

public interface GuessViewable {
    void setEnterGuessEvent(UnaryOperator<Integer> enterGuessOperator);

    void setExitEvent(Runnable exitRunnable);

    void setNewGameEvent(Runnable newGameRunnable);

    void initView();

    void notifyGameOver(int numberOfGuesses);




}
