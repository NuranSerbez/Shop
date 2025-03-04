//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.time.LocalDateTime;
//
//public class SepetDB {
//    private static final String SELECT_ALL_SEPET = "SELECT * FROM sepet";
//    private static final String SELECT_MUSTERILER_BY_ID = "SELECT * FROM musteriler WHERE musteriID = ?";
//    private static final String INSERT_SEPET = "INSERT INTO sepet (sepetID, musteriID, guncellemeTarihi) VALUES (?, ?, ?)";
//    private static final String UPDATE_SEPET = "UPDATE sepet SET musteriID = ?, guncellemeTarihi = ? WHERE sepetID = ?";
//    private static final String DELETE_SEPET = "DELETE FROM sepet WHERE sepetID = ?";
//
//    public List<Sepet> getAllSepet() {
//        List<Sepet> sepetler = new ArrayList<>();
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SEPET);
//             ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                int musteriID = rs.getInt("musteriID");
//                Musteriler musteriler = getMusterilerByID(musteriID, conn);
//                LocalDateTime guncellemeTarihi = rs.getTimestamp("guncellemeTarihi").toLocalDateTime();
//                Sepet sepet = new Sepet(
//                        rs.getInt("sepetID"),
//                        musteriler,
//                        LocalDateTime.now()
//                );
//                sepetler.add(sepet);
//            }
//        } catch (SQLException e) {
//            System.out.println("Sepet listeleme hatası: " + e.getMessage());
//        }
//        return sepetler;
//    }
//    private Musteriler getMusterilerByID(int musteriID, Connection conn) throws SQLException {
//        try (PreparedStatement stmt = conn.prepareStatement(SELECT_MUSTERILER_BY_ID)) {
//            stmt.setInt(1, musteriID);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return new Musteriler(
//                        rs.getInt("musteriID")
//                );
//            }
//        }
//        return null;
//    }
//
//    public void add(Sepet sepet) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(INSERT_SEPET)) {
//            stmt.setInt(1, sepet.getSepetID());
//            stmt.setInt(2, sepet.getMusteriler().getMusteriID());
//            stmt.setTimestamp(3, Timestamp.valueOf(sepet.getGuncellemeTarihi()));
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Sepet ekleme hatası: " + e.getMessage());
//        }
//    }
//
//    public void update(Sepet sepet) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(UPDATE_SEPET)) {
//            stmt.setInt(1, sepet.getMusteriler().getMusteriID());
//            stmt.setTimestamp(2, Timestamp.valueOf(sepet.getGuncellemeTarihi()));
//            stmt.setInt(3, sepet.getSepetID());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Sepet güncelleme hatası: " + e.getMessage());
//        }
//    }
//
//    public void delete(Sepet sepet) {
//        try (Connection conn = DatabaseConnection.connect();
//             PreparedStatement stmt = conn.prepareStatement(DELETE_SEPET)) {
//            stmt.setInt(1, sepet.getSepetID());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Sepet silme hatası: " + e.getMessage());
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//
//}
