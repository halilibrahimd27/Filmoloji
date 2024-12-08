package bean;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.annotation.PostConstruct;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import dao.YorumDao;
import entity.Yorum;

@Named(value = "yorumBean")
@SessionScoped
public class YorumBean implements Serializable {

    private Yorum entity;
    private YorumDao dao;
    private List<Yorum> list;
    private List<Yorum> adminlist;
   

    public YorumBean() {
        entity = new Yorum();
    }

    @PostConstruct
    public void init() {
      
     
        
    }

    private int getLoggedInUserId() {
        
        return 1; 
    }

    private int getCurrentFilmId() {
      
        return 1; 
    }

    public void create(int df_id,  int kullanici_id , String yorum) throws SQLException {
        this.getDao().create(df_id , kullanici_id, yorum );
        this.entity=new Yorum();
    }



    public void delete(String yorum) throws SQLException {
        this.getDao().delete(yorum);
       
    }

    public Yorum getEntity() {
        if (entity == null) {
            entity = new Yorum();
        }
        return entity;
    }

    public void setEntity(Yorum entity) {
        this.entity = entity;
    }

    public YorumDao getDao() {
        if (dao == null) {
            dao = new YorumDao();
        }
        return dao;
    }

    public void setDao(YorumDao dao) {
        this.dao = dao;
    }

    public List<Yorum> getList() {
        return list;
    }

    public void setList(List<Yorum> list) {
        this.list = list;
    }

    public List<Yorum> secilenYorum(int fd_id) {
        
        this.list = this.getDao().getFilmeGirenKısım(fd_id);
        return list;
    }

    public List<Yorum> getAdminlist() {
         this.adminlist = this.getDao().AdminList();
        return adminlist;
    }

    public void setAdminlist(List<Yorum> adminlist) {
        this.adminlist = this.getDao().AdminList();
    }
    
    

   
}
