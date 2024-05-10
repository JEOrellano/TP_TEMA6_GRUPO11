package excepciones;

public class PK_Repetida extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PK_Repetida(){}

	@Override
	public String getMessage() {
		return "Clave PK Medico repetida";
	}
	
}
