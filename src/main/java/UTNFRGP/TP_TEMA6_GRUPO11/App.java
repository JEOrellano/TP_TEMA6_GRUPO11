package UTNFRGP.TP_TEMA6_GRUPO11;

import entidad.Medico;
import enums.Sexo;
import excepciones.PK_Repetida;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import dao.DaoHibernateMedico;
import daoImpl.HibernateMedicoDaoImpl;

public class App {
	public static void main(String[] args) {
		LocalDate fecha = LocalDate.of(1980, 1, 5);
		Date fechaNacimiento = Date.valueOf(fecha);

		// carga datos de medico por constructor
		Medico medico = new Medico("123", "Juan", "Pérez", Sexo.M, fechaNacimiento, "Calle 123", "Ciudad",
				"juan@example.com", "123456789");
		
		HibernateMedicoDaoImpl hmdi = new HibernateMedicoDaoImpl();
		// guardar
		try {
			hmdi.add(medico);
		} catch(PK_Repetida e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// leer uno
		Medico medico2 = hmdi.leerUno("123");
		System.out.println("se leyo 123 - " + medico2.toString());
		// modificar
		medico2.setNombre("Jose");
		hmdi.modificarMedico(medico2);
		medico2 = hmdi.leerUno("123");
		System.out.println("se modifico 123 - " + medico2.toString());
		// borrar
		hmdi.delete("123");
		System.out.println("se borro 123 - ");
		// listar todos
		for (int i = 0; i < 10; i++) {
			medico = new Medico("123"+i, "Juan"+i, "Pérez"+i, Sexo.M, fechaNacimiento, "Calle 123"+i, "Ciudad"+i,
					i+"juan@example.com", "123456789"+i);
			try {
				hmdi.add(medico);				
			} catch(PK_Repetida e) {
				e.printStackTrace();;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		hmdi.listarMedico();
		
		
		/* VERSION con metodos static
		// DaoHibernateMedico.Add(medico);

		// DaoHibernateMedico.Delete("123");

		 Medico medico2 = DaoHibernateMedico.leerUno("123");
		 System.out.println(medico2.toString());

		 medico2.setNombre("Jose");
		 DaoHibernateMedico.modificarMedico(medico2);

		// medico2 = DaoHibernateMedico.leerUno("123");

		// System.out.println(medico2.toString());

		DaoHibernateMedico.listarMedico();
		*/

	}
}
