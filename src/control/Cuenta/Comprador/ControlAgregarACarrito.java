package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlAgregarACarrito extends OpcionDeMenu implements ActionListener {
	
	/*
	 * Propósito: Ejecutar el metodo agregarACarrito() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	int idProducto, cantProd;

	@Override
	public void actionPerformed(ActionEvent e) {

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
		String precio = JOptionPane.showInputDialog(null, "Cantidad para agregar:");
		int cant = 0;
		try {
			cant = MetodosConError.controlNumero(precio, 1, Integer.MAX_VALUE, "Cantidad",
					"Por favor ingrese una cantidad válida");
		} 
		catch (ErrorAplicacion e1) {
			JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicación: " + e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(null, CarritoDeCompras.agregarACarrito(codigo, cant), "Agregar A Carrito",
				JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public String toString() {

		// TODO Auto-generated method stub
		return "Agregar A Carrito";

	}
}