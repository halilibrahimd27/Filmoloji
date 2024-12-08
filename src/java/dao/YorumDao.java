package dao;

import entity.Document;
import entity.FilmveDizi;
import entity.Kitaplik;
import entity.Kullanıcı;
import entity.Yorum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class YorumDao extends DBConnection {

    public void create(int df_id,  int kullanici_id , String yorum) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.getConnect();
            String sql = "INSERT INTO yorum (df_id, kullanici_id,yorum) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, df_id);
            statement.setInt(2, kullanici_id);
            statement.setString(3, yorum);
            
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

    public void delete(String yorum) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.getConnect();
            String sql = "DELETE FROM yorum WHERE yorum = ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, yorum);            
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

   public List<Yorum> getFilmeGirenKısım(int fd_id) {
        List<Yorum> yorumlar = new ArrayList<>();
        Yorum yorum = null;
        String atılanYorum;
        try {

            String query = "SELECT f.*, d.filepath, d.filename, d.filetype, u.kullanıcıadı, u.email,k.yorum "
                    + "FROM yorum k "
                    + "JOIN kullanıcılar u ON k.kullanici_id = u.kullanici_id "
                    + "JOIN filmvedizi f ON k.df_id = f.id "
                    + "LEFT JOIN documents d ON f.id = d.df_id "
                    + "WHERE k.df_id = ?";

            PreparedStatement statement = this.getConnect().prepareStatement(query);
            statement.setInt(1, fd_id); // ID parametresini ayarlama

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                // Create Document object
                Document document = new Document(
                        resultSet.getString("filepath"),
                        resultSet.getString("filename"),
                        resultSet.getString("filetype")
                );

                // Create FilmveDizi object
                FilmveDizi filmveDizi = new FilmveDizi(
                        resultSet.getInt("id"),
                        resultSet.getString("tur"),
                        resultSet.getString("adi"),
                        resultSet.getString("konusu"),
                        resultSet.getString("kategorisi"),
                        resultSet.getString("yonetmen_adi"),
                        resultSet.getString("oyuncular"),
                        resultSet.getBoolean("vizyontrend"),
                        document
                );

                Kullanıcı kullanıcı = new Kullanıcı(
                        resultSet.getString("kullanıcıadı")
                );
                
                 Yorum yorumm = new Yorum(
                        resultSet.getString("yorum")
                );
                
                 atılanYorum=yorumm.getYorum();
                

                yorum = new Yorum(filmveDizi,atılanYorum,kullanıcı);

                yorumlar.add(yorum);

            }

            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return yorumlar;
    }
   
    public List<Yorum> AdminList() {
        List<Yorum> yorumlar = new ArrayList<>();
        Yorum yorum = null;
        String atılanYorum;
        try {

            String query = "SELECT f.*, d.filepath, d.filename, d.filetype, u.kullanıcıadı, u.email,k.yorum "
                    + "FROM yorum k "
                    + "JOIN kullanıcılar u ON k.kullanici_id = u.kullanici_id "
                    + "JOIN filmvedizi f ON k.df_id = f.id "
                    + "LEFT JOIN documents d ON f.id = d.df_id "
                    ;

            PreparedStatement statement = this.getConnect().prepareStatement(query);
          

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                // Create Document object
                Document document = new Document(
                        resultSet.getString("filepath"),
                        resultSet.getString("filename"),
                        resultSet.getString("filetype")
                );

                // Create FilmveDizi object
                FilmveDizi filmveDizi = new FilmveDizi(
                        resultSet.getInt("id"),
                        resultSet.getString("tur"),
                        resultSet.getString("adi"),
                        resultSet.getString("konusu"),
                        resultSet.getString("kategorisi"),
                        resultSet.getString("yonetmen_adi"),
                        resultSet.getString("oyuncular"),
                        resultSet.getBoolean("vizyontrend"),
                        document
                );

                Kullanıcı kullanıcı = new Kullanıcı(
                        resultSet.getString("kullanıcıadı")
                );
                
                 Yorum yorumm = new Yorum(
                        resultSet.getString("yorum")
                );
                
                 atılanYorum=yorumm.getYorum();
                

                yorum = new Yorum(filmveDizi,atılanYorum,kullanıcı);

                yorumlar.add(yorum);

            }

            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return yorumlar;
    }
   
   
}
