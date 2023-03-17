package logica;

public class Auxiliar {
    private String nombreEmpresa;
	private String direccion;
	private String telef;
	private String sector;
	private Puesto insPuesto;
	
	public Auxiliar(String nombreEmpresa,String sector, String direccion, String telef, Puesto p) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.direccion = direccion;
		this.telef = telef;
		this.sector = sector;
	    this.insPuesto = p;
	}
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelef() {
		return telef;
	}
	public void setTelef(String telef) {
		this.telef = telef;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public Puesto getInsPuesto() {
		return insPuesto;
	}
	public void setInsPuesto(Puesto insPuesto) {
		this.insPuesto = insPuesto;
	}
	
}
