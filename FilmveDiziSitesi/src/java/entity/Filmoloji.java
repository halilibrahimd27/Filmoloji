
package entity;


public class Filmoloji {
    
    private Long df_id;
    private String adı;
    private String tür;
    private String konusu;
    private String kategori;
    private String yönetmenadı;
    private String oyuncular;
    private String vizyondamitrenddemi;

    public Long getDf_id() {
        return df_id;
    }

    public void setDf_id(Long df_id) {
        this.df_id = df_id;
    }

    public String getAdı() {
        return adı;
    }

    public void setAdı(String adı) {
        this.adı = adı;
    }

    public String getTür() {
        return tür;
    }

    public void setTür(String tür) {
        this.tür = tür;
    }

    public String getKonusu() {
        return konusu;
    }

    public void setKonusu(String konusu) {
        this.konusu = konusu;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getYönetmenadı() {
        return yönetmenadı;
    }

    public void setYönetmenadı(String yönetmenadı) {
        this.yönetmenadı = yönetmenadı;
    }

    public String getOyuncular() {
        return oyuncular;
    }

    public void setOyuncular(String oyuncular) {
        this.oyuncular = oyuncular;
    }

    public String getVizyondamitrenddemi() {
        return vizyondamitrenddemi;
    }

    public void setVizyondamitrenddemi(String vizyondamitrenddemi) {
        this.vizyondamitrenddemi = vizyondamitrenddemi;
    }



    public Filmoloji(String adı, String tür, String kategori) {
        this.adı = adı;
        this.tür = tür;
        this.kategori = kategori;
    }

    public Filmoloji(Long df_id, String tür, String adı, String konusu, String kategori, String yönetmenadı, String oyuncular, String vizyondamitrenddemi) {
        this.df_id = df_id;
        this.adı = adı;
        this.tür = tür;
        this.konusu = konusu;
        this.kategori = kategori;
        this.yönetmenadı = yönetmenadı;
        this.oyuncular = oyuncular;
        this.vizyondamitrenddemi = vizyondamitrenddemi;
    }

    public Filmoloji() {
        
    }

    
   
}
