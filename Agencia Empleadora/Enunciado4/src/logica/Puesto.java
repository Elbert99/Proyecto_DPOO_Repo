package logica;

import java.util.ArrayList;
import java.util.Date;

public class Puesto {
	private String identificadorPropio;
	private String identificadorRama;
	private int plazasNecesarias;
	private int yearsExp;
	private String nivelEscolar;
	private Date diaEscogido;
	private ArrayList<Entrevista> ListadoEntrevistas;


	public Puesto(String identificadorPropio, String ideRama, String nivelEscolar, int plazasNecesarias, int yearsExp, Date diaEscogido) {
		super();
		this.identificadorPropio = identificadorPropio;
		this.identificadorRama = ideRama;
		this.yearsExp = yearsExp;
		this.nivelEscolar = nivelEscolar;
		this.plazasNecesarias = plazasNecesarias;
		this.diaEscogido = diaEscogido;
	    ListadoEntrevistas = new ArrayList<Entrevista>();
	}

	public String getIdentificadorPropio() {
		return identificadorPropio;
	}
	public void setIdentificadorPropio(String identificadorPropio) {
		this.identificadorPropio = identificadorPropio;
	}
	public String getIdentificadorRama() {
		return identificadorRama;
	}
	public void setIdentificadorRama(String identificadorRama) {
		this.identificadorRama = identificadorRama;
	}
	public int getPlazasNecesarias() {
		return plazasNecesarias;
	}
	public void setPlazasNecesarias(int plazasNecesarias) {
		this.plazasNecesarias = plazasNecesarias;
	}
	public int getYearsExp() {
		return yearsExp;
	}
	public void setYearsExp(int yearsExp) {
		this.yearsExp = yearsExp;
	}
	public String getNivelEscolar() {
		return nivelEscolar;
	}
	public void setNivelEscolar(String nivelEscolar) {
		this.nivelEscolar = nivelEscolar;
	}
	
	public Date getDiaEscogido() {
		return diaEscogido;
	}

	public void setDiaEscogido(Date diaEscogido) {
		this.diaEscogido = diaEscogido;
	}

	public ArrayList<Entrevista> getListadoEntrevistas() {
		return ListadoEntrevistas;
	}

	public void insertarEntrevista(Entrevista entrevista) {
		ListadoEntrevistas.add(entrevista);  
	}
}
