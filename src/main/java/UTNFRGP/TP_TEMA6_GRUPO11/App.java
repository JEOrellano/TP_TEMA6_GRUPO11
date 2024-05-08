package UTNFRGP.TP_TEMA6_GRUPO11;
import entidad.Medico;
import enums.Sexo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import dao.DaoHibernateMedico;
public class App 
{
    public static void main( String[] args )
    {	
    		
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here

    		LocalDate fecha = formatter.(LocalDate.of(1980, 01, 05));
    		
    		System.out.println(fecha.toString());
    		
    		Medico medico = new Medico("123", "Juan", "Pérez", Sexo.M, fecha , "Calle 123", "Ciudad", "juan@example.com", "123456789");
    	
    		DaoHibernateMedico.Add(medico);


    }
}
