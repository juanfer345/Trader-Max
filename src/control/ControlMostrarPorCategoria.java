package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.Cuenta.Vendedor.PanelVerProductos;
import uiMain.vista.Visitante.PanelBuscarCategoria;

public class ControlMostrarPorCategoria extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		PanelBuscarCategoria x3 = new PanelBuscarCategoria();

		if (InicializacionAplicacion.usuarioActivo.getCatalogo().size() != 0) {
			if (e.getSource() instanceof JMenuItem) {
				x3.lanzar();
			}
		} else {
			if (e.getSource() instanceof JMenuItem) {
				JOptionPane.showMessageDialog(null, "No hay ninguna producto en el catálogo", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public String toString() {
		return "Mostrar productos por categoría";
	}

}
