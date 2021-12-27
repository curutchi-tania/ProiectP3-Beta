import java.sql.*;

public class DealershipDatabase {
    private Connection conn;

    public void runQuery() {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clienti");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nume"));
            }
        } catch (SQLException e) {
            System.err.println("Query failed. Reason: " + e.getMessage());
        }
    }

    public void connect() {
        System.out.println("Connecting to db..");
        try {
            String url = "jdbc:mysql://localhost:3306/dealership";
            conn = DriverManager.getConnection(url, "tania", "parola123");
            System.out.println("Connection was successful.");
        } catch (SQLException e) {
            System.err.println("Connection failed. Reason: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Couldn't close connection. Reason: " + e.getMessage());
        } finally {
            conn = null;
        }
    }
}
