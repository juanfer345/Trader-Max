package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlModificarCantidad extends OpcionDeMenu implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
		int cant_existente = vend.getCatalogo().get(codigo).getCantidad();
		String opciones[] = { "Aumentar", "Disminuir" };
		String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una accion", "OPERACION",
				JOptionPane.QUESTION_MESSAGE, null, opciones, "Seleccione");
		String cant = JOptionPane.showInputDialog(null, "Ingrese la cantidad que desea " + seleccion);
		int c = 0;
		try {
			c = MetodosConError.controlNumero(cant, 1, Integer.MAX_VALUE, "Cantidad",
					"Por favor ingrese una cantidad válida");
		} catch (ErrorAplicacion e1) {
			JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicación: " + e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (seleccion.equals("Aumentar")) {
			vend.modificarCantidad(codigo, c, (byte) 1);
		} else if (seleccion.equals("Disminuir")) {
			String x = vend.modificarCantidad(codigo, c, (byte) 2);
			if (x.equals("No se puede")) {
				try {
					MetodosConError.errorNegativo(cant_existente, c, "No hay suficientes productos");
				} catch (ErrorAplicacion a) {
					JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}
	}
	public String toString() {
		return "Modificar la cantidad de un producto";
	}

}