package interfaz;

import java.util.ArrayList;

import javax.swing.JDialog;

import logica.AgenciaEmpleadora;
import logica.Auxiliar;
import logica.Candidato;
import logica.Entrevista;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class ListadoCoincidencias extends JDialog {
	private boolean candidatoNombre = true;
	private boolean candidatoEspecialidad = true;
	private boolean candidatoNivelescolar = true;
	private boolean candidatoTelefono = true;
	private boolean candidatoRama = true;
	private boolean candidatoYearsEsp = true;
	private static final long serialVersionUID = 1L;
	private ArrayList<Candidato> revisionCandidatos;
	private AgenciaEmpleadora agencia;
	private Fondo fondo;
	private JTable table;
	private JTable tableEmpleos;
	private JTable tableEntrevistas;
	private JLabel lblNewLabel;
	private JLabel lblListadoConEmpleos;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JLabel lblHorarioDeLas;
	private JScrollPane scrollPane_2;
	private JButton btnPlanificar;
	private JButton btnDescartar;
	private JButton btnContinuar;
	/**
	 * @wbp.nonvisual location=117,-11
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	/**
	 * @wbp.nonvisual location=297,-11
	 */
	private DefaultTableModel defaultTableModelE = new DefaultTableModel();
	/**
	 * @wbp.nonvisual location=527,-11
	 */
	private DefaultTableModel defaultTableModelC = new DefaultTableModel();
	protected int indiceCandidato = 0;
	protected int indiceEmpleo = 0;
	protected int indiceEntrevista = 0;
	private boolean empresaTelef = true;
	private boolean empresaDir = true;
	private boolean empresaSec = true;
	private boolean empresaPuesto = true;
	private boolean empresaPuestoRama = true;
	private boolean empresaCantPuestos = true;
	private boolean empresaDiaEntrevista = true;
	private JButton btnHabilitarPlanificar;


	/**
	 * Create the frame.
	 */
	public ListadoCoincidencias(ArrayList<Candidato> ListaA, AgenciaEmpleadora a) {
		this.revisionCandidatos = ListaA;
		this.agencia = a;
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setUndecorated(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Programar Entrevistas para Candidatos Inscritos");
		this.revisionCandidatos = ListaA;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1017, 426);
		fondo = new Fondo();
		fondo.setToolTipText("Esta ventana est\u00E1 dise\u00F1ada para informar a cada uno de los candidatos y analizar todas sus opciones de empleo.");
		fondo.setBackground(new Color(0, 102, 102));
		fondo.imagen = Toolkit.getDefaultToolkit().getImage(ListadoCoincidencias.class.getResource("/fondos/fondo-abstracto-diseno-poli_1048-8478.jpg"));
		fondo.setBounds(10, 0, 643, 466);
		setContentPane(fondo);
		fondo.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Presione un \"click\" en el candidato que desea analizar para revisar sus opciones disponibles. ");
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 37, 457, 161);
		fondo.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListadoCoincidencias.this.indiceCandidato = ListadoCoincidencias.this.table.getSelectedRow();
				ListadoCoincidencias.this. cargarTablaConEmpleosCorrespondientes(revisionCandidatos.get(indiceCandidato));
			}
		});
		table.setToolTipText("Presione un \"click\" en el candidato que desea analizar para revisar sus opciones disponibles. ");
		scrollPane.setViewportView(table);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setToolTipText("Presione un \"click\" en el empleo elegido para descartarlo o para verificar el horario m\u00E1s conveniente en cu\u00E1nto a la entrevista. El candidato solo puede asistir a una cita al dia ");
		scrollPane_1.setBounds(500, 37, 477, 161);
		fondo.add(scrollPane_1);

		tableEmpleos = new JTable();
		tableEmpleos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		tableEmpleos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEmpleos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListadoCoincidencias.this.indiceEmpleo  = ListadoCoincidencias.this.tableEmpleos.getSelectedRow();
				ListadoCoincidencias.this. cargarTablaConEntrevistas(revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo));
			}
		});
		tableEmpleos.setToolTipText("Presione un \"click\" en el empleo elegido para descartarlo o para verificar el horario m\u00E1s conveniente en cu\u00E1nto a la entrevista. El candidato solo puede asistir a una cita al dia ");
		scrollPane_1.setViewportView(tableEmpleos);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportBorder(null);
		scrollPane_2.setToolTipText("Eliga solo una hora. El candidato solo puede asistir a una sola cita al d\u00EDa.");
		scrollPane_2.setBounds(10, 271, 148, 62);
		fondo.add(scrollPane_2);

		tableEntrevistas = new JTable();
		tableEntrevistas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListadoCoincidencias.this.indiceEntrevista   = ListadoCoincidencias.this.tableEntrevistas.getSelectedRow();
			}
		});
		tableEntrevistas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		tableEntrevistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEntrevistas.setToolTipText("Eliga solo una hora. El candidato solo puede asistir a una sola cita al d\u00EDa.");
		scrollPane_2.setViewportView(tableEntrevistas);

		lblNewLabel = new JLabel("Listado con posibles futuros empleados :");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(204, 204, 255));
		lblNewLabel.setBounds(10, 11, 382, 23);
		fondo.add(lblNewLabel);

		lblListadoConEmpleos = new JLabel("Listado con empleos disponibles :");
		lblListadoConEmpleos.setBackground(new Color(255, 255, 255));
		lblListadoConEmpleos.setForeground(new Color(204, 204, 255));
		lblListadoConEmpleos.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblListadoConEmpleos.setBounds(500, 11, 382, 23);
		fondo.add(lblListadoConEmpleos);

		lblHorarioDeLas = new JLabel("Horario de las entrevistas :");
		lblHorarioDeLas.setBackground(new Color(255, 255, 255));
		lblHorarioDeLas.setForeground(new Color(204, 204, 255));
		lblHorarioDeLas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblHorarioDeLas.setBounds(10, 237, 237, 30);
		fondo.add(lblHorarioDeLas);

		btnPlanificar = new JButton("Planificar");
		btnPlanificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableEntrevistas.getSelectedRow() >= 0){
					agencia.almacenarEnRegistroMes(revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getNombreEmpresa(),
							revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getTelef(),
							revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getSector(),
							revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getInsPuesto().getIdentificadorPropio(),
							revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getInsPuesto().getIdentificadorRama(),
							revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getInsPuesto().getDiaEscogido(),
							revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getInsPuesto().getListadoEntrevistas().get(indiceEntrevista));
					defaultTableModelC.removeRow(indiceEntrevista);
					
					if(tableEntrevistas.getModel().getRowCount() == 0){
						for(int i = 0 ;i<revisionCandidatos.size();i++){
							int j = 0;boolean found = false;
							while(j< revisionCandidatos.get(i).getListadoEmpleos().size() && !found){
								if(revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).equals(revisionCandidatos.get(i).getListadoEmpleos().get(j))){
									revisionCandidatos.get(i).getListadoEmpleos().remove(revisionCandidatos.get(i).getListadoEmpleos().get(j));
								    found = true;
								}
								else
									j++;
							}
						}
					}
					for(int k = 0 ;k<revisionCandidatos.size();k++){
						int u = 0;boolean found2 = false;
						while(u< revisionCandidatos.get(k).getListadoEmpleos().size() && !found2){
							if(revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).equals(revisionCandidatos.get(k).getListadoEmpleos().get(u))){
								revisionCandidatos.get(k).getListadoEmpleos().get(u).getInsPuesto().getListadoEntrevistas().remove(revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getInsPuesto().getListadoEntrevistas().get(indiceEntrevista));
							    found2 = true;
							}
							else
								u++;
						}
					}
					revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getInsPuesto().getListadoEntrevistas().remove(revisionCandidatos.get(indiceCandidato).getListadoEmpleos().get(indiceEmpleo).getInsPuesto().getListadoEntrevistas().get(indiceEntrevista));
					scrollPane_2.repaint();
					tableEntrevistas.setEnabled(false);
					btnPlanificar.setEnabled(false);
					defaultTableModelE.removeRow(indiceEmpleo);
					scrollPane_2.repaint();
					scrollPane_1.repaint();
					if(tableEmpleos.getModel().getRowCount()== 0){
						defaultTableModel.removeRow(indiceCandidato);
						scrollPane.repaint();
						if(table.getModel().getRowCount()== 0){
							btnContinuar.setEnabled(true);
							JOptionPane.showMessageDialog(ListadoCoincidencias.this, "Se han analizado a todos los posibles futuros empleados. Presione el botón Continuar.");
						}
					}
				}
			}
		});
		btnPlanificar.setToolTipText("Almacena los datos escogidos en el registro mensual.");
		btnPlanificar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnPlanificar.setBackground(new Color(240, 240, 240));
		btnPlanificar.setForeground(new Color(0, 0, 0));
		btnPlanificar.setBounds(164, 271, 89, 23);
		fondo.add(btnPlanificar);

		btnDescartar = new JButton("Descartar");
		btnDescartar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDescartar.setToolTipText("Descarta un empleo seleccionado");
		btnDescartar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnDescartar.setBackground(new Color(240, 240, 240));
		btnDescartar.setBounds(864, 209, 113, 23);
		fondo.add(btnDescartar);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setEnabled(false);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); 
			}
		});
		btnContinuar.setToolTipText("Usted lo puede presionar cuando termine de analizar a todos los candidatos en cuesti\u00F3n.");
		btnContinuar.setBackground(new Color(240, 240, 240));
		btnContinuar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnContinuar.setBounds(388, 361, 179, 54);
		fondo.add(btnContinuar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setMnemonic('E');
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setToolTipText("Elimina a un candidato seleccionado del listado.");
		btnEliminar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnEliminar.setBounds(378, 209, 89, 23);
		fondo.add(btnEliminar);

		btnEditar = new JButton("Editar");
		btnEditar.setMnemonic('E');
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditar.setToolTipText("Modifica los datos de un candidato seleccionado.");
		btnEditar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnEditar.setBounds(279, 209, 89, 23);
		fondo.add(btnEditar);

		btnHabilitarPlanificar = new JButton("Habilitar Planificar");
		btnHabilitarPlanificar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnHabilitarPlanificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(indiceEmpleo >= 0 ){
					tableEntrevistas.setEnabled(true);
					btnPlanificar.setEnabled(true);
				}
				else
					JOptionPane.showMessageDialog(ListadoCoincidencias.this, "No se ha seleccionado ningún empleo disponible.");
			}
		});
		btnHabilitarPlanificar.setBounds(261, 271, 148, 23);
		fondo.add(btnHabilitarPlanificar);

		cargarTablaConCandidatos(revisionCandidatos);
	}

	protected void cargarTablaConEntrevistas(Auxiliar auxiliar) {
		ArrayList<Object> horaCita = new ArrayList<Object>();		

		Auxiliar empleo = auxiliar;
		for (int i = 0; i < empleo.getInsPuesto().getListadoEntrevistas().size(); i++) {
			Entrevista aux = empleo.getInsPuesto().getListadoEntrevistas().get(i);
			horaCita.add(aux.getHora());
		}

		defaultTableModelC = new DefaultTableModel();
		defaultTableModelC.addColumn("Hora", horaCita.toArray());
		tableEntrevistas.setModel(defaultTableModelC);
		scrollPane_2.repaint();

	}

	protected void cargarTablaConEmpleosCorrespondientes(Candidato candidato) {
		ArrayList<Object> nombreE = new ArrayList<Object>();		
		ArrayList<Object> telE = new ArrayList<Object>();	
		ArrayList<Object> dir = new ArrayList<Object>();	
		ArrayList<Object> sector = new ArrayList<Object>();		
		ArrayList<Object> puesto = new ArrayList<Object>();
		ArrayList<Object> rama = new ArrayList<Object>();		
		ArrayList<Object> cantPuestos = new ArrayList<Object>();
		ArrayList<Object> dia = new ArrayList<Object>();

		Candidato cand = candidato;
		for (int i = 0; i < cand.getListadoEmpleos().size(); i++) {
			Auxiliar aux = cand.getListadoEmpleos().get(i);
			nombreE.add(aux.getNombreEmpresa());

			if(empresaTelef)
				telE.add(aux.getTelef());
			if(empresaDir)
				dir.add(aux.getDireccion());
			if(empresaSec)
				sector.add(aux.getSector());
			if(empresaPuesto)
				puesto.add(aux.getInsPuesto().getIdentificadorPropio());
			if(empresaPuestoRama)
				rama.add(aux.getInsPuesto().getIdentificadorRama());
			if(empresaCantPuestos)
				cantPuestos.add(aux.getInsPuesto().getPlazasNecesarias());	
			if(empresaDiaEntrevista)
				dia.add(aux.getInsPuesto().getDiaEscogido());	
		}

		defaultTableModelE = new DefaultTableModel();
		defaultTableModelE.addColumn("Empresa ID", nombreE.toArray());
		if(empresaTelef)
			defaultTableModelE.addColumn("Tel\u00E9fono", telE.toArray());
		if(empresaDir)
			defaultTableModelE.addColumn("Dirección", dir.toArray());
		if(empresaSec)
			defaultTableModelE.addColumn("Sector", sector.toArray());
		if(empresaPuesto)
			defaultTableModelE.addColumn("Puesto", puesto.toArray());
		if(empresaPuestoRama)
			defaultTableModelE.addColumn("Rama", rama.toArray());
		if(empresaCantPuestos)
			defaultTableModelE.addColumn("Cantidad", cantPuestos.toArray());
		if(empresaDiaEntrevista )
			defaultTableModelE.addColumn("Dia de la entrevista", dia.toArray());	
		tableEmpleos.setModel(defaultTableModelE);
		scrollPane_1.repaint();
	}

	public void cargarTablaConCandidatos(ArrayList<Candidato> Lista) {

		ArrayList<Object> nombreCand = new ArrayList<Object>();		
		ArrayList<Object> numID = new ArrayList<Object>();	
		ArrayList<Object> rama = new ArrayList<Object>();		
		ArrayList<Object> telCand = new ArrayList<Object>();		
		ArrayList<Object> nivelEsc = new ArrayList<Object>();		
		ArrayList<Object> yearsEsp = new ArrayList<Object>();
		ArrayList<Object> especialidad = new ArrayList<Object>();

		ArrayList<Candidato> candidatos = Lista;
		for (int i = 0; i < candidatos.size(); i++) {
			Candidato aux = candidatos.get(i);
			numID.add(aux.getNumID());

			if(candidatoNombre)
				nombreCand.add(aux.getNombre());
			if(candidatoTelefono)
				telCand.add(aux.getTelefono());
			if(candidatoRama)
				rama.add(aux.getRama());
			if(candidatoEspecialidad)
				especialidad.add(aux.getEspecialidad());
			if(candidatoYearsEsp)
				yearsEsp.add(aux.getYearsEspecialidad());
			if(candidatoNivelescolar)
				nivelEsc.add(aux.getNivelEscolar());	
		}

		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("C.I", numID.toArray());
		if(candidatoNombre)
			defaultTableModel.addColumn("Nombre", nombreCand.toArray());
		if(candidatoTelefono)
			defaultTableModel.addColumn("Tel\u00E9fono", telCand.toArray());
		if(candidatoRama)
			defaultTableModel.addColumn("Rama a trabajar", rama.toArray());
		if(candidatoEspecialidad)
			defaultTableModel.addColumn("Especialidad", especialidad.toArray());
		if(candidatoYearsEsp)
			defaultTableModel.addColumn("Años en su especialidad", yearsEsp.toArray());
		if(candidatoNivelescolar)
			defaultTableModel.addColumn("Nivel escolar", nivelEsc.toArray());
		table.setModel(defaultTableModel);
	}




}
