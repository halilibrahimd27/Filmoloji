package entity;

public class Mesajlar {
    private int mesaj_id;
    private String mesaj;
    private Kullanıcı kullanıcı;

    public Mesajlar(String mesaj, Kullanıcı kullanıcı) {
        this.mesaj_id = mesaj_id;
        this.mesaj = mesaj;
        this.kullanıcı = kullanıcı;
    }

    public Mesajlar( String mesaj) {
        this.mesaj = mesaj;
    }

    public Mesajlar() {
    }

    

    public int getMesaj_id() {
        return mesaj_id;
    }

    public void setMesaj_id(int mesaj_id) {
        this.mesaj_id = mesaj_id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public Kullanıcı getKullanıcı() {
        return kullanıcı;
    }

    public void setKullanıcı(Kullanıcı kullanıcı) {
        this.kullanıcı = kullanıcı;
    }
    
}
