package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.OpcionDeMenu;
import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Materiales.CarritoDeCompras;

public class ControlQuitarProductoCarrito extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo quitarProducto() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
		Object[] opciones = { "Si", "No" };

		int resp = JOptionPane.showOptionDialog(null, "¿Está seguro que desea quitar el producto?",
				"Quitar Producto de Carrito", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,
				opciones[0]);

		if (JOptionPane.OK_OPTION == resp) {
			String precio = JOptionPane.showInputDialog(null, "Cantidad para quitar:");
			try {
				int cant = MetodosConError.controlNumero((precio), 1, Integer.MAX_VALUE, "Cantidad",
						"Por favor ingrese un precio válido");
				JOptionPane.showMessageDialog(null, CarritoDeCompras.quitarProducto(codigo, cant), "Notificación",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (ErrorAplicacion e1) {
				JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicación: " + e1.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}

	@Override
	public String toString() {return "Quitar producto del carrito";}
}