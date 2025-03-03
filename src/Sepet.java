import java.time.LocalDateTime;
import java.util.List;
public class Sepet {
    private int sepetID;
    private Musteriler musteriler;
    public LocalDateTime guncellemeTarihi;
    private List<SepetDetay> sepetDetaylar;
    public Sepet(int sepetID) {
        this.sepetID = sepetID;
        this.musteriler = musteriler;
        this.guncellemeTarihi = guncellemeTarihi;
        this.sepetDetaylar = sepetDetaylar;
    }



    public Sepet(int sepetID, Musteriler musteriler, LocalDateTime now) {
    }

    public int getSepetID() {

        return sepetID;
    }
    public void setSepetID(int sepetID) {

        this.sepetID = sepetID;
    }
    public Musteriler getMusteriler() {

        return musteriler;
    }
    public void setMusteriler(Musteriler musteriler) {

        this.musteriler = musteriler;
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
        return "Sepet{" + "sepetID=" + sepetID + ", musteriler='" + musteriler + '\'' + ", guncellemeTarihi=" + guncellemeTarihi  + '}';
    }
    public static void main(String[] args) {
        LocalDateTime getGuncellemeTarihi = LocalDateTime.now();
        System.out.println("BAŞARILI");
    }
}

