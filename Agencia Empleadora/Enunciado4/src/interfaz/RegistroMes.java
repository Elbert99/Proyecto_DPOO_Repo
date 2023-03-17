package interfaz;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import logica.AgenciaEmpleadora;
import logica.RegistroMensual;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;

public class RegistroMes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AgenciaEmpleadora agencia;
	private JScrollPane scrollPane;
	private JTable table;

	@SuppressWarnings("unused")
	private boolean empresasDir = true;
	private boolean diaPrev = true;
	private boolean idPuesto = true;
	private boolean hora = true;
	private boolean empresaTelef = true;
	private boolean isPlan = true;
	private boolean empresaSector = true;

	/**
	 * @wbp.nonvisual location=307,-11
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RegistroMes(AgenciaEmpleadora a) {
		this.agencia=a;
		setTitle("Registro Mensual de Entrevistas");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 625, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"}));
		
		JLabel lblMes = new JLabel("Mes :");
		
		JLabel lblA = new JLabel("A\u00F1o :");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(2000, 2000, 2050, 1));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addComponent(lblMes)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMes)
						.addComponent(lblA)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addGap(101))
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	  RegistroMes.this.cargarTablaConEmpresas();
	}
	public void cargarTablaConEmpresas() {

		ArrayList<Object> nombre = new ArrayList<Object>();		
		ArrayList<Object> telef = new ArrayList<Object>();			
		ArrayList<Object> sector = new ArrayList<Object>();
		ArrayList<Object> puesto = new ArrayList<Object>();
		ArrayList<Object> dia = new ArrayList<Object>();
		ArrayList<Object> horaEntrevista = new ArrayList<Object>();
		ArrayList<Object> palnificada = new ArrayList<Object>();

		ArrayList<RegistroMensual> registrosMes = agencia.getListadoRegistros();
		for (int i = 0; i < registrosMes.size(); i++) {
			RegistroMensual aux = registrosMes.get(i);
			nombre.add(aux.getEmpleo().getNombreEmpresa());

			if(empresaTelef)
				telef.add(aux.getEmpleo().getTelef());
			if(empresaSector)
				sector.add(aux.getEmpleo().getSector());
			if(idPuesto)	
			   puesto.add(aux.getEmpleo().getIdentificadorPropio());
			if(diaPrev)
			   dia.add(aux.getEmpleo().getDiaEscogido());
			if(hora)
			   horaEntrevista.add(aux.getEmpleo().getHora());
			if(isPlan)
			   palnificada.add(aux.getEmpleo().isPlanificada());
		  
		}

		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Nombre", nombre.toArray());
		if(empresaTelef)
			defaultTableModel.addColumn("Telefono", telef.toArray());
		if(empresaSector)
			defaultTableModel.addColumn("Sector", sector.toArray());		
		if(idPuesto)
		    defaultTableModel.addColumn("Puesto", puesto.toArray());
		if(diaPrev)
			defaultTableModel.addColumn("Dia Escogido", dia.toArray());
		if(hora)
		    defaultTableModel.addColumn("Hora", horaEntrevista.toArray());
		if(isPlan)
			defaultTableModel.addColumn("Planificada", palnificada.toArray());
		table.setModel(defaultTableModel);
	}
}
