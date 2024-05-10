/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author MERVAN
 */
public class Kullanıcı {
    private int kullanici_id;
    private int id;
    private String kullanıcıadı;
    private String sifre;

    public Kullanıcı() {
    }

    public Kullanıcı(int kullanici_id, int id, String kullanıcıadı, String sifre) {
        this.kullanici_id = kullanici_id;
        this.id = id;
        this.kullanıcıadı = kullanıcıadı;
        this.sifre = sifre;
    }
    
    

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
