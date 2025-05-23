//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FiyatDB {
//    private static final String SELECT_ALL_FIYAT = "SELECT * FROM fiyat";
//    private static final String SELECT_URUN_BY_ID = "SELECT * FROM urun WHERE urunID = ?";
//    private static final String INSERT_FIYAT ="INSERT INTO fiyat(fiyatID, urunID, fiyat) values (?,?,?)";
//    private static final String UPDATE_FIYAT = "UPDATE fiyat SET urunID = ?, fiyat = ? WHERE fiyatID = ?";
//    private static final String DELETE_FIYAT = "DELETE FROM fiyat WHERE fiyatID = ?";
//    public List<Fiyat> getAllFiyat() {
//        List<Fiyat>Fiyat = new ArrayList<>();
//        try  (Connection conn = DatabaseConnection.connect();
//              PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_FIYAT);
//              ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()){
//                int urunID = rs.getInt("urunID");
//                Urun urun = getUrunByID(urunID, conn);
//                Fiyat fiyat = new Fiyat(
//                        rs.getInt("fiyatID")
//                );
//                Fiyat.add(fiyat);
//            }
//        }catch (SQLException e) {
//            System.out.println("Fiyatları listeleme hatası: " + e.getMessage());
//        }
//        return Fiyat;
//    }
//    private Urun getUrunByID(int urunID, Connection conn) throws SQLException {
//        try (PreparedStatement stmt = conn.prepareStatement(SELECT_URUN_BY_ID)) {
//            stmt.setInt(1, urunID);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return new Urun(
//                        rs.getInt("urunID")
//                );
//            }
//        }
//        return null;
//    }
//
//
//    public void addFiyat(Fiyat fiyat) {
//        try(Connection conn = DatabaseConnection.connect();
//            PreparedStatement stmt = conn.prepareStatement(INSERT_FIYAT)){
//            stmt.setInt(1,fiyat.getFiyatID());
//            stmt.setInt(2,fiyat.getUrun().getUrunID());
//            stmt.setInt(3,fiyat.getFiyat());
//            stmt.executeUpdate();
//        }catch (SQLException e) {
//            System.out.println("Fiyat ekleme hatası: " + e.getMessage());
//        }
//    }
//
//    public void updateFiyat(Fiyat fiyat) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(UPDATE_FIYAT)){
//            stmt.setInt(1,fiyat.getFiyatID());
//            stmt.setInt(2,fiyat.getUrun().getUrunID());
//            stmt.setInt(3,fiyat.getFiyat());
//            stmt.executeUpdate();
//        }
//        catch (SQLException e) {
//            System.out.println("Fiyat güncelleme hatası: " + e.getMessage());
//        }
//    }
//    public void deleteFiyat(Fiyat fiyat) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(DELETE_FIYAT)) {
//            stmt.setInt(1, fiyat.getFiyat());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Ürün silme hatası: " + e.getMessage());
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//}
