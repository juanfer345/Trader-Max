/*	Clase MostrarRese�as (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
 			Prop�sito: Ejecutar el m�todo mostrarRese�as() haciendo los respectivos
	            	   controles de error del ingreso de datos
		 */
		
		int idProducto;

		if (!Cuenta.getCatalogo().isEmpty()) {
			while (!controlError) {
				
				idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto", "El dato que ingres� como c�digo es invalido, vuelva a intentarlo");
				if (controlError) {System.out.println(); return;}
				
				//Comprobaci�n de que el producto existe en el cat�logo
				if (!Cuenta.getCatalogo().containsKey(idProducto)) {
					System.out.println("Producto no existente, intentelo de nuevo.");
				} 
				else {
					System.out.println(Cuenta.getCatalogo().get(idProducto).mostrarResenas());
				}
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			}
		} else {
			System.out.println("El cat�logo est� vac�o.\n");
			controlError = true;
		}
	}

	public String toString() {return "Mostrar rese�as de un producto";}
}