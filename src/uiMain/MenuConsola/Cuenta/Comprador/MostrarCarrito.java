package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarCarrito extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		/*
		 Propósito: Ejecutar el método mostrar carrito haciendo los respectivos 
		            controles de error del ingreso de datos
		 */

		if (!CarritoDeCompras.getProductos().isEmpty()) {

			sb.append("\nUsted ha elegido la opcion para mostrar su historial de compras. ¿Que desea hacer?");
			sb.append("\n0. Volver al menú y cancelar el proceso\n");
			sb.append("\n1. Continuar con el proceso\n");

			// Ingreso del dato por parte del usuario
			ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "El dato que ingresó es inválido, vuelva a intentarlo");
			if (controlError) {System.out.println(); return;}

			// Ejecución del método
			System.out.println(CarritoDeCompras.mostrarCarrito());
		}
		else {
			System.out.println("El carrito está vacio\n");
		}
	}

	@Override
	public String toString() {
		return "Ver el carrito de compras";
	}
}