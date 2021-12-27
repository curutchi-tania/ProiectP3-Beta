import java.sql.*;
import java.time.Instant;
import java.util.Calendar;

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

    public void insertClient(String nume) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO clienti(nume) VALUES (?)");
            stmt.setString(1, nume);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Query failed. Reason: " + e.getMessage());
        }
    }

    public void insertMasina(String marca, int an, float kilometraj, float pret, String culoare, String descriere) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO masini(marca, an, kilometraj, pret, culoare, descriere) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, marca);
            stmt.setInt(2, an);
            stmt.setFloat(3, kilometraj);
            stmt.setFloat(4, pret);
            stmt.setString(5, culoare);
            stmt.setString(6, descriere);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Query failed. Reason: " + e.getMessage());
        }
    }

    public void insertComanda(int cantitate, StatusPlata status, int masina, int client) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO comenzi(data, cantitate, status, id_masina, id_client) VALUES (?, ?, ?, ?, ?)");
            stmt.setTimestamp(1, new Timestamp(Instant.now().getEpochSecond() * 1000));
            stmt.setInt(2, cantitate);
            stmt.setString(3, status.toString());
            stmt.setInt(4, masina);
            stmt.setInt(5, client);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Query failed. Reason: " + e.getMessage());
        }
    }

    public void connect() {
        System.out.println("Connecting to db..");
        try {
            String url = "jdbc:mysql://localhost:3306/dealership";
            conn = DriverManager.getConnection(url, "tania", "parola123");
            System.out.println("Connection successful.");
        } catch (SQLException e) {
            System.err.println("Connection failed. Reason: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Couldn't close connection. Reason: " + e.getMessage());
        } finally {
            conn = null;
        }
    }
}
