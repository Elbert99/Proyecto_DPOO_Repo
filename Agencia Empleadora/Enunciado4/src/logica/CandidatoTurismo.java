package logica;

public class CandidatoTurismo extends Candidato {
	private boolean certificadoIdioma;

	public CandidatoTurismo(String numID, String nombre, String direccion,
			String telefono, String nivelEscolar, String especialidad,
			String rama, String sector, int yearsEspecialidad,
			boolean certificadoIdioma) {
		super(numID, nombre, direccion, telefono, nivelEscolar, especialidad,
				rama, sector, yearsEspecialidad);

		this.certificadoIdioma = certificadoIdioma;
	}

	public boolean isCertificadoIdioma() {
		return certificadoIdioma;
	}

	public void setCertificadoIdioma(boolean certificadoIdioma) {
		this.certificadoIdioma = certificadoIdioma;
	}


}
