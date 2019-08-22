/*	Clase QuitarProductoCarrito (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import control.ControlErrorDatos;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;

public class QuitarProductoCarrito extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		/*
		 Prop�sito: Ejecutar el metodo quitarProducto() haciendo los respectivos 
		            controles de error del ingreso de datos
		 */

		int idProducto, cantidadProducto;

		//Concicional de carrito vac�o
		if (!CarritoDeCompras.getProductos().isEmpty()) {

			System.out.println("\nUsted ha elegido la opci�n para quitar un producto de su carrito.");

			while (!controlError) {

				//Ingreso del c�digo del producto
				idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto que desea eliminar", "El dato que ingres� como c�digo es invalido, vuelva a intentarlo");
				if (controlError) {System.out.println(); return;}

				//Ingreso de la cantidad de producto
				cantidadProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese la cantidad de elementos que desea eliminar", "El dato que ingres� como cantidad es invalido, vuelva a intentarlo");
				if (controlError) {System.out.println(); return;}

				//Ejecuci�n del m�todo
				System.out.println(CarritoDeCompras.quitarProducto(idProducto, cantidadProducto));
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			}
		} 
		else {
			System.out.println("Su carrito de compras esta vac�o, no puede quitar productos.\n");
			controlError = true;
		}
	}

	@Override
	public String toString() {return "Quitar producto del carrito";}
}