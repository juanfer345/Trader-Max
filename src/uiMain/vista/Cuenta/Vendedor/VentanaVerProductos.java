package uiMain.vista.Cuenta.Vendedor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import control.Cuenta.Vendedor.ControlVerProductos;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class VentanaVerProductos extends JFrame {

	Container panel;

	public VentanaVerProductos() {
		panel = this.getContentPane();
		ControlVerProductos oidor = new ControlVerProductos();
		JTextArea aux = new JTextArea(oidor.getProd());
		//JTextArea aux = new JTextArea("fkfkkf fkkfowf ffokwf,kof \n i44owo froorroro"); PRUEBA

		aux.setEditable(false);
		aux.setLineWrap(true);
		aux.setWrapStyleWord(true);
		JLabel titulo = new JLabel("PRODUCTOS SUBIDOS");
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 16));

		JLabel descripcion = new JLabel("A continuación encontrará la información de los productos "
				                      + "que ha subido con anterioridad a la aplicación \n");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		JScrollPane scroll = new JScrollPane(aux, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(350, 250));

		JButton acep = new JButton("Aceptar");
		acep.addActionListener(oidor);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1, 10, 10));
		panel2.add(titulo);
		panel2.add(descripcion);

		panel.setLayout(new BorderLayout(5, 20));
		panel.add(scroll, BorderLayout.CENTER);
		panel.add(acep, BorderLayout.SOUTH);
		panel.add(panel2, BorderLayout.NORTH);

	}

	public void lanzar() {
		this.setTitle("Catálogo productos vendedor");
		getDefaultCloseOperation();
		organizar();
	}

	private void organizar() {
		pack(); // coloca los componentes
		setLocationRelativeTo(null); // centra la ventana en la pantalla
		setVisible(true); 
	}
}
