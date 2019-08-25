package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlQuitarProductoCarrito implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int idProducto=0, cantidadProducto=0;

		//Concicional de carrito vac�o
		if (!CarritoDeCompras.getProductos().isEmpty()) {

			System.out.println("\nUsted ha elegido la opci�n para quitar un producto de su carrito.");

			while (!OpcionDeMenu.controlError) {

				//Ingreso del c�digo del producto
				//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto que desea eliminar", "El dato que ingres� como c�digo es invalido, vuelva a intentarlo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ingreso de la cantidad de producto
				//cantidadProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese la cantidad de elementos que desea eliminar", "El dato que ingres� como cantidad es invalido, vuelva a intentarlo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ejecuci�n del m�todo
				System.out.println(CarritoDeCompras.quitarProducto(idProducto, cantidadProducto));
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			}
		} 
		else {
			System.out.println("Su carrito de compras esta vac�o, no puede quitar productos.\n");
			OpcionDeMenu.controlError = true;
		}
	}

	@Override
	public String toString() {return "Quitar producto del carrito";}

}
