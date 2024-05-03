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
}
