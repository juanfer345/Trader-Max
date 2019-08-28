package control.Cuenta.Comprador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Cuenta.Comprador.PanelAgregarACarrito;
import uiMain.vista.Cuenta.Comprador.PanelMostrarCarrito;

public class ControlAgregarACarrito extends OpcionDeMenu implements ActionListener {

	int idProducto, cantProd;

	@Override
	public void actionPerformed(ActionEvent e) {

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
		String precio = JOptionPane.showInputDialog(null, "Cantidad para agregar:");
		int cant = 0;
		try {
			cant = ErrorAplicacion.controlEntero((precio), 1, Integer.MAX_VALUE, "Precio",
					"Por favor ingrese un precio válido");
		} catch (IOException e1) {
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
		return null;
	}
}