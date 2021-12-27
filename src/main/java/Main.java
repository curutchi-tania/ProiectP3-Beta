import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DealershipDatabase db = new DealershipDatabase();
        db.connect();
//        Client client = new Client("Mara");
//        db.insertClient(client);
//        Masina masina = new Masina("Audi", 2020, 5000, 35000, "albastru", "A3 1.6 160cp");
//        db.insertMasina(masina);
//        Comanda comanda = new Comanda(2, StatusPlata.ANULAT, 1, 3);
//        db.insertComanda(comanda);
        db.closeConnection();
    }
}
