import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DealershipDatabase db = new DealershipDatabase();
        db.connect();
        db.runQuery();
        db.closeConnection();
    }
}
