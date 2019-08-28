package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.vista.PanelBuscarProducto;

public class ControlBuscarProducto extends OpcionDeMenu implements ActionListener {
	PanelBuscarProducto buscarprod;
	String resultado;

	/*
	 * Prop�sito: Ejecutar el metodo buscarProducto() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent arg) {

		// Verificaci�n de catalogo no vac�o
		if (!Cuenta.getCatalogo().isEmpty()) {
			Object[] opciones = { "Si", "No" };

			int resp = JOptionPane.showOptionDialog(null, "Buscar el producto por c�digo", "Buscar producto",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

			if (JOptionPane.OK_OPTION == resp) {
				String cod = JOptionPane.showInputDialog(null, "C�digo del producto");
				if (cod != null) {
					try {
						int codigo = MetodosConError.controlNumero((cod), 1, Integer.MAX_VALUE, "C�digo",
								"Por favor ingrese un codigo v�lido");
						JOptionPane.showMessageDialog(null,
								InicializacionAplicacion.usuarioActivo.buscarProducto(codigo), "Notificaci�n",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (ErrorAplicacion e1) {
						JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicaci�n: " + e1.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else {
					return;
				}
			} else {
				Object[] opciones2 = { "Si", "No" };

				int resp2 = JOptionPane.showOptionDialog(null, "Buscar el producto por nombre", "Buscar Producto",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones[0]);

				if (JOptionPane.OK_OPTION == resp2) {
					String cod = JOptionPane.showInputDialog(null, "Nombre del producto");
					if (cod != null) {
						try {
							String codigo = MetodosConError.controlString((cod), "Nombre",
									"Por favor ingrese un nombre v�lido");
							JOptionPane.showMessageDialog(null,
									InicializacionAplicacion.usuarioActivo.buscarProducto(codigo), "Notificaci�n",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (ErrorAplicacion e1) {
							JOptionPane.showMessageDialog(null,
									"Manejo de errores de la Aplicaci�n: " + e1.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					} else {
						return;
					}
				}
			}
		}
	}

	public String toString() {
		return "Buscar producto";
	}

}
