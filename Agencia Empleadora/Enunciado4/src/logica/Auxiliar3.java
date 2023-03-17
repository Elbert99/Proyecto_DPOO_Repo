package logica;

public class Auxiliar3 {
    private String sector;
    private String rama;
    private String empleo;
    private int frecuenciaPedida;
	
    public Auxiliar3(String sector, String rama, String empleo) {
		super();
		this.sector = sector;
		this.rama = rama;
		this.empleo = empleo;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getRama() {
		return rama;
	}
	public void setRama(String rama) {
		this.rama = rama;
	}
	public String getEmpleo() {
		return empleo;
	}
	public void setEmpleo(String empleo) {
		this.empleo = empleo;
	}
	public int getFrecuenciaPedida() {
		return frecuenciaPedida;
	}
	public void setFrecuenciaPedida(int frecuenciaPedida) {
		this.frecuenciaPedida = frecuenciaPedida;
	}
}
