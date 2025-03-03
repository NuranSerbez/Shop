import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/shop";
            String username = "root";
            String password = "Ns964916.";
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Ns964916.");
        } catch (SQLException e) {
            System.out.println("Veritabanı bağlantı hatası: " + e.getMessage());
            return null;
        }
    }
public static void main(String[] args) {

}
}
