public class SiparisDetay {
    private int siparisdetayID;
    private int siparisID;
    private int urunID;
    private int adet;
    private int fiyatID;

    public SiparisDetay(int siparisdetayID, int siparisID, int urunID, int adet, int fiyatID) {
        this.siparisdetayID = siparisdetayID;
        this.siparisID = siparisID;
        this.urunID = urunID;
        this.adet = adet;
        this.fiyatID = fiyatID;
    }

    public int getSiparisdetayID() {

        return siparisdetayID;
    }

    public void setSiparisdetayID(int siparisdetayID) {

        this.siparisdetayID = siparisdetayID;
    }

    public int getSiparisID() {

        return siparisID;
    }

    public void setSiparisID(int siparisID) {

        this.siparisID = siparisID;
    }

    public int getUrunID() {

        return urunID;
    }

    public void setUrunID(int urunID) {

        this.urunID = urunID;
    }

    public int getAdet() {

        return adet;
    }

    public void setAdet(int adet) {

        this.adet = adet;
    }

    public int getFiyatID() {

        return fiyatID;
    }

    public void setFiyatID(int FiyatID) {

        this.fiyatID = fiyatID;
    }

    public static void main(String[] args) {

    }
}

