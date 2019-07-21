/*	Clase ComprarProducto (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class ComprarProducto extends OpcionDeMenu { // opcion 7

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		/*
		 Prop�sito: Ejecutar el metodo comprarProductos() haciendo los respectivos 
		            controles de error del ingreso de datos
		 */

		StringBuilder sb = new StringBuilder();

		if (!CarritoDeCompras.getProductos().isEmpty()) {

			sb.append("\nSu carrito tiene ").append(CarritoDeCompras.getTotalproductos()).append(" productos.\n");
			sb.append("El costo total de los productos es de ").append(CarritoDeCompras.getPrecioTotal()).append(" pesos.\n");
			sb.append("Su saldo disponible es de ").append(CarritoDeCompras.getTitular()).append(" pesos.\n");
			sb.append("\n�Est� seguro de que desea realizar la compra?");
			sb.append("\n0. Volver al men� y cancelar el proceso ");
			sb.append("\n1. Continuar con el proceso ");

			// Ingreso del dato por parte del usuario
			ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
			if (controlError) {System.out.println(); return;}

			//Ejecuci�n del m�todo
			System.out.println(CarritoDeCompras.comprarProductos());
		}
		else {
			System.out.println("\nSu carrito de compras esta vac�o \n");
		}
	}

	@Override
	public String toString() {
		return "Comprar productos en el carrito";
	}
}