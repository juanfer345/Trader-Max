package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import control.Errores.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;

public class MostrarCarrito {

//	@Override
//	public void ejecutar() throws IOException {
//		/*
//		 Propósito: Ejecutar el método mostrar carrito haciendo los respectivos 
//		            controles de error del ingreso de datos
//		 */
//
//		byte seleccion;
//		
//		if (!CarritoDeCompras.getProductos().isEmpty()) {
//
//			System.out.println();
//			sb.append("Usted ha elegido la opcion para mostrar su carrito de compras. ¿Que desea hacer?\n");
//			sb.append("1. Continuar con el proceso\n");
//			sb.append("2. Volver al menú y cancelar el proceso\n");
//			sb.append("Selección");
//
//			// Ingreso del dato por parte del usuario
//			seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingresó es inválido, vuelva a intentarlo");
//			if (controlError || seleccion == 2) {System.out.println(); return;}
//
//			// Ejecución del método
//			System.out.println(CarritoDeCompras.mostrarCarrito());
//		}
//		else {
//			System.out.println("Su carrito de compras está vacío.\n");
//		}
//	}
//
//	@Override
//	public String toString() {
//		return "Ver los productos del carrito";
//	}
}