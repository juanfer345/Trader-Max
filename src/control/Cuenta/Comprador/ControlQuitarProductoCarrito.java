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

		//Concicional de carrito vacío
		if (!CarritoDeCompras.getProductos().isEmpty()) {

			System.out.println("\nUsted ha elegido la opción para quitar un producto de su carrito.");

			while (!OpcionDeMenu.controlError) {

				//Ingreso del código del producto
				//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto que desea eliminar", "El dato que ingresó como código es invalido, vuelva a intentarlo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ingreso de la cantidad de producto
				//cantidadProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese la cantidad de elementos que desea eliminar", "El dato que ingresó como cantidad es invalido, vuelva a intentarlo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ejecución del método
				System.out.println(CarritoDeCompras.quitarProducto(idProducto, cantidadProducto));
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
			}
		} 
		else {
			System.out.println("Su carrito de compras esta vacío, no puede quitar productos.\n");
			OpcionDeMenu.controlError = true;
		}
	}

	@Override
	public String toString() {return "Quitar producto del carrito";}

}
