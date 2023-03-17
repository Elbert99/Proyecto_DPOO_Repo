package interfaz;


import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.swing.JLabel;

import logica.AgenciaEmpleadora;
import logica.Empresa;
import logica.Entrevista;
import logica.Puesto;

import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;

import java.util.Date;

import javax.swing.SpinnerListModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;


public class RegistrarEmpresa extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal pri;
	private AgenciaEmpleadora agencia;
	@SuppressWarnings("unused")
	private boolean empresaIdentificador=true;
	private boolean puestoRama= true;
	private int indiceEmpresa = 0;
	private int indicePuesto = 0;

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textFieldNombre;
	private JTextField textFieldTelef;
	private JTextField textFieldSector;
	private JScrollPane scrollPane;
	private JTextArea textAreaDireccion;
	private JLabel lblNombre;
	private JLabel lblTelef;
	private JLabel lblSector;
	private JLabel lblDireccion;
	/**
	 * @wbp.nonvisual location=387,-11
	 */
	@SuppressWarnings("unused")
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnRegistrar;
	private JTable table1;
	private JScrollPane scrollPane_2;
	/**
	 * @wbp.nonvisual location=187,-11
	 */
	private DefaultTableModel tableModel1 = new DefaultTableModel();
	private JPanel panel_2;
	private JLabel lblIdentificadorDelPuesto;
	private JTextField textFieldPuesto;
	private JLabel lblAosDeExperiencia;
	private JSpinner spinnerYearsExpN;
	private JLabel lblCantidadDePuestos;
	private JSpinner spinnerCantPuestos;
	private JLabel lblNivelEscolarNecesario;
	private JComboBox<String> comboBoxNivel;
	private JScrollPane scrollPane_3;
	private JTable table_1;
	private JPanel panel_3;
	private JButton btnAlmacenar;
	private JButton btnPlanificar;
	/**
	 * @wbp.nonvisual location=767,-11
	 */
	private  DefaultTableModel TableModel = new DefaultTableModel();
	private JTextField textFieldRama;
	private JLabel lblRamaPerteneciente;
	private JButton btnAceptar_1;
	private JLabel lblHora;
	private JSpinner spinnerHora;
	private JScrollPane scrollPaneHorasdeunEmpleo;
	private JTable tableHora;
	private JLabel lblDiaEntrevista;
	/**
	 * @wbp.nonvisual location=617,-21
	 */
	private DefaultTableModel TableModelHoras = new DefaultTableModel();
	private JDateChooser dateChooser ;

	/**
	 * @wbp.nonvisual location=737,209
	 */

	/**
	 * Create the frame.
	 */
	public RegistrarEmpresa(Principal p,AgenciaEmpleadora a) {
		this.pri=p;
		this.agencia = a;
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Registrar Empresa");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 827, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Datos principales de la empresa :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 393, 329);
		contentPane.add(panel);

		lblNombre = new JLabel("Nombre : ");

		lblSector = new JLabel("Sector :");

		lblTelef = new JLabel("Tel\u00E9fono :");

		lblDireccion = new JLabel("Direcci\u00F3n :");

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);

		textFieldTelef = new JTextField();
		textFieldTelef.setColumns(10);

		textFieldSector = new JTextField();
		textFieldSector.setColumns(10);

		scrollPane = new JScrollPane();

		btnRegistrar = new JButton("Insertar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreEmpresa = textFieldNombre.getText();
				String direccionE = textAreaDireccion.getText();
				String telefEmpresa = textFieldTelef.getText();
				String sectorEmpresa = textFieldSector.getText();
				boolean datoIncorrecto = false;

				if(nombreEmpresa.replaceAll(" ", "").equalsIgnoreCase("")){
					lblNombre.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(telefEmpresa.replaceAll(" ", "").equalsIgnoreCase("")){
					lblTelef.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(sectorEmpresa.replaceAll(" ", "").equalsIgnoreCase("")){
					lblSector.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(direccionE.replaceAll(" ", "").equalsIgnoreCase("")){
					lblDireccion.setForeground(Color.RED);
					datoIncorrecto = true;
				}			

				if(datoIncorrecto)
					JOptionPane.showMessageDialog(RegistrarEmpresa.this, "No pueden estar vacios los campos marcados en rojo.Por favor rellenelos.");
				else{
					if( agencia.registrarEmpresa(nombreEmpresa, direccionE, telefEmpresa, sectorEmpresa)==true){
						JOptionPane.showMessageDialog(RegistrarEmpresa.this, "Empresa agregada de manera satisfactoria.");						
						cargarTablaConEmpresasID();
					}
					else 
						JOptionPane.showMessageDialog(RegistrarEmpresa.this, "Esta empresa ya existe.");										

				}
			}
		});

		scrollPane_2 = new JScrollPane();

		textAreaDireccion = new JTextArea();
		scrollPane.setViewportView(textAreaDireccion);

		table1 = new JTable();
		scrollPane_2.setViewportView(table1);
		table1.setFillsViewportHeight(true);
		table1.setCellSelectionEnabled(true);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegistrarEmpresa.this.indiceEmpresa = RegistrarEmpresa.this.table1.getSelectedRow();	
				if( indiceEmpresa != -1){
					textFieldPuesto.setEnabled(true);
					textFieldRama.setEnabled(true);
					lblRamaPerteneciente.setEnabled(true);
					lblAosDeExperiencia.setEnabled(true);
					lblCantidadDePuestos.setEnabled(true);
					lblIdentificadorDelPuesto.setEnabled(true);
					lblNivelEscolarNecesario.setEnabled(true);
					lblDiaEntrevista.setEnabled(true);
					dateChooser.setEnabled(true);
					comboBoxNivel.setEnabled(true);
					spinnerCantPuestos.setEnabled(true);
					spinnerYearsExpN.setEnabled(true);

					scrollPane_3.setEnabled(true);
					btnAlmacenar.setEnabled(true);
				}
			}
		});
		table1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		
		JButton btnEliminar = new JButton("Eliminar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblTelef, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(textFieldTelef, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblSector, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(textFieldSector, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(91)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(167)
					.addComponent(btnEliminar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNombre))
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblTelef))
						.addComponent(textFieldTelef, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblSector))
						.addComponent(textFieldSector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDireccion)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegistrar)
						.addComponent(btnEliminar)))
		);
		panel.setLayout(gl_panel);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(70, 130, 180));
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Solicitudes en cuanto a puesto laboral  :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(413, 11, 393, 329);
		contentPane.add(panel_2);

		lblIdentificadorDelPuesto = new JLabel("Identificador del Puesto :");
		lblIdentificadorDelPuesto.setEnabled(false);
		lblIdentificadorDelPuesto.setBounds(16, 33, 160, 14);

		textFieldPuesto = new JTextField();
		textFieldPuesto.setEnabled(false);
		textFieldPuesto.setBounds(186, 27, 191, 20);
		textFieldPuesto.setColumns(10);

		lblAosDeExperiencia = new JLabel("A\u00F1os de Experiencia Necesarios :");
		lblAosDeExperiencia.setEnabled(false);
		lblAosDeExperiencia.setBounds(16, 122, 202, 14);

		spinnerYearsExpN = new JSpinner();
		spinnerYearsExpN.setEnabled(false);
		spinnerYearsExpN.setBounds(228, 119, 59, 20);
		spinnerYearsExpN.setModel(new SpinnerNumberModel(0, 0, 70, 1));

		lblCantidadDePuestos = new JLabel("Cantidad de puestos necesarios :");
		lblCantidadDePuestos.setEnabled(false);
		lblCantidadDePuestos.setBounds(16, 150, 202, 14);

		spinnerCantPuestos = new JSpinner();
		spinnerCantPuestos.setEnabled(false);
		spinnerCantPuestos.setBounds(228, 147, 59, 20);
		spinnerCantPuestos.setModel(new SpinnerNumberModel(1, 1, 100, 1));

		lblNivelEscolarNecesario = new JLabel("Nivel escolar necesario :");
		lblNivelEscolarNecesario.setEnabled(false);
		lblNivelEscolarNecesario.setBounds(16, 96, 160, 12);

		comboBoxNivel = new JComboBox<String>();
		comboBoxNivel.setEnabled(false);
		comboBoxNivel.setBounds(186, 88, 191, 20);
		comboBoxNivel.setModel(new DefaultComboBoxModel<String>(new String[] {"6to grado", "9no grado", "12mo grado", "Universitario"}));

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setEnabled(false);
		scrollPane_3.setBounds(16, 206, 285, 75);

		btnAlmacenar = new JButton("Registrar");
		btnAlmacenar.setEnabled(false);
		btnAlmacenar.setBounds(203, 292, 98, 23);
		btnAlmacenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idPuesto = textFieldPuesto.getText();						
				String idRama = textFieldRama.getText();
				String nivel = comboBoxNivel.getSelectedItem().toString();
				SpinnerNumberModel yearsEx = (SpinnerNumberModel)spinnerYearsExpN.getModel();
				int yearsExp = ((Integer)yearsEx.getNumber());
				SpinnerNumberModel cantNes = (SpinnerNumberModel)spinnerCantPuestos.getModel();
				int cantNesecaria = ((Integer)cantNes.getNumber());
				Date diaElegido = dateChooser.getDate();

				boolean datoIncorrecto = false;

				if(idPuesto.replaceAll(" ", "").equalsIgnoreCase("")){
					lblIdentificadorDelPuesto.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(idRama.replaceAll(" ", "").equalsIgnoreCase("")){
					lblRamaPerteneciente.setForeground(Color.RED);
					datoIncorrecto = true;
				}
				if(nivel.replaceAll(" ", "").equalsIgnoreCase("")){
					lblNivelEscolarNecesario.setForeground(Color.RED);
					datoIncorrecto = true;
				}

				if(datoIncorrecto)
					JOptionPane.showMessageDialog(RegistrarEmpresa.this, "No pueden estar vacios los campos marcados en rojo.Por favor rellenelos.");
				else{
					Puesto puesto = new Puesto(idPuesto,idRama,nivel,cantNesecaria,yearsExp, diaElegido);
					agencia.insertarPuesto(agencia.getListadoEmpresas().get(indiceEmpresa).getNombre(), puesto);		
					JOptionPane.showMessageDialog(RegistrarEmpresa.this, "Solicitud realizada exitosamente.");						
					cargarTablaConPuestos(agencia.getListadoEmpresas().get(indiceEmpresa));

				}
			}
		});

		lblRamaPerteneciente = new JLabel("Rama  perteneciente :");
		lblRamaPerteneciente.setEnabled(false);
		lblRamaPerteneciente.setBounds(16, 65, 160, 14);

		textFieldRama = new JTextField();
		textFieldRama.setEnabled(false);
		textFieldRama.setBounds(186, 59, 191, 20);
		textFieldRama.setColumns(10);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegistrarEmpresa.this.indicePuesto = RegistrarEmpresa.this.table_1.getSelectedRow();	
				if( indicePuesto != -1){
					lblHora.setEnabled(true);
					spinnerHora.setEnabled(true);
					scrollPaneHorasdeunEmpleo.setEnabled(true);
					btnPlanificar.setEnabled(true);
				}
			}
		});
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		scrollPane_3.setViewportView(table_1);
		panel_2.setLayout(null);
		panel_2.add(lblRamaPerteneciente);
		panel_2.add(textFieldRama);
		panel_2.add(scrollPane_3);
		panel_2.add(lblIdentificadorDelPuesto);
		panel_2.add(lblNivelEscolarNecesario);
		panel_2.add(comboBoxNivel);
		panel_2.add(textFieldPuesto);
		panel_2.add(lblAosDeExperiencia);
		panel_2.add(lblCantidadDePuestos);
		panel_2.add(spinnerCantPuestos);
		panel_2.add(spinnerYearsExpN);
		panel_2.add(btnAlmacenar);

		lblDiaEntrevista = new JLabel("Dia de la entrevista :");
		lblDiaEntrevista.setEnabled(false);
		lblDiaEntrevista.setBounds(16, 181, 130, 14);
		panel_2.add(lblDiaEntrevista);

		dateChooser = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		dateChooser.setEnabled(false);
		dateChooser.setBounds(156, 175, 145, 20);

		panel_2.add(dateChooser);
		
		JButton btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setEnabled(false);
		btnEliminar_1.setBounds(102, 292, 89, 23);
		panel_2.add(btnEliminar_1);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(70, 130, 180));
		panel_3.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Definicion de sus entrevistas :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(413, 351, 303, 157);
		contentPane.add(panel_3);

		lblHora = new JLabel("Hora de inicio:");
		lblHora.setEnabled(false);

		spinnerHora = new JSpinner();
		spinnerHora.setEnabled(false);
		spinnerHora.setModel(new SpinnerListModel(new String[] {"7 : 00 AM", "8 : 00 AM", "9 : 00 AM", "10 : 00 AM", "11 : 00 AM", "12 : 00 PM", "1 : 00 PM", "2 : 00 PM", "3 : 00 PM", "4 : 00 PM", "5 : 00 PM", "6 : 00 PM", "7 : 00 PM"}));

		scrollPaneHorasdeunEmpleo = new JScrollPane();
		scrollPaneHorasdeunEmpleo.setEnabled(false);

		btnPlanificar = new JButton("Aceptar");
		btnPlanificar.setEnabled(false);
		btnPlanificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SpinnerListModel hora = (SpinnerListModel)spinnerHora.getModel();
				String horaCita = hora.getValue().toString();
				Entrevista cita = new Entrevista(horaCita,false);
				agencia.getListadoEmpresas().get(indiceEmpresa).insertarEntrevista( agencia.getListadoEmpresas().get(indiceEmpresa).getListadoPuestos().get(indicePuesto).getIdentificadorPropio(),
						agencia.getListadoEmpresas().get(indiceEmpresa).getListadoPuestos().get(indicePuesto).getIdentificadorRama(), cita);
				if(agencia.getListadoEmpresas().get(indiceEmpresa).getListadoPuestos().get(indicePuesto).getListadoEntrevistas().size() == agencia.getListadoEmpresas().get(indiceEmpresa).getListadoPuestos().get(indicePuesto).getPlazasNecesarias()){
					JOptionPane.showMessageDialog(RegistrarEmpresa.this, "Ha alcanzado el numero maximo de entrevista para cada una de las plazas del empleo solicitado.");		
					lblHora.setEnabled(false);
					spinnerHora.setEnabled(false);
					btnPlanificar.setEnabled(false);
				}
				cargarTablaConHorarios(agencia.getListadoEmpresas().get(indiceEmpresa).getListadoPuestos().get(indicePuesto));
			}
		});
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setEnabled(false);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblHora, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinnerHora, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneHorasdeunEmpleo, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPlanificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(6)
							.addComponent(lblHora))
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPlanificar)
							.addComponent(spinnerHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPaneHorasdeunEmpleo, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)))
					.addGap(10))
		);

		tableHora = new JTable();
		tableHora.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableHora.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		scrollPaneHorasdeunEmpleo.setViewportView(tableHora);
		panel_3.setLayout(gl_panel_3);

		btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarEmpresa.this.dispose();
				pri.mostrarNotificacion();

			}
		});
		btnAceptar_1.setBounds(627, 515, 89, 23);
		contentPane.add(btnAceptar_1);

	}

	public void cargarTablaConEmpresasID() {

		ArrayList<Object> nomEmpresa = new ArrayList<Object>();				


		ArrayList<Empresa> empresas = agencia.getListadoEmpresas();
		for (int i = 0; i < empresas.size(); i++) {
			Empresa aux = agencia.getListadoEmpresas().get(i);
			nomEmpresa.add(aux.getNombre());
		}
		tableModel1 = new DefaultTableModel();
		tableModel1.addColumn("Nombre Empresa", nomEmpresa.toArray());
		table1.setModel(tableModel1);
	}

	public void cargarTablaConPuestos(Empresa e1) {

		ArrayList<Object> nomPuesto = new ArrayList<Object>();				
		ArrayList<Object> nomRama = new ArrayList<Object>();
		ArrayList<Puesto> ListaPuestos = e1.getListadoPuestos();

		for (int i = 0; i < ListaPuestos.size(); i++) {
			Puesto aux =ListaPuestos.get(i);
			nomPuesto.add(aux.getIdentificadorPropio());

			if(puestoRama)
				nomRama.add(aux.getIdentificadorRama());	
		}
		TableModel = new DefaultTableModel();
		TableModel.addColumn("Nombre Puesto", nomPuesto.toArray());
		if(puestoRama)
			TableModel.addColumn("Rama", nomRama.toArray());			

		table_1.setModel(TableModel);
	}

	public void cargarTablaConHorarios(Puesto p1) {

		ArrayList<Object> horaEntrevista = new ArrayList<Object>();				
		ArrayList<Entrevista> ListaCitas = p1.getListadoEntrevistas();

		for (int i = 0; i < ListaCitas.size(); i++) {
			Entrevista aux =ListaCitas.get(i);
			horaEntrevista.add(aux.getHora());	
		}
		TableModelHoras = new DefaultTableModel();
		TableModelHoras.addColumn("Hora Entrevista", horaEntrevista.toArray());			
		tableHora.setModel(TableModelHoras);
	}
}
