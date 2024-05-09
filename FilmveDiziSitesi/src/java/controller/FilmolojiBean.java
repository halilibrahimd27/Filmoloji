/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.FilmolojiDAO;
import entity.Filmoloji;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Halil
 */
@Named(value = "filmolojiBean")
@SessionScoped
public class FilmolojiBean implements Serializable {

    private Filmoloji entity;
    private FilmolojiDAO dao;
    private List<Filmoloji> list;

    public FilmolojiBean() {
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

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void delete(Filmoloji c) {
        this.getDao().delete(c);
    }

    public void create() {
        this.getDao().createFilmDizi(this.entity);
        this.entity = new Filmoloji();
    }

    public Filmoloji getEntity() {
        if (this.entity == null) {
            this.entity = new Filmoloji();
        }
        return entity;
    }

    public void setEntity(Filmoloji entity) {
        this.entity = entity;
    }

    public FilmolojiDAO getDao() {
        if (this.dao == null) {
            this.dao = new FilmolojiDAO();
        }
        return dao;
    }

    public void setDao(FilmolojiDAO dao) {
        this.dao = dao;
    }

    public List<Filmoloji> getList() throws SQLException {
        this.list = this.getDao().getFilmolojiList(page, pageSize);
        return list;
    }

    public void setList(List<Filmoloji> list) {
        this.list = list;
    }

}
