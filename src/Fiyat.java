public class Fiyat {
    private int fiyatID;
    private Urun urun;
    private int fiyat;

    public Fiyat(int fiyatID) {
        this.fiyatID = fiyatID;
        this.urun = urun;
        this.fiyat = fiyat;
    }

    public int getFiyatID() {

        return fiyatID;
    }

    public void setFiyatID(int fiyatID) {

        this.fiyatID = fiyatID;
    }

    public Urun getUrun() {

        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Fiyat{" + "fiyatID=" + fiyatID + ", urun='" + urun + '\'' + ", fiyat=" + fiyat + '}';
    }


    public static void main(String[] args) {

    }
}