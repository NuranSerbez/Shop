import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IletisimDB {
    private static final String SELECT_ALL_ILETISIM = "SELECT * FROM iletisim";
    private static final String INSERT_ILETISIM = "INSERT INTO iletisim (iletisimID, musteriID, adres, telefon) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ILETISIM = "UPDATE iletisim SET musteriID = ?, adres = ?, telefon = ? WHERE iletisimID = ?";
    private static final String DELETE_ILETISIM = "DELETE FROM iletisim WHERE iletisimID = ?";

    // Tüm iletişim bilgilerini listeleme
    public List<Iletisim> getAllIletisim() {
        List<Iletisim> iletisimler = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_ILETISIM);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Iletisim objesini oluşturup listeye ekliyoruz
                Iletisim iletisim = new Iletisim(
                        rs.getInt("iletisimID"),
                        rs.getInt("musteriID"),
                        rs.getString("adres"),
                        rs.getInt("telefon")
                );
                iletisimler.add(iletisim); // Listeye ekle
            }
        } catch (SQLException e) {
            System.out.println("İletişim listeleme hatası: " + e.getMessage());
        }
        return iletisimler;
    }

    // Yeni iletişim ekleme
    public void add(Iletisim iletisim) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_ILETISIM)) {
            stmt.setInt(1, iletisim.getIletisimID());
            stmt.setInt(2, iletisim.getMusteriID());
            stmt.setString(3, iletisim.getAdres());
            stmt.setInt(4, iletisim.getTelefon());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("İletişim ekleme hatası: " + e.getMessage());
        }
    }

    // İletişim güncelleme
    public void update(Iletisim iletisim) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_ILETISIM)) {
            stmt.setInt(1, iletisim.getMusteriID());
            stmt.setString(2, iletisim.getAdres());
            stmt.setInt(3, iletisim.getTelefon());
            stmt.setInt(4, iletisim.getIletisimID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("İletişim güncelleme hatası: " + e.getMessage());
        }
    }

    // İletişim silme
    public void delete(Iletisim iletisim) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(DELETE_ILETISIM)) {
            stmt.setInt(1, iletisim.getIletisimID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("İletişim silme hatası: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}

