package entity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filmoloji {

    private Long df_id;
    private String adı;
    private String[] turarray = {"Film", "Dizi"};
    private String tür;
    private String konusu;
    private List<String> secilenkategoriler;
    private List<String> kategori;
    private String yönetmenadı;
    private String oyuncular;
    private String[] vizyontrendarray = {"Evet", "Hayır"};
    private String seçilenVizyonTrends;
    private String vizyondamitrenddemi;
    private String gönderilecekKategori;

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
        System.out.println("la" + tür);
        this.tür = tür;
    }

    public String[] getTurarray() {
        System.out.println("laaad" + Arrays.toString(turarray));
        return turarray;
    }

    public void setTurarray(String[] turarray) {
        this.turarray = turarray;
    }

    public String getKonusu() {
        return konusu;
    }

    public void setKonusu(String konusu) {
        this.konusu = konusu;
    }

    public List<String> getSecilenkategoriler() {
        secilenkategoriler = new ArrayList<>();
        return secilenkategoriler;
    }

    public void setSecilenkategoriler(List<String> secilenkategoriler) {
        this.secilenkategoriler = secilenkategoriler;
        System.out.println("hozam"+this.secilenkategoriler);
        StringBuilder builder = new StringBuilder();
        for (String deger : this.secilenkategoriler) {
            if (builder.length() > 0) {
                builder.append(",");
            }
            builder.append(deger);
        }
        this.gönderilecekKategori = builder.toString();
        System.out.println("as"+this.gönderilecekKategori);

    }

    public List<String> getKategoriler() {
        return kategori;
    }

    public void setKategoriler(List<String> kategoriler) {
        this.kategori = kategoriler;
    }

    public String getGönderilecekKategori() {
        return gönderilecekKategori;
    }

    public void setGönderilecekKategori(String gönderilecekKategori) {
        this.gönderilecekKategori = gönderilecekKategori;
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
        public String[] getVizyontrendarray() {
        return vizyontrendarray;
    }

    public void setVizyontrendarray(String[] vizyontrendarray) {
        this.vizyontrendarray = vizyontrendarray;
    }

    public String getSeçilenVizyonTrends() {

        return seçilenVizyonTrends;
    }

    public void setSeçilenVizyonTrends(String seçilenVizyonTrends) {
        this.seçilenVizyonTrends = seçilenVizyonTrends;

        if (seçilenVizyonTrends.equals("Evet")) {
            this.vizyondamitrenddemi = "Evet";
        } else {
            this.vizyondamitrenddemi = "Hayır";
        }
    }

    public Filmoloji(String adı, String tür, List<String> kategori) {
        this.adı = adı;
        this.tür = tür;
        this.kategori = kategori;
    }

    public Filmoloji(Long df_id, String tür, String adı, String konusu, String gönderilecekKategori, String yönetmenadı, String oyuncular, String vizyondamitrenddemi) {
        this.df_id = df_id;
        this.adı = adı;
        this.tür = tür;
        this.konusu = konusu;
        this.gönderilecekKategori = gönderilecekKategori;
        this.yönetmenadı = yönetmenadı;
        this.oyuncular = oyuncular;
        this.vizyondamitrenddemi = vizyondamitrenddemi;
    }
    public Filmoloji() {
        kategori = new ArrayList<>();
        kategori.add("Macera");
        kategori.add("Aksiyon");
        kategori.add("Korku");
        kategori.add("Komedi");
        kategori.add("Bilim-Kurgu");
    }


}

