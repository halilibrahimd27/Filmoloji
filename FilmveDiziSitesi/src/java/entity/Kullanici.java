/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Halil
 */
public class Kullanici {
    
    private String kullanıcıadı;
    private String sifre;
    private Long kullanici_id;
    private Long df_id;

    public Kullanici(Long kullanici_id, String kullanıcıadı, String sifre) {
        this.kullanici_id = kullanici_id;
        this.kullanıcıadı = kullanıcıadı;
        this.sifre = sifre;
    }


    public Kullanici() {
    }

    public Kullanici(String kullanıcıadı, String sifre) {
        this.kullanıcıadı = kullanıcıadı;
        this.sifre = sifre;
    }

    public Kullanici(Long kullanici_id, Long df_id, String kullanıcıadı, String sifre) {
        this.kullanici_id = kullanici_id;
        this.df_id = df_id;
        this.kullanıcıadı = kullanıcıadı;
        this.sifre = sifre;
    }

    public Long getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(Long kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public Long getDf_id() {
        return df_id;
    }

    public void setDf_id(Long df_id) {
        this.df_id = df_id;
    }

    public String getKullanıcıadı() {
        return kullanıcıadı;
    }

    public void setKullanıcıadı(String kullanıcıadı) {
        this.kullanıcıadı = kullanıcıadı;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
}
