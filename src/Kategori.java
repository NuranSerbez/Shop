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

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    @Override
    public String toString() {
        return "Kategori{" + "kategoriID=" + kategoriID + ", kategoriAdi='" + kategoriAdi + '\'' + '}';
    }
}
