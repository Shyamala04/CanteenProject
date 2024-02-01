package Datbaseconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class Update {
        // JDBC URL, username, and password of MySQL server
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/canteenManagement";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "root";

        public static void main(String[] args) {
            // SQL query to update customer table
            String updateQuery = "UPDATE customers SET name = ?, contact_number = ? WHERE id = ?";

            try (
                    // Establish connection to the database
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteenManagement", "root", "root");
                    // Create a prepared statement for the update query
                    PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)
            ) {
                // Set parameters for the prepared statement
                preparedStatement.setString(1, "Shyamala");
                preparedStatement.setInt(2,147852369);
                preparedStatement.setInt(3, 1); // Assuming customer ID is 123

                // Execute the update query
                int rowsAffected = preparedStatement.executeUpdate();

                // Check if any rows were affected
                if (rowsAffected > 0) {
                    System.out.println("Update successful. " + rowsAffected + " row(s) affected.");
                } else {
                    System.out.println("No rows were updated.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


