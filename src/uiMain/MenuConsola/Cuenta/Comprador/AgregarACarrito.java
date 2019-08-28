/*	Clase AgregarACarrito (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import control.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.MenuConsola.OpcionDeMenu;

	public class AgregarACarrito {
//
//	public void ejecutar() throws NumberFormatException, IOException {
//		/*
//		 * Prop�sito: Ejecutar el metodo agregarACarrito() haciendo los respectivos
//		 * controles de error del ingreso de datos
//		 */
//
//		int idProducto, cantProd;
//
//		// Verificaci�n de catalogo no vac�o
//		if (!Cuenta.getCatalogo().isEmpty()) {
//
//			System.out.println();
//
//			while (!controlError) {
//				// Ingreso del c�digo
//				idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE,
//						"Ingrese el c�digo del producto que desea agregar",
//						"El dato que ingres� como c�digo es inv�lido, vuelva a intentarlo");
//				if (controlError) {
//					System.out.println();
//					return;
//				}
//
//				// Ingreso de la cantidad del producto
//				cantProd = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE,
//						"Ingrese la cantidad de elementos que desea agregar",
//						"El dato que ingres� como cantidad es inv�lido, vuelva a intentarlo");
//				if (controlError) {
//					System.out.println();
//					return;
//				}
//
//				// Ejecuci�n del m�todo
//				System.out.println(CarritoDeCompras.agregarACarrito(idProducto, cantProd));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
//			}
//		} else {
//			System.out.println("No hay productos en el cat�logo.\n");
//		}
	

	public String toString() {
		return "Agregar a carrito";
	}
}