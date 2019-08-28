package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import control.OpcionDeMenu;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.vista.Cuenta.Vendedor.PanelVerProductos;


public class ControlVerProductos extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo verProductos() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;

		PanelVerProductos x3 = new PanelVerProductos();

		if (vend.getTotalDeProductosSubidos() != 0) {
			if (e.getSource() instanceof JMenuItem) {
				x3.lanzar();
			}
		} else {
			if (e.getSource() instanceof JMenuItem) {
				JOptionPane.showMessageDialog(null, "Usted no ha subido ningun producto", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	@Override
	public String toString() {
		return "Ver productos subidos";
	}

}