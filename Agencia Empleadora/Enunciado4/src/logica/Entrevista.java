package logica;

public class Entrevista {
	private String hora;
	private boolean planificada = false;

	public Entrevista(String h,boolean p) {
		super();
		this.hora = h;
	    this.planificada = p;
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