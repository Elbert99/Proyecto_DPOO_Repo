package logica;

import java.util.ArrayList;
import java.util.Date;

public class AgenciaEmpleadora {


	private String identificador;
	private ArrayList<Candidato> ListadoCandidatosInscritos;
	private ArrayList<Candidato> ListadoCandidatosEmpleados;
	private ArrayList<Empresa> ListadoEmpresas;
	private ArrayList<RegistroMensual> ListadoRegistros;
	private ArrayList<Auxiliar> ListaAux;

	public AgenciaEmpleadora() {
		super();// TODO Auto-generated constructor stub
	}
	public AgenciaEmpleadora(String identificador) {
		super();
		this.identificador = identificador;
		ListadoCandidatosInscritos = new ArrayList<Candidato>();
		ListadoCandidatosEmpleados = new ArrayList<Candidato>();
		ListadoEmpresas = new ArrayList<Empresa>();
		ListadoRegistros = new ArrayList<RegistroMensual>();
	}



	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public ArrayList<Candidato> getListadoCandidatosInscritos() {
		return ListadoCandidatosInscritos;
	}

	public ArrayList<Candidato> getListadoCandidatosEmpleados(){
		return ListadoCandidatosEmpleados;
	}
	public ArrayList<Empresa> getListadoEmpresas() {
		return ListadoEmpresas;
	}
	public ArrayList<RegistroMensual> getListadoRegistros() {
		return ListadoRegistros;
	}

	public ArrayList<Auxiliar> getListaAux() {
		return ListaAux;
	}

	public void setListaAux(ArrayList<Auxiliar> listaAux) {
		this.ListaAux = listaAux;
	}

	public int buscarCandidato(String numID) {
		int pos = -1;
		int i = 0;
		boolean found = false;
		while (i < ListadoCandidatosInscritos.size() && !found)
			if (ListadoCandidatosInscritos.get(i).getNumID().equalsIgnoreCase(numID)) {
				found = true;
				pos = i;
			} else
				i++;
		return pos;
	}

	public int buscarCandidatoEmpleado(String numID) {
		int pos = -1;
		int i = 0;
		boolean found = false;
		while (i < ListadoCandidatosEmpleados.size() && !found)
			if (ListadoCandidatosEmpleados.get(i).getNumID().equalsIgnoreCase(numID)) {
				found = true;
				pos = i;
			} else
				i++;
		return pos;
	}

	public String registrarCandidato(String numID, String nombre, String direccion,
			String telefono, String nivelEscolar, String especialidad,
			String rama, String sector, int yearsEspecialidad){
		String retorno= "El candidato y esta inscrito" ;
		int pos = buscarCandidato(numID);

		if(pos == -1){
			ListadoCandidatosInscritos.add(new Candidato( numID, nombre, direccion,
					telefono, nivelEscolar,  especialidad,
					rama,  sector,  yearsEspecialidad));
			retorno = "Se ha ingresado exitosamente el candidato";
		}
		return retorno;
	}

	public void registrarCandidatoCustodio(String numID, String nombre, String direccion,
			String telefono, String nivelEscolar, String especialidad,
			String rama, String sector, int yearsEspecialidad, float promedio, int numHC){

		int pos = buscarCandidato(numID);

		if(pos == -1){
			ListadoCandidatosInscritos.add(new CandidatoCustodio( numID, nombre, direccion,
					telefono, nivelEscolar,  especialidad,
					rama,  sector,  yearsEspecialidad, promedio ,numHC));
		}
	}

	public void registrarCandidatoTurismo(String numID, String nombre, String direccion,
			String telefono, String nivelEscolar, String especialidad,
			String rama, String sector, int yearsEspecialidad, boolean entregado){

		int pos = buscarCandidato(numID);

		if(pos == -1){
			ListadoCandidatosInscritos.add(new CandidatoTurismo( numID, nombre, direccion,
					telefono, nivelEscolar,  especialidad,
					rama,  sector,  yearsEspecialidad, entregado));
		}
	}

	public void registrarCandidatoEmpleado(String numID,String nombre,String direccion,
			String telef,String nivelEscolar,String especialidad,
			String rama,String sector,int yearsEsp){
		int pos = buscarCandidatoEmpleado(numID);

		if(pos == -1){
			ListadoCandidatosEmpleados.add(new Candidato( numID, nombre, direccion,
					telef, nivelEscolar,  especialidad,
					rama,  sector,  yearsEsp));
		}
	}

	public boolean comprobarExistenciaEmpleo(String numID,String  nombre,String  direccion,String  telef,String  nivelEscolar, String especialidad,String  rama,String  sector,int yearsExp){
		ArrayList<Auxiliar>ListaEmpresasInteresadas = new ArrayList<Auxiliar>();
		int j;
		int pos = buscarCandidato(numID);
		boolean found, comprobar = false;

		for(int i=0; i<ListadoEmpresas.size(); i++){
			if(sector.equalsIgnoreCase("cualesquiera") || ListadoEmpresas.get(i).getSector().equalsIgnoreCase(sector)){ 
				j=0;
				found = false;
				while (j<ListadoEmpresas.get(i).getListadoPuestos().size() && !found){
					if(ListadoEmpresas.get(i).getListadoPuestos().get(j).getIdentificadorRama().equalsIgnoreCase(rama)){
						if(ListadoEmpresas.get(i).getListadoPuestos().get(j).getIdentificadorPropio().equalsIgnoreCase(especialidad) &&
								ListadoEmpresas.get(i).getListadoPuestos().get(j).getYearsExp() <= yearsExp && 
								ListadoEmpresas.get(i).getListadoPuestos().get(j).getNivelEscolar().equalsIgnoreCase(nivelEscolar)){
							if(ListadoEmpresas.get(i).getListadoPuestos().get(j).getPlazasNecesarias()>0){
								Auxiliar aux = new Auxiliar(ListadoEmpresas.get(i).getNombre(),ListadoEmpresas.get(i).getSector(),
										ListadoEmpresas.get(i).getDireccion(),ListadoEmpresas.get(i).getTelefono(),
										ListadoEmpresas.get(i).getListadoPuestos().get(j));
								ListaEmpresasInteresadas.add(aux);
								found =true;
								comprobar = true;
							}
						}
					}
					else
						j++;
				}			            	  
			}
		}
		if( pos !=-1 && comprobar == true)
			ListadoCandidatosInscritos.get(pos).setListadoEmpleos(ListaEmpresasInteresadas);
		else if(pos ==-1 && comprobar == true)
			setListaAux(ListaEmpresasInteresadas);

		return comprobar;
	}

	/*
	public void programarCita(Auxiliar empleo, Entrevista cita){
		int i =0, j = 0;
		boolean encontrado = false, encontradoEmpleo = false, verificador = false;

		while(i<registroCitas.getMes().size() && !encontrado){
			if(empleo.getNombreEmpresa().equalsIgnoreCase(registroCitas.getMes().get(i).getE1().getNombre())){
				while(j<registroCitas.getMes().get(i).getE1().getListadoPuestos().size() && !encontradoEmpleo){
					if(empleo.getIdRama().equalsIgnoreCase(registroCitas.getMes().get(i).getE1().getListadoPuestos().get(j).getIdentificadorRama()) &&
							empleo.getIdPuesto().equalsIgnoreCase(registroCitas.getMes().get(i).getE1().getListadoPuestos().get(j).getIdentificadorPropio())){

						int cant = registroCitas.getMes().get(i).getE1().getListadoPuestos().get(j).getCantidadEntrevistas();
						registroCitas.getMes().get(i).getE1().getListadoPuestos().get(j).setCantidadEntrevistas(cant+1);
						encontradoEmpleo=true;
						verificador=true;
					}
					else
						j++;
				}
				encontrado=true;    
			}
			else 
				i++;
		}
		if(verificador){
			int pos = buscarEmpresa(empleo.getNombreEmpresa());
			int pos2 = ListadoEmpresas.get(pos).buscarPuesto(empleo.getIdRama(), empleo.getIdPuesto());
			registroCitas.getMes().get(cita.getFecha().getDay()).setE1(ListadoEmpresas.get(pos));
			registroCitas.getMes().get(cita.getFecha().getDay()).getE1().getListadoPuestos().get(pos2).setEntrevista(cita);
			registroCitas.getMes().get(cita.getFecha().getDay()).getE1().getListadoPuestos().get(pos2).getEntrevista().setPlanificada(true);
			registroCitas.getMes().get(cita.getFecha().getDay()).getE1().getListadoPuestos().get(pos2).setCantidadEntrevistas(1);
			empleo.setEntrevista(cita);
		}
	}
	 */




	public int conocerElTIpodeCandidato(String numID, String nombre, String direccion, String telefono, String nivelEscolar, String especialidad, String rama, String sector, int yearsEspecialidad){
		int tipo=1;
		int posActual = buscarCandidato(numID);;

		if(ListadoCandidatosInscritos.get(posActual) instanceof CandidatoTurismo)
			tipo = 2;
		else if(ListadoCandidatosInscritos.get(posActual) instanceof CandidatoCustodio)
			tipo = 3;        	

		return tipo;
	}

	/*
	public void ubicarCandidato(String numID, String nombre, String direccion,
			String telefono, String nivelEscolar, String especialidad,
			String rama, String sector, int yearsEspecialidad){

		int posActual=buscarCandidato(numID);

		if(posActual == -1){
			registrarCandidato(numID, nombre, direccion, telefono, nivelEscolar, especialidad, rama, sector, yearsEspecialidad);
		}
		ArrayList<Auxiliar> auxiliar = comprobarExistenciaEmpleo(numID, nombre, direccion, telefono, nivelEscolar, especialidad, rama, sector, yearsEspecialidad);
		if(auxiliar.isEmpty()==false){
			for(int i=0; i< auxiliar.size(); i++){

				ListadoCandidatosInscritos.get(posActual).getListadoEntrevistas().add( registroCitas.conocerEntrevista(auxiliar.get(i).getNombre(),ListadoCandidatosInscritos.get(posActual).getRama(),ListadoCandidatosInscritos.get(posActual).getEspecialidad()));
			}
			if(ListadoCandidatosInscritos.get(posActual).decisionUbicacionLaboral()!= null){
				actualizarListadoEmpresas(ListadoCandidatosInscritos.get(posActual).decisionUbicacionLaboral(),1, rama, especialidad);  	
				ListadoCandidatosInscritos.remove(posActual);
			}	
		}

	}

	/*public void actualizarListadoEmpresas(String nombreEmpresa,int cant, String identRama, String identificadorPuesto){
		int i=0, pos = buscarEmpresa(nombreEmpresa);
		boolean found = false;

		while(i< ListadoEmpresas.size() && !found){
			if(pos != -1){
				ListadoEmpresas.get(i).modificarListadoRamas(cant, identRama, identificadorPuesto);
				if(ListadoEmpresas.get(i).getListadoRamas().isEmpty()==true)
					ListadoEmpresas.remove(i); 
				found=true;
			}
			else
				i++;
		}
	}
	 */
	public int buscarEmpresa(String nombre) {
		int pos = -1;
		int i = 0;
		boolean found = false;
		while (i < ListadoEmpresas.size() && !found)
			if (ListadoEmpresas.get(i).getNombre().equalsIgnoreCase(nombre)) {
				found = true;
				pos = i;
			} else
				i++;
		return pos;
	}

	public boolean registrarEmpresa(String nombre, String direccion,
			String telefono, String sector){
		int pos = buscarEmpresa(nombre);

		if(pos == -1){
			ListadoEmpresas.add(new Empresa( nombre, direccion, telefono, sector));
		}
		return pos==-1? true : false;

	}

	public void insertarPuesto(String nombreEmpresa, Puesto puesto) {		
		int pos = buscarEmpresa(nombreEmpresa);
		if (pos != -1)
			ListadoEmpresas.get(pos).insertarEmpleo(puesto);
	}

	public void registrarCandidatoEmpleadoCustodio(String numID, String nombre,
			String direccion, String telef, String nivelEscolar,
			String especialidad, String rama, String sector, int yearsExp,
			float promedioEF, int numHC) {
		int pos = buscarCandidatoEmpleado(numID);

		if(pos == -1){
			ListadoCandidatosEmpleados.add(new CandidatoCustodio( numID, nombre, direccion,
					telef, nivelEscolar,  especialidad,
					rama,  sector,  yearsExp, promedioEF, numHC));
		}
	}

	public void registrarCandidatoEmpleadoTurismo(String numID,String nombre,String direccion,
			String telef,String nivelEscolar,String especialidad,
			String rama,String sector,int yearsEsp, boolean certificado){
		int pos = buscarCandidatoEmpleado(numID);

		if(pos == -1){
			ListadoCandidatosEmpleados.add(new CandidatoTurismo( numID, nombre, direccion,
					telef, nivelEscolar,  especialidad,
					rama,  sector,  yearsEsp, certificado));
		}
	}

	public void almacenarEnRegistroMes(String nombreEmpresa, String telef, String sector, String identificadorPropio, String identificadorRama,
			Date diaEscogido, Entrevista e){
		Auxiliar2 aux = new Auxiliar2(nombreEmpresa, telef, sector, identificadorPropio,identificadorRama,diaEscogido, e.getHora(),e.isPlanificada()); 
		aux.setPlanificada(true);
		RegistroMensual reg = new RegistroMensual(aux);
		this.ListadoRegistros.add(reg);
	}

	public ArrayList<Auxiliar3> emitirReportedEmpleosmasFrecuentesCand (){
		ArrayList<Candidato> lista1 = this.ListadoCandidatosInscritos;
		ArrayList<Candidato> lista2 = this.ListadoCandidatosEmpleados;
		ArrayList<Candidato> listaAnalisis = obtenerListaAnalisis(lista1,lista2);
		ArrayList<Auxiliar3> listaReporte = new ArrayList<Auxiliar3>();
		int i = 0 ;
		String sector = null, rama = null, empleo = null;
		int frecuencia;

		while(i<listaAnalisis.size()){

			if(!listaAnalisis.get(i).getSector().equalsIgnoreCase("cualesquiera")){
				sector = listaAnalisis.get(i).getSector();
				rama = listaAnalisis.get(i).getRama();
				empleo = listaAnalisis.get(i).getEspecialidad();

				if(!listaReporte.contains(new Auxiliar3(sector, rama, empleo))){
					frecuencia = 0;
					for(int j=0; j<listaAnalisis.size() ;j++){
						if(listaAnalisis.get(j).getSector().equalsIgnoreCase(sector)){
							if(listaAnalisis.get(j).getRama().equalsIgnoreCase(rama)){
								if(listaAnalisis.get(j).getEspecialidad().equalsIgnoreCase(empleo)){
									frecuencia++;
								}
							}							    
						}
					}
					if(frecuencia >=3){
						Auxiliar3 aux = new Auxiliar3(sector, rama, empleo);
						aux.setFrecuenciaPedida(frecuencia);
						listaReporte.add(aux);
					}
				}
				i++;
			}
			else
				i++;
		}
		if(listaReporte.isEmpty())
			listaReporte=null;
		return listaReporte;
	}

	public ArrayList<Candidato> obtenerListaAnalisis(ArrayList<Candidato> lista1, ArrayList<Candidato> lista2) {
		ArrayList<Candidato> listaA = null;
		for(int i = 0 ;i<lista2.size(); i++){
			lista1.add(lista2.get(i));
		}
		listaA = lista1;
		return listaA;
	}

	public ArrayList<Auxiliar3> emitirReporteEmpleosmasSolicitadosXEmpresas(){
		ArrayList<Auxiliar3> listaReporteE = new ArrayList<Auxiliar3>();
		ArrayList<Puesto> puestosAux = obtenerListadoAuxPuesto();

		for(int i = 0; i<puestosAux.size(); i++){

		}




		return null;
	}

	private ArrayList<Puesto> obtenerListadoAuxPuesto() {
		ArrayList<Puesto> listRetorno = new ArrayList<Puesto>();

		for(int i = 0 ; i<ListadoEmpresas.size(); i++){
			for(int j = 0;j < ListadoEmpresas.get(i).getListadoPuestos().size(); j++){
				listRetorno.add(ListadoEmpresas.get(i).getListadoPuestos().get(j));
			}
		}
		return listRetorno;
	}
	@SuppressWarnings("deprecation")
	public void poblar(){
		Entrevista e1 = new Entrevista("9:00am",false);
		Entrevista e2 = new Entrevista("8:00am",false);
		Entrevista e3 = new Entrevista("10:00am",false);
		Entrevista e4 = new Entrevista("11:00am",false);
		Entrevista e5 = new Entrevista("7:00am",false);
		Entrevista e6 = new Entrevista("12:00pm",false);


		Puesto p1 = new Puesto("informatico", "ingeniero", "universitario",2,0,new Date(3, 5, 2019));
		p1.getListadoEntrevistas().add(e1);
		p1.getListadoEntrevistas().add(e2);
		Puesto p2 = new Puesto("informatico", "directivo", "universitario",2,3,new Date(5, 5, 2019));
		p2.getListadoEntrevistas().add(e3);
		p2.getListadoEntrevistas().add(e4);
		Puesto p3 = new Puesto("informatico", "ingeniero", "universitario",2,0,new Date(5, 5, 2019));
		p3.getListadoEntrevistas().add(e5);
		p3.getListadoEntrevistas().add(e6);

		Empresa em1 = new Empresa("Empresas Comercializadora", "calle 23","2139489032", "transporte");
		em1.getListadoPuestos().add(p1);
		em1.getListadoPuestos().add(p2);

		Empresa em2 = new Empresa("Empresas SA", "calle 25","2139489032", "transporte");
		em2.getListadoPuestos().add(p3);

		getListadoEmpresas().add(em1);
		getListadoEmpresas().add(em2);
	
	    Candidato c1 = new Candidato("1242534", "Elsa", "Stgo de las vegas calle 4", "564575733254", "universitario", "electrica", "ingeniera", "industrial", 0);
	    Candidato c2 = new Candidato("124672534", "Juan", "Stgo de las vegas calle 5", "564575734574", "universitario", "informatica", "ingeniera", "industrial", 0);
	    Candidato c3 = new Candidato("1244572534", "Martica", "Stgo de las vegas calle 7", "564457575734", "universitario", "informatica", "ingeniera", "industrial", 0);
	    
	    getListadoCandidatosInscritos().add(c1);
	    getListadoCandidatosInscritos().add(c2);
	    getListadoCandidatosInscritos().add(c3);
	}
}
