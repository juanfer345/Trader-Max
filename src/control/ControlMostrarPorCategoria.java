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
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Cuenta.Vendedor.PanelVerProductos;
import uiMain.vista.Visitante.PanelBuscarCategoria;

public class ControlMostrarPorCategoria extends OpcionDeMenu implements ActionListener {

	/*
	 * Prop�sito: Ejecutar el metodo mostrarPorCategoria() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (Cuenta.getCatalogo().size() != 0) {

			String categorias[] = { "Belleza", "Veh�culos", "Deportes", "Electrodom�sticos", "Hogar", "Juegos",
					"Libros", "M�sica", "Tecnolog�a", "Vestimenta", "Vivienda" };

			String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una categoria", "CATEGORIAS",
					JOptionPane.QUESTION_MESSAGE, null, categorias, "Seleccione");

			if (seleccion != null) {

				PanelBuscarCategoria x3 = new PanelBuscarCategoria(seleccion);
				x3.lanzar();
			}
		} else {
			if (e.getSource() instanceof JMenuItem) {
				JOptionPane.showMessageDialog(null, "No hay ninguna producto en el cat�logo", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		VentanaAplicacion.organizar();
		controlError = false;
	}

	public String toString() {
		return "Mostrar productos por categor�a";
	}

}
