package UTNFRGP.TP_TEMA6_GRUPO11;
import entidad.Medico;
import enums.Sexo;

import java.time.LocalDate;

import dao.DaoHibernateMedico;
public class App 
{
    public static void main( String[] args )
    {
    	DaoHibernateMedico medicoDAO = new DaoHibernateMedico();
    	Medico medico = new Medico(1,"123", "Juan", "Pérez", Sexo.M, LocalDate.parse("1980-01-01"), "Calle 123", "Ciudad", "juan@example.com", "123456789");
    	medicoDAO.Add(medico);
    		
    	//medicoDAO.Delete("123");
    	
    }
}
