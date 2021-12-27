import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Connecting to db..");
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:path-to-db/chinook/chinook.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection was successful.");
        } catch (SQLException e) {
            System.err.println("Connection failed. Reason: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Couldn't close connection. Reason: " + e.getMessage());
            }
        }
    }
}
