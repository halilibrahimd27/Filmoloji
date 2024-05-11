/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import dao.FilmveDiziDao;
import entity.FilmveDizi;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.List;


@Named(value = "filmveDiziBean")
@SessionScoped
public class FilmveDiziBean  implements Serializable {
    
    private FilmveDizi entity;
    private FilmveDiziDao dao;
    private List<FilmveDizi> list;
    
     public FilmveDiziBean() {
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

    public void delete(FilmveDizi c) {
        this.getDao().delete(c);
    }
    public void update(FilmveDizi c) {
        this.getDao().update(entity);
        this.entity=new FilmveDizi();
    }

    
    public void create(){
        this.getDao().create(entity);
        this.entity=new FilmveDizi();
    }

    public FilmveDizi getEntity() {
        if(this.entity==null){
            entity=new FilmveDizi();
        }
        return entity;
    }

    public void setEntity(FilmveDizi entity) {
        this.entity = entity;
    }

    public FilmveDiziDao getDao() {
        if(this.dao==null){
            this.dao=new FilmveDiziDao();
        }
        return dao;
    }

    public void setDao(FilmveDiziDao dao) {
        this.dao = dao;
    }

    public List<FilmveDizi> getList() {
        this.list = this.getDao().getFilmolojiList(page, pageSize);
        return list;
    }

    public void setList(List<FilmveDizi> list) {
        this.list = list;
    }
   
    
 
   
}
