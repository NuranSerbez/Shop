import java.util.List;

public class SepetDetay {
    private int sepetdetayID;
    private Sepet sepet;
    private Urun urun;
    private Fiyat fiyat;
    private int adet;
    public SepetDetay(int sepetdetayID, Sepet sepet, Urun urun, Fiyat fiyat, int adet) {
        this.sepetdetayID = sepetdetayID;
        this.sepet = sepet;
        this.urun = urun;
        this.fiyat = fiyat;
        this.adet = adet;
    }
    public int getSepetdetayID() {

        return sepetdetayID;
    }
    public void setSepetdetayID(int sepetdetayID) {

        this.sepetdetayID = sepetdetayID;
    }
    public Sepet getSepet() {

        return sepet;
    }
    public void setSepet(Sepet sepet) {

        this.sepet = sepet;
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
    public int getAdet() {

        return adet;
    }
    public void setAdet(int adet) {

        this.adet = adet;
    }
    public static void main(String[] args) {
    }
}

