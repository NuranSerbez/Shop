import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SepetDetayDB {
    private static final String SELECT_ALL_SEPETDETAY = "SELECT * FROM sepetdetay";
    private static final String INSERT_SEPETDETAY = "INSERT INTO sepetdetay (sepetdetayID, sepetID, urunID, fiyatID, adet) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SEPETDETAY = "UPDATE sepetdetay SET sepetID = ?, urunID = ?, fiyatID = ? WHERE sepetdetayID = ?";
    private static final String DELETE_SEPETDETAY = "DELETE FROM sepetdetay Where sepetdetayID = ?";

    public List<SepetDetay> getAllSepetDetay() {
        List<SepetDetay> sepetDetay = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SEPETDETAY);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                SepetDetay sepetdetay = new SepetDetay(
                        rs.getInt("sepetdetayID"),
                        rs.getInt("sepetID"),
                        rs.getInt("urunID"),
                        rs.getInt("fiyatID"),
                        rs.getInt("adet")
                );
                sepetDetay.add(sepetdetay);
            }
        } catch (SQLException e) {
            System.out.println("Sepet Detay listeleme hatası: " + e.getMessage());
        }
        return sepetDetay;
    }

    public void addSepetDetay(SepetDetay sepetDetay) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SEPETDETAY)) {
            stmt.setInt(1, sepetDetay.getSepetID());
            stmt.setInt(2, sepetDetay.getUrunID());
            stmt.setInt(3, sepetDetay.getFiyatID());
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
            stmt.setInt(1, sepetDetay.getSepetID());
            stmt.setInt(2, sepetDetay.getUrunID());
            stmt.setInt(3, sepetDetay.getFiyatID());
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

