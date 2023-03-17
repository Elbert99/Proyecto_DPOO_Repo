package logica;

import java.util.Date;

public class Auxiliar2 {
	private String nombreEmpresa;
	private String telef;
	private String sector;
	private String identificadorPropio;
	private String identificadorRama;
	private Date diaEscogido;
	private String  hora;
	private boolean planificada;

	public Auxiliar2(String nombreEmpresa, String telef, String sector,
			String identificadorPropio, String identificadorRama,
			Date diaEscogido, String hora, boolean planificada) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.telef = telef;
		this.sector = sector;
		this.identificadorPropio = identificadorPropio;
		this.identificadorRama = identificadorRama;
		this.diaEscogido = diaEscogido;
		this.hora = hora;
		this.planificada = planificada;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
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
	public Date getDiaEscogido() {
		return diaEscogido;
	}
	public void setDiaEscogido(Date diaEscogido) {
		this.diaEscogido = diaEscogido;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public boolean isPlanificada() {
		return planificada;
	}
	public void setPlanificada(boolean planificada) {
		this.planificada = planificada;
	}


}


