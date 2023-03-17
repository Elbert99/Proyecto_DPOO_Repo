package logica;

import java.util.ArrayList;

public class Candidato {
	protected String numID;
	protected String nombre;
	protected String direccion;
	protected String telefono;
	protected String nivelEscolar;
	protected String especialidad;
	protected String rama;
	protected String sector;
	protected int yearsEspecialidad;
	protected ArrayList<Auxiliar> ListadoEmpleos;

	public Candidato(String numID, String nombre, String direccion,
			String telefono, String nivelEscolar, String especialidad,
			String rama, String sector, int yearsEspecialidad) {
		super();
		this.numID = numID;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nivelEscolar = nivelEscolar;
		this.especialidad = especialidad;
		this.rama = rama;
		this.sector = sector;
		this.yearsEspecialidad = yearsEspecialidad;
		ListadoEmpleos = new ArrayList<Auxiliar>();
	}

	public String getNumID() {
		return numID;
	}

	public void setNumID(String numID) {
		this.numID = numID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNivelEscolar() {
		return nivelEscolar;
	}

	public void setNivelEscolar(String nivelEscolar) {
		this.nivelEscolar = nivelEscolar;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getRama() {
		return rama;
	}

	public void setRama(String rama) {
		this.rama = rama;
	}

	public int getYearsEspecialidad() {
		return yearsEspecialidad;
	}

	public void setYearsEspecialidad(int yearsEspecialidad) {
		this.yearsEspecialidad = yearsEspecialidad;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public ArrayList<Auxiliar> getListadoEmpleos() {
		return ListadoEmpleos;
	}
    
	public void setListadoEmpleos(ArrayList<Auxiliar> l){
		this.ListadoEmpleos = l;
	}
}
