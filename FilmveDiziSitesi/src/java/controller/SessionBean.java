/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.LoginDAO;
import entity.Admin;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.FacesComponent;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
/**
 *
 * @author Halil
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import dao.LoginDAO;
import entity.Admin;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.FacesComponent;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author MERVAN
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    private String username;
    private String password;
    private Admin admin;
    private LoginDAO ldao;

    public SessionBean() {
    }

    public String login() {
        Admin admin = this.getLdao().getAdmin(this.username, this.password);
        if (admin != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("admin", admin);
            return "/AdminPaneli/AdminIslemleri?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("kullanıcı adı veya şifre hatalı"));
            return "/AdminPaneli/Admin?faces-redirect=true";
        }
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public LoginDAO getLdao() {
        if (this.ldao == null) {
            this.ldao = new LoginDAO();
        }
        return ldao;
    }

    public void setLdao(LoginDAO ldao) {
        this.ldao = ldao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
