package de.dhbwka.java.exercise.ui;

import javax.swing.*;

public class TextFrame extends JFrame {
    public TextFrame(String name, int width, int height, String content) {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setTitle(name);
        this.add(new JTextArea(content));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TextFrame("bla", 400, 400, "ja");
    }
}
