public class SiparisDetay {
    private int siparisdetayID;
    private Siparis siparis;
    private Urun urun;
    private int adet;
    private Fiyat fiyat;

    public SiparisDetay(int siparisdetayID, Siparis siparis, Urun urun, int adet, Fiyat fiyat) {
        this.siparisdetayID = siparisdetayID;
        this.siparis = siparis;
        this.urun = urun;
        this.adet = adet;
        this.fiyat = fiyat;
    }

    public int getSiparisdetayID() {

        return siparisdetayID;
    }

    public void setSiparisdetayID(int siparisdetayID) {

        this.siparisdetayID = siparisdetayID;
    }

    public Siparis getSiparis() {

        return siparis;
    }

    public void setSiparis(Siparis siparis) {

        this.siparis = siparis;
    }

    public Urun getUrun() {

        return urun;
    }

    public void setUrun(Urun urun) {

        this.urun = urun;
    }

    public int getAdet() {

        return adet;
    }

    public void setAdet(int adet) {

        this.adet = adet;
    }

    public Fiyat getFiyat() {

        return fiyat;
    }

    public void setFiyat(Fiyat fiyat) {

        this.fiyat = fiyat;
    }

    public static void main(String[] args) {

    }
}

