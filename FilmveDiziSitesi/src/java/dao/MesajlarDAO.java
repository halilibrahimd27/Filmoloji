/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FilmveDizi;
import entity.Kullanıcı;
import entity.Mesajlar;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author MERVAN
 */
public class MesajlarDAO extends DBConnection{
    
    public void create(Mesajlar ms) {

        try {

            Statement st = (Statement) this.getConnect().createStatement();
            st.executeUpdate("INSERT INTO mesajlar(mesaj) VALUES ('"
                    + ms.getMesaj()+ "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public List<Mesajlar> getMesajlarList(int page, int pageSize) {

        List<Mesajlar> mesajlarList = new ArrayList<>();

        int start = ((page - 1) * pageSize);
        int son = start + 5;
        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query = "SELECT * FROM mesajlar WHERE id BETWEEN " + start + " AND " + son;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                mesajlarList.add(new Mesajlar(rs.getInt("kullanici_id"), rs.getString("mesaj")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mesajlarList;
    }
    
    public void delete(Mesajlar ms) {
        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query0 = "UPDATE mesajlar SET id = id - 1 WHERE id > " + ms.getKullanici_id();
            String query1 = "DELETE from mesajlar where id=" + ms.getKullanici_id();
            st.executeUpdate(query1);
            st.executeUpdate(query0);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public int count() {

        int count = 0;

        List<FilmveDizi> categoryList = new ArrayList<>();

        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query = "select count(admin_id) as mesaj_count from mesajlar";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("mesaj_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
}
