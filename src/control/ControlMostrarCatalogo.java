package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.Visitante.PanelCatalogoGeneral;
import uiMain.vista.Visitante.VentanaCatalogo;

public class ControlMostrarCatalogo extends OpcionDeMenu implements ActionListener {

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

		VentanaCatalogo x = new VentanaCatalogo();
		PanelCatalogoGeneral x2 = new PanelCatalogoGeneral();
		if (!Cuenta.getCatalogo().isEmpty()) {
			if (e.getSource() instanceof JMenuItem) {
				x.lanzar();
				x2.lanzar();
			}

		} else {
			if (e.getSource() instanceof JMenuItem) {
				JOptionPane.showMessageDialog(null, "El cat�logo se encuentra vac�o", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				//x.lanzar();
			}
		}

	}

	public String toString() {
		return "Mostrar todos los productos";
	}

}
