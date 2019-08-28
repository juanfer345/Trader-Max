package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Visitante.PanelCatalogo;


public class ControlMostrarCatalogo extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo mostrarCatalogo() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	String productos;

	public String getProductos() {
		if (!Cuenta.getCatalogo().isEmpty()) {
			productos = InicializacionAplicacion.usuarioActivo.mostrarCatalogo();
			return productos;
		} else {
			return "";
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		PanelCatalogo x2 = new PanelCatalogo();

		if (!Cuenta.getCatalogo().isEmpty()) {
			if (e.getSource() instanceof JMenuItem) {
				x2.lanzar();
			}

		} else {
			if (e.getSource() instanceof JMenuItem) {
				JOptionPane.showMessageDialog(null, "El catálogo se encuentra vacío", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		VentanaAplicacion.organizar();
		controlError = false;
	}

	public String toString() {
		return "Mostrar todos los productos";
	}

}
