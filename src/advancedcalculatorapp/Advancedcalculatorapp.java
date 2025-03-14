/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package advancedcalculatorapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdvancedCalculator implements ActionListener {
    JFrame frame;
    JTextField num1TextField, num2TextField;
    JButton addButton, subButton, multiplyButton, divideButton, clearButton;
    JLabel resultLabel;

    public AdvancedCalculator() {
        frame = new JFrame("Advanced Calculator");
        frame.setLayout(new FlowLayout());

        num1TextField = new JTextField(10);
        num2TextField = new JTextField(10);
        
        addButton = new JButton("Add");
        subButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        clearButton = new JButton("Clear");

        resultLabel = new JLabel("Result: ");

        frame.add(new JLabel("Enter first number:"));
        frame.add(num1TextField);
        frame.add(new JLabel("Enter second number:"));
        frame.add(num2TextField);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(clearButton);
        frame.add(resultLabel);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        clearButton.addActionListener(this);

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == clearButton) {
                num1TextField.setText("");
                num2TextField.setText("");
                resultLabel.setText("Result: ");
                return;
            }

            if (num1TextField.getText().isEmpty() || num2TextField.getText().isEmpty()) {
                resultLabel.setText("Error: Fields cannot be empty.");
                return;
            }

            double num1 = Double.parseDouble(num1TextField.getText());
            double num2 = Double.parseDouble(num2TextField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
                resultLabel.setText("Result: " + result);
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
                resultLabel.setText("Result: " + result);
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
                resultLabel.setText("Result: " + result);
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    resultLabel.setText("Error: Division by zero");
                } else {
                    result = num1 / num2;
                    resultLabel.setText("Result: " + result);
                }
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input! Please enter numbers.");
        }
    }

    public static void main(String[] args) {
        new AdvancedCalculator();
    }
}
