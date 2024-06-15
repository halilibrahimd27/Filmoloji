/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import dao.FilmveDiziDao;
import dao.MesajlarDAO;
import entity.FilmveDizi;
import entity.Mesajlar;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MERVAN
 */
@Named(value = "mesajlarBean")
@SessionScoped
public class MesajlarBean implements Serializable{
    
    private Mesajlar entity;
    private MesajlarDAO dao;
    private List<Mesajlar> list;
    
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public MesajlarBean() {
    }
    
    public void create(){
        this.getDao().create(this.entity);
        this.entity=new Mesajlar();
    }
    
    public void delete(Mesajlar ms){
        this.getDao().delete(ms);
    }

    public Mesajlar getEntity() {
        if(this.entity==null){
            entity=new Mesajlar();
        }
        return entity;
    }

    public void setEntity(Mesajlar entity) {
        this.entity = entity;
    }

    public MesajlarDAO getDao() {
         if(this.dao==null){
            this.dao=new MesajlarDAO();
        }
        return dao;
    }

    public void setDao(MesajlarDAO dao) {
        this.dao = dao;
    }

    public List<Mesajlar> getList() {
        this.list = this.getDao().getMesajlarList(page, pageSize);
        return list;
    }

    public void setList(List<Mesajlar> list) {
        this.list = list;
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
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
    
}
