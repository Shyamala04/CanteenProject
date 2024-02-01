package Datbaseconnectivity;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;




    public class Insert {
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            String url = "jdbc:mysql://localhost:3306/canteenManagement";
            String username = "root";
            String password = "root";
            String query = "select *form customers";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteenManagement", "root", "root");
            System.out.println("connection establised successfully");


            //String sql= "DELETE FROM student_details WHERE id=1";
            String sql1 = "insert into customers( id,name,contact_number) VALUES (?,?,?)";
            String sql2 = "insert into menu_items( item_id,item_name,price) VALUES (?,?,?)";
            //String sql3="insert into orders(oder_id,customer_id,order_date,order_time,total_amount) VALUES (?,?,?,?,?)";
            Statement smt = con.createStatement();
            con.close();
            System.out.println("Connection Closed...");


            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter customer ID:");
            int id = scanner.nextInt();
            System.out.println("Enter customer name:");
            String name = scanner.nextLine();
            name = scanner.nextLine();
            System.out.println("Enter customer contact_number:");
            int contact_number = scanner.nextInt();
            System.out.println("Enter item ID:");
            int item_id = scanner.nextInt();
            System.out.println("Enter item name:");
            String item_name = scanner.nextLine();
            item_name = scanner.nextLine();
            //System.out.println("Enter customer id:");
            // int customer_id = scanner.nextInt();
            System.out.println("Enter item price:");
            int price = scanner.nextInt();
            //System.out.println("Enter order id:");
            //String order_id = scanner.nextLine();
            //System.out.println("Enter order date:");
            //LocalDate date = LocalDate.now(); // Current date
            //System.out.println("Enter order time:");
            //LocalDateTime dateTime = LocalDateTime.now();


            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteenManagement", "root", "root")) {
                System.out.println("Connected to the database!");

                try (PreparedStatement statement = connection.prepareStatement(sql1)) {
                    statement.setInt(1, id);
                    statement.setString(2, name);
                    statement.setDouble(3, contact_number);

                    try (PreparedStatement statement1 = connection.prepareStatement(sql2)) {
                        statement1.setInt(1, item_id);
                        statement1.setString(2, item_name);
                        statement1.setDouble(3, price);


                        try (PreparedStatement statement2 = connection.prepareStatement(sql2)) {
                            statement1.setInt(1, item_id);
                            statement1.setString(2, item_name);
                            statement1.setDouble(3, price);



                            int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("customer data inserted successfully!");
                        } else {
                            System.out.println("Failed to insert customer data.");
                        }
                        int rowsInserted1 = statement1.executeUpdate();
                        if (rowsInserted1 > 0) {
                            System.out.println("customer data inserted successfully!");
                        } else {
                            System.out.println("Failed to insert customer data.");
                        }
                    } catch (SQLException e) {
                        System.err.println("Error connecting to the database or inserting data: " + e.getMessage());
                    }
                }
            }
        }
    }

