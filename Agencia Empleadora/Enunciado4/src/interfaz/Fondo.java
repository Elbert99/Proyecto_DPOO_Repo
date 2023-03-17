package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9137412856130307443L;
	public Image imagen;
	public URL fondo ;

	public Fondo(){
	
	
		fondo = this.getClass().getResource("/Fondos/mujer-negocios-que-dibuja-redes-globales-estructura-e-intercambios-datos-conexion-clientes_34200-270.jpg");
		imagen = new ImageIcon(fondo).getImage();

	}
	  
	public void paintComponent(Graphics g){
	
		  g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
			
	}
}