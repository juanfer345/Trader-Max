package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlComprarProducto extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		byte seleccion=0;
		
		if (!CarritoDeCompras.getProductos().isEmpty()) {
			// Ingreso del dato por parte del usuario
			//seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError || seleccion == 2) {System.out.println(); return;}

			//Ejecuci�n del m�todo
			System.out.println(CarritoDeCompras.comprarProductos());
		}
		else {
			System.out.println("Su carrito de compras esta vac�o, no hay ning�n producto pendiente por comprar.\n");
		}
	}

	@Override
	public String toString() {
		return "Comprar productos del carrito";
	}

}
