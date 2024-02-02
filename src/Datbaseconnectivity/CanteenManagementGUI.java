package Datbaseconnectivity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class CanteenManagementGUI extends JFrame {



    private JTable table;
    private DefaultTableModel model;

    public CanteenManagementGUI() throws SQLException {
        setTitle("Canteen Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        String[] columns = {"ID", "Item", "Price"};


        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);


        table = new JTable(model);


        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);


        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);


        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);


        getContentPane().add(buttonPanel, BorderLayout.SOUTH);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewItem();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateItem();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem();
            }
        });
    }

    private void addNewItem() {
        String id = JOptionPane.showInputDialog(this, "Enter ID:");
        String item = JOptionPane.showInputDialog(this, "Enter Item:");
        String price = JOptionPane.showInputDialog(this, "Enter Price:");

        if (id != null && item != null && price != null) {
            Vector<String> row = new Vector<>();
            row.add(id);
            row.add(item);
            row.add(price);
            model.addRow(row);
        }
    }

    private void updateItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String id = JOptionPane.showInputDialog(this, "Enter ID:", model.getValueAt(selectedRow, 0));
            String item = JOptionPane.showInputDialog(this, "Enter Item:", model.getValueAt(selectedRow, 1));
            String price = JOptionPane.showInputDialog(this, "Enter Price:", model.getValueAt(selectedRow, 2));


            if (id != null && item != null && price != null) {
                model.setValueAt(id, selectedRow, 0);
                model.setValueAt(item, selectedRow, 1);
                model.setValueAt(price, selectedRow, 2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
        }
    }

    private void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/canteenManagement";
        String username = "root";
        String password = "root";
        String query = "select *form menu_items";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteenManagement", "root", "root");
        System.out.println("connection establised successfully");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteenManagement", "root", "root")) {
            System.out.println("Connected to the database!");
        }
        SwingUtilities.invokeLater(() -> {
            CanteenManagementGUI gui = null;
            try {
                gui = new CanteenManagementGUI();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            gui.setVisible(true);
        });
    }


}
