import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiparisDB {
    private static final String SELECT_ALL_SIPARIS = "SELECT * FROM siparis";
    private static final String INSERT_SIPARIS = "INSERT INTO siparis (siparisID, musteriID, toplamTutar) VALUES (?, ?, ?)";
    private static final String UPDATE_SIPARIS = "UPDATE siparis SET musteriID = ?, toplamTutar = ? WHERE siparisID = ?";
    private static final String DELETE_SIPARIS = "DELETE FROM siparis WHERE siparisID = ?";

    public List<Siparis> getAllSiparis() {
        List<Siparis> siparisler = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SIPARIS);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Siparis siparis = new Siparis(
                        rs.getInt("siparisID"),
                        rs.getInt("musteriID"),
                        rs.getInt("toplamTutar"),
                        new ArrayList<>()
                );
                siparisler.add(siparis);
            }
        } catch (SQLException e) {
            System.out.println("Sipariş listeleme hatası: " + e.getMessage());
        }
        return siparisler;
    }

    public void add(Siparis siparis) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SIPARIS)) {
            stmt.setInt(1, siparis.getSiparisID());
            stmt.setInt(2, siparis.getMusteriID());
            stmt.setInt(3, siparis.getToplamTutar());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sipariş ekleme hatası: " + e.getMessage());
        }
    }

    public void update(Siparis siparis) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_SIPARIS)) {
            stmt.setInt(1, siparis.getSiparisID());
            stmt.setInt(2, siparis.getMusteriID());
            stmt.setInt(3, siparis.getToplamTutar());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sipariş güncelleme hatası: " + e.getMessage());
        }
    }

    public void delete(Siparis siparis) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(DELETE_SIPARIS)) {
            stmt.setInt(1, siparis.getSiparisID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sipariş silme hatası: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    }
}

