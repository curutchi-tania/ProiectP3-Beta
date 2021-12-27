import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Client> getClienti() {
        List<Client> clienti = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clienti");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                clienti.add(new Client(rs.getInt("id"), rs.getString("nume")));
            }
        } catch (SQLException e) {
            System.err.println("Couldn't get clienti. Reason: " + e.getMessage());
        }
        return clienti;
    }

    public List<Masina> getMasini() {
        List<Masina> masini = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM masini");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                masini.add(new Masina(rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getInt("an"),
                        rs.getFloat("kilometraj"),
                        rs.getFloat("pret"),
                        rs.getString("culoare"),
                        rs.getString("descriere")));
            }
        } catch (SQLException e) {
            System.err.println("Couldn't get masini. Reason: " + e.getMessage());
        }
        return masini;
    }

    public List<Comanda> getComenzi() {
        List<Comanda> comenzi = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM comenzi");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                comenzi.add(new Comanda(rs.getInt("id"),
                        rs.getTimestamp("data"),
                        rs.getInt("cantitate"),
                        StatusPlata.valueOf(rs.getString("status")),
                        rs.getInt("id_masina"),
                        rs.getInt("id_client")));
            }
        } catch (SQLException e) {
            System.err.println("Couldn't get clienti. Reason: " + e.getMessage());
        }
        return comenzi;
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
