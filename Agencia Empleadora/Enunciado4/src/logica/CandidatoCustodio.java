package logica;

public class CandidatoCustodio extends Candidato {
	private float califEF;
	private int numHC;
	
	public CandidatoCustodio(String numID, String nombre, String direccion,
			String telefono, String nivelEscolar, String especialidad,
			String rama, String sector, int yearsEspecialidad, float califEF,
			int numHC) {
		super(numID, nombre, direccion, telefono, nivelEscolar, especialidad,
				rama, sector, yearsEspecialidad);
		this.califEF = califEF;
		this.numHC = numHC;
	}
    
    public float getCalifEF() {
		return califEF;
	}

	public void setCalifEF(float califEF) {
		
		this.califEF = califEF;
	}

	public int getNumHC() {
		return numHC;
	}

	public void setNumHC(int numHC) {
		this.numHC = numHC;
	}


}
