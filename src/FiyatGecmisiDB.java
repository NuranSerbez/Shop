//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FiyatGecmisiDB {
//    private static final String SELECT_ALL_FIYATGECMISI = "SELECT * FROM fiyatgecmisi";
//    private static final String SELECT_URUN_BY_ID = "SELECT * FROM urun WHERE urunID = ?";
//    private static final String SELECT_FIYAT_BY_ID = "SELECT * FROM fiyat WHERE fiyatID = ?";
//    private static final String INSERT_FIYATGECMISI = "INSERT INTO fiyatgecmisi (fiyatgecmisiID, urunID, fiyatID, gecerlilik) VALUES (?, ?, ?, ?)";
//    private static final String UPDATE_FIYATGECMISI = "UPDATE fiyatgecmisi SET urunID = ?, fiyatID = ?, gecerlilik = ? WHERE fiyatgecmisiID = ?";
//    private static final String DELETE_FIYATGECMISI = "DELETE FROM fiyatgecmisi WHERE fiyatgecmisiID = ?";
//
//    public List<FiyatGecmisi> getAllFiyatGecmisi() {
//        List<FiyatGecmisi> fiyatGecmisleri = new ArrayList<>();
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_FIYATGECMISI);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                int urunID = rs.getInt("urunID");
//                Urun urun = getUrunByID(urunID, conn);
//                int fiyatID = rs.getInt("fiyatID");
//                Fiyat fiyat = getFiyatByID(fiyatID, conn);
//                FiyatGecmisi fiyatgecmisi = new FiyatGecmisi(
//                        rs.getInt("fiyatgecmisiID"),
//                        urun,
//                        fiyat,
//                        rs.getBoolean("gecerlilik")
//                );
//                fiyatGecmisleri.add(fiyatgecmisi);
//            }
//        } catch (SQLException e) {
//            System.out.println("Fiyat geçmişi listeleme hatası: " + e.getMessage());
//        }
//        return fiyatGecmisleri;
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
//    private Fiyat getFiyatByID(int fiyatID, Connection conn) throws SQLException {
//        try (PreparedStatement stmt = conn.prepareStatement(SELECT_FIYAT_BY_ID)) {
//            stmt.setInt(1, fiyatID);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return new Fiyat(
//                        rs.getInt("fiyatID"));
//            }
//        }
//        return null;
//    }
//
//    public void add(FiyatGecmisi fiyatgecmisi) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(INSERT_FIYATGECMISI)) {
//            stmt.setInt(1, fiyatgecmisi.getFiyatgecmisiID());
//            stmt.setInt(2, fiyatgecmisi.getUrun().getUrunID());
//            stmt.setInt(3, fiyatgecmisi.getFiyat().getFiyatID());
//            stmt.setBoolean(4, fiyatgecmisi.isGecerlilik());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Fiyat geçmişi ekleme hatası: " + e.getMessage());
//        }
//    }
//
//    public void update(FiyatGecmisi fiyatgecmisi) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(UPDATE_FIYATGECMISI)) {
//            stmt.setInt(1, fiyatgecmisi.getUrun().getUrunID());
//            stmt.setInt(2, fiyatgecmisi.getFiyat().getFiyatID());
//            stmt.setBoolean(3, fiyatgecmisi.isGecerlilik());
//            stmt.setInt(4, fiyatgecmisi.getFiyatgecmisiID());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Fiyat geçmişi güncelleme hatası: " + e.getMessage());
//        }
//    }
//
//    public void delete(FiyatGecmisi fiyatgecmisi) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(DELETE_FIYATGECMISI)) {
//            stmt.setInt(1, fiyatgecmisi.getFiyatgecmisiID());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Fiyat geçmişi silme hatası: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
//
