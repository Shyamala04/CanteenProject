package Datbaseconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class create {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/canteenManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteenManagement", "root", "root");

            if (connection != null) {
                System.out.println("Connected to the database!");

                Statement statement = connection.createStatement();


                //String createTable1SQL = "CREATE TABLE customers (" + "id INT AUTO_INCREMENT PRIMARY KEY," + "name VARCHAR(255)," + "contact_number int" + ")";
                //String createTable2SQL ="CREATE TABLE menu_items("+ "item_id int primary key,"+" item_name varchar(50),"+" price decimal(10,2)"+")";
                String createTable3SQL ="CREATE TABLE orders( "+"order_id int primary key,"+" customer_id int,"+" order_date Date,"+" order_time time,"+" total_amount decimal(10,2))";

               // statement.executeUpdate(createTable1SQL);
               // statement.executeUpdate(createTable2SQL);
                statement.executeUpdate(createTable3SQL);

               // System.out.println("Table 'customers' created successfully!");
                //System.out.println("Table 'menu_items' created successfully!");
                System.out.println("Table 'orders' created successfully!");


                connection.close();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
