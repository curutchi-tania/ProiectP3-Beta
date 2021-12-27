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

    public void insertClient(Client client) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO clienti(nume) VALUES (?)");
            stmt.setString(1, client.getNume());
            stmt.executeUpdate();
            System.out.println("Successfully inserted client: " + client.toString());
        } catch (SQLException e) {
            System.err.println("Query failed. Reason: " + e.getMessage());
        }
    }

    public void insertMasina(Masina masina) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO masini(marca, an, kilometraj, pret, culoare, descriere) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, masina.getMarca());
            stmt.setInt(2, masina.getAn());
            stmt.setFloat(3, masina.getKilometraj());
            stmt.setFloat(4, masina.getPret());
            stmt.setString(5, masina.getCuloare());
            stmt.setString(6, masina.getDescriere());
            stmt.executeUpdate();
            System.out.println("Successfully inserted masina: " + masina.toString());
        } catch (SQLException e) {
            System.err.println("Query failed. Reason: " + e.getMessage());
        }
    }

    public void insertComanda(Comanda comanda) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO comenzi(data, cantitate, status, id_masina, id_client) VALUES (?, ?, ?, ?, ?)");
            stmt.setTimestamp(1, comanda.getData());
            stmt.setInt(2, comanda.getCantitate());
            stmt.setString(3, comanda.getStatus().toString());
            stmt.setInt(4, comanda.getIdMasina());
            stmt.setInt(5, comanda.getIdClient());
            stmt.executeUpdate();
            System.out.println("Successfully inserted comanda: " + comanda.toString());
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
