public class Musteriler {
    private int musteriID;
    private String ad;
    private String soyad;
    private int tckn;
    private String email;
    public Musteriler(int musteriID) {
        this.musteriID = musteriID;
        this.ad = ad;
        this.soyad = soyad;
        this.tckn = tckn;
        this.email = ad;
    }

    public int getMusteriID() {
        return musteriID;
    }

    public void setMusteriID(int musteriID) {
        this.musteriID = musteriID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getTckn() {
        return tckn;
    }

    public void setTckn(int tckn) {
        this.tckn = tckn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@Override
public String toString() {
        return "Musteriler{" + "musteriID= " + musteriID + "AD= " + ad + "Soyad= " + soyad + "Tckn= " + tckn + "Email= " + email + '}';
}
    public static void main(String[] args) {

    }
}
