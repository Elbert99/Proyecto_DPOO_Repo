package interfaz;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.AgenciaEmpleadora;
import logica.Candidato;
import logica.CandidatoCustodio;
import logica.CandidatoTurismo;

import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ListadoCandidatos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean candidatoNumID = true;
	private boolean candidatoNivelescolar = true;
	private boolean candidatoTelefono = true;
	private boolean candidatoRama = true;
	private boolean candidatoYearsEsp = true;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Principal pri;
	private AgenciaEmpleadora agencia;
	private JTable table;
	private JScrollPane scrollPane;
	/**
	 * @wbp.nonvisual location=248,-11
	 */
	private DefaultTableModel TableModel = new DefaultTableModel();
	private JPanel panel;
	private JButton btnRevisar;
	private JButton btnEliminar;
	private JButton btnModificar;

	public ListadoCandidatos(Principal p , AgenciaEmpleadora a) {
		setTitle("Registro de candidatos inscritos en el sistema");
		this.pri= p;
		this.agencia=a;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 673, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Listado de candidatos en espera :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 26, 637, 515);
		contentPane.add(panel);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBackground(Color.GRAY);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		btnRevisar = new JButton("Revisar");
		btnRevisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Candidato> Lista = new ArrayList<Candidato>();
				int almenosUno = 0;
				for(int i=0; i<agencia.getListadoCandidatosInscritos().size(); i++){
					if(agencia.getListadoCandidatosInscritos().get(i) instanceof CandidatoCustodio){
						if(((CandidatoCustodio)agencia.getListadoCandidatosInscritos().get(i)).getCalifEF()>=50){
							if( agencia.comprobarExistenciaEmpleo(agencia.getListadoCandidatosInscritos().get(i).getNumID(),agencia.getListadoCandidatosInscritos().get(i).getNombre(),
									agencia.getListadoCandidatosInscritos().get(i).getDireccion(), agencia.getListadoCandidatosInscritos().get(i).getTelefono(), 
									agencia.getListadoCandidatosInscritos().get(i).getNivelEscolar(), agencia.getListadoCandidatosInscritos().get(i).getEspecialidad(),
									agencia.getListadoCandidatosInscritos().get(i).getRama(), agencia.getListadoCandidatosInscritos().get(i).getSector(),agencia.getListadoCandidatosInscritos().get(i).getYearsEspecialidad())){
								agencia.registrarCandidatoEmpleadoCustodio(agencia.getListadoCandidatosInscritos().get(i).getNumID(),agencia.getListadoCandidatosInscritos().get(i).getNombre(),
										agencia.getListadoCandidatosInscritos().get(i).getDireccion(), agencia.getListadoCandidatosInscritos().get(i).getTelefono(), 
										agencia.getListadoCandidatosInscritos().get(i).getNivelEscolar(), agencia.getListadoCandidatosInscritos().get(i).getEspecialidad(),
										agencia.getListadoCandidatosInscritos().get(i).getRama(), agencia.getListadoCandidatosInscritos().get(i).getSector(),agencia.getListadoCandidatosInscritos().get(i).getYearsEspecialidad(),((CandidatoCustodio)agencia.getListadoCandidatosInscritos().get(i)).getCalifEF(),((CandidatoCustodio)agencia.getListadoCandidatosInscritos().get(i)).getNumHC());
								Lista.add(agencia.getListadoCandidatosInscritos().get(i));
								agencia.getListadoCandidatosInscritos().remove(agencia.getListadoCandidatosInscritos().get(i));
								almenosUno++;
							}
						}
					}
					else if(agencia.getListadoCandidatosInscritos().get(i) instanceof CandidatoTurismo){
						if(((CandidatoTurismo)agencia.getListadoCandidatosInscritos().get(i)).isCertificadoIdioma()){
							if( agencia.comprobarExistenciaEmpleo(agencia.getListadoCandidatosInscritos().get(i).getNumID(),agencia.getListadoCandidatosInscritos().get(i).getNombre(),
									agencia.getListadoCandidatosInscritos().get(i).getDireccion(), agencia.getListadoCandidatosInscritos().get(i).getTelefono(), 
									agencia.getListadoCandidatosInscritos().get(i).getNivelEscolar(), agencia.getListadoCandidatosInscritos().get(i).getEspecialidad(),
									agencia.getListadoCandidatosInscritos().get(i).getRama(), agencia.getListadoCandidatosInscritos().get(i).getSector(),agencia.getListadoCandidatosInscritos().get(i).getYearsEspecialidad())){
								agencia.registrarCandidatoEmpleadoTurismo(agencia.getListadoCandidatosInscritos().get(i).getNumID(),agencia.getListadoCandidatosInscritos().get(i).getNombre(),
										agencia.getListadoCandidatosInscritos().get(i).getDireccion(), agencia.getListadoCandidatosInscritos().get(i).getTelefono(), 
										agencia.getListadoCandidatosInscritos().get(i).getNivelEscolar(), agencia.getListadoCandidatosInscritos().get(i).getEspecialidad(),
										agencia.getListadoCandidatosInscritos().get(i).getRama(), agencia.getListadoCandidatosInscritos().get(i).getSector(),agencia.getListadoCandidatosInscritos().get(i).getYearsEspecialidad(),((CandidatoTurismo)agencia.getListadoCandidatosInscritos().get(i)).isCertificadoIdioma());
								Lista.add(agencia.getListadoCandidatosInscritos().get(i));
								agencia.getListadoCandidatosInscritos().remove(agencia.getListadoCandidatosInscritos().get(i));
								almenosUno++;
							}
						}
					}
					else{
						if( agencia.comprobarExistenciaEmpleo(agencia.getListadoCandidatosInscritos().get(i).getNumID(),agencia.getListadoCandidatosInscritos().get(i).getNombre(),
								agencia.getListadoCandidatosInscritos().get(i).getDireccion(), agencia.getListadoCandidatosInscritos().get(i).getTelefono(), 
								agencia.getListadoCandidatosInscritos().get(i).getNivelEscolar(), agencia.getListadoCandidatosInscritos().get(i).getEspecialidad(),
								agencia.getListadoCandidatosInscritos().get(i).getRama(), agencia.getListadoCandidatosInscritos().get(i).getSector(),agencia.getListadoCandidatosInscritos().get(i).getYearsEspecialidad())){
							agencia.registrarCandidatoEmpleado(agencia.getListadoCandidatosInscritos().get(i).getNumID(),agencia.getListadoCandidatosInscritos().get(i).getNombre(),
									agencia.getListadoCandidatosInscritos().get(i).getDireccion(), agencia.getListadoCandidatosInscritos().get(i).getTelefono(), 
									agencia.getListadoCandidatosInscritos().get(i).getNivelEscolar(), agencia.getListadoCandidatosInscritos().get(i).getEspecialidad(),
									agencia.getListadoCandidatosInscritos().get(i).getRama(), agencia.getListadoCandidatosInscritos().get(i).getSector(),agencia.getListadoCandidatosInscritos().get(i).getYearsEspecialidad());
							Lista.add(agencia.getListadoCandidatosInscritos().get(i));
							agencia.getListadoCandidatosInscritos().remove(agencia.getListadoCandidatosInscritos().get(i));
							almenosUno++;
						}
					}
				}
				if(!(agencia.getListadoCandidatosInscritos().isEmpty()) || !(Lista.isEmpty())){
					if(almenosUno >=1){
						ListadoCandidatos.this.dispose();
						try {
							ListadoCoincidencias frameListaPosiblesEmpleados = new 
									ListadoCoincidencias(Lista,agencia);
							frameListaPosiblesEmpleados.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(ListadoCandidatos.this, "No se ha realizado ninguna solicitud de empleo por parte de ninguna empresa o...");
						JOptionPane.showMessageDialog(ListadoCandidatos.this, "No existen candidatos que satisfagan ninguna de las solicitudes realizadas.");
					}
				}
				else
					JOptionPane.showMessageDialog(ListadoCandidatos.this, "No existen candidatos inscritos en el sistema.");
			}
		});

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
										.addComponent(btnModificar)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnEliminar)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnRevisar)))
										.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRevisar)
								.addComponent(btnEliminar)
								.addComponent(btnModificar))
								.addContainerGap(22, Short.MAX_VALUE))
				);
		panel.setLayout(gl_panel);
		ListadoCandidatos.this.cargarTablaConCandidatos();
	}

	public void cargarTablaConCandidatos() {

		ArrayList<Object> nombreCand = new ArrayList<Object>();		
		ArrayList<Object> numID = new ArrayList<Object>();	
		ArrayList<Object> rama = new ArrayList<Object>();		
		ArrayList<Object> telCand = new ArrayList<Object>();		
		ArrayList<Object> nivelEsc = new ArrayList<Object>();		
		ArrayList<Object> yearsEsp = new ArrayList<Object>();

		ArrayList<Candidato> candidatos = agencia.getListadoCandidatosInscritos();
		for (int i = 0; i < candidatos.size(); i++) {
			Candidato aux = candidatos.get(i);
			nombreCand.add(aux.getNombre());

			if(candidatoNumID)
				numID.add(aux.getNumID());
			if(candidatoRama)
				rama.add(aux.getRama());
			if(candidatoTelefono)
				telCand.add(aux.getTelefono());
			if(candidatoNivelescolar)
				nivelEsc.add(aux.getNivelEscolar());	
			if(candidatoYearsEsp)
				yearsEsp.add(aux.getYearsEspecialidad());
		}

		TableModel = new DefaultTableModel();
		TableModel.addColumn("Nombre", nombreCand.toArray());
		if(candidatoNumID)
			TableModel.addColumn("Numero de Identidad", numID.toArray());
		if(candidatoRama)
			TableModel.addColumn("Rama a Trabajar", rama.toArray());
		if(candidatoTelefono)
			TableModel.addColumn("Tel\u00E9fono", telCand.toArray());
		if(candidatoNivelescolar)
			TableModel.addColumn("Nivel de Escolaridad", nivelEsc.toArray());
		if(candidatoYearsEsp)
			TableModel.addColumn("Years Experiencia en su Especialidad", yearsEsp.toArray());
		table.setModel(TableModel);
	}



}
