import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Connecting to db..");
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/dealership";
            conn = DriverManager.getConnection(url, "tania", "parola123");

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clienti");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nume"));
            }

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
