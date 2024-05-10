package dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

import javax.transaction.Transaction;

import entidad.Medico;

public class DaoHibernateMedico {
	public static void Add(Medico medico) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		session.save(medico);

		session.getTransaction().commit();
		ch.cerrarSession();
	}

	public static void Delete(String legajo) {
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

	public static Medico leerUno(String legajo) {

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

	public static void modificarMedico(Medico medicoModificado) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();

		Medico medicoExistente = (Medico) session.get(Medico.class, medicoModificado.getId());

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

	public static void listarMedico() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		System.out.println("entro mostrar");

		Query queryMedico = session.createQuery("FROM Medico");
		List<Medico> listMedico = queryMedico.list();
		for (Medico medico : listMedico) {
			System.out.println("Legajo: " + medico.getLegajo() + ", Nombre: " + medico.getNombre() + ", Apellido: "
					+ medico.getApellido() + ", Sexo: " + medico.getSexo() + ", Fecha de Nacimiento: "
					+ medico.getNacimiento() + ", Dirección: " + medico.getDireccion() + ", Localidad: "
					+ medico.getLocalidad() + ", Email: " + medico.getEmail() + ", Teléfono: " + medico.getTelefono());
		}
		session.getTransaction().commit();

	}
}
