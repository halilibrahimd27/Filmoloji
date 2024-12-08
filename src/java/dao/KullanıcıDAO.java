/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FilmveDizi;
import entity.Kullanıcı;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Halil
 */
public class KullanıcıDAO extends DBConnection {

   
    public int newFilmDiziId;

    public boolean isValidUser(String name, String password) {

        boolean isValid = false;
        jakarta.resource.cci.Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Veritabanı bağlantısı

            // SQL sorgusu
            String sql = "SELECT kullanici_id FROM kullanıcılar WHERE kullanıcıadı = ? AND password = ?";
            statement = this.getConnect().prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                newFilmDiziId = resultSet.getInt("kullanici_id");
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }


    /*
    public void create(Kullanıcı c) {
        try {
            
//            Statement st = (Statement) this.getConnect().createStatement();
//            st.executeUpdate("INSERT INTO abc (name, email, password) VALUES ('"
//
//                    + c.getName()+ "','"
//                    + c.getEmail()+ "',"
//                    + c.getPassword()+ ")");

      String insertQuery = "INSERT INTO kullanıcılar(email,name, password) VALUES(?,?,?)";
            try (PreparedStatement preparedStatement = this.getDb().prepareStatement(insertQuery)) {
                preparedStatement.setString(1, c.getEmail());
                preparedStatement.setString(2, c.getName());
                preparedStatement.setString(3, c.getPassword());
                
                preparedStatement.executeUpdate();
            }
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     */
    public void create(Kullanıcı k) {

        String sql = "INSERT INTO kullanıcılar (email, kullanıcıadı, password) VALUES (?, ?, ?)";

        try (Connection conn = this.getConnect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, k.getEmail());
            pstmt.setString(2, k.getName());
            pstmt.setString(3, k.getPassword());
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    public void update(Kullanıcı c){
//    
//        try{
//            Statement st = this.getDb().createStatement();
//            st.executeUpdate("update kullanıcılar set email='"+c.getEmail()+"'kullanıcıadı='"+c.getName()+"'password='"+c.getPassword()+"'where kullanici_id="+c.getId());
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
    public void update(Kullanıcı c) {
        try {
            Statement st = this.getConnect().createStatement();
            String sql = "UPDATE kullanıcılar SET email='" + c.getEmail()
                    + "', kullanıcıadı='" + c.getName()
                    + "', password='" + c.getPassword()
                    + "' WHERE kullanici_id=" + c.getId();
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Kullanıcı c) {
        try {

            Statement st = this.getConnect().createStatement();

            String query0 = "UPDATE kullanıcılar SET kullanici_id = kullanici_id - 1 WHERE kullanici_id > " + c.getId();
            String query1 = "DELETE from kullanıcılar where kullanici_id=" + c.getId();
            st.executeUpdate(query1);
            st.executeUpdate(query0);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Kullanıcı> getKullanıcıList() {

        List<Kullanıcı> kullanıcıList = new ArrayList<>();

        try {

            Statement st = (Statement) this.getConnect().createStatement();

            String query = "SELECT * FROM kullanıcılar ";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                kullanıcıList.add(new Kullanıcı(rs.getInt("kullanici_id"), rs.getString("kullanıcıadı"), rs.getString("email"), rs.getString("password")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kullanıcıList;
    }

    public List<Kullanıcı> findAll(int page, int pageSize) {
        List<Kullanıcı> kullanıcıList = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.getConnect().prepareStatement("SELECT * FROM kullanıcılar ORDER BY kullanici_id ASC LIMIT ? OFFSET ?");
            pst.setInt(1, pageSize);
            pst.setInt(2, start);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Kullanıcı k = new Kullanıcı();
                k.setId(rs.getInt("kullanici_id"));
                k.setEmail(rs.getString("email"));
                k.setName(rs.getString("kullanıcıadı"));
                k.setPassword(rs.getString("password"));
                kullanıcıList.add(k);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return kullanıcıList;
    }


         
    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnect().prepareStatement("SELECT COUNT(kullanici_id) AS kullanıcılar_count FROM kullanıcılar");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("kullanıcılar_count");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int id() {
        return newFilmDiziId;
    }

 
}
