/*	Clase VaciarCarrito (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class VaciarCarrito extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		/*
		  Propósito: Ejecutar el metodo vaciarCarrito() haciendo los respectivos
		             controles de error del ingreso de datos
		 */

		if (CarritoDeCompras.getTotalproductos() != 0) {

			sb.append("\nSu carrito tiene " + CarritoDeCompras.getTotalproductos() + " productos\n");
			sb.append("\n¿Está seguro de que dese vaciar su carrito de compras?");
			sb.append("\n0. Volver al menú y cancelar el proceso.");
			sb.append("\n1. Continuar con el proceso.");

			//Ingreso de valores y control de error
			ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "Por favor ingrese un número entero");
			if (controlError) {System.out.println(); return;}

			//Ejecución del método
			System.out.println(CarritoDeCompras.vaciarCarrito());
		}
		else {
			System.out.println("Su carrito ya se encuentra vacío\n");
		}
	}

	@Override
	public String toString() {return "Vaciar el carrito";}
}