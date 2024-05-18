package de.dhbwka.java.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest extends JFrame {
    public static void main(String[] args) {
        new SwingTest();
    }
    public SwingTest(){
        super();
        this.setSize(400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
        JButton button = new JButton("Hallo");
        button.addActionListener(e -> {
            System.out.println("Der Button wurde gedrückt");
            button.setSize((int)(button.getWidth()*0.9),(int)(button.getHeight()*0.9));
        });
        topPanel.add(new JToggleButton("ToggleButton"));
        topPanel.add(button);
        JRadioButton[] radioButtons=new JRadioButton[3];
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            radioButtons[i]=new JRadioButton(i+"");
            buttonGroup.add(radioButtons[i]);
            topPanel.add(radioButtons[i]);
        }
        this.add(topPanel);
        this.setTitle("JSwing");
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(help);
        JMenuItem lol = new JMenuItem("lol");
        lol.addActionListener(e->button.setSize((int)(button.getWidth()*1.1),(int)(button.getHeight()*1.1)));
        file.add(lol);
        file.add(new JMenuItem("nee"));
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }
}
