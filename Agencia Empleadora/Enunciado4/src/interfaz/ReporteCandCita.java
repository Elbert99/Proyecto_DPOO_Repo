package interfaz;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.AgenciaEmpleadora;

import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

public class ReporteCandCita extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    @SuppressWarnings("unused")
	private Principal pri;
    @SuppressWarnings("unused")
	private AgenciaEmpleadora agencia;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTable table;
    private JPanel panel_1;
    private JScrollPane scrollPane_1;
    private JTable table_1;
    private JTextField textFieldBuscar;
    private JButton btnBuscar;
    private JButton btnElegir;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ReporteCandCita(Principal p, AgenciaEmpleadora a) {
		this.pri=p;
		this.agencia=a;
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Reportar las Citas de un Candidato");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pri=p;
		this.agencia=a;
		setBounds(100, 100, 945, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Listado de Candidatos :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 83, 379, 375);
		contentPane.add(panel);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Listado de Citas del Candidato Elegido :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(410, 83, 331, 375);
		contentPane.add(panel_1);
		
		scrollPane_1 = new JScrollPane();
		
		btnElegir = new JButton("Elegir");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
						.addComponent(btnElegir, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnElegir)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_1.setViewportView(table_1);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblLIndicacion = new JLabel("La siguiente tabla de candidatos evidencia la(s) empresa(s) a disposicion de un candidato elegido al azar o buscado .Esta dispocision esta dada por la cantidad de entrevistas.");
		lblLIndicacion.setBounds(10, 11, 855, 25);
		contentPane.add(lblLIndicacion);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(10, 47, 222, 20);
		contentPane.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar...");
		btnBuscar.setHorizontalAlignment(SwingConstants.TRAILING);
		btnBuscar.setBounds(245, 44, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNotaDe = new JLabel("Nota : De elegir alguna cita (marcarla) significa que el candidato se decide por una empresa determinada ,empresa futura en la que v\r\na a trabajar .Si no decide ninguna se almacena en el listado de candidatos inscritos en el sistema .");
		lblNotaDe.setBackground(new Color(240, 240, 240));
		lblNotaDe.setToolTipText("");
		lblNotaDe.setLabelFor(this);
		lblNotaDe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNotaDe.setBounds(10, 503, 909, 46);
		contentPane.add(lblNotaDe);
	}
}
