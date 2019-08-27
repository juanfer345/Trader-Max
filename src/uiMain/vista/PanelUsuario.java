package uiMain.vista;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import uiMain.InicializacionAplicacion;

public class PanelUsuario extends JPanel {

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
		
		// Añadiendo todo a cada panel
		
		panelArriba.add(usuario);
		//PENDIENTE PARA QUE SALGA ORGANIZARO
		
		// Juntando todos los paneles
		this.add(usuario); this.add(panelArriba); this.add(panelAbajo);
	}
}