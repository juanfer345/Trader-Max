package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Errores.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlVaciarCarrito extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		byte seleccion=0;
		if (CarritoDeCompras.getTotalproductos() != 0) {

			//Ingreso de valores y control de error
			//seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un número entero");
			if (OpcionDeMenu.controlError || seleccion == 2) {System.out.println(); return;}

			//Ejecución del método
			System.out.println(CarritoDeCompras.vaciarCarrito());
		}
		else {
			System.out.println("Su carrito ya se encuentra vacío.\n");
		}
		
	}

	@Override
	public String toString() {return "Vaciar el carrito";}
}
