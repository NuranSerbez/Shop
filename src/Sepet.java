import java.time.LocalDateTime;
import java.util.List;
public class Sepet {
    private int sepetID;
    private int musteriID;
    public LocalDateTime guncellemeTarihi;
    private List<SepetDetay> sepetDetaylar;
    public Sepet(int sepetID, int musteriID, LocalDateTime guncellemeTarihi, List<SepetDetay> sepetDetaylar) {
        this.sepetID = sepetID;
        this.musteriID = musteriID;
        this.guncellemeTarihi = guncellemeTarihi;
        this.sepetDetaylar = sepetDetaylar;
    }



    public Sepet(int sepetID, int musteriID, LocalDateTime now) {
    }

    public int getSepetID() {

        return sepetID;
    }
    public void setSepetID(int sepetID) {

        this.sepetID = sepetID;
    }
    public int getMusteriID() {

        return musteriID;
    }
    public void setMusteriID(int musteriID) {

        this.musteriID = musteriID;
    }
    public LocalDateTime getGuncellemeTarihi() {
        return guncellemeTarihi;
    }
    public void setGuncellemeTarihi(LocalDateTime guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
    }
    public List<SepetDetay> getSepetDetaylar() {

        return sepetDetaylar;
    }
    public void setSepetDetaylar(List<SepetDetay> sepetDetaylar) {

        this.sepetDetaylar = sepetDetaylar;
    }
    @Override
    public String toString() {
        return "Sepet{" + "sepetID=" + sepetID + ", musteriID='" + musteriID + '\'' + ", guncellemeTarihi=" + guncellemeTarihi  + '}';
    }
    public static void main(String[] args) {
        LocalDateTime getGuncellemeTarihi = LocalDateTime.now();
        System.out.println("BAŞARILI");
    }
}

