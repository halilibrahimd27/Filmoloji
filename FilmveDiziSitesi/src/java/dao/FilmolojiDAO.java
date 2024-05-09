/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Filmoloji;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmolojiDAO extends DBConnection {

    private Connection db;

    public void createFilmDizi(Filmoloji c) {
        try {
            String selectMaxIdQuery = "SELECT COALESCE(MAX(df_id), 0) AS max_id FROM dizifilm";
            PreparedStatement selectStatement = this.getDb().prepareStatement(selectMaxIdQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            int maxId = 0;
            if (resultSet.next()) {
                maxId = resultSet.getInt("max_id");
            }

            resultSet.close();
            selectStatement.close();

            int newId = maxId + 1;

            String insertQuery = "INSERT INTO dizifilm(df_id, tür, adı, konusu, kategori, yönetmenadı, oyuncular, vizyondamitrenddemi) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.getDb().prepareStatement(insertQuery);

            preparedStatement.setInt(1, newId);
            preparedStatement.setString(2, c.getTür());
            preparedStatement.setString(3, c.getAdı());
            preparedStatement.setString(4, c.getKonusu());
            preparedStatement.setString(5, c.getKategori());
            preparedStatement.setString(6, c.getYönetmenadı());
            preparedStatement.setString(7, c.getOyuncular());
            preparedStatement.setString(8, c.getVizyondamitrenddemi());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println("Veritabanı işlemi sırasında bir hata oluştu: " + ex.getMessage());
        }
    }

    public void delete(Filmoloji c) {
        try {

            Statement st = this.getDb().createStatement();

            String query0 = "UPDATE dizifilm SET df_id = df_id - 1 WHERE df_id > " + c.getDf_id();
            String query1 = "delete from dizifilm where df_id=" + c.getDf_id();
            st.executeUpdate(query1);
            st.executeUpdate(query0);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Filmoloji> getFilmolojiList(int page, int pageSize) {

        List<Filmoloji> categoryList = new ArrayList<>();

        int start = ((page - 1) * pageSize);
        int son = start + 5;
        try {

            Statement st = this.getDb().createStatement();

            String query = "SELECT * FROM dizifilm WHERE df_id BETWEEN " + start + " AND " + son;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                categoryList.add(new Filmoloji(rs.getLong("df_id"), rs.getString("tür"), rs.getString("adı"), rs.getString("konusu"), rs.getString("kategori"), rs.getString("yönetmenadı"), rs.getString("oyuncular"), rs.getString("vizyondamitrenddemi")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categoryList;
    }

    public int count() {

        int count = 0;

        List<Filmoloji> categoryList = new ArrayList<>();

        try {

            Statement st = this.getDb().createStatement();

            String query = "select count(df_id) as film_count from dizifilm";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("film_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

}
