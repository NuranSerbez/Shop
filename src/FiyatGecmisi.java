public class FiyatGecmisi {
    private int fiyatgecmisiID;
    private int urunID;
    private int fiyatID;
    private boolean gecerlilik;
    public FiyatGecmisi(int fiyatgecmisiID, int urunID, int fiyatID, boolean gecerlilik) {
        this.fiyatgecmisiID = fiyatgecmisiID;
        this.urunID = urunID;
        this.fiyatID = fiyatID;
        this.gecerlilik = gecerlilik;
    }

    public int getFiyatgecmisiID() {
        return fiyatgecmisiID;
    }

    public void setFiyatgecmisiID(int fiyatgecmisiID) {
        this.fiyatgecmisiID = fiyatgecmisiID;
    }

    public int getUrunID() {
        return urunID;
    }

    public void setUrunID(int urunID) {
        this.urunID = urunID;
    }

    public int getFiyatID() {
        return fiyatID;
    }

    public void setFiyatID(int fiyatID) {
        this.fiyatID = fiyatID;
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
