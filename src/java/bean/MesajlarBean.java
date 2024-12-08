package bean;

import dao.MesajlarDao;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.annotation.PostConstruct;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import entity.Mesajlar;

@Named(value = "mesajlarBean")
@SessionScoped
public class MesajlarBean implements Serializable {

    private Mesajlar entity;
    private MesajlarDao dao;
    private List<Mesajlar> list; 

    public MesajlarBean() {
        entity = new Mesajlar();
    }

    

    

//    public void loadMesajlar() {
//        this.list = this.getDao().getMesajlar(currentKullaniciId);
//    }

    public void create(int kullanici_id,String mesaj) throws SQLException {
        this.getDao().create(kullanici_id,mesaj);
        
    }

    public void delete(String mesaj) throws SQLException {
        this.getDao().delete(mesaj);
        
    }

    public Mesajlar getEntity() {
        if (entity == null) {
            entity = new Mesajlar();
        }
        return entity;
    }

    public void setEntity(Mesajlar entity) {
        this.entity = entity;
    }

    public MesajlarDao getDao() {
        if (dao == null) {
            dao = new MesajlarDao();
        }
        return dao;
    }

    public void setDao(MesajlarDao dao) {
        this.dao = dao;
    }

    public List<Mesajlar> getList() {
        this.list=this.getDao().AdminList();
        return list;
    }

    public void setList(List<Mesajlar> list) {
        this.list = list;
    }

   

}
