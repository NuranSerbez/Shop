public class Iletisim {
    private int iletisimID;
    private Musteriler musteri;
    private String adres;
    private int telefon;
    public Iletisim(int iletisimID, String adres, int telefon) {
        this.iletisimID = iletisimID;
        this.musteri = musteri;
        this.adres = adres;
        this.telefon = telefon;
    }

    public int getIletisimID() {
        return iletisimID;
    }

    public void setIletisimID(int iletisimID) {
        this.iletisimID = iletisimID;
    }

    public Musteriler getMusteriler() {
        return musteri;
    }

    public void setMusteri(Musteriler musteri) {
        this.musteri = musteri;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public static void main(String[] args) {

    }


}
