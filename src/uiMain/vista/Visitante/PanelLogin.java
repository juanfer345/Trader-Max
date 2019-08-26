package uiMain.vista.Visitante;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.ControlLogin;
import control.ControlSalir;
import uiMain.vista.VentanaAplicacion;

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
	public JButton boton_5;

	// Textos
	public JScrollPane texto_1;
	public JTextField texto_2;
	public JPasswordField texto_3;

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
		panelIzquierdo.setLayout(new BorderLayout());
		panelDerecho.setLayout(new GridLayout(2,1));
		panelDerechoAbajo.setLayout(new GridLayout(5, 1));
		panelDerechoAbajoDobleA.setLayout(new GridLayout(1, 2));
		panelDerechoAbajoDobleB.setLayout(new GridLayout(1, 2));
		panelDerechoAbajoDobleC.setLayout(new GridLayout(1, 2));
		
		// Etiquetas
		etiqueta_1 = new JLabel("Bienvenido a Trader-Max invitado!");
		
		etiqueta_2 = new JLabel("Ingrese su correo de usuario y su contraseña", SwingConstants.CENTER);
		etiqueta_2.setVisible(false);
		
		etiqueta_3 = new JLabel("Correo de usuario");
		etiqueta_3.setVisible(false);
		
		etiqueta_4 = new JLabel("Clave");
		etiqueta_4.setVisible(false);

		// Botones
		ImageIcon imagen = new ImageIcon(System.getProperty("user.dir") + "\\src\\fotos\\Mensaje.jpg");
		boton_1 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(250, 210, Image.SCALE_SMOOTH)));
		
		boton_2 = new JButton("Administrador");
		boton_3 = new JButton("Comprador");
		boton_5 = new JButton("Vendedor");
		boton_4 = new JButton("Salir");

		// Textos
		JTextArea aux = new JTextArea(
		"Trader max es una aplicación que esta diseñada para la "
		 + "compra y venta autónoma de artículos, cada usuario podrá "
		 + "crear su cuenta ya sea para poner en venta sus productos, "
		 + "o para comprar aquellos ofrecidos por parte de los demás "
		 + "usuarios.\n\nEl comprador tendrá acceso a un carrito de "
		 + "compras donde almacenará los productos que desee para su "
		 + "posterior adquisición, en caso de que sea vendedor podrá "
		 + "montar sus productos al catalogo. El proceso de pago se "
		 + "encuentra vinculado a una cuenta bancaria que cada usuario "
		 + "deberá haber registrado con anterioridad, esto para hacer "
		 + "la transacción de una cuenta a otra cuando se realice la "
		 + "compra y venta del producto.\n\nFue desarrollada por el"
		 + "equipo 1 de programación orientada a objetos (2019-I) "
		 + "conformado por:\n\n "
		 + "- Sara Catalina Balbín Ramírez\n"
		 + "- Juan Manuel Cárdenas Vélez\n"
		 + "- María Paulina García Velásquez\n"
		 + "- Julián Camilo Ossa Zapata (LA NEA)\n"
		 + "- Juan Fernando Patiño Castro\n");
		
		aux.setEditable(false);
		aux.setLineWrap(true);
		aux.setWrapStyleWord(true);

		texto_1 = new JScrollPane(aux, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		texto_1.setPreferredSize(new Dimension(350, 100));
		
		texto_2 = new JTextField(); texto_2.setVisible(false);
		texto_3 = new JPasswordField(); texto_3.setVisible(false);
		
		// Definición de las partes del panel - [Fin]
		
		// Añadiendo todos los elementos al panel

		// Panel izquierdo
		panelIzquierdoArriba.add(etiqueta_1); panelIzquierdoAbajo.add(boton_1);
		panelIzquierdo.add(panelIzquierdoArriba, BorderLayout.NORTH);
		panelIzquierdo.add(panelIzquierdoAbajo);
		
		// Panel derecho
		panelDerechoArriba.add(texto_1);
		
		panelDerechoAbajoDobleA.add(boton_2); panelDerechoAbajoDobleA.add(boton_3); panelDerechoAbajoDobleA.add(boton_5);
		panelDerechoAbajoDobleB.add(etiqueta_3); panelDerechoAbajoDobleB.add(texto_2);
		panelDerechoAbajoDobleC.add(etiqueta_4); panelDerechoAbajoDobleC.add(texto_3);
		
		panelDerechoAbajo.add(panelDerechoAbajoDobleA);
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
		ControlSalir oidor2 = new ControlSalir();
		this.addMouseMotionListener(oidor);
		etiqueta_1.addMouseMotionListener(oidor);
		boton_1.addActionListener(oidor);
		boton_2.addActionListener(oidor);
		boton_3.addActionListener(oidor);
		boton_5.addActionListener(oidor);
		boton_4.addMouseMotionListener(oidor2);
	}
}