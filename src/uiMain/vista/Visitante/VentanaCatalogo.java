package uiMain.vista.Visitante;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import control.ControlMostrarCatalogo;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class VentanaCatalogo extends JFrame {

	Container panel;

	public VentanaCatalogo() {
		panel = this.getContentPane();
		ControlMostrarCatalogo oidor = new ControlMostrarCatalogo();
		JTextArea aux = new JTextArea(oidor.getProductos());
		aux.setEditable(false);
		aux.setLineWrap(true);
		aux.setWrapStyleWord(true);
		JLabel titulo = new JLabel("PRODUCTOS");
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 16));

		JLabel descripcion = new JLabel("A continuaci�n encontrar� la informaci�n de los productos disponibles\n");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		JScrollPane scroll = new JScrollPane(aux, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(350, 250));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1, 10, 10));
		panel2.add(titulo);
		panel2.add(descripcion);
		JButton acep = new JButton("Aceptar");
		acep.addActionListener(oidor);

		panel.setLayout(new BorderLayout(5, 20));

		panel.add(scroll, BorderLayout.CENTER);
		panel.add(acep, BorderLayout.SOUTH);
		panel.add(panel2, BorderLayout.NORTH);
		
		this.setMinimumSize(new Dimension(800, 300)); 

	}

	public void lanzar() {
		this.setTitle("Cat�logo de productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		organizar();
	}

	private void organizar() {
		pack(); // coloca los componentes
		setLocationRelativeTo(null); // centra la ventana en la pantalla
		setVisible(true); 
	}
}
