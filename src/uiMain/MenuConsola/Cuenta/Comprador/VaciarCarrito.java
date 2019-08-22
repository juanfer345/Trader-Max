/*	Clase VaciarCarrito (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
		  Prop�sito: Ejecutar el metodo vaciarCarrito() haciendo los respectivos
		             controles de error del ingreso de datos
		 */
		byte seleccion;
		if (CarritoDeCompras.getTotalproductos() != 0) {

			System.out.println();
			sb.append("Su carrito tiene un total de " + CarritoDeCompras.getTotalproductos() + " productos. ");
			sb.append("�Est� seguro de que desea eliminarlos todos?");
			sb.append("\n1. Continuar con el proceso.");
			sb.append("\n2. Volver al men� y cancelar el proceso.\n");
			sb.append("Selecci�n");

			//Ingreso de valores y control de error
			seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
			if (controlError || seleccion == 2) {System.out.println(); return;}

			//Ejecuci�n del m�todo
			System.out.println(CarritoDeCompras.vaciarCarrito());
		}
		else {
			System.out.println("Su carrito ya se encuentra vac�o.\n");
		}
	}

	@Override
	public String toString() {return "Vaciar el carrito";}
}