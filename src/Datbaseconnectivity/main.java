package Datbaseconnectivity;

import javax.swing.*;
import java.awt.*;

public class main extends JFrame {

        {
            setTitle("Canteen Management System");
            setSize(600, 400);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        private JTextField nameField;
        private JTextField foodField;
        private JButton submitButton;


    public main() {
            // ... existing code ...

            nameField = new JTextField();
            foodField = new JTextField();

            add(nameField);
            add(foodField);

            submitButton = new JButton("Submit");
            add(submitButton);

            submitButton.addActionListener(e -> {
                Label nameField = new Label();
                String name = nameField.getText();
                Label foodField = new Label();
                String food = foodField.getText();

                // ... do something with the name and food ...
            });
        }
    }







