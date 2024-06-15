/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import dao.AdminDAO;
import entity.Admin;
import entity.FilmveDizi;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MERVAN
 */
@Named(value = "adminBean")
@SessionScoped
public class AdminBean implements Serializable{
    
    private Admin entity;
    private AdminDAO dao;
    private List<Admin> list;
    
    public AdminBean() {
    }

    public Admin getEntity() {
        return entity;
    }

    public void setEntity(Admin entity) {
        this.entity = entity;
    }

    public AdminDAO getDao() {
        return dao;
    }

    public void setDao(AdminDAO dao) {
        this.dao = dao;
    }

    public List<Admin> getList() {
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }
    
    public void create(){
        this.getDao().create(entity);
        this.entity=new Admin();
    }
    
    
      public void update() throws SQLException  {
        this.getDao().update(entity);
        entity=new Admin();
    }

    public void delete(Admin a) {
        this.getDao().delete(a);
    }
    
}
