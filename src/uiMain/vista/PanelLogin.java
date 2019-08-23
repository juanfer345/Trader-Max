package uiMain.vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.ControlLogin;

public class PanelLogin extends JPanel {

	// Etiquetas
	public JLabel etiqueta_1;
	public JLabel etiqueta_2;
	public JLabel etiqueta_3;
	public JLabel etiqueta_4;

	// Botones
	public JButton boton_2;
	public JButton boton_1;
	public JButton boton_3;
	public JButton boton_4;

	// Textos
	public JScrollPane texto_1;
	public JTextField texto_2;
	public JTextField texto_3;

	public PanelLogin() {
		
		// Definición de las partes del panel - [Inicio]

		// Panelas
		JPanel panelIzquierdo = new JPanel();
		JPanel panelIzquierdoArriba = new JPanel();
		JPanel panelIzquierdoAbajo = new JPanel();
		JPanel panelDerecho = new JPanel();
		JPanel panelDerechoArriba = new JPanel();
		JPanel panelDerechoAbajo = new JPanel();
		JPanel panelDerechoAbajoDobleA = new JPanel();
		JPanel panelDerechoAbajoDobleB = new JPanel();
		JPanel panelDerechoAbajoDobleC = new JPanel();

		this.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 25));
		panelIzquierdo.setLayout(new GridLayout(2,1));
		panelDerecho.setLayout(new GridLayout(2,1));
		panelDerechoAbajo.setLayout(new GridLayout(5, 1));
		panelDerechoAbajoDobleA.setLayout(new GridLayout(1, 2));
		panelDerechoAbajoDobleB.setLayout(new GridLayout(1, 2));
		panelDerechoAbajoDobleC.setLayout(new GridLayout(1, 2));

		// Etiquetas
		etiqueta_1 = new JLabel("Bienvenido a Trader-Max invitado!");
		
		etiqueta_2 = new JLabel("Ingrese su código de usuario y su clave");
		etiqueta_2.setVisible(false);
		
		etiqueta_3 = new JLabel("Código de usuario");
		etiqueta_3.setVisible(false);
		
		etiqueta_4 = new JLabel("Clave");
		etiqueta_4.setVisible(false);

		// Botones
		boton_1 = new JButton("Haga clic para ver fotos de los autores del sistema");
		boton_2 = new JButton("Administrador");
		boton_3 = new JButton("UsuarioComún");
		boton_4 = new JButton("Salir");

		// Textos
		texto_1 = new JScrollPane(new JTextArea("Trader-Max es la solución para realizar compras y ventas "
				+ "de todo lo que quieras a través de internet!"));
		texto_2 = new JTextField(); texto_2.setVisible(false);
		texto_3 = new JTextField(); texto_3.setVisible(false);
		
		// Definición de las partes del panel - [Fin]

		// Añadiendo todos los elementos al panel

		// Panel izquierdo
		panelIzquierdoArriba.add(etiqueta_1); panelIzquierdoAbajo.add(boton_1);
		panelIzquierdo.add(panelIzquierdoArriba);
		panelIzquierdo.add(panelIzquierdoAbajo);
		
		// Panel derecho
		panelDerechoArriba.add(texto_1);
		
		panelDerechoAbajoDobleA.add(boton_2); panelDerechoAbajoDobleA.add(boton_3);
		panelDerechoAbajoDobleB.add(etiqueta_3); panelDerechoAbajoDobleB.add(texto_2);
		panelDerechoAbajoDobleC.add(etiqueta_4); panelDerechoAbajoDobleC.add(texto_3);
		
		panelDerechoAbajo.add(panelDerechoAbajoDobleA);
//		etiqueta_2.setAlignmentY(CENTER_ALIGNMENT);
//		etiqueta_2.setAlignmentX(CENTER_ALIGNMENT);
		panelDerechoAbajo.add(etiqueta_2);
		panelDerechoAbajo.add(panelDerechoAbajoDobleB);
		panelDerechoAbajo.add(panelDerechoAbajoDobleC);
		panelDerechoAbajo.add(boton_4);
		
		panelDerecho.add(panelDerechoArriba); panelDerecho.add(panelDerechoAbajo);
		
		// Juntando todos los paneles
		this.add(panelIzquierdo); this.add(panelDerecho);
	}
	
	public void asignarOyente() {
		// Declaración del oyente
		ControlLogin oidor = new ControlLogin();
		
//		this.addMouseMotionListener(oidor);
//		super.addMouseMotionListener(oidor);
		etiqueta_1.addMouseMotionListener(oidor);
		boton_1.addActionListener(oidor);
		boton_2.addActionListener(oidor);
		boton_3.addActionListener(oidor);
		boton_4.addMouseMotionListener(oidor);
	}
}