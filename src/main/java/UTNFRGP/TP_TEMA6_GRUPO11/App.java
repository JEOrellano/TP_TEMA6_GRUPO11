package UTNFRGP.TP_TEMA6_GRUPO11;

import entidad.Medico;
import enums.Sexo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import dao.DaoHibernateMedico;

public class App {
	public static void main(String[] args) {
		
		
		// Ejemplo 1
        LocalDate fecha1 = LocalDate.of(1988, 3, 5);
        Date fechaNacimiento1 = Date.valueOf(fecha1);
        Medico medico1 = new Medico("001", "Juan", "Pérez", Sexo.M, fechaNacimiento1, "Calle A 123", "Buenos Aires", "juan@example.com", "01123456789");
        DaoHibernateMedico.Add(medico1);
        
        // Ejemplo 2
        LocalDate fecha2 = LocalDate.of(1975, 6, 15);
        Date fechaNacimiento2 = Date.valueOf(fecha2);
        Medico medico2 = new Medico("002", "María", "García", Sexo.F, fechaNacimiento2, "Avenida B 456", "La Plata", "maria@example.com", "02234567890");
        DaoHibernateMedico.Add(medico2);
        
        // Ejemplo 3
        LocalDate fecha3 = LocalDate.of(1990, 9, 25);
        Date fechaNacimiento3 = Date.valueOf(fecha3);
        Medico medico3 = new Medico("003", "Carlos", "Martínez", Sexo.M, fechaNacimiento3, "Calle C 789", "Mar del Plata", "carlos@example.com", "03345678901");
        DaoHibernateMedico.Add(medico3);
        
        // Ejemplo 4
        LocalDate fecha4 = LocalDate.of(1985, 11, 10);
        Date fechaNacimiento4 = Date.valueOf(fecha4);
        Medico medico4 = new Medico("004", "Ana", "López", Sexo.F, fechaNacimiento4, "Avenida D 012", "Bahía Blanca", "ana@example.com", "04456789012");
        DaoHibernateMedico.Add(medico4);
        
        // Ejemplo 5
        LocalDate fecha5 = LocalDate.of(1972, 7, 20);
        Date fechaNacimiento5 = Date.valueOf(fecha5);
        Medico medico5 = new Medico("005", "Pedro", "Sánchez", Sexo.M, fechaNacimiento5, "Calle E 345", "Quilmes", "pedro@example.com", "05567890123");
        DaoHibernateMedico.Add(medico5);
        
        // Ejemplo 6
        LocalDate fecha6 = LocalDate.of(1980, 5, 30);
        Date fechaNacimiento6 = Date.valueOf(fecha6);
        Medico medico6 = new Medico("006", "Laura", "Díaz", Sexo.F, fechaNacimiento6, "Avenida F 678", "Avellaneda", "laura@example.com", "06678901234");
        DaoHibernateMedico.Add(medico6);
        
        // Ejemplo 7
        LocalDate fecha7 = LocalDate.of(1995, 4, 12);
        Date fechaNacimiento7 = Date.valueOf(fecha7);
        Medico medico7 = new Medico("007", "Martín", "Rodríguez", Sexo.M, fechaNacimiento7, "Calle G 901", "Lanús", "martin@example.com", "07789012345");
        DaoHibernateMedico.Add(medico7);
        
        // Ejemplo 8
        LocalDate fecha8 = LocalDate.of(1983, 8, 8);
        Date fechaNacimiento8 = Date.valueOf(fecha8);
        Medico medico8 = new Medico("008", "Elena", "Gómez", Sexo.F, fechaNacimiento8, "Avenida H 234", "Berazategui", "elena@example.com", "08890123456");
        DaoHibernateMedico.Add(medico8);
        
        // Ejemplo 9
        LocalDate fecha9 = LocalDate.of(1978, 10, 18);
        Date fechaNacimiento9 = Date.valueOf(fecha9);
        Medico medico9 = new Medico("009", "Diego", "Hernández", Sexo.M, fechaNacimiento9, "Calle I 567", "Florencio Varela", "diego@example.com", "09901234567");
        DaoHibernateMedico.Add(medico9);
        
        // Ejemplo 10
        LocalDate fecha10 = LocalDate.of(1987, 12, 3);
        Date fechaNacimiento10 = Date.valueOf(fecha10);
        Medico medico10 = new Medico("010", "Luisa", "Fernández", Sexo.F, fechaNacimiento10, "Avenida J 890", "Temperley", "luisa@example.com", "00112345678");
        DaoHibernateMedico.Add(medico10);
        
        System.out.println("--------------------------------------------------- ");

        DaoHibernateMedico.listarMedico();
        
        //Borro un registro
        System.out.println("Borro un registro y vuelvo a listar: ");
		DaoHibernateMedico.Delete("007");
     
        System.out.println("--------------------------------------------------- ");

         DaoHibernateMedico.listarMedico();
         
         System.out.println("Modifico el registro con el legajo 009 y le cambio el nombre a José");

		Medico medicoX = DaoHibernateMedico.leerUno("009");
		 
		System.out.println(medicoX.toString());

		medicoX.setNombre("Jose");
		DaoHibernateMedico.modificarMedico(medicoX);

		medicoX = DaoHibernateMedico.leerUno("009");


		

		DaoHibernateMedico.listarMedico();

	}
}
