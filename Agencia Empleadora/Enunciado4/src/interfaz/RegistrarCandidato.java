package interfaz;



import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.AgenciaEmpleadora;
import logica.Auxiliar;
import logica.Entrevista;
import logica.Puesto;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;
import java.awt.Font;

public class RegistrarCandidato extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AgenciaEmpleadora agencia;
	@SuppressWarnings("unused")
	private Principal pri;
	@SuppressWarnings("unused")
	private ListadoCandidatos Listado;
	private ArrayList<Auxiliar> arrayAux;
	private JLabel lblNombre;
	private JLabel lblDireccion;
	private JLabel lblRama;
	private JLabel lblTelefono;
	private JLabel lblNumID;
	private JLabel lblNivelEscolar;
	private JLabel lblEspecialidad;
	private JLabel lblYearsExp;
	private JLabel lblSector;
	private JTextField textFieldNumID;
	private JTextField textFieldEspecialidad;
	private JTextField textFieldNombre;
	private JTextField textFieldTelef;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JSpinner spinner;
	private JComboBox<String> comboBox;
	/**
	 * @wbp.nonvisual location=221,-21
	 */
	private int indiceEmpresa = 0;
	private int indiceEntrevista = 0;
	@SuppressWarnings("unused")
	private DefaultComboBoxModel<String> ComboBoxModel = new DefaultComboBoxModel<String>();
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textAreaDireccion;
	private JComboBox<String> comboBoxSector;
	private JComboBox<String> comboBoxRama;
	private JLabel lblTur;
	private JLabel lblCustodio;
	private JPanel panel;
	private JLabel lblCertificadoDeIdioma;
	private JRadioButton rdbtnSi;
	private JLabel lblNumeroDeHistoria;
	private JLabel lblCalificacionesEnPruebas;
	private JSpinner spinnerPromedio;
	private JSpinner spinnerNumHC;
	private JPanel panelListaEmpresas;
	private JTable table;
	private JScrollPane scrollPaneListaEmpresas;
	/**
	 * @wbp.nonvisual location=477,-11
	 */
	private DefaultTableModel TableModel = new DefaultTableModel();

	private boolean direccion = true;
	private boolean sector = true;
	private boolean idRama = true;
	private boolean puesto = true;
	private boolean cantidad = true;
	private JButton btnDescartar;
	private JTable tableCita;
	private JPanel panelEntrevistas;
	private JScrollPane scrollPane_1;
	/**
	 * @wbp.nonvisual location=737,-11
	 */
	private  DefaultTableModel TableModelC = new DefaultTableModel();
	private JButton btnPlanificar;
	private JPanel panel1;

	public RegistrarCandidato( Principal p, AgenciaEmpleadora a) {
		super(p,true);
		setFont(new Font("Dialog", Font.BOLD, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Elmer\\Documents\\Zapya\\Photo\\agencia_cv.jpg"));
		setForeground(Color.GRAY);
		this.agencia = a;
		this.pri=p;
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Registrar Candidato");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1013, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(70, 130, 180));
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Campos extra :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 335, 454, 105);
		contentPane.add(panel);
		panel.setVisible(false);

		lblCustodio = new JLabel("Por favor ingrese los siguientes datos ya que su especialidad es custodio :");
		lblCustodio.setHorizontalAlignment(SwingConstants.LEFT);

		lblNumeroDeHistoria = new JLabel("Numero de historia clinica :");

		lblCalificacionesEnPruebas = new JLabel("Promedio de calificaciones en pruebas de eficiencia fisica :");
		lblCalificacionesEnPruebas.setHorizontalAlignment(SwingConstants.LEFT);

		spinnerPromedio = new JSpinner();
		spinnerPromedio.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(2)));

		spinnerNumHC = new JSpinner();
		spinnerNumHC.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCustodio, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNumeroDeHistoria, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(spinnerNumHC, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblCalificacionesEnPruebas, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(spinnerPromedio, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(7)
						.addComponent(lblCustodio)
						.addGap(11)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(6)
										.addComponent(lblNumeroDeHistoria))
										.addComponent(spinnerNumHC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(5)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
														.addGap(6)
														.addComponent(lblCalificacionesEnPruebas))
														.addComponent(spinnerPromedio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				);
		panel.setLayout(gl_panel);

		lblNombre = new JLabel("Nombre y Apellidos :");
		lblNombre.setBounds(10, 18, 119, 14);
		contentPane.add(lblNombre);

		lblNumID = new JLabel("N\u00FAmero de Identidad :");
		lblNumID.setBounds(10, 48, 127, 14);
		contentPane.add(lblNumID);

		lblNivelEscolar = new JLabel("Nivel de Escolaridad :");
		lblNivelEscolar.setBounds(10, 79, 127, 14);
		contentPane.add(lblNivelEscolar);

		lblEspecialidad = new JLabel("Especialidad :");
		lblEspecialidad.setBounds(10, 110, 83, 14);
		contentPane.add(lblEspecialidad);

		lblYearsExp = new JLabel("A\u00F1os de Experiencia en su Especialidad :");
		lblYearsExp.setBounds(10, 311, 248, 14);
		contentPane.add(lblYearsExp);

		lblRama = new JLabel("Rama a Trabajar :");
		lblRama.setBounds(10, 175, 108, 14);
		contentPane.add(lblRama);

		lblTelefono = new JLabel("Tel\u00E9fono :");
		lblTelefono.setBounds(10, 206, 65, 14);
		contentPane.add(lblTelefono);

		lblDireccion = new JLabel("Direcci\u00F3n :");
		lblDireccion.setBounds(10, 231, 65, 14);
		contentPane.add(lblDireccion);

		lblSector = new JLabel("Sector a Trabajar :");
		lblSector.setBounds(10, 144, 108, 14);
		contentPane.add(lblSector);

		textFieldNombre = new JTextField();
		textFieldNombre.setBackground(Color.WHITE);
		textFieldNombre.setToolTipText("");
		textFieldNombre.setBounds(139, 12, 234, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldNumID = new JTextField();
		textFieldNumID.setBounds(139, 42, 234, 20);
		contentPane.add(textFieldNumID);
		textFieldNumID.setColumns(10);

		textFieldEspecialidad = new JTextField();
		textFieldEspecialidad.setToolTipText("Aviso: Si la especialidad del candidato es custodio, al finalizar de teclearla se har\u00E1n visible los campos extras a llenar en la esquina inferior izquierda.");
		textFieldEspecialidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			   comprobarPreferencia(textFieldEspecialidad.getText());
			}
		});
		textFieldEspecialidad.setBounds(139, 107, 234, 20);
		contentPane.add(textFieldEspecialidad);
		textFieldEspecialidad.setColumns(10);

		textFieldTelef = new JTextField();
		textFieldTelef.setBounds(139, 200, 234, 20);
		contentPane.add(textFieldTelef);
		textFieldTelef.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "6to grado", "9no grado", "12mo grado", "Universitario"}));
		comboBox.setBounds(139, 73, 234, 20);
		contentPane.add(comboBox);

		comboBoxSector = new JComboBox<String>();
		comboBoxSector.setEditable(true);
		comboBoxSector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comprobarPreferencia(comboBoxSector.getSelectedItem().toString());
			}
		});
		comboBoxSector.setToolTipText("Aviso: En el caso de elegir turismo se har\u00E1 visible un campo extra en la esquina inferior izquierda.");
		comboBoxSector.setModel(new DefaultComboBoxModel<String>(new String[] {"", "turismo", "salud", "educaci\u00F3n", "cualesquiera"}));
		comboBoxSector.setBounds(139, 138, 234, 20);
		contentPane.add(comboBoxSector);

		comboBoxRama = new JComboBox<String>();
		comboBoxRama.setEditable(true);
		comboBoxRama.setModel(new DefaultComboBoxModel<String>(new String[] {"", "directivo", "ingeniero", "recursos humanos "}));
		comboBoxRama.setBounds(139, 169, 234, 20);
		contentPane.add(comboBoxRama);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 234, 234, 60);
		contentPane.add(scrollPane);

		textAreaDireccion = new JTextArea();
		scrollPane.setViewportView(textAreaDireccion);



		btnRegistrar = new JButton("Aceptar");
		btnRegistrar.addActionListener(new ActionListener() {
			private float promedioEF;
			private int numHC;
			private boolean var;

			public void actionPerformed(ActionEvent arg0) {
				String nombre = textFieldNombre.getText();
				String numID = textFieldNumID.getText();
				String telef = textFieldTelef.getText();
				String especialidad = textFieldEspecialidad.getText();
				String nivelEscolar = comboBox.getSelectedItem().toString();
				String sector = comboBoxSector.getSelectedItem().toString();
				String rama = comboBoxRama.getSelectedItem().toString();
				String direccion = textAreaDireccion.getText();
				SpinnerNumberModel yearsEx = (SpinnerNumberModel)spinner.getModel();
				int yearsExp = ((Integer)yearsEx.getNumber());
				boolean datoIncorrecto = false;
				boolean continuar = true;
				boolean mostrarMensaje = false;
				boolean mostrarMensaje2 = false;

				if(panel.isVisible()){
					SpinnerNumberModel numeroH = (SpinnerNumberModel)spinnerNumHC.getModel();
					this. numHC = ((Integer)numeroH.getNumber());
					SpinnerNumberModel promedio = (SpinnerNumberModel)spinnerPromedio.getModel();
					this.promedioEF = ((Float)promedio.getNumber());
					if(promedioEF < 50){
						agencia.registrarCandidatoCustodio(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp,promedioEF,numHC);
						mostrarMensaje = true;
						continuar=false;
					}
				}

				if(panel1.isVisible()){
					this. var = rdbtnSi.getModel().isSelected();
					if(var==false){
						agencia.registrarCandidatoTurismo(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp,var);
						mostrarMensaje2 = true;
						continuar=false;
					}
				}

				if(nombre.replaceAll(" ", "").equalsIgnoreCase("")){
					lblNombre.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(numID.replaceAll(" ", "").equalsIgnoreCase("")){
					lblNumID.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(especialidad.replaceAll(" ", "").equalsIgnoreCase("")){
					lblEspecialidad.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(nivelEscolar.replaceAll(" ", "").equalsIgnoreCase("")){
					lblNivelEscolar.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(sector.replaceAll(" ", "").equalsIgnoreCase("")){
					lblSector.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(rama.replaceAll(" ", "").equalsIgnoreCase("")){
					lblRama.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(direccion.replaceAll(" ", "").equalsIgnoreCase("")){
					lblDireccion.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(telef.replaceAll(" ", "").equalsIgnoreCase("")){
					lblTelefono.setForeground(Color.RED);
					datoIncorrecto = true;
				}			


				if(datoIncorrecto)
					JOptionPane.showMessageDialog(RegistrarCandidato.this, "No pueden estar vacios los campos marcados en rojo.Por favor rellenelos.");
				if(mostrarMensaje && datoIncorrecto==false){
					JOptionPane.showMessageDialog(RegistrarCandidato.this, "El promedio de calificaciones de eficiencia fisica no cumple con el estandar nesecario para este tipo de empleo (mayor o igual a 50)."
							+ "El candidato debe volver cuando mejore su rendimiento. El candidato se ha almacenado en el registro interno");
					dispose();
				}
				if(mostrarMensaje2 && datoIncorrecto==false){
					JOptionPane.showMessageDialog(RegistrarCandidato.this, "El certificado de idiomas es vital para cualquier empleo relacionado con el turismo. El candidato queda almacenado temporalmente en el sistema hasta la entrega de dicho documento.");
					dispose();
				}

				if(continuar && datoIncorrecto==false){
					if(agencia.comprobarExistenciaEmpleo(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp)== false){
						if(panel.isVisible()){
							agencia.registrarCandidatoCustodio(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp,promedioEF,numHC);				
							JOptionPane.showMessageDialog(RegistrarCandidato.this, "No existen empresas interesadas.El candidato se ha agregado al registro de candidatos inscritos en el sistema.");						
							dispose();
							textFieldTelef.setText("");
							textFieldNombre.setText("");

						}
						else if(panel1.isVisible()){
							agencia.registrarCandidatoTurismo(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp, var);
							JOptionPane.showMessageDialog(RegistrarCandidato.this, "No existen empresas interesadas.El candidato se ha agregado al registro de candidatos inscritos en el sistema.");						
							dispose();
							textFieldTelef.setText("");
							textFieldNombre.setText("");

						}
						else{
							agencia.registrarCandidato(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp);
							JOptionPane.showMessageDialog(RegistrarCandidato.this, "No existen empresas interesadas.El candidato se ha agregado al registro de candidatos inscritos en el sistema.");						
							dispose();
							textFieldTelef.setText("");
							textFieldNombre.setText("");

						}
					}
					else {
						if(panel.isVisible()){
							agencia.registrarCandidatoEmpleadoCustodio(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp, promedioEF, numHC);
							agencia.getListadoCandidatosEmpleados().get(agencia.buscarCandidatoEmpleado(numID)).setListadoEmpleos(agencia.getListaAux());
							cargarTablaConEmpleos(agencia.getListadoCandidatosEmpleados().get(agencia.buscarCandidatoEmpleado(numID)).getListadoEmpleos());
							JOptionPane.showMessageDialog(RegistrarCandidato.this, "Existen empresas interesadas.");	
						}
						else if(panel1.isVisible()){
							agencia.registrarCandidatoEmpleadoTurismo(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp,var);
							agencia.getListadoCandidatosEmpleados().get(agencia.buscarCandidatoEmpleado(numID)).setListadoEmpleos(agencia.getListaAux());
							cargarTablaConEmpleos(agencia.getListadoCandidatosEmpleados().get(agencia.buscarCandidatoEmpleado(numID)).getListadoEmpleos());
							JOptionPane.showMessageDialog(RegistrarCandidato.this, "Existen empresas interesadas.");	
						}
						else {
							agencia.registrarCandidatoEmpleado(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp);
							agencia.getListadoCandidatosEmpleados().get(agencia.buscarCandidatoEmpleado(numID)).setListadoEmpleos(agencia.getListaAux());
							arrayAux = agencia.getListadoCandidatosEmpleados().get(agencia.buscarCandidatoEmpleado(numID)).getListadoEmpleos();
							cargarTablaConEmpleos(agencia.getListadoCandidatosEmpleados().get(agencia.buscarCandidatoEmpleado(numID)).getListadoEmpleos());
							JOptionPane.showMessageDialog(RegistrarCandidato.this, "Existen empresas interesadas.");	
						}


					}

				}




			}
		});
		btnRegistrar.setBounds(278, 451, 89, 23);
		contentPane.add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(375, 451, 89, 23);
		contentPane.add(btnCancelar);

		panelListaEmpresas = new JPanel();
		panelListaEmpresas.setBackground(new Color(70, 130, 180));
		panelListaEmpresas.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Lista de Empleos Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListaEmpresas.setBounds(474, 11, 527, 379);
		contentPane.add(panelListaEmpresas);

		scrollPaneListaEmpresas = new JScrollPane();

		btnDescartar = new JButton("Descartar");
		btnDescartar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textFieldNombre.getText();
				String numID = textFieldNumID.getText();
				String telef = textFieldTelef.getText();
				String especialidad = textFieldEspecialidad.getText();
				String nivelEscolar = comboBox.getSelectedItem().toString();
				String sector = comboBoxSector.getSelectedItem().toString();
				String rama = comboBoxRama.getSelectedItem().toString();
				String direccion = textAreaDireccion.getText();
				SpinnerNumberModel yearsEx = (SpinnerNumberModel)spinner.getModel();
				int yearsExp = ((Integer)yearsEx.getNumber());
				/*ArrayList<Auxiliar>ListaAuxy = agencia.comprobarExistenciaEmpleo(numID, nombre, direccion, telef, nivelEscolar, especialidad, rama, sector, yearsExp);
				ListaAuxy.remove(ListaAuxy.get(indiceEmpresa));
				if(ListaAuxy.isEmpty()){
					int pos = agencia.buscarCandidatoEmpleado(numID);
					agencia.getListadoCandidatosInscritos().add(agencia.getListadoCandidatosEmpleados().get(pos));
					agencia.getListadoCandidatosEmpleados().remove(agencia.getListadoCandidatosEmpleados().get(pos));
					JOptionPane.showMessageDialog(RegistrarCandidato.this, "El candidato se ha almacenado en el sistema esperando una nueva solicitud de empresa.");	
				}
				cargarTablaConEmpleos(ListaAuxy);
				cargarTablaConEntrevistas(ListaAuxy.get(indiceEmpresa));*/
			}
		});

		panelEntrevistas = new JPanel();
		panelEntrevistas.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Horario de Entrevistas :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panelListaEmpresas = new GroupLayout(panelListaEmpresas);
		gl_panelListaEmpresas.setHorizontalGroup(
				gl_panelListaEmpresas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListaEmpresas.createSequentialGroup()
						.addGroup(gl_panelListaEmpresas.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelListaEmpresas.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnDescartar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, gl_panelListaEmpresas.createSequentialGroup()
												.addContainerGap()
												.addComponent(scrollPaneListaEmpresas, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(panelEntrevistas, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
												.addContainerGap(36, Short.MAX_VALUE))
				);
		gl_panelListaEmpresas.setVerticalGroup(
				gl_panelListaEmpresas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListaEmpresas.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelListaEmpresas.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panelEntrevistas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
								.addComponent(scrollPaneListaEmpresas, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDescartar)
								.addContainerGap())
				);

		scrollPane_1 = new JScrollPane();

		btnPlanificar = new JButton("Planificar");
		btnPlanificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agencia.almacenarEnRegistroMes(arrayAux.get(indiceEmpresa).getNombreEmpresa(),arrayAux.get(indiceEmpresa).getTelef(),
						arrayAux.get(indiceEmpresa).getSector(),arrayAux.get(indiceEmpresa).getInsPuesto().getIdentificadorPropio(),
						arrayAux.get(indiceEmpresa).getInsPuesto().getIdentificadorRama(),arrayAux.get(indiceEmpresa).getInsPuesto().getDiaEscogido(),
						arrayAux.get(indiceEmpresa).getInsPuesto().getListadoEntrevistas().get(indiceEntrevista));
				TableModelC.removeRow(tableCita.getSelectedRow());
				tableCita.repaint();
			}
		});
		GroupLayout gl_panelEntrevistas = new GroupLayout(panelEntrevistas);
		gl_panelEntrevistas.setHorizontalGroup(
				gl_panelEntrevistas.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelEntrevistas.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelEntrevistas.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
								.addComponent(btnPlanificar, Alignment.TRAILING))
								.addContainerGap())
				);
		gl_panelEntrevistas.setVerticalGroup(
				gl_panelEntrevistas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEntrevistas.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
						.addComponent(btnPlanificar))
				);

		tableCita = new JTable();
		tableCita.setCellSelectionEnabled(true);
		tableCita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegistrarCandidato.this.indiceEntrevista = RegistrarCandidato.this.tableCita.getSelectedRow();
			}
		});
		tableCita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCita.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		scrollPane_1.setViewportView(tableCita);
		panelEntrevistas.setLayout(gl_panelEntrevistas);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegistrarCandidato.this.indiceEmpresa = RegistrarCandidato.this.table.getSelectedRow();
				RegistrarCandidato.this. cargarTablaConEntrevistas(arrayAux.get(indiceEmpresa));
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		scrollPaneListaEmpresas.setViewportView(table);
		panelListaEmpresas.setLayout(gl_panelListaEmpresas);

		spinner = new JSpinner();
		spinner.setBounds(253, 305, 69, 20);
		contentPane.add(spinner);
		spinner.setModel(new SpinnerNumberModel(0, 0, 70, 1));

		panel1 = new JPanel();
		panel1.setBounds(10, 335, 422, 66);
		contentPane.add(panel1);
		panel1.setVisible(false);
		panel1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Campo Extra :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBackground(Color.GRAY);
		panel1.setLayout(null);

		lblTur = new JLabel("Por favor ingrese los siguientes datos ya que su sector es el turismo :");
		lblTur.setBounds(10, 21, 401, 14);
		panel1.add(lblTur);

		lblCertificadoDeIdioma = new JLabel("Certificado de idioma :");
		lblCertificadoDeIdioma.setBounds(10, 41, 135, 14);
		panel1.add(lblCertificadoDeIdioma);

		rdbtnSi = new JRadioButton("Entregado");
		rdbtnSi.setBounds(151, 37, 98, 23);
		panel1.add(rdbtnSi);
		rdbtnSi.setBackground(Color.GRAY);

	}

	public void cargarTablaConEmpleos(ArrayList<Auxiliar> ListaAux) {

		ArrayList<Object> telefEmpresa = new ArrayList<Object>();		
		ArrayList<Object> dirEmpresa = new ArrayList<Object>();		
		ArrayList<Object> sectorEmpresa = new ArrayList<Object>();		
		ArrayList<Object> ramaEmpresa = new ArrayList<Object>();	
		ArrayList<Object> puestoEmpresa = new ArrayList<Object>();
		ArrayList<Object> puestoCant = new ArrayList<Object>();

		for (int i = 0; i < ListaAux.size(); i++) {
			Auxiliar aux = ListaAux.get(i);
			telefEmpresa.add(aux.getTelef());

			if(direccion)
				dirEmpresa.add(aux.getDireccion());
			if(sector)
				sectorEmpresa.add(aux.getSector());
			if(idRama)
				ramaEmpresa.add(aux.getInsPuesto().getIdentificadorRama());
			if(puesto)
				puestoEmpresa.add(aux.getInsPuesto().getIdentificadorPropio());
			if(cantidad)
				puestoCant.add(aux.getInsPuesto().getPlazasNecesarias());
		}	   


		TableModel = new DefaultTableModel();
		TableModel.addColumn("Telefono Empresa", telefEmpresa.toArray());
		if(direccion)
			TableModel.addColumn("Direcci\u00F3n", dirEmpresa.toArray());
		if(sector)
			TableModel.addColumn("Sector", sectorEmpresa.toArray());
		if(idRama)
			TableModel.addColumn("Rama", ramaEmpresa.toArray());
		if(puesto)
			TableModel.addColumn("Empleo", puestoEmpresa.toArray());
		if(cantidad)
			TableModel.addColumn("Cantidad", puestoCant.toArray());	
		table.setModel(TableModel);
	} 

	public void cargarTablaConEntrevistas(Auxiliar aux) {

		ArrayList<Object> horaCita = new ArrayList<Object>();
		Puesto p = aux.getInsPuesto();

		for (int i = 0; i < p.getListadoEntrevistas().size(); i++) {
			Entrevista cit = p.getListadoEntrevistas().get(i);
			horaCita.add(cit.getHora());

		}	   


		TableModelC = new DefaultTableModel();
		TableModelC.addColumn("Hora de la Entrevista", horaCita.toArray());	
		tableCita.setModel(TableModelC);
		panelEntrevistas.repaint();
	} 

	public void comprobarPreferencia(String identificador){
		String cadena = "Turismo";
		String cadena1 = "Custodio";

		if(identificador.equalsIgnoreCase(cadena1)){
			panel.setVisible(true);
		}
		else if(identificador.equalsIgnoreCase(cadena)){
			panel1.setVisible(true);
		}
	}
}