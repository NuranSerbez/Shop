public class Urun {
    private int urunID;
    private String urunAdi;
    private int urunAdet;
    private int urunFiyat;
    private int kategoriID;
    public Urun(int urunID, String urunAdi, int urunAdet, int urunFiyat, int kategoriID) {
        this.urunID = urunID;
        this.urunAdi = urunAdi;
        this.urunAdet = urunAdet;
        this.urunFiyat = urunFiyat;
        this.kategoriID = kategoriID;
    }
    public int getUrunID() {

        return urunID;
    }

    public void setUrunID(int urunID) {

        this.urunID = urunID;
    }

    public String getUrunAdi() {

        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {

        this.urunAdi = urunAdi;
    }

    public int getUrunAdet() {

        return urunAdet;
    }

    public void setUrunAdet(int urunAdet) {

        this.urunAdet = urunAdet;
    }

    public int getUrunFiyat() {

        return urunFiyat;
    }

    public void setUrunFiyat(int urunFiyat) {

        this.urunFiyat = urunFiyat;
    }

    public int getKategoriID() {

        return kategoriID;
    }

    public void setKategoriID(int kategoriID) {

        this.kategoriID = kategoriID;
    }
    @Override
    public String toString() {
        return "Urun{" + "urunID=" + urunID + ", urunAdi='" + urunAdi + '\'' + ", urunAdet=" + urunAdet + ", urunFiyat=" + urunFiyat + ", kategoriID=" + kategoriID + '}';
    }
    public static void main(String[] args) {
        System.out.println("BAŞARILI");
    }
}