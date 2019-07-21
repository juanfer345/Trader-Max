/*	Clase VaciarCarrito (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
		  Prop�sito: Ejecutar el metodo vaciarCarrito() haciendo los respectivos
		             controles de error del ingreso de datos
		 */

		if (CarritoDeCompras.getTotalproductos() != 0) {

			sb.append("\nSu carrito tiene " + CarritoDeCompras.getTotalproductos() + " productos\n");
			sb.append("\n�Est� seguro de que dese vaciar su carrito de compras?");
			sb.append("\n0. Volver al men� y cancelar el proceso.");
			sb.append("\n1. Continuar con el proceso.");

			//Ingreso de valores y control de error
			ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "Por favor ingrese un n�mero entero");
			if (controlError) {System.out.println(); return;}

			//Ejecuci�n del m�todo
			System.out.println(CarritoDeCompras.vaciarCarrito());
		}
		else {
			System.out.println("Su carrito ya se encuentra vac�o\n");
		}
	}

	@Override
	public String toString() {return "Vaciar el carrito";}
}