package dao;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import entidad.Medico;

public class DaoHibernateMedico {
	public static void Add(Medico medico)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
	        
	    session.beginTransaction();
	    session.save(medico);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public static void Delete(String legajo) {
        ConfigHibernate ch = new ConfigHibernate();
        Session session = ch.abrirConexion();
        
        Medico medico = (Medico) session.createQuery("FROM Medico WHERE legajo = :legajo")
                                       .setParameter("legajo", legajo)
                                       .uniqueResult();
        if (medico != null) {
            session.beginTransaction();
            session.delete(medico);
            session.getTransaction().commit();
        } else {
            System.out.println("No se encontró ningún médico con el legajo especificado.");
        }
        
        ch.cerrarSession();
    }
}
