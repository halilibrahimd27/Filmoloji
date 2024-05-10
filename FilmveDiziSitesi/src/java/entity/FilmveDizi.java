/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package entity;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.ValueChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmveDizi {

    private int id;
    private String[] turarray = {"Film", "Dizi"};
    private String tur;
    private String adi;
    private String konusu;
    private List<String> secilenkategoriler;
    private List<String> kategoriler;
    private String gönderilecekKategori;
    private String yonetmen_adi;
    private String oyuncular;
    private String[] vizyontrendarray = {"Evet", "Hayır"};
    private String seçilenVizyonTrends;
    private boolean vizyontrend;

    public FilmveDizi() {
        kategoriler = new ArrayList<>();
        kategoriler.add("Macera");
        kategoriler.add("Aksiyon");
        kategoriler.add("Korku");
        kategoriler.add("Komedi");
        kategoriler.add("Bilim-Kurgu");
    }

    public FilmveDizi(int id,String tur, String adi, String konusu, String gönderilecekKategori, String yonetmen_adi, String oyuncular, boolean vizyontrend) {
        this.id=id;
        this.tur = tur;
        this.adi = adi;
        this.konusu = konusu;
        this.gönderilecekKategori = gönderilecekKategori;
        this.yonetmen_adi = yonetmen_adi;
        this.oyuncular = oyuncular;
        this.vizyontrend = vizyontrend;
    }
    
    
    

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        System.out.println("la" + tur);
        this.tur = tur;
    }

    public String[] getTurarray() {
        System.out.println("laaad" + Arrays.toString(turarray));
        return turarray;
    }

    public void setTurarray(String[] turarray) {
        this.turarray = turarray;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
        System.out.println("day" + adi);
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
        return kategoriler;
    }

    public void setKategoriler(List<String> kategoriler) {
        this.kategoriler = kategoriler;
    }

    public String getGönderilecekKategori() {
        return gönderilecekKategori;
    }

    public void setGönderilecekKategori(String gönderilecekKategori) {
        this.gönderilecekKategori = gönderilecekKategori;
    }
    
    public String getYonetmen_adi() {
        return yonetmen_adi;
    }

    public void setYonetmen_adi(String yonetmen_adi) {
        this.yonetmen_adi = yonetmen_adi;
    }

    public String getOyuncular() {
        return oyuncular;
    }

    public void setOyuncular(String oyuncular) {
        this.oyuncular = oyuncular;
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
            this.vizyontrend = true;
        } else {
            this.vizyontrend = false;
        }
    }

    public boolean isVizyontrend() {
        return vizyontrend;
    }

    public void setVizyontrend(boolean vizyontrend) {
        this.vizyontrend = vizyontrend;
    }

  
    
    

}
