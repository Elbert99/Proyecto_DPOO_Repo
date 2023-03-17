package interfaz;

import javax.swing.JDialog;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import control.Seguridad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.AgenciaEmpleadora;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class Autenticar extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3094737529720585324L;
	private Fondo fondo;
	private JTextField textField;
	private JLabel lblUsuario;
	private JLabel lblContrase;
	private JLabel lblBienvenidoAJobsfinder;
	private JLabel lblIntroduzcaLosCreedenciales;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JPasswordField passwordField;
	private JLabel lblSuUsuarioO;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Autenticar() {
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 352);
		fondo = new Fondo();
		fondo.setAlignmentY(Component.TOP_ALIGNMENT);
		fondo.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		setContentPane(fondo);
		fondo.imagen = Toolkit.getDefaultToolkit().getImage(Autenticar.class.getResource("/fondos/concepto-seguridad-seguridad-empresarial-proteccion-corporativa_53876-64964.jpg"));
		fondo.setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		textField.setForeground(Color.BLACK);
		textField.setBounds(141, 102, 188, 20);
		fondo.add(textField);
		textField.setColumns(10);
		
		lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(44, 108, 87, 14);
		fondo.add(lblUsuario);
		
		lblContrase = new JLabel("Contrase\u00F1a :");
		lblContrase.setForeground(Color.BLACK);
		lblContrase.setBackground(Color.WHITE);
		lblContrase.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblContrase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrase.setBounds(10, 146, 121, 14);
		fondo.add(lblContrase);
		
		lblBienvenidoAJobsfinder = new JLabel("Bienvenido a JobsFinder !!!");
		lblBienvenidoAJobsfinder.setForeground(Color.WHITE);
		lblBienvenidoAJobsfinder.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		lblBienvenidoAJobsfinder.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoAJobsfinder.setBounds(52, 29, 371, 38);
		fondo.add(lblBienvenidoAJobsfinder);
		
		lblIntroduzcaLosCreedenciales = new JLabel("Introduzca los credenciales de acceso :");
		lblIntroduzcaLosCreedenciales.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblIntroduzcaLosCreedenciales.setBackground(Color.WHITE);
		lblIntroduzcaLosCreedenciales.setForeground(Color.BLACK);
		lblIntroduzcaLosCreedenciales.setBounds(62, 78, 361, 14);
		fondo.add(lblIntroduzcaLosCreedenciales);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  String nombre = textField.getText();
				  textField.setText("");
				  String pass = new String(passwordField.getPassword());
				  passwordField.setText("");
				  Seguridad aux = new Seguridad();
				  if (aux.acceso(nombre, pass)) {
					Autenticar.this.setVisible(false);
					AgenciaEmpleadora a = new AgenciaEmpleadora("1234759124");
					Principal frame = new Principal(a);
					frame.setVisible(true);						
				  } 
				  else 
					lblSuUsuarioO.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnNewButton.setMnemonic('A');
		btnNewButton.setBounds(276, 265, 87, 23);
		fondo.add(btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   Autenticar.this.dispose();
			}
		});
		btnCancelar.setMnemonic('C');
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnCancelar.setBounds(373, 265, 87, 23);
		fondo.add(btnCancelar);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(UIManager.getBorder("Button.border"));
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(141, 140, 188, 20);
		fondo.add(passwordField);
		
		lblSuUsuarioO = new JLabel("Su usuario o contrase\u00F1a son incorrectos.\r\n No tiene permisos para entrar.");
		lblSuUsuarioO.setVisible(false);
		lblSuUsuarioO.setForeground(Color.RED);
		lblSuUsuarioO.setHorizontalAlignment(SwingConstants.LEFT);
		lblSuUsuarioO.setFont(new Font("Arial Narrow", Font.ITALIC, 17));
		lblSuUsuarioO.setBounds(0, 191, 460, 38);
		fondo.add(lblSuUsuarioO);
		
	}
}
