public class FiyatGecmisi {
    private int fiyatgecmisiID;
    private Urun urun;
    private Fiyat fiyat;
    private boolean gecerlilik;
    public FiyatGecmisi(int fiyatgecmisiID, Urun urun, Fiyat fiyat, boolean gecerlilik) {
        this.fiyatgecmisiID = fiyatgecmisiID;
        this.urun = urun;
        this.fiyat = fiyat;
        this.gecerlilik = gecerlilik;
    }

    public int getFiyatgecmisiID() {
        return fiyatgecmisiID;
    }

    public void setFiyatgecmisiID(int fiyatgecmisiID) {
        this.fiyatgecmisiID = fiyatgecmisiID;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public Fiyat getFiyat() {
        return fiyat;
    }

    public void setFiyat(Fiyat fiyat) {
        this.fiyat = fiyat;
    }

    public boolean isGecerlilik() {
        return gecerlilik;
    }

    public void setGecerlilik(boolean gecerlilik) {
        this.gecerlilik = gecerlilik;
    }

    public static void main(String[] args) {

    }
}
