package entity;

public class Yorum {
    
    private FilmveDizi filmdizi;
    private String yorum;
    private Kullanıcı kullanıcı;

    public Yorum() {
    }

    public Yorum(FilmveDizi filmdizi, String yorum, Kullanıcı kullanıcı) {
        this.filmdizi = filmdizi;
        this.yorum = yorum;
        this.kullanıcı = kullanıcı;
    }

    public Yorum(String yorum) {
        this.yorum = yorum;
    }
    
    

    public Yorum(FilmveDizi filmdizi, Kullanıcı kullanıcı) {
        this.filmdizi = filmdizi;
        this.kullanıcı = kullanıcı;
    }

    
    public FilmveDizi getFilmdizi() {
        return filmdizi;
    }

    public void setFilmdizi(FilmveDizi filmdizi) {
        this.filmdizi = filmdizi;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public Kullanıcı getKullanıcı() {
        return kullanıcı;
    }

    public void setKullanıcı(Kullanıcı kullanıcı) {
        this.kullanıcı = kullanıcı;
    }
    

}