import java.util.List;

public class SepetDetay {
    private int sepetdetayID;
    private int sepetID;
    private int urunID;
    private int fiyatID;
    private int adet;
    public SepetDetay(int sepetdetayID, int sepetID, int urunID, int fiyatID, int adet) {
        this.sepetdetayID = sepetdetayID;
        this.sepetID = sepetID;
        this.urunID = urunID;
        this.fiyatID = fiyatID;
        this.adet = adet;
    }
    public int getSepetdetayID() {

        return sepetdetayID;
    }
    public void setSepetdetayID(int sepetdetayID) {

        this.sepetdetayID = sepetdetayID;
    }
    public int getSepetID() {

        return sepetID;
    }
    public void setSepetID(int sepetID) {

        this.sepetID = sepetID;
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
    public int getAdet() {

        return adet;
    }
    public void setAdet(int adet) {
        this.adet = adet;
    }
    public static void main(String[] args) {
    }
}

