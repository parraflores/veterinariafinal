
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;
import dao.TipoatencionDao;
import entidades.Tipoatencion;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lenovo
 */
@ManagedBean
@ViewScoped
public class TipoatencionBean implements Serializable{
    
    private Tipoatencion tipoatencion;
    private boolean banderaSelect = false;
    
    public TipoatencionBean(){
        this.tipoatencion = new Tipoatencion();
        
    }
       public String guardarTipoatencion() {
        TipoatencionDao dao = new TipoatencionDao();
        boolean respuesta = dao.guardarTipoatencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroTipoatencion";

    }
       
        public String actualizarTipoatencion() {
        try {
            TipoatencionDao mascotadao = new TipoatencionDao();
            
            boolean resp = mascotadao.actualizarTipoatencion(tipoatencion);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            mascotadao.actualizarTipoatencion(tipoatencion);
        } catch (Exception e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroTipoatencion";
    }
         public ArrayList<Tipoatencion> listarTipoatencion() {
        ArrayList<Tipoatencion> milista = new ArrayList<>();
        TipoatencionDao dao = new TipoatencionDao();
        milista = dao.listarTipoatencion();
        return milista;

    }
       
    public String eliminar(Tipoatencion data) {
        TipoatencionDao tadao = new TipoatencionDao();
        boolean respuesta = tadao.eliminarTipoatencion(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/RegistroTipoatencion.xhtml";
    }
    
     public String limpiar() {
        banderaSelect=false;
        return "/RegistroTipoatencion.xhtml";
    }
     
     
    public void selectBandera() {
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
    public Tipoatencion getTipoatenciones() {
        return tipoatencion;
    }

    public void setTipoatenciones(Tipoatencion tipoatenciones) {
        this.tipoatencion = tipoatenciones;
    }
    
    
    
}
