/*	Clase MostrarReseñas (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.Usuarios.Cuenta;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;


public class MostrarResenas extends OpcionDeMenu {

	public void ejecutar() throws IOException {

		/*
 			Propósito: Ejecutar el método mostrarReseñas() haciendo los respectivos
	            	   controles de error del ingreso de datos
		 */
		
		int idProducto;

		if (!Cuenta.getCatalogo().isEmpty()) {
			while (!controlError) {
				
				idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto que desea agregar", "El dato que ingreso como código es invalido, vuelva a intentarlo");
				if (controlError) {System.out.println(); return;}
				
				//Comprobación de que el producto existe en el catálogo
				if (!Cuenta.getCatalogo().containsKey(idProducto)) {
					System.out.println("Código inválido.");
				} 
				else {
					System.out.println(Cuenta.getCatalogo().get(idProducto).mostrarResenas());
				}
			}
		} else {
			System.out.println("El catálogo está vacío.\n");
			controlError = true;
		}
	}

	public String toString() {return "Mostrar reseñas de un producto";}
}