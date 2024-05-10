/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullanıcıDAO;
import entity.Kullanici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Halil
 */
@Named(value = "kullanıcıBean")
@SessionScoped
public class KullanıcıBean implements Serializable {

    private Kullanici entity;
    private KullanıcıDAO dao;
    private List<Kullanici> list;

    public KullanıcıBean() {
    }

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if(this.page == this.pageCount) {
            this.page = 1;
        }
        else{
            this.page++;
        }
       
    }

    public void prev() {
        if (this.page == 1) {
            this.page = this.pageCount;
        }else{
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public KullanıcıBean(Kullanici entity, KullanıcıDAO dao, List<Kullanici> list, int pageCount) {
        this.entity = entity;
        this.dao = dao;
        this.list = list;
        this.pageCount = pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void delete(Kullanici c) {
        this.getDao().delete(c);
    }

    public void create() {
        this.getDao().createKullanıcı(entity);
        this.entity = new Kullanici();
    }

    public Kullanici getEntity() {
        if (this.entity == null) {
            this.entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
        this.entity = entity;
    }

    public KullanıcıDAO getDao() {
        if (this.dao == null) {
            this.dao = new KullanıcıDAO();
        }
        return dao;
    }

    public void setDao(KullanıcıDAO dao) {
        this.dao = dao;
    }

    public List<Kullanici> getList(){
        this.list = this.getDao().getKullanıcıList(page, pageSize);
        return list;
    }

    public void setList(List<Kullanici> list) {
        this.list = list;
    }
    
}