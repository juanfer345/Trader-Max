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
		/*TextArea aux2 = new JTextArea("\"Trader max es una aplicaci�n que esta dise�ada para la \"\r\n"
				+ " \"compra y venta aut�noma de art�culos, cada usuario podr� \"\r\n"
				+ "\"crear su cuenta ya sea para poner en venta sus productos, \"\r\n"
				+ " \"o para comprar aquellos ofrecidos por parte de los dem�s \"\r\n"
				+ "\"usuarios.\\n\\nEl comprador tendr� acceso a un carrito de \"\r\n"
				+ "\"compras donde almacenar� los productos que desee para su \"\r\n"
				+ "\"posterior adquisici�n, en caso de que sea vendedor podr� \"\r\n"
				+ "+ \"montar sus productos al catalogo. El proceso de pago se \"\r\n"
				+ " + \"encuentra vinculado a una cuenta bancaria que cada usuario \"\r\n"
				+ "+ \"deber� haber registrado con anterioridad, esto para hacer \"\r\n"
				+ "+ \"la transacci�n de una cuenta a otra cuando se realice la \"\r\n"
				+ " + \"compra y venta del producto.\\n\\nFue desarrollada por el\"\r\n"
				+ "\"equipo 1 de programaci�n orientada a objetos (2019-I) \"\r\n"); */

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
