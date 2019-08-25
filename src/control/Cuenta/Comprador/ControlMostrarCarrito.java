package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarCarrito extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		byte seleccion=0;
		
		if (!CarritoDeCompras.getProductos().isEmpty()) {

			// Ingreso del dato por parte del usuario
			//seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingresó es inválido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError || seleccion == 2) {System.out.println(); return;}

			// Ejecución del método
			System.out.println(CarritoDeCompras.mostrarCarrito());
		}
		else {
			System.out.println("Su carrito de compras está vacío.\n");
		}
	}

	@Override
	public String toString() {
		return "Ver los productos del carrito";
	}

}
