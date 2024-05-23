package de.dhbwka.java.exercise.ui.event;

import com.sun.jdi.connect.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {
    public static void main(String[] args) {
        new BMICalculator();
    }

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField weight = new JTextField(8);
    JTextField height = new JTextField(8);
    JRadioButton male = new JRadioButton("male");
    JRadioButton female = new JRadioButton("female");
    JButton calc = new JButton("calculate");
    JTextField bmi = new JTextField(16);
    JTextField category = new JTextField(32);

    public BMICalculator() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("BMIClaculator");
        frame.setSize(400,400);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Weight [kg]"));
        panel.add(weight);
        panel.add(new JLabel("Body height [m]"));
        panel.add(height);
        panel.add(male);
        panel.add(female);
        panel.add(calc);
        panel.add((new JLabel("BMI: ")));
        panel.add(bmi);
        panel.add(category);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        bmi.setEditable(false);
        category.setEditable(false);

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double bmiNum = calcBMI(Double.parseDouble(weight.getText()), Double.parseDouble(height.getText()));
                    bmi.setText(bmiNum+"");
                    if(male.isSelected()||female.isSelected()) {
                        category.setText(classifyBMI(bmiNum, male.isSelected()));
                    }
                }catch (NumberFormatException n){}

            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private static double calcBMI (double weight, double height){
        return weight/(height*height);
    }

    public static String classifyBMI(double bmi, boolean isMale) {
        if (isMale) {
            if (bmi < 20) {
                return "Untergewicht (Short weight)";
            } else if (bmi >= 20 && bmi <= 25) {
                return "Normalgewicht (Normal weight)";
            } else if (bmi > 25 && bmi <= 30) {
                return "Übergewicht (Overweight)";
            } else if (bmi > 30 && bmi <= 40) {
                return "Adipositas (Adiposity)";
            } else {
                return "massive Adipositas (Massive Adiposity)";
            }
        } else {
            if (bmi < 19) {
                return "Untergewicht (Short weight)";
            } else if (bmi >= 19 && bmi <= 24) {
                return "Normalgewicht (Normal weight)";
            } else if (bmi > 24 && bmi <= 30) {
                return "Übergewicht (Overweight)";
            } else if (bmi > 30 && bmi <= 40) {
                return "Adipositas (Adiposity)";
            } else {
                return "massive Adipositas (Massive Adiposity)";
            }
        }
    }
}
