package de.dhbwka.java.exercise.ui.paint.election;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ElectionFrame {
    public static void main(String[] args) {
        List<Party> partys = List.of(
                new Party("SPD", 25.7, Color.RED),
                new Party("Union", 24.1, Color.BLACK),
                new Party("Grüne", 14.8, Color.GREEN),
                new Party("FDP", 11.5, Color.YELLOW),
                new Party("AfD", 10.3, Color.BLUE),
                new Party("Linke", 4.9, Color.MAGENTA),
                new Party("SSW", 0.1, Color.CYAN),
                new Party("Andere", 8.6, Color.DARK_GRAY)
        );
        new ElectionFrame(partys);
    }

    private List<Party>partys;
    private JFrame frame;
    private JPanel panel;
    public ElectionFrame(List<Party> partys) {
        this.partys=partys;
        frame= new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Election");
        frame.setSize(800,800);
        frame.add(new ElectionGrpahics(partys));
        frame.setVisible(true);


    }
}
