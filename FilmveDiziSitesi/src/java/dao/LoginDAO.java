/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Admin;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author Halil
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MERVAN
 */
public class LoginDAO extends DBConnection {

    public Admin getAdmin(String username, String password) {
        Admin a = new Admin();
        a.setId(1);
        a.setUsername(username);
        a.setPassword(password);
        try {

            Statement st = (Statement) this.connect().createStatement();
            st.executeUpdate("INSERT INTO admin (username,password) VALUES ('"
                    + a.getUsername() + "','"
                    + a.getPassword() + ")");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return a;

    }

}
