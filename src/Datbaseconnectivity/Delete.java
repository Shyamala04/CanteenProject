package Datbaseconnectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/canteenManagement";
        String user = "root";
        String password = "root";

        // SQL query to delete a customer
        String sql = "DELETE FROM customers WHERE id = 1";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            // Execute the SQL query
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + rowsAffected);
            System.out.println("Customer deleted successfully.");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}

