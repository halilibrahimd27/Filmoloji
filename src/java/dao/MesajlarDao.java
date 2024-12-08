package dao;

import entity.Document;
import entity.FilmveDizi;
import entity.Kullanıcı;
import entity.Mesajlar;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class MesajlarDao extends DBConnection {

    public void create(int kullanici_id, String mesaj) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.getConnect();
            String sql = "INSERT INTO mesajlar (kullanici_id, mesaj) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, kullanici_id);
            statement.setString(2, mesaj);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    public Mesajlar getById(int id){
        Mesajlar m = null;
        try{
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from mesajlar where mesaj_id="+id);
            rs.next();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return m;
    }

    public void delete(String mesaj) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.getConnect();
            String sql = "DELETE FROM mesajlar WHERE mesaj = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, mesaj);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    public List<Mesajlar> AdminList() {
        List<Mesajlar> mesajlar = new ArrayList<>();
        Mesajlar mesajlarr = null;
        String mesaj;
        int mesaj_id;
        try {

            String query = "SELECT m.*, k.kullanıcıadı, k.email "
             + "FROM mesajlar m "
             + "JOIN kullanıcılar k ON m.kullanici_id = k.kullanici_id";


            PreparedStatement statement = this.getConnect().prepareStatement(query);
          

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

  

                Kullanıcı kullanıcı = new Kullanıcı(
                        resultSet.getString("kullanıcıadı")
                );
                
                 Mesajlar mesajlarrr = new Mesajlar(
                       
                        resultSet.getString("mesaj")
                );
                
                 mesaj=mesajlarrr.getMesaj();
                

                mesajlarr = new Mesajlar(mesaj,kullanıcı);

                mesajlar.add(mesajlarr);

            }

            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mesajlar;
    }

}
