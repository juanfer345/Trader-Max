/*	Clase VaciarCarrito (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import control.ControlErrorDatos;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;

public class VaciarCarrito extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		/*
		  Propósito: Ejecutar el metodo vaciarCarrito() haciendo los respectivos
		             controles de error del ingreso de datos
		 */
		byte seleccion;
		if (CarritoDeCompras.getTotalproductos() != 0) {

			System.out.println();
			sb.append("Su carrito tiene un total de " + CarritoDeCompras.getTotalproductos() + " productos. ");
			sb.append("¿Está seguro de que desea eliminarlos todos?");
			sb.append("\n1. Continuar con el proceso.");
			sb.append("\n2. Volver al menú y cancelar el proceso.\n");
			sb.append("Selección");

			//Ingreso de valores y control de error
			seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un número entero");
			if (controlError || seleccion == 2) {System.out.println(); return;}

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