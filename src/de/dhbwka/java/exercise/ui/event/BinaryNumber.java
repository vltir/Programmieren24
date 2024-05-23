package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryNumber {
    public static void main(String[] args) {
        new BinaryNumber();
    }

    private static final ImageIcon IMG_OFF = new ImageIcon("off.png");
    private static final ImageIcon IMG_ON = new ImageIcon("on.png");

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JToggleButton[] buttons = new JToggleButton[8];
    private JLabel label = new JLabel();
    public BinaryNumber() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800,400);
        frame.setTitle("Binary Number");
        panel.setLayout(new FlowLayout());
        for (int i = 0; i < 8; i++) {
            JToggleButton button = new JToggleButton();
            button.setIcon(IMG_OFF); // icon if not selected (default icon)
            button.setSelectedIcon(IMG_ON);
            buttons[i]=button;
            panel.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateBinaryNumber();
                }
            });
        }
        panel.add(label);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateBinaryNumber(){
        int sum=0;
        for (int i = 0; i < buttons.length; i++) {
            if(buttons[i].isSelected()) sum+=1<<(buttons.length-i-1);
        }
        label.setText(sum+"");
    }
}
