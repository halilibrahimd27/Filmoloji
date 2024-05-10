/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FilmveDizi;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author semih
 */
public class FilmveDiziDao extends DBConnection {

    public void create(FilmveDizi fd) {

        try {

            Statement st = (Statement) this.getConnect().createStatement();
            st.executeUpdate("INSERT INTO filmvedizi (tur, adi, konusu, kategorisi, yonetmen_adi, oyuncular, vizyontrend) VALUES ('"
                    + fd.getTur() + "','"
                    + fd.getAdi() + "','"
                    + fd.getKonusu() + "','"
                    + fd.getGönderilecekKategori() + "','"
                    + fd.getYonetmen_adi() + "','"
                    + fd.getOyuncular() + "',"
                    + fd.isVizyontrend() + ")");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<FilmveDizi> getFilmolojiList(int page, int pageSize) {

        List<FilmveDizi> categoryList = new ArrayList<>();

        int start = ((page - 1) * pageSize);
        int son = start + 5;
        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query = "SELECT * FROM filmvedizi WHERE id BETWEEN " + start + " AND " + son;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                categoryList.add(new FilmveDizi(rs.getInt("id"), rs.getString("tur"), rs.getString("adi"), rs.getString("konusu"), rs.getString("kategorisi"), rs.getString("yonetmen_adi"), rs.getString("oyuncular"), rs.getBoolean("vizyontrend")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categoryList;
    }

    public void delete(FilmveDizi fd) {
        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query0 = "UPDATE filmvedizi SET id = id - 1 WHERE id > " + fd.getId();
            String query1 = "DELETE from filmvedizi where id=" + fd.getId();
            st.executeUpdate(query1);
            st.executeUpdate(query0);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void update(FilmveDizi fd){
    
    }

    public int count() {

        int count = 0;

        List<FilmveDizi> categoryList = new ArrayList<>();

        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query = "select count(df_id) as film_count from dizifilm";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("film_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

}
