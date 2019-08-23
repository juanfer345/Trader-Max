package uiMain.vista;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaAplicacion extends JFrame {

//	public static JFrame ventana;
	public static Container panelPrincipal;

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
	}
	
	public void lanzar() {
		// Parámetros principales
		this.setTitle("TRADER-MAX INC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		organizar();
	}
	
	public void organizar() {
		pack();							// coloca los componentes
		setLocationRelativeTo(null);	// centra la ventana en la pantalla
		setVisible(true);				// visualiza la ventana
	}
}