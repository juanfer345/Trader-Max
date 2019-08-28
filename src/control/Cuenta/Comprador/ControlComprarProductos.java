package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.OpcionDeMenu;
import gestorAplicacion.Materiales.CarritoDeCompras;

public class ControlComprarProductos extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo comprarProductos() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	public void actionPerformed(ActionEvent arg) {

		OpcionDeMenu.controlError = false;
		switch (((String) arg.getActionCommand())) {
		case "Comprar productos":
			if (!CarritoDeCompras.getProductos().isEmpty()) {
				JOptionPane.showMessageDialog(null, CarritoDeCompras.comprarProductos(), "Comprar Productos",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"Su carrito de compras esta vacío, no hay ningún producto pendiente por comprar.",
						"Comprar Productos", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	@Override
	public String toString() {
		return "Comprar productos del carrito";
	}

}
