package interfaz;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class EditarCandidato extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public EditarCandidato() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Elmer\\Documents\\Zapya\\Photo\\agencia_cv.jpg"));
		setTitle("Editar Candidato");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 13, 54, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(21, 38, 61, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nivel Escolar :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 63, 82, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Sector :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(28, 88, 54, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Rama :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(36, 113, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Especialidad :");
		lblNewLabel_5.setBounds(10, 138, 46, 14);
		contentPane.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setBounds(93, 7, 262, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(93, 32, 262, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setBounds(93, 57, 262, 20);
		contentPane.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				for(int i = 0;i<comboBox_1.getModel().getSize(); i++)
					if(!comboBox_1.getModel().getElementAt(i).equals(comboBox_1.getSelectedItem())){
						comboBox_1.getModel().addListDataListener((ListDataListener)comboBox_1.getSelectedItem());
					}
			}
		});
				comboBox_1.setEditable(true);
				comboBox_1.setBounds(93, 85, 262, 20);
				contentPane.add(comboBox_1);

				comboBox_2 = new JComboBox();
				comboBox_2.setBounds(93, 151, 262, 20);
				contentPane.add(comboBox_2);

	}
}
