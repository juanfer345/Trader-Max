package control.Cuenta.Comprador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Cuenta.Comprador.PanelMostrarCarrito;

public class ControlMostrarCarrito extends OpcionDeMenu implements ActionListener, MouseMotionListener {
	public void mouseDragged(MouseEvent arg0) {}
	public void mouseMoved(MouseEvent arg) {}
	@Override

	public void actionPerformed(ActionEvent arg) {

		if (arg.getSource() instanceof JMenuItem) {
			// Caso A: Se elige la opción del menú y se requiere mostrar el formulario

			//Remoción de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();
			PanelUsuario panelresultados= new PanelUsuario();
			panelresultados.panelCambiante.removeAll();
			panelresultados.panelCambiante.setLayout(new BorderLayout());
			panelresultados.panelCambiante.add(new PanelMostrarCarrito());
			VentanaAplicacion.panelPrincipal.add(panelresultados, SwingConstants.CENTER);

			// Añadiendo los nuevos elementos para la ventana de usuario
		}
		VentanaAplicacion.organizar();
	}
	@Override
	public String toString() {
		return "Ver los productos del carrito";
	}

}
