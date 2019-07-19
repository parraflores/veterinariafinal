/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.MascotaporclienteDao;
import dao.ClienteDao;
import dao.MascotaDao;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
//@RequestScoped
@ViewScoped
public class MascotaporclienteBean{

 private boolean banderaSelect=false;
 private   ArrayList listaclientes;
 private   ArrayList listamascotas;
 private int idCliente;
 private int idMascota;
 
 private Mascotaporcliente mascotaporcliente;
 MascotaporclienteId mascotaclienteid;
 
 
 
    
 public MascotaporclienteBean(){
     listaclientes = new ArrayList();
     mascotaporcliente = new Mascotaporcliente();
     mascotaclienteid = new MascotaporclienteId();
     listarCombos();
     
 }
 public void  listarCombos(){
     ClienteDao clientedao = new ClienteDao();
     MascotaDao mascotadao = new MascotaDao();
     listaclientes = clientedao.listarCliente();
     listamascotas = mascotadao.listarMascotas();
     
     
 }
 public String guardar(){
     MascotaporclienteDao dao =new MascotaporclienteDao();
     mascotaclienteid.setClienteIdCliente(idCliente);
     mascotaclienteid.setMascotaIdMascota(idMascota);
     mascotaporcliente.setId(mascotaclienteid);
     dao.guardarMascotaporcliente(mascotaporcliente);
        return "/RegistroMascotaporcliente";
    }
   public void selectBandera() {
        banderaSelect = true;
    }

    public ArrayList getListaCliente() {
        return listaclientes;
    }

    public void setListaCliente(ArrayList listaCliente) {
        this.listaclientes = listaCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

    public ArrayList getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList listaclientes) {
        this.listaclientes = listaclientes;
    }

    public ArrayList getListamascotas() {
        return listamascotas;
    }

    public void setListamascotas(ArrayList listamascotas) {
        this.listamascotas = listamascotas;
    }

    public Mascotaporcliente getMascotaporcliente() {
        return mascotaporcliente;
    }

    public void setMascotaporcliente(Mascotaporcliente mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }

    public MascotaporclienteId getMascotaclienteid() {
        return mascotaclienteid;
    }

    public void setMascotaclienteid(MascotaporclienteId mascotaclienteid) {
        this.mascotaclienteid = mascotaclienteid;
    }
    
}