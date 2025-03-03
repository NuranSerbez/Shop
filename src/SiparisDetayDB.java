import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiparisDetayDB {
    private static final String SELECT_ALL_SIPARIS_DETAY = "SELECT * FROM siparisdetay";
    private static final String INSERT_SIPARIS_DETAY = "INSERT INTO siparisdetay (siparisdetayID, siparisID, urunID, adet, fiyatID) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_SIPARIS_DETAY = "UPDATE siparisdetay SET siparisID = ?, urunID = ?, adet = ?, fiyatID = ? WHERE siparisdetayID = ?";
    private static final String DELETE_SIPARIS_DETAY = "DELETE FROM siparisdetay WHERE siparisdetayID = ?";

    public List<SiparisDetay> getAllSiparisDetay() {
        List<SiparisDetay> siparisDetaylar = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SIPARIS_DETAY);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                SiparisDetay siparisDetay = new SiparisDetay(
                        rs.getInt("siparisdetayID"),
                        rs.getInt("siparisID"),
                        rs.getInt("urunID"),
                        rs.getInt("adet"),
                        rs.getInt("fiyatID")
                );
                siparisDetaylar.add(siparisDetay);
            }
        } catch (SQLException e) {
            System.out.println("Sipariş Detay listeleme hatası: " + e.getMessage());
        }
        return siparisDetaylar;
    }

    public void add(SiparisDetay siparisDetay) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SIPARIS_DETAY)) {
            stmt.setInt(1, siparisDetay.getSiparisdetayID());
            stmt.setInt(2, siparisDetay.getSiparisID());
            stmt.setInt(3, siparisDetay.getUrunID());
            stmt.setInt(4, siparisDetay.getAdet());
            stmt.setInt(5, siparisDetay.getFiyatID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sipariş Detay ekleme hatası: " + e.getMessage());
        }
    }

    public void update(SiparisDetay siparisDetay) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_SIPARIS_DETAY)) {
            stmt.setInt(1, siparisDetay.getSiparisdetayID());
            stmt.setInt(2, siparisDetay.getSiparisID());
            stmt.setInt(3, siparisDetay.getUrunID());
            stmt.setInt(4, siparisDetay.getAdet());
            stmt.setInt(5, siparisDetay.getFiyatID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sipariş Detay güncelleme hatası: " + e.getMessage());
        }
    }

    public void delete(SiparisDetay siparisDetay) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(DELETE_SIPARIS_DETAY)) {
            stmt.setInt(1, siparisDetay.getSiparisdetayID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sipariş Detay silme hatası: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    }
}

