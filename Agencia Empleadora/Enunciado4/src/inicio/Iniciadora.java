package inicio;

import interfaz.Autenticar;
import java.awt.EventQueue;

import javax.swing.JDialog;

public class Iniciadora {
	/**
	 * Launch the application.
	 */
	/*public static void inicializar(AgenciaEmpleadora a){
		Puesto p1 = new Puesto("Informatico","Ingeniero","Universitario",2,10 );
	    Empresa e1 = new Empresa("egerg","ergergeg","egergerg","ergerge");
	    AgenciaEmpleadora a1 = new AgenciaEmpleadora("Mirando hacia el Futuro");
	    e1.getListadoPuestos().add(p1);
	}*/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autenticar dialog = new Autenticar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
