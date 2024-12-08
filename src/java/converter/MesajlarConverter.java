/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.MesajlarDao;
import entity.Mesajlar;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author berkaysari
 */
@FacesConverter(value="mesajlarConverter")
public class MesajlarConverter implements Converter {
    
    private MesajlarDao mDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
       return this.mDao.getById(Integer.valueOf(string));
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        Mesajlar m = (Mesajlar)t;
        return String.valueOf(m.getMesaj_id());
    }
    
    
}
