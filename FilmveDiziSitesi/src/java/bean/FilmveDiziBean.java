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

/**
 *
 * @author semih
 */
@Named(value = "filmveDiziBean")
@SessionScoped
public class FilmveDiziBean  implements Serializable {
    
    private FilmveDizi entity;
    private FilmveDiziDao dao;
    private List<FilmveDizi> list;
    
     public FilmveDiziBean() {
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
        return list;
    }

    public void setList(List<FilmveDizi> list) {
        this.list = list;
    }
   
    
 
   
}
