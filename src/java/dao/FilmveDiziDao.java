/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FilmveDizi;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author semih
 */
public class FilmveDiziDao extends DBConnection {

    public void create(FilmveDizi fd) {

        try {
            fd.setId(1);
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

}
