package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import logica.AgenciaEmpleadora;
import logica.Candidato;
import logica.Empresa;
import logica.Puesto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;












import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class Principal extends JFrame {

	/**
	 * 
	 */

	private int indiceEmpresa=0;
	
	private boolean empresasDir=true;
	private boolean empresaTelef=true;
	private boolean empresaSector=true;
	private boolean idRama=true;
	private boolean  cantN=true;
	private boolean puesto=true;

	private static final long serialVersionUID = 1L;
	
	private AgenciaEmpleadora agencia;
	private DefaultTableModel TableModel = new DefaultTableModel();
	private JMenu mnAccederA;
	private JMenuItem mntmColaboradora;
	private JMenu mnArchivo;
	private JMenu mnNuevo;
	private JMenuItem mntmCandidato;
	private JMenuItem mntmActualizar;
	private JMenuItem mntmSalir;
	private JMenu mnVista;
	private JMenu mnReportes;
	private JMenuBar menuBar;
	private JMenuItem mntmClientecitas;
	private JMenu mnCreditos;
	private JMenuItem mntmRegistroMensual;
	/**
	 * @wbp.nonvisual location=597,-11
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	/**
	 * @wbp.nonvisual location=817,-11
	 */
	private  DefaultTableModel model = new DefaultTableModel();
	private JMenuItem mntmEmpleosQueQuedaron;
	private JMenuItem mntmEmpleosQueMayor;
	private JMenuItem mntmOfertasDeEmpleos;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmEmpresaListado;
	protected Object JOptionPane;
	private Fondo fondo;
	private JMenuItem mntmListadoDeCandidatos;
	private JFecha fchmay;



	/**
	 * Create the frame.
	 */
	public Principal(AgenciaEmpleadora a) {
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Elmer\\Documents\\Zapya\\Photo\\agencia_cv.jpg"));
		agencia = a;
		setTitle("Gesti\u00F3n bolsa de ubicaci\u00F3n laboral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 456);
		setLocationRelativeTo(null);

		menuBar = new JMenuBar();
		menuBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);

		mnNuevo = new JMenu("Nuevo");
		mnArchivo.add(mnNuevo);




		mntmCandidato = new JMenuItem("Candidato");
		mntmCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					RegistrarCandidato frameRegistrarCandidato = new 
							RegistrarCandidato(Principal.this,agencia);
					frameRegistrarCandidato.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


		});
		mntmCandidato.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		mnNuevo.add(mntmCandidato);

		mnAccederA = new JMenu("Acceder a ...");
		mnArchivo.add(mnAccederA);

		mntmColaboradora = new JMenuItem("Colaboradora");
		mntmColaboradora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					RegistrarEmpresa frameRegistrarEmpresa = new 
							RegistrarEmpresa(Principal.this,agencia);
					frameRegistrarEmpresa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mntmColaboradora.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mnAccederA.add(mntmColaboradora);

		mntmActualizar = new JMenuItem("Actualizar");
		mnArchivo.add(mntmActualizar);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.this.setVisible(false);
				Principal.this.dispose();
			}
		});
		mnArchivo.add(mntmSalir);

		mnVista = new JMenu("Vista");
		mnVista.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mnVista.setMnemonic('V');
		menuBar.add(mnVista);

		mntmRegistroMensual = new JMenuItem("Registro Mensual");
		mntmRegistroMensual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					RegistroMes frameRegistroCitas = new 
							RegistroMes(agencia);
					frameRegistroCitas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mntmRegistroMensual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mnVista.add(mntmRegistroMensual);
		
		mntmListadoDeCandidatos = new JMenuItem("Listado de Candidatos Inscritos");
		mntmListadoDeCandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ListadoCandidatos frameLista1 = new 
							ListadoCandidatos(Principal.this,agencia);
					frameLista1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mntmListadoDeCandidatos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnVista.add(mntmListadoDeCandidatos);

		mnReportes = new JMenu("Reportes");
		mnReportes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mnReportes.setMnemonic('R');
		menuBar.add(mnReportes);

		mntmClientecitas = new JMenuItem("Candidato -Cita(s)");
		mntmClientecitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ReporteCandCita frameReporte1 = new 
							ReporteCandCita(Principal.this,agencia);
					frameReporte1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnReportes.add(mntmClientecitas);

		mntmEmpleosQueQuedaron = new JMenuItem("Empleos que quedaron vacantes");
		mnReportes.add(mntmEmpleosQueQuedaron);

		mntmEmpleosQueMayor = new JMenuItem("Empleos que mayor demanda poseen");
		mnReportes.add(mntmEmpleosQueMayor);

		mntmOfertasDeEmpleos = new JMenuItem("Ofertas de empleos mas frecuentes");
		mnReportes.add(mntmOfertasDeEmpleos);

		mntmEmpresaListado = new JMenuItem("Empresa - Listado de Candidatos que va a presentarse en total");
		mnReportes.add(mntmEmpresaListado);

		mntmNewMenuItem = new JMenuItem("Dado un puesto los candidatos que se presentaran a sus entrevistas \r\nasi como los que la aceptaron y los que no");
		mnReportes.add(mntmNewMenuItem);

		mnCreditos = new JMenu("Ayuda y Cr\u00E9ditos");
		mnCreditos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mnCreditos.setMnemonic('A');
		menuBar.add(mnCreditos);

		fondo = new Fondo();
		fondo.setBackground(Color.WHITE);
		fondo.setBounds(0, 0, 1125, 501);

		setContentPane(fondo);	
		fondo.setLayout(null);

		fchmay = new JFecha();
		fchmay.setForeground(Color.WHITE);
		fchmay.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		fchmay.setBounds(481, 11, 131, 29);
		fondo.add(fchmay);


		cargarTablaConEmpresas();

	}
	

	public void cargarTablaConEmpresas() {

		ArrayList<Object> nombre = new ArrayList<Object>();		
		ArrayList<Object> telef = new ArrayList<Object>();	
		ArrayList<Object> direccion = new ArrayList<Object>();		
		ArrayList<Object> sector = new ArrayList<Object>();		

		ArrayList<Empresa> empresas = agencia.getListadoEmpresas();
		for (int i = 0; i < empresas.size(); i++) {
			Empresa aux = empresas.get(i);
			nombre.add(aux.getNombre());

			if(empresaTelef)
				telef.add(aux.getTelefono());
			if(empresasDir)
				direccion.add(aux.getDireccion());
			if(empresaSector)
				sector.add(aux.getSector());
		}

		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Nombre", nombre.toArray());
		if(empresaTelef)
			defaultTableModel.addColumn("Telef", telef.toArray());
		if(empresasDir)
			defaultTableModel.addColumn("Dire", direccion.toArray());
		if(empresaSector)
			defaultTableModel.addColumn("Sector", sector.toArray());
	}


	public void cargarTablaConEmpleos() {
		ArrayList<Empresa> empresas = agencia.getListadoEmpresas();
		if(empresas.size()>=indiceEmpresa)
		{
			scrollPaneEmpleos.setVisible(puesto);
			if(puesto)
			{			
				ArrayList<Object> puesto = new ArrayList<Object>();		
				ArrayList<Object> rama = new ArrayList<Object>();		
				ArrayList<Object> cantPuesto = new ArrayList<Object>();		

				ArrayList<Puesto> puestos = empresas.get(indiceEmpresa).getListadoPuestos();
				for (int i = 0; i < puestos.size(); i++) {
					Puesto aux = puestos.get(i);
					puesto.add(aux.getIdentificadorPropio());

					if(idRama)
						rama.add(aux.getIdentificadorRama());
					if(cantN)
						cantPuesto.add(aux.getPlazasNecesarias());
				}

				model = new DefaultTableModel();
				model.addColumn("Empleo", puesto.toArray());
				if(idRama)
					model.addColumn("Rama Perteneciente", rama.toArray());	
				if(cantN)
					model.addColumn("Cant Plazas Actuales", cantPuesto.toArray());		
				table2.setModel(model);
			}
			fondo.repaint();

		}
	}



	public void mostrarNotificacion(){
		javax.swing.JOptionPane.showMessageDialog(Principal.this, "Se han solicitado empleos. Revise a los candidatos inscritos en el sistema.");						

	}	
}