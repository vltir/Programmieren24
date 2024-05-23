package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class CurrencyCalculator {
    public static float EXCHANGE = 1.0869f;

    private final JTextField inputTextField;
    private final JButton euroToDollarButton;
    private final JButton dollarToEuroButton;
    private final JButton cancelButton;

    public CurrencyCalculator() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        inputTextField = new JTextField(60);
        inputTextField.setToolTipText("Please enter amount to convert!");
        frame.add(inputTextField, BorderLayout.CENTER);
        euroToDollarButton = new JButton("EUR -> USD");
        dollarToEuroButton = new JButton("USD -> EUR");
        cancelButton = new JButton("Cancel");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(euroToDollarButton);
        buttonPanel.add(dollarToEuroButton);
        buttonPanel.add(cancelButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        addActionListeners();
        frame.setVisible(true);
    }

    private void addActionListeners() {
        euroToDollarButton.addActionListener(e -> convert(inputTextField.getText(), EXCHANGE));
        dollarToEuroButton.addActionListener(e -> convert(inputTextField.getText(), 1 / EXCHANGE));
        cancelButton.addActionListener(e -> inputTextField.setText(""));
    }

    private void convert(String text, float factor) {
        try {
            float euro = Float.parseFloat(text);
            inputTextField.setText(euro * factor + "");
        } catch (NumberFormatException e) {
            inputTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new CurrencyCalculator();
    }
}
