/*	Clase ComprarProducto (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import control.Errores.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;

public class ComprarProducto { // opcion 7

//	@Override
//	public void ejecutar() throws NumberFormatException, IOException {
//		/*
//		 Prop�sito: Ejecutar el m�todo comprarProductos() haciendo los respectivos 
//		            controles de error del ingreso de datos
//		 */
//
//		byte seleccion;
//		
//		if (!CarritoDeCompras.getProductos().isEmpty()) {
//
//			System.out.println();
//			sb.append("Su carrito tiene ").append(CarritoDeCompras.getTotalproductos()).append(" productos. ");
//			sb.append("El costo total de los productos es de ").append(CarritoDeCompras.getPrecioTotal()).append(" pesos.");
//			sb.append(" Su saldo disponible es de ").append(CarritoDeCompras.getTitular().getCuentaBancaria().getSaldo()).append(" pesos.\n");
//			sb.append("\n�Est� seguro de que desea realizar la compra?");;
//			sb.append("\n1. Continuar con el proceso");
//			sb.append("\n2. Volver al men� y cancelar el proceso\n");
//			sb.append("Selecci�n");
//
//			// Ingreso del dato por parte del usuario
//			seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
//			if (controlError || seleccion == 2) {System.out.println(); return;}
//
//			//Ejecuci�n del m�todo
//			System.out.println(CarritoDeCompras.comprarProductos());
//		}
//		else {
//			System.out.println("Su carrito de compras esta vac�o, no hay ning�n producto pendiente por comprar.\n");
//		}
//	}
//
//	@Override
//	public String toString() {
//		return "Comprar productos del carrito";
//	}
}