/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FilmveDizi;
import entity.Yorumlar;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author MERVAN
 */
public class YorumlarDAO extends DBConnection{
    public List<Yorumlar> getYorumlarList(int page, int pageSize) {

        List<Yorumlar> yorumlarList = new ArrayList<>();

        int start = ((page - 1) * pageSize);
        int son = start + 5;
        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query = "SELECT * FROM yorum WHERE id BETWEEN " + start + " AND " + son;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                yorumlarList.add(new Yorumlar(rs.getString("yorum")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return yorumlarList;
    }
    
}
