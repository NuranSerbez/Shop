public class Iletisim {
    private int iletisimID;
    private int musteriID;
    private String adres;
    private int telefon;
    public Iletisim(int iletisimID, int musteriID, String adres, int telefon) {
        this.iletisimID = iletisimID;
        this.musteriID = musteriID;
        this.adres = adres;
        this.telefon = telefon;
    }

    public int getIletisimID() {
        return iletisimID;
    }

    public void setIletisimID(int iletisimID) {
        this.iletisimID = iletisimID;
    }

    public int getMusteriID() {
        return musteriID;
    }

    public void setMusteriID(int musteriID) {
        this.musteriID = musteriID;
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
