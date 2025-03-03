import java.util.List;

public class Siparis {
    private int siparisID;
    private int musteriID;
    private int toplamTutar;
    private List<SiparisDetay> siparisDetaylar;

    public Siparis(int siparisID, int musteriID, int toplamTutar, List<SiparisDetay> siparisDetaylar) {
        this.siparisID = siparisID;
        this.musteriID = musteriID;
        this.siparisDetaylar = siparisDetaylar;
        this.toplamTutar = hesaplaToplamTutar();
    }

    public int getSiparisID() {

        return siparisID;
    }

    public void setSiparisID(int siparisID) {

        this.siparisID = siparisID;
    }

    public int getMusteriID() {

        return musteriID;
    }

    public void setMusteriID(int musteriID) {

        this.musteriID = musteriID;
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
            toplam += siparisDetay.getAdet() * siparisDetay.getFiyatID();
        }
        return toplam;
    }

    public static void main(String[] args) {

    }
}

