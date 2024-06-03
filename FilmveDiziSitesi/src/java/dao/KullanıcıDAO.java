/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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

    private Connection db;

    public boolean isValidUser(String name, String password) {
        boolean isValid = false;
        jakarta.resource.cci.Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Veritabanı bağlantısı

            // SQL sorgusu
            String sql = "SELECT COUNT(*) FROM kullanıcılar WHERE name = ? AND password = ?";
            statement = getDb().prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isValid = resultSet.getInt(1) > 0;
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

        String sql = "INSERT INTO kullanıcılar (email, name, password) VALUES (?, ?, ?)";

        try (Connection conn = this.getConnect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, k.getEmail());
            pstmt.setString(2, k.getName());
            pstmt.setString(3, k.getPassword());
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Kullanıcı c) {
        try {

            Statement st = this.getDb().createStatement();

            String query0 = "UPDATE kullanıcılar SET kullanici_id = kullanici_id - 1 WHERE kullanici_id > " + c.getId();
            String query1 = "delete from kullanıcılar where kullanici_id=" + c.getId();
            st.executeUpdate(query1);
            st.executeUpdate(query0);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Kullanıcı> getKullanıcıList(int page, int pageSize) {

        List<Kullanıcı> kullanıcıList = new ArrayList<>();

        int start = ((page - 1) * pageSize);
        int son = start + 5;
        try {

            Statement st = (Statement) this.getDb().createStatement();

            String query = "SELECT * FROM kullanıcılar WHERE kullanici_id BETWEEN " + start + " AND " + son;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                kullanıcıList.add(new Kullanıcı(rs.getLong("kullanici_id"), rs.getString("email"), rs.getString("name"), rs.getString("password")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kullanıcıList;
    }

    public int count() {

        int count = 0;

        List<Kullanıcı> kullanıcıList = new ArrayList<>();

        try {

            Statement st = this.getDb().createStatement();

            String query = "select count(kullanici_id) as kullanıcı_count from kullanıcılar";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("kullanıcı_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.getConnect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
}
