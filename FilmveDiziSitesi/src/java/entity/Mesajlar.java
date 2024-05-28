/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author MERVAN
 */
public class Mesajlar {
    private int kullanici_id;
    private String mesaj;

    public Mesajlar() {
    }

    public Mesajlar(int kullanici_id, String mesaj) {
        this.kullanici_id = kullanici_id;
        this.mesaj = mesaj;
    }

    

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }
    
    

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
    
    
    
}
