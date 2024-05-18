package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class ComponentFrame extends JFrame {
    public static void main(String[] args) {
        new ComponentFrame();
    }
    public ComponentFrame(){
        super();
        this.setSize(800,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(initCenterPanel(new JPanel()), BorderLayout.CENTER);
        this.add(initSouthPanel(new JPanel()),BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private JPanel initSouthPanel(JPanel panel) {
        panel.setLayout(new FlowLayout());
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            JRadioButton jRadioButton = new JRadioButton("JRadioButton "+i);
            buttonGroup.add(jRadioButton);
            panel.add(jRadioButton);
        }
        return panel;
    }

    private JPanel initCenterPanel(JPanel panel){
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("JLabel"));
        panel.add(new JTextField("JTextField",10));
        panel.add(new JPasswordField("password",10));
        panel.add(new JButton("JButton"));
        panel.add(new JToggleButton("JToggleButton"));
        panel.add(new JCheckBox("JCheckBox"));
        JComboBox comboBox = new JComboBox();
        for (int i = 0; i < 4; i++) {
            comboBox.addItem("Item "+(i+1));
        }
        panel.add(comboBox);
        return panel;
    }
}
