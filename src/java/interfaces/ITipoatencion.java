/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Tipoatencion;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface ITipoatencion {
    
    public abstract boolean guardarTipoatencion(Tipoatencion tipoatencion);
    public abstract ArrayList<Tipoatencion> listarTipoatencion();
    public abstract boolean actualizarTipoatencion(Tipoatencion tipoatencion);
    public abstract boolean eliminarTipoatencion(Tipoatencion tipoatencion);
    
}
