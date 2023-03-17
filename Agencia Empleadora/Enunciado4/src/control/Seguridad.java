package control;

public class Seguridad {
	private final String nombreUsuario = "admin";
	private final String contrasenna = "agenciaE";
	
	public final boolean acceso(String usuario, String contrasenna)
	{
		return this.nombreUsuario.equalsIgnoreCase(usuario) && this.contrasenna.equalsIgnoreCase(contrasenna);
	}
}
