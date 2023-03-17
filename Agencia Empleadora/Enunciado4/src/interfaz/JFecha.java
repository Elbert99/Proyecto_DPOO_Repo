package interfaz;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class JFecha extends JLabel{
	private static final long serialVersionUID = -7765211006244185348L;
	public JFecha() {
		setFont(new Font("Microsoft Tai Le", getFont().getStyle(), 22));
		setHorizontalAlignment(SwingConstants.CENTER);
		setLabelFor(this);
		Date fechaSys = new Date();
		DateFormat formatoFecha= DateFormat.getDateInstance();
		String fecha = formatoFecha.format(fechaSys);
		this.setText(fecha);
	}

}
