package daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.ConfigHibernate;
import dao.IHibernateMedicoDao;
import entidad.Medico;
import excepciones.PK_Repetida;

public class HibernateMedicoDaoImpl implements IHibernateMedicoDao{

	public void add(Medico medico) throws PK_Repetida{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		
		if(leerUno(medico.getLegajo())!=null) {
			throw new PK_Repetida();
		} else {
			session.save(medico);
		}

		session.getTransaction().commit();
		ch.cerrarSession();
	}

	public void delete(String legajo) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		Medico medico = (Medico) session.createQuery("FROM Medico WHERE legajo = :legajo")
				.setParameter("legajo", legajo).uniqueResult();
		if (medico != null) {
			session.beginTransaction();
			session.delete(medico);
			session.getTransaction().commit();
		} else {
			System.out.println("No se encontró ningún médico con el legajo especificado.");
		}

		ch.cerrarSession();
	}

	public Medico leerUno(String legajo) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();

		// filtro por el legajo
		Query query = session.createQuery("FROM Medico WHERE legajo = :legajo");
		query.setParameter("legajo", legajo);
		Medico medico = (Medico) query.uniqueResult();

		ch.cerrarSession();
		return medico;
	}

	public void modificarMedico(Medico medicoModificado) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();

		Medico medicoExistente = (Medico) session.get(Medico.class, medicoModificado.getLegajo());

		if (medicoExistente != null) {
			medicoExistente.setNombre(medicoModificado.getNombre());
			medicoExistente.setApellido(medicoModificado.getApellido());
			medicoExistente.setDireccion(medicoModificado.getDireccion());
			medicoExistente.setEmail(medicoModificado.getEmail());
			medicoExistente.setTelefono(medicoModificado.getTelefono());
			medicoExistente.setLocalidad(medicoModificado.getLocalidad());
			medicoExistente.setNacimiento(medicoModificado.getNacimiento());
			medicoExistente.setSexo(medicoModificado.getSexo());

			session.update(medicoExistente);
			session.getTransaction().commit();
			System.out.println(
					"El médico con legajo " + medicoExistente.getLegajo() + " ha sido modificado exitosamente.");
		} else {
			System.out.println("No se encontró ningún médico con el ID especificado.");
		}

		ch.cerrarSession();
	}

	public void listarMedico() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();

		Query queryMedico = session.createQuery("FROM Medico");
		List<Medico> listMedico = queryMedico.list();
		for (Medico medico : listMedico) {
			System.out.println(medico.toString());
		}
		session.getTransaction().commit();
	}

}
