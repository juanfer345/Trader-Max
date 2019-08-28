/*	Clase AgregarACarrito (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
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
//		 * Propósito: Ejecutar el metodo agregarACarrito() haciendo los respectivos
//		 * controles de error del ingreso de datos
//		 */
//
//		int idProducto, cantProd;
//
//		// Verificación de catalogo no vacío
//		if (!Cuenta.getCatalogo().isEmpty()) {
//
//			System.out.println();
//
//			while (!controlError) {
//				// Ingreso del código
//				idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE,
//						"Ingrese el código del producto que desea agregar",
//						"El dato que ingresó como código es inválido, vuelva a intentarlo");
//				if (controlError) {
//					System.out.println();
//					return;
//				}
//
//				// Ingreso de la cantidad del producto
//				cantProd = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE,
//						"Ingrese la cantidad de elementos que desea agregar",
//						"El dato que ingresó como cantidad es inválido, vuelva a intentarlo");
//				if (controlError) {
//					System.out.println();
//					return;
//				}
//
//				// Ejecución del método
//				System.out.println(CarritoDeCompras.agregarACarrito(idProducto, cantProd));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
//			}
//		} else {
//			System.out.println("No hay productos en el catálogo.\n");
//		}
	

	public String toString() {
		return "Agregar a carrito";
	}
}