package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.OpcionDeMenu;
import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;

public class ControlCambiarPrecio extends OpcionDeMenu implements ActionListener {

	/*
	 * Prop�sito: Ejecutar el metodo cambiarPrecio() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	public void actionPerformed(ActionEvent e) {
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
		String precio = JOptionPane.showInputDialog(null, "Nuevo precio del producto:");
		int pre = 0;

		try {
			pre = MetodosConError.controlNumero(precio, 1, Integer.MAX_VALUE, "Precio", "Por favor ingrese un precio v�lido");
		}
		catch (ErrorAplicacion a) {
			JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		vend.cambiarPrecio(codigo, pre);
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}