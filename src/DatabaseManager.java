import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/shop";
    private static final String USER = "root";
    private static final String PASSWORD = "Ns964916.";
    private static Connection connection = null;

    private DatabaseManager() { }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Ns964916.");
                System.out.println("Veritabanına bağlantı başarılı.");
            } catch (Exception e) {
                System.out.println("Bağlantı hatası: " + e.getMessage());
            }
        }
        return connection;
    }

    public static boolean executeUpdate(String query, Object... params) {
        if (params.length == 0) {
            System.out.println("HATA: SQL sorgusunda parametre eksik!");
            return false;
        }

        Connection conn = getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("SQL Hatası: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        // Ekleme
        String insertQuery = "INSERT INTO urunler (urunID, urunAdi, urunAdet, urunFiyat, kategoriID) VALUES (?, ?, ?, ?, ?)";
        boolean success = executeUpdate(insertQuery, " ");
        System.out.println(success ? "Ekleme başarılı!" : "Ekleme başarısız!");

        // Güncelleme
        String updateQuery = "UPDATE tablo SET kolon = ? WHERE id = ?";
        boolean updated = executeUpdate(updateQuery, " ");
        System.out.println(updated ? "Güncelleme başarılı!" : "Güncelleme başarısız!");

        // Silme
        String deleteQuery = "DELETE FROM urunler WHERE urunID= ?";
        boolean deleted = executeUpdate(deleteQuery, " ");
        System.out.println(deleted ? "Silme başarılı!" : "Silme başarısız!");

    }
}
