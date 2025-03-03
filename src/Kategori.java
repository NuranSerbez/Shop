public class Kategori {
    private int kategoriID;
    private String kategoriAdi;

    public Kategori(int kategoriID, String kategoriAdi) {
        this.kategoriID = kategoriID;
        this.kategoriAdi = kategoriAdi;
    }

    public int getKategoriID() {
        return kategoriID;
    }

    public void setKategoriID(int kategoriID) {
        this.kategoriID = kategoriID;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    @Override
    public String toString() {
        return "Kategori{" + "kategoriID=" + kategoriID + ", kategoriAdi='" + kategoriAdi + '\'' + '}';
    }
    public static void main(String[] args) {

    }
}
