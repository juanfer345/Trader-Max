package uiMain.vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterfazPrincipal extends JFrame implements InterfazGrafica {

	// Etiquetas
	Label etiqueta_1;
	Label etiqueta_2;
	Label etiqueta_3;
	Label etiqueta_4;
	
	// Botones
	JButton boton_1;
	JButton boton_2;
	JButton boton_3;
	JButton boton_4;
	
	// Textos
	JScrollPane texto_1;
	JTextField texto_2;
	JTextField texto_3;
	
	public InterfazPrincipal() {		
		// Parámetros principales
		super("TRADER-MAX INC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Definición de las partes del frame - [Inicio]
		
		// Frame y paneles
		Container panelPrincipal = getContentPane();
		JPanel panelIzquierdo = new JPanel();
		JPanel panelIzquierdoArriba = new JPanel();
		JPanel panelIzquierdoAbajo = new JPanel();
		JPanel panelDerecho = new JPanel();
		JPanel panelDerechoArriba = new JPanel();
		JPanel panelDerechoAbajo = new JPanel();
		
		// Etiquetas
		etiqueta_1 = new Label();
		etiqueta_2 = new Label();
		etiqueta_3 = new Label();
		etiqueta_4 = new Label();
		
		// Botones
		boton_1 = new JButton();
		boton_2 = new JButton();
		boton_3 = new JButton();
		boton_4 = new JButton();
		
		// Textos
        texto_1 = new JScrollPane(new JTextArea("DESCRIPCIÓN DE LA APLICACIÓN"));
		texto_2 = new JTextField();
		texto_3 = new JTextField();
        
		// Declaración del oyente
		Oyente oidor = new Oyente();
		
		// Definición de las partes del frame - [Fin] 
		
		// Definiendo el layout de los paneles
		panelPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 25));
		panelIzquierdo.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelDerecho.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelDerechoAbajo.setLayout(new GridLayout(3,3));
		
		// Configuración de la etiqueta 1
		etiqueta_1.addMouseMotionListener(oidor);
		etiqueta_1.setText("Bienvenido a Trader-Max invitado.");
		
		// Configuración de las demas etiquetas
		etiqueta_2.setText("Ingrese su código de usuario y su clave");
		etiqueta_2.setVisible(false);
		
		etiqueta_3.setText("Código de usuario");
		etiqueta_3.setVisible(false);
		
		etiqueta_4.setText("Clave");
		etiqueta_4.setVisible(false);
		
		// Configuración de botones
		boton_1.setText("Haga clic para ver fotos de los autores del sistema");
		boton_1.addActionListener(oidor);
		
		boton_2.setText("Administrador");
		boton_2.addActionListener(oidor);
		
		boton_3.setText("UsuarioComun");
		
		// Configuración de los textos
		texto_2.setVisible(false);
		texto_3.setVisible(false);
		
		// Añadiendo todos los elementos al frame
		
		// Panel izquierdo
		panelIzquierdoArriba.add(etiqueta_1);
		panelIzquierdoAbajo.add(boton_1);
		panelIzquierdo.add(panelIzquierdoArriba);
		panelIzquierdo.add(panelIzquierdoAbajo);
		
		// Panel derecho
		
		
		
		panelPrincipal.add(panelIzquierdo);
		panelPrincipal.add(panelDerecho);
	}
	
	@Override
	public void setControlador(ActionListener a) {
		// TODO Auto-generated method stub
	}

	@Override
	public void lanzar() {
		// TODO Auto-generated method stub
	}
	
	class Oyente implements MouseMotionListener, ActionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			//arg0.getSource() instanceof Label 9.3 diap 20
			etiqueta_1.setForeground(Color.blue);
		}

		@Override
		public void actionPerformed(ActionEvent arg) {
			
			switch (((String) arg.getActionCommand())) {
				case "Administrador":
					boton_2.setText("Administrador Complete y Nuevamente Clic");
					etiqueta_2.setVisible(true);
					etiqueta_3.setVisible(true);
					etiqueta_4.setVisible(true);
					texto_2.setVisible(true);
					texto_3.setVisible(true);
					break;
				case "Administrador Complete y Nuevamente Clic":
					//LANZAR EXEPCIÓN 1
					break;
				case "UsuarioComún":
					boton_3.setText("UsuarioComún Complete y Nuevamente Clic");
					etiqueta_2.setVisible(true);
					etiqueta_3.setVisible(true);
					etiqueta_4.setVisible(true);
					texto_2.setVisible(true);
					texto_3.setVisible(true);
					break;
				case "UsuarioComún Complete y Nuevamente Clic":
					//LANZAR EXEPCIÓN 2
					break;
				default:
					boton_1.setIcon( new ImageIcon("./fotos/foto1.jpg"));
					boton_1.setIcon( new ImageIcon("./fotos/foto2.jpg"));
					boton_1.setIcon( new ImageIcon("./fotos/foto3.jpg"));
					break;
			}
		}
	}
}