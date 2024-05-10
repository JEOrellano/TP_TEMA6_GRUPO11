package dao;

import org.hibernate.Session;

public interface IConfigHibernateDao {
	public void ConfigHibernate();
	public Session abrirConexion();
	public void cerrarSession();
	public void cerrarSessionFactory();
}
