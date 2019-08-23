package uiMain.vista;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class VentanaAplicacion extends JFrame {

	public static JFrame ventana;
	public static Container panelPrincipal;
	public static JMenuBar barraMenu = new JMenuBar();
	
	public VentanaAplicacion() {
//		ventana = this;
		PanelLogin panel = new PanelLogin();
		panelPrincipal = this.getContentPane();
		panelPrincipal.removeAll();
		panelPrincipal.add(panel);
		panel.asignarOyente();
	}
	
	public VentanaAplicacion(JPanel panel) {
		panelPrincipal = this.getContentPane();
		panelPrincipal.removeAll();
		panelPrincipal.add(panel);

		// Barra de menú
		setJMenuBar(barraMenu);
	}
	
	public void lanzar() {
		// Parámetros principales
		this.setTitle("TRADER-MAX INC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		organizar();
	}
	
	private void organizar() {
		pack();							// coloca los componentes
		setLocationRelativeTo(null);	// centra la ventana en la pantalla
		setVisible(true);				// visualiza la ventana
	}
}