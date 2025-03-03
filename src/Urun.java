public class Urun {
    private int urunID;
    private String urunAdi;
    private int urunAdet;
    private int urunFiyat;
    private Kategori kategori;

    public Urun(int urunID) {
        this.urunID = urunID;
        this.urunAdi = this.urunAdi;
        this.urunAdet = urunAdet;
        this.urunFiyat = urunFiyat;
        this.kategori = kategori;
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

    public Kategori getKategori() {

        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "urunID=" + urunID +
                ", urunAdi='" + urunAdi + '\'' +
                ", urunAdet=" + urunAdet +
                ", urunFiyat=" + urunFiyat +
                ", kategori=" + kategori +
                '}';
    }
    public static void main(String[] args) {

    }
}
