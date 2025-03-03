public class Fiyat {
    private int fiyatID;
    private int urunID;
    private int fiyat;

    public Fiyat(int fiyatID, int urunID, int fiyat) {
        this.fiyatID = fiyatID;
        this.urunID = urunID;
        this.fiyat = fiyat;
    }

    public int getFiyatID() {

        return fiyatID;
    }

    public void setFiyatID(int fiyatID) {

        this.fiyatID = fiyatID;
    }

    public int getUrunID() {

        return urunID;
    }

    public void setUrunID(int urunID) {
        this.urunID = urunID;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Fiyat{" + "fiyatID=" + fiyatID + ", urunID='" + urunID + '\'' + ", fiyat=" + fiyat + '}';
    }


    public static void main(String[] args) {

    }
}