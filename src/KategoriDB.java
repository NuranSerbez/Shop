import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KategoriDB {
    private static final String SELECT_ALL_KATEGORI = "SELECT * FROM Kategori";
    private static final String INSERT_KATEGORI = "INSERT INTO Kategori (kategoriID, kategoriAdi) VALUES (?, ?)";
    private static final String UPDATE_KATEGORI = "UPDATE Kategori SET kategoriAdi = ? WHERE kategoriID = ?";
    private static final String DELETE_KATEGORI = "DELETE FROM Kategori WHERE kategoriID = ?";

    public List<Kategori> getAllKategoriler() {
        List<Kategori> kategoriler = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_KATEGORI);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Kategori kategori = new Kategori(
                        rs.getInt("kategoriID"),
                        rs.getString("kategoriAdi")
                );
                kategoriler.add(kategori);
            }
        } catch (SQLException e) {
            System.out.println("Kategori listeleme hatası: " + e.getMessage());
        }
        return kategoriler;
    }

    public void add(Kategori kategori) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_KATEGORI)) {
            stmt.setInt(1, kategori.getKategoriID());
            stmt.setString(2, kategori.getKategoriAdi());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kategori ekleme hatası: " + e.getMessage());
        }
    }

    public void update(Kategori kategori) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_KATEGORI)) {
            stmt.setString(1, kategori.getKategoriAdi());
            stmt.setInt(2, kategori.getKategoriID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kategori güncelleme hatası: " + e.getMessage());
        }
    }

    public void delete(Kategori kategori) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(DELETE_KATEGORI)) {
            stmt.setInt(1, kategori.getKategoriID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kategori silme hatası: " + e.getMessage());
        }
    }

public static void main(String[] args) {

    }
}
