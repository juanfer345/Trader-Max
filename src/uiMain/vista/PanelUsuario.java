package uiMain.vista;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uiMain.InicializacionAplicacion;

public class PanelUsuario extends JPanel {

	// Etiquetas
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

	public PanelUsuario() {
		
		// Definición de las partes del panel - [Inicio]

		// Panelas
		JPanel panelArriba = new JPanel();
		JPanel panelAbajo = new JPanel();

		this.setLayout(new GridLayout(2, 1));

		// Etiquetas
		JLabel usuario = new JLabel("Usuario: " + InicializacionAplicacion.usuarioActivo.getNombre());
		JLabel tituloPrincipal = new JLabel("Página Principal TRADER-MAX");
		JLabel mensajePrincipal = new JLabel("Bienvenido a TRADER-MAX por favor elija una opción desde el menú superior");
		
		// Fuente etiquetas
		tituloPrincipal.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
		mensajePrincipal.setFont(new Font("TimesNewRoman", Font.PLAIN, 10));
		
		// Definición de las partes del panel - [Fin]
		
		// Juntando todos los paneles
		this.add(usuario); this.add(panelArriba); this.add(panelAbajo);
	}
}