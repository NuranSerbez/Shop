import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SepetDetayDB {
    private static final String SELECT_ALL_SEPETDETAY = "SELECT * FROM sepetdetay";
    private static final String SELECT_SEPET_BY_ID = "SELECT * FROM sepet WHERE sepetID = ?";
    private static final String SELECT_URUN_BY_ID = "SELECT * FROM urun WHERE urunID = ?";
    private static final String SELECT_FIYAT_BY_ID = "SELECT * FROM fiyat WHERE fiyatID = ?";
    private static final String INSERT_SEPETDETAY = "INSERT INTO sepetdetay (sepetdetayID, sepetID, urunID, fiyatID, adet) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SEPETDETAY = "UPDATE sepetdetay SET sepetID = ?, urunID = ?, fiyatID = ? WHERE sepetdetayID = ?";
    private static final String DELETE_SEPETDETAY = "DELETE FROM sepetdetay Where sepetdetayID = ?";

    public List<SepetDetay> getAllSepetDetay() {
        List<SepetDetay> sepetDetay = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SEPETDETAY);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int sepetID = rs.getInt("sepetID");
                Sepet sepet = getSepetByID(sepetID, conn);
                int urunID = rs.getInt("urunID");
                Urun urun = getUrunByID(urunID, conn);
                int fiyatID = rs.getInt("fiyatID");
                Fiyat fiyat = getFiyatByID(fiyatID, conn);
                SepetDetay sepetdetay = new SepetDetay(
                        rs.getInt("sepetdetayID"),
                        sepet,
                        urun,
                        fiyat,
                        rs.getInt("adet")
                );
                sepetDetay.add(sepetdetay);
            }
        } catch (SQLException e) {
            System.out.println("Sepet Detay listeleme hatası: " + e.getMessage());
        }
        return sepetDetay;
    }
    private Sepet getSepetByID(int sepetID, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_SEPET_BY_ID)) {
            stmt.setInt(1, sepetID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Sepet(
                        rs.getInt("sepetID")
                );
            }
        }
        return null;
    }
    private Urun getUrunByID(int urunID, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_URUN_BY_ID)) {
            stmt.setInt(1, urunID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Urun(
                        rs.getInt("urunID")
                );
            }
        }
        return null;
    }
    private Fiyat getFiyatByID(int fiyatID, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_FIYAT_BY_ID)) {
            stmt.setInt(1, fiyatID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Fiyat(
                        rs.getInt("fiyatID")
                );
            }
        }
        return null;
    }

    public void addSepetDetay(SepetDetay sepetDetay) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SEPETDETAY)) {
            stmt.setInt(1, sepetDetay.getSepet().getSepetID());
            stmt.setInt(2, sepetDetay.getUrun().getUrunID());
            stmt.setInt(3, sepetDetay.getFiyat().getFiyatID());
            stmt.setInt(4, sepetDetay.getAdet());
            stmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Sepet Detay Listesine Ekleme hatası: " + e.getMessage());
        }
    }
    public void updateSepetDetay(SepetDetay sepetDetay) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_SEPETDETAY)) {
            stmt.setInt(1, sepetDetay.getSepet().getSepetID());
            stmt.setInt(2, sepetDetay.getUrun().getUrunID());
            stmt.setInt(3, sepetDetay.getFiyat().getFiyatID());
            stmt.setInt(4, sepetDetay.getAdet());
            stmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Sepet Detay güncelleme hatası: " + e.getMessage());
        }
    }
    public void deleteSepetDetay(SepetDetay sepetDetay) {
        try (Connection conn = DatabaseConnection.connect()) {
            try (PreparedStatement stmt = conn.prepareStatement(DELETE_SEPETDETAY)) {
                stmt.setInt(1, sepetDetay.getSepetdetayID());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Ürün silme hatası: " + e.getMessage());
        }
    }
    public static void main(String[] args) {

    }
}

