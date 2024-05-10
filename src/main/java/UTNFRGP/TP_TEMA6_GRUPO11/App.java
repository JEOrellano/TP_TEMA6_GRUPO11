package UTNFRGP.TP_TEMA6_GRUPO11;

import entidad.Medico;
import enums.Sexo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import dao.DaoHibernateMedico;

public class App {
	public static void main(String[] args) {
		LocalDate fecha = LocalDate.of(1980, 1, 5);
		Date fechaNacimiento = Date.valueOf(fecha);

		Medico medico = new Medico("123", "Juan", "Pérez", Sexo.M, fechaNacimiento, "Calle 123", "Ciudad",
				"juan@example.com", "123456789");
		DaoHibernateMedico.Add(medico);

		// DaoHibernateMedico.Delete("123");

		// Medico medico2 = DaoHibernateMedico.leerUno("123");
		// System.out.println(medico2.toString());

		// medico2.setNombre("Jose");
		// DaoHibernateMedico.modificarMedico(medico2);

		// medico2 = DaoHibernateMedico.leerUno("123");

		// System.out.println(medico2.toString());

		DaoHibernateMedico.listarMedico();

	}
}
