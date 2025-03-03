import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FiyatGecmisiDB {
    private static final String SELECT_ALL_FIATGECMISI = "SELECT * FROM fiyatgecmisi";
    private static final String INSERT_FIATGECMISI = "INSERT INTO fiyatgecmisi (fiyatgecmisiID, urunID, fiyatID, gecerlilik) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_FIATGECMISI = "UPDATE fiyatgecmisi SET urunID = ?, fiyatID = ?, gecerlilik = ? WHERE fiyatgecmisiID = ?";
    private static final String DELETE_FIATGECMISI = "DELETE FROM fiyatgecmisi WHERE fiyatgecmisiID = ?";

    // Tüm fiyat geçmişlerini listeleme
    public List<FiyatGecmisi> getAllFiyatGecmisi() {
        List<FiyatGecmisi> fiyatGecmisleri = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_FIATGECMISI);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Fiyatgecmisi objesini oluşturup listeye ekliyoruz
                FiyatGecmisi fiyatgecmisi = new FiyatGecmisi(
                        rs.getInt("fiyatgecmisiID"),
                        rs.getInt("urunID"),
                        rs.getInt("fiyatID"),
                        rs.getBoolean("gecerlilik")
                );
                fiyatGecmisleri.add(fiyatgecmisi); // Listeye ekle
            }
        } catch (SQLException e) {
            System.out.println("Fiyat geçmişi listeleme hatası: " + e.getMessage());
        }
        return fiyatGecmisleri;
    }

    // Yeni fiyat geçmişi ekleme
    public void add(FiyatGecmisi fiyatgecmisi) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_FIATGECMISI)) {
            stmt.setInt(1, fiyatgecmisi.getFiyatgecmisiID());
            stmt.setInt(2, fiyatgecmisi.getUrunID());
            stmt.setInt(3, fiyatgecmisi.getFiyatID());
            stmt.setBoolean(4, fiyatgecmisi.isGecerlilik());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fiyat geçmişi ekleme hatası: " + e.getMessage());
        }
    }

    // Fiyat geçmişini güncelleme
    public void update(FiyatGecmisi fiyatgecmisi) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_FIATGECMISI)) {
            stmt.setInt(1, fiyatgecmisi.getUrunID());
            stmt.setInt(2, fiyatgecmisi.getFiyatID());
            stmt.setBoolean(3, fiyatgecmisi.isGecerlilik());
            stmt.setInt(4, fiyatgecmisi.getFiyatgecmisiID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fiyat geçmişi güncelleme hatası: " + e.getMessage());
        }
    }

    // Fiyat geçmişini silme
    public void delete(FiyatGecmisi fiyatgecmisi) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(DELETE_FIATGECMISI)) {
            stmt.setInt(1, fiyatgecmisi.getFiyatgecmisiID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fiyat geçmişi silme hatası: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}

