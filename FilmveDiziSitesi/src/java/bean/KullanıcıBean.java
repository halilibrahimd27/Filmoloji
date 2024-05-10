/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import dao.FilmveDiziDao;
import dao.KullanıcıDAO;
import entity.FilmveDizi;
import entity.Kullanıcı;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MERVAN
 */
@Named(value = "kullanıcıBean")
@SessionScoped
public class KullanıcıBean implements Serializable{
    private Kullanıcı entity;
    private KullanıcıDAO dao;
    private List<Kullanıcı> list;
    
    
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public KullanıcıBean() {
    }
    
    
    

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
    public void create(){
        this.getDao().create(entity);
        this.entity=new Kullanıcı();
    }
    
    public void delete(Kullanıcı k){
        this.getDao().delete(k);
    }

    public Kullanıcı getEntity() {
        if(this.entity==null){
            entity=new Kullanıcı();
        }
        return entity;
    }

    public void setEntity(Kullanıcı entity) {
        this.entity = entity;
    }

    public KullanıcıDAO getDao() {
         if(this.dao==null){
            this.dao=new KullanıcıDAO();
        }
        return dao;
    }

    public void setDao(KullanıcıDAO dao) {
        this.dao = dao;
    }

    public List<Kullanıcı> getList() {
        this.list = this.getDao().getKullanıcıList(page, pageSize);
        return list;
    }

    public void setList(List<Kullanıcı> list) {
        this.list = list;
    }
    
    
}
