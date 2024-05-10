/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Halil
 */
public class Kullanıcı {
    
    private String kullanıcıadı;
    private String sifre;
    private Long kullanıcı_id;
    private Long df_id;

    public Kullanıcı(Long kullanıcı_id, String kullanıcıadı, String sifre) {
        this.kullanıcı_id = kullanıcı_id;
        this.kullanıcıadı = kullanıcıadı;
        this.sifre = sifre;
    }


    public Kullanıcı() {
    }

    public Kullanıcı(String kullanıcıadı, String sifre) {
        this.kullanıcıadı = kullanıcıadı;
        this.sifre = sifre;
    }

    public Kullanıcı(Long kullanıcı_id, Long df_id, String kullanıcıadı, String sifre) {
        this.kullanıcı_id = kullanıcı_id;
        this.df_id = df_id;
        this.kullanıcıadı = kullanıcıadı;
        this.sifre = sifre;
    }

    public Long getKullanıcı_id() {
        return kullanıcı_id;
    }

    public void setKullanıcı_id(Long kullanıcı_id) {
        this.kullanıcı_id = kullanıcı_id;
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
