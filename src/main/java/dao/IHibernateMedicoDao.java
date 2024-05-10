package dao;

import entidad.Medico;

public interface IHibernateMedicoDao {
	public void add(Medico medico);
	public void delete(String legajo);
	public Medico leerUno(String legajo);
	public void modificarMedico(Medico medicoModificado);
	public void listarMedico();
}
