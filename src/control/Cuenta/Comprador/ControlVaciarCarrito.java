package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.OpcionDeMenu;
import gestorAplicacion.Materiales.CarritoDeCompras;

public class ControlVaciarCarrito extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo vaciarCarrito() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		byte seleccion=0;
		if (CarritoDeCompras.getTotalproductos() != 0) {

			//Ingreso de valores y control de error
			//seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un número entero");
			if (OpcionDeMenu.controlError || seleccion == 2) {System.out.println(); return;}
		}
	}

	@Override
	public String toString() {return "Vaciar el carrito";}
}