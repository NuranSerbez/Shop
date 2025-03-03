import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusterilerDB {
    private static final String SELECT_ALL_MUSTERILER = "SELECT * FROM musteriler";
    private static final String INSERT_MUSTERI = "INSERT INTO musteriler (musteriID, ad, soyad, tckn, email) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_MUSTERI = "UPDATE musteriler SET ad = ?, soyad = ?, tckn = ?, email = ? WHERE musteriID = ?";
    private static final String DELETE_MUSTERI = "DELETE FROM musteriler WHERE musteriID = ?";

    // Tüm müşterileri listeleme
    public List<Musteriler> getAllMusteriler() {
        List<Musteriler> musteriler = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_MUSTERILER);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Müşteri objesini oluşturup listeye ekliyoruz
                Musteriler musteri = new Musteriler(
                        rs.getInt("musteriID"),
                        rs.getString("ad"),
                        rs.getString("soyad"),
                        rs.getInt("tckn")
                );
                musteri.setEmail(rs.getString("email"));
                musteriler.add(musteri); // Listeye ekle
            }
        } catch (SQLException e) {
            System.out.println("Müşteri listeleme hatası: " + e.getMessage());
        }
        return musteriler;
    }

    // Yeni müşteri ekleme
    public void add(Musteriler musteri) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_MUSTERI)) {
            stmt.setInt(1, musteri.getMusteriID());
            stmt.setString(2, musteri.getAd());
            stmt.setString(3, musteri.getSoyad());
            stmt.setInt(4, musteri.getTckn());
            stmt.setString(5, musteri.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Müşteri ekleme hatası: " + e.getMessage());
        }
    }

    // Müşteri güncelleme
    public void update(Musteriler musteri) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_MUSTERI)) {
            stmt.setString(1, musteri.getAd());
            stmt.setString(2, musteri.getSoyad());
            stmt.setInt(3, musteri.getTckn());
            stmt.setString(4, musteri.getEmail());
            stmt.setInt(5, musteri.getMusteriID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Müşteri güncelleme hatası: " + e.getMessage());
        }
    }

    // Müşteri silme
    public void delete(Musteriler musteri) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(DELETE_MUSTERI)) {
            stmt.setInt(1, musteri.getMusteriID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Müşteri silme hatası: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
    }
}
