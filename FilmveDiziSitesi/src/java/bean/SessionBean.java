/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

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
public class SessionBean implements Serializable{
    
    private String username;
    private String password;
    private Admin admin;
    private LoginDAO ldao;
    private String username2;
    private  String password2;

    public SessionBean() {
    }
    
    public String login(){
        Admin admin = this.getLdao().getAdmin(this.username, this.password);
        if((getUsername2().equals("mervan")) && (getPassword2().equals("123"))){
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("admin", admin);
        return "/AdminPaneli/AdminIslemleri?faces-redirect=true";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("kullanıcı adı veya şifre hatalı"));
            return"/AdminPaneli/Admin?faces-redirect=true";
        }
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public LoginDAO getLdao() {
        if(this.ldao==null){
            this.ldao =new LoginDAO();
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
