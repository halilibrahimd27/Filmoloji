/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FilmveDizi;
import entity.Kullanıcı;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author MERVAN
 */
public class KullanıcıDAO extends DBConnection{
    
    public void create(Kullanıcı k) {

        try {

            Statement st = (Statement) this.getConnect().createStatement();
            st.executeUpdate("INSERT INTO kullanıcılar (kullanıcıadı, sifre) VALUES ('"
                    + k.getKullanıcıadı()+ "','"
                    + k.getSifre()+ ")");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Kullanıcı> getKullanıcıList(int page, int pageSize) {

        List<Kullanıcı> kullanıcıList = new ArrayList<>();

        int start = ((page - 1) * pageSize);
        int son = start + 5;
        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query = "SELECT * FROM kullanıcılar WHERE id BETWEEN " + start + " AND " + son;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                kullanıcıList.add(new Kullanıcı(rs.getInt("kullanıcı_id"), rs.getInt("id"), rs.getString("kullanıcıadı"), rs.getString("sifre")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kullanıcıList;
    }
    
     public void delete(Kullanıcı k) {
        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query0 = "UPDATE kullanıcılar SET kullanıcı_id = kullanıcı_id - 1 WHERE id > " + k.getKullanici_id();
            String query1 = "DELETE from kullanıcılar where id=" + k.getKullanici_id();
            st.executeUpdate(query1);
            st.executeUpdate(query0);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
     
      public int count() {

        int count = 0;

        List<Kullanıcı> kullanıcıList = new ArrayList<>();

        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query = "select count(kullanıcı_id) as kullanıcılar_count from kullanıcılar";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("kullanıcılar_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
    
}
