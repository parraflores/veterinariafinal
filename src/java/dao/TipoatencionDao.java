
package dao;

import entidades.Tipoatencion;
import entidades.Tiporeserva;
import interfaces.ITipoatencion;
import interfaces.ITiporeserva;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIO
 */
public class TipoatencionDao implements ITipoatencion {

    @Override
    public boolean guardarTipoatencion(Tipoatencion tipoatencion) {
          boolean respuesta=true;
      Session session =HibernateUtil.getSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(tipoatencion);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
        }
    
        session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Tipoatencion> listarTipoatencion() {
          Session session =HibernateUtil.getSessionFactory().openSession();
          ArrayList<Tipoatencion> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Tipoatencion");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Tipoatencion>) query.list();
         session.close();
        return milista;
    }
    @Override
    public boolean actualizarTipoatencion(Tipoatencion tipoatencion) {
             Session session =HibernateUtil.getSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(tipoatencion);
        transaccion.commit();
        } catch (Exception e) {
            System.out.println(" error"+e);
            respuesta = false;
        }
        session.close();
        return respuesta;
    }

    @Override
    public boolean eliminarTipoatencion(Tipoatencion tipoatencion) {
    boolean respuesta = true;
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(tipoatencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;

    }
    
    
}