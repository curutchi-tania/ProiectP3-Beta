import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DealershipDatabase db = new DealershipDatabase();
        db.connect();
        // db.insertMasina("BMW", 2019, 80000, 40000, "negru", "X1 2.0 170cp diesel");
        db.insertComanda(1, StatusPlata.IN_ASTEPTARE, 2, 2);
        db.closeConnection();
    }
}
