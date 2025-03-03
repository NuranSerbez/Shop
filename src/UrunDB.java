import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UrunDB {
    private static final String SELECT_ALL_URUN = "SELECT * FROM Urun";
    private static final String SELECT_KATEGORI_BY_ID = "SELECT * FROM Kategori WHERE kategoriID = ?";
    private static final String INSERT_URUN = "INSERT INTO Urun (urunID, urunAdi, urunAdet, urunFiyat, kategoriID) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_URUN = "UPDATE Urun SET urunAdi = ?, urunAdet = ?, urunFiyat = ?, kategoriID = ? WHERE urunID = ?";
    private static final String DELETE_URUN = "DELETE FROM Urun WHERE urunID = ?";

    public List<Urun> getAllUrunler() {
        List<Urun> urunler = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_URUN);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int kategoriID = rs.getInt("kategoriID");
                Kategori kategori = getKategoriByID(kategoriID, conn);

                Urun urun = new Urun(
                        rs.getInt("urunID")
                );
                urunler.add(urun);
            }
        } catch (SQLException e) {
            System.out.println("Ürün listeleme hatası: " + e.getMessage());
        }
        return urunler;
    }

    private Kategori getKategoriByID(int kategoriID, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_KATEGORI_BY_ID)) {
            stmt.setInt(1, kategoriID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Kategori(
                        rs.getInt("kategoriID"),
                        rs.getString("kategoriAdi")
                );
            }
        }
        return null;  // Eğer kategori bulunamazsa
    }

    public void add(Urun urun) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_URUN)) {
            stmt.setInt(1, urun.getUrunID());
            stmt.setString(2, urun.getUrunAdi());
            stmt.setInt(3, urun.getUrunAdet());
            stmt.setInt(4, urun.getUrunFiyat());
            stmt.setInt(5, urun.getKategori().getKategoriID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ürün ekleme hatası: " + e.getMessage());
        }
    }

    public void update(Urun urun) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_URUN)) {
            stmt.setString(1, urun.getUrunAdi());
            stmt.setInt(2, urun.getUrunAdet());
            stmt.setInt(3, urun.getUrunFiyat());
            stmt.setInt(4, urun.getKategori().getKategoriID());
            stmt.setInt(5, urun.getUrunID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ürün güncelleme hatası: " + e.getMessage());
        }
    }

    public void delete(Urun urun) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(DELETE_URUN)) {
            stmt.setInt(1, urun.getUrunID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ürün silme hatası: " + e.getMessage());
        }
    }
    public static void main(String[] args) {

    }
}
