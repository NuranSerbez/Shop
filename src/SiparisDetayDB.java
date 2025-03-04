//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SiparisDetayDB {
//    private static final String SELECT_ALL_SIPARIS_DETAY = "SELECT * FROM siparisdetay";
//    private static final String SELECT_SIPARIS_BY_ID = "SELECT * FROM siparis WHERE siparisID = ?";
//    private static final String SELECT_URUN_BY_ID = "SELECT * FROM urun WHERE urunID = ?";
//    private static final String SELECT_FIYAT_BY_ID = "SELECT * FROM fiyat WHERE fiyatID = ?";
//    private static final String INSERT_SIPARIS_DETAY = "INSERT INTO siparisdetay (siparisdetayID, siparisID, urunID, adet, fiyatID) VALUES (?, ?, ?, ?, ?)";
//    private static final String UPDATE_SIPARIS_DETAY = "UPDATE siparisdetay SET siparisID = ?, urunID = ?, adet = ?, fiyatID = ? WHERE siparisdetayID = ?";
//    private static final String DELETE_SIPARIS_DETAY = "DELETE FROM siparisdetay WHERE siparisdetayID = ?";
//
//    public List<SiparisDetay> getAllSiparisDetay() {
//        List<SiparisDetay> siparisDetaylar = new ArrayList<>();
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SIPARIS_DETAY);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                int siparisID = rs.getInt("siparisID");
//                Siparis siparis = getSiparisByID(siparisID, conn);
//                int urunID = rs.getInt("urunID");
//                Urun urun = getUrunByID(urunID, conn);
//                int fiyatID = rs.getInt("fiyatID");
//                Fiyat fiyat = getFiyatByID(fiyatID, conn);
//                SiparisDetay siparisDetay = new SiparisDetay(
//                        rs.getInt("siparisdetayID"),
//                        siparis,
//                        urun,
//                        rs.getInt("adet"),
//                        fiyat
//                );
//                siparisDetaylar.add(siparisDetay);
//            }
//        } catch (SQLException e) {
//            System.out.println("Sipariş Detay listeleme hatası: " + e.getMessage());
//        }
//        return siparisDetaylar;
//    }
//    private Siparis getSiparisByID(int siparisID, Connection conn) throws SQLException {
//        try (PreparedStatement stmt = conn.prepareStatement(SELECT_SIPARIS_BY_ID)) {
//            stmt.setInt(1, siparisID);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return new Siparis(
//                        rs.getInt("siparisID")
//                );
//            }
//        }
//        return null;
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
//                        rs.getInt("fiyatID")
//                );
//            }
//        }
//        return null;
//    }
//
//    public void add(SiparisDetay siparisDetay) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(INSERT_SIPARIS_DETAY)) {
//            stmt.setInt(1, siparisDetay.getSiparisdetayID());
//            stmt.setInt(2, siparisDetay.getSiparis().getSiparisID());
//            stmt.setInt(3, siparisDetay.getUrun().getUrunID());
//            stmt.setInt(4, siparisDetay.getAdet());
//            stmt.setInt(5, siparisDetay.getFiyat().getFiyatID());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Sipariş Detay ekleme hatası: " + e.getMessage());
//        }
//    }
//
//    public void update(SiparisDetay siparisDetay) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(UPDATE_SIPARIS_DETAY)) {
//            stmt.setInt(1, siparisDetay.getSiparisdetayID());
//            stmt.setInt(2, siparisDetay.getSiparis().getSiparisID());
//            stmt.setInt(3, siparisDetay.getUrun().getUrunID());
//            stmt.setInt(4, siparisDetay.getAdet());
//            stmt.setInt(5, siparisDetay.getFiyat().getFiyatID());
//
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Sipariş Detay güncelleme hatası: " + e.getMessage());
//        }
//    }
//
//    public void delete(SiparisDetay siparisDetay) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(DELETE_SIPARIS_DETAY)) {
//            stmt.setInt(1, siparisDetay.getSiparisdetayID());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Sipariş Detay silme hatası: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//    }
//}
//
