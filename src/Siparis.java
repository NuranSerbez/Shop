import java.util.List;

public class Siparis {
    private int siparisID;
    private Musteriler musteriler;
    private int toplamTutar;
    private List<SiparisDetay> siparisDetaylar;

    public Siparis(int siparisID) {
        this.siparisID = siparisID;
        this.musteriler = musteriler;
        this.siparisDetaylar = siparisDetaylar;
        this.toplamTutar = hesaplaToplamTutar();
    }

    public int getSiparisID() {

        return siparisID;
    }

    public void setSiparisID(int siparisID) {

        this.siparisID = siparisID;
    }

    public Musteriler getMusteriler() {

        return musteriler;
    }

    public void setMusteriler(Musteriler musteriler) {

        this.musteriler = musteriler;
    }

    public List<SiparisDetay> getSiparisDetaylar() {

        return siparisDetaylar;
    }

    public int getToplamTutar() {

        return toplamTutar;
    }

    public void setSiparisDetaylar(List<SiparisDetay> siparisDetaylar) {

        this.siparisDetaylar = siparisDetaylar;
        this.toplamTutar = hesaplaToplamTutar();
    }

    private int hesaplaToplamTutar() {
        int toplam = 0;
        for (SiparisDetay siparisDetay : siparisDetaylar) {
            toplam += siparisDetay.getAdet() * siparisDetay.getFiyat().getFiyatID();
        }
        return toplam;
    }

    public static void main(String[] args) {

    }
}

