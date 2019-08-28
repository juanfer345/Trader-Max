package uiMain.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import uiMain.InicializacionAplicacion;

public class PanelUsuario extends JPanel {

	/*
	 * Propósito: Se encarga de la parte visual del usuario registrado
	 */

	public JPanel panelCambiante = new JPanel();

	public PanelUsuario() {
		// Definición de las partes del panel - [Inicio]

		// Panelas
		this.setLayout(new BorderLayout(2, 20));
		JPanel panelFijo = new JPanel();
		panelFijo.setLayout(new GridLayout(2, 1));
		panelCambiante.setLayout(new BorderLayout(2, 1));

		panelFijo.setPreferredSize(new Dimension(1100, 50));
		panelCambiante.setPreferredSize(new Dimension (1100, 300));

		// Etiquetas
		JLabel usuario = new JLabel("Usuario: " + InicializacionAplicacion.usuarioActivo.getNombre());
		JLabel tituloPrincipal = new JLabel("Página Principal TRADER-MAX", SwingConstants.CENTER);
		JLabel mensajePrincipal = new JLabel("Bienvenido a TRADER-MAX por favor elija una opción desde el menú superior.", SwingConstants.CENTER);

		// Fuente etiquetas
		tituloPrincipal.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
		mensajePrincipal.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));

		// Definición de las partes del panel - [Fin]

		// Añadiendo todo a cada panel
		panelFijo.add(usuario);
		panelFijo.add(VentanaAplicacion.getMenuBarUsuario());

		panelCambiante.add(tituloPrincipal, BorderLayout.NORTH);
		panelCambiante.add(mensajePrincipal, BorderLayout.CENTER);

		// Juntando todos los paneles
		this.add(panelFijo, BorderLayout.NORTH); this.add(panelCambiante, BorderLayout.CENTER);
	}
}