/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import dao.KitaplikDAO;
import dao.KullanıcıDAO;
import entity.Kitaplik;
import entity.Kullanıcı;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MERVAN
 */
@Named(value = "kitaplikBean")
@SessionScoped
public class KitaplikBean implements Serializable {

    private Kitaplik entity;
    private KitaplikDAO dao;
    private List<Kitaplik> list;

    public KitaplikBean() {
    }

    public KitaplikBean(Kitaplik entity, KitaplikDAO dao, List<Kitaplik> list) {
        this.entity = entity;
        this.dao = dao;
        this.list = list;
    }

    public Kitaplik getEntity() {
        if (entity == null) {
            entity = new Kitaplik();
        }
        return entity;
    }

    public void setEntity(Kitaplik entity) {
        this.entity = entity;
    }

    public KitaplikDAO getDao() {
        if (dao == null) {
            dao = new KitaplikDAO();
        }
        return dao;
    }

    public void setDao(KitaplikDAO dao) {
        this.dao = dao;
    }

    public List<Kitaplik> getList() {

        return list;
    }

    public void setList(List<Kitaplik> list) {
        this.list = list;
    }

}
