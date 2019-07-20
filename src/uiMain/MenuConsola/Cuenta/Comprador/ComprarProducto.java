/*	Clase ComprarProducto (pública)        
	
	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class ComprarProducto extends OpcionDeMenu { // opcion 7

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		/*
		 Propósito: Ejecutar el metodo comprarProductos() haciendo los respectivos 
		            controles de error del ingreso de datos
		 */

		StringBuilder sb = new StringBuilder();
		sb.append("\nUsted ha elegido la opcion para comprar los productos de su carrito. ¿Que desea hacer?");
		sb.append("\n0. Devolverse al menú y cancelar el proceso ");
		sb.append("\n1. Continuar con el proceso ");

		controlError = false;
		String opcion;
		int comprobOpc;

		while (!controlError) {
			
			// Ingreso del dato por parte del usuario
			System.out.println(sb);
			System.out.print("=> ");
			opcion = br.readLine().trim();
			comprobOpc = esInt(opcion);

			/*
			 Ciclo de control de error para la opcion ingresada, pide un número
			 hasta que sea válido (puede ingresar el 0 para salir)
			*/
			while (comprobOpc == -1) {
				System.out.println("\nEl dato que ingreso es invalido, vuelva a intentarlo");
				System.out.print("Ingrese su eleccion => ");
				opcion = br.readLine().trim();
				comprobOpc = esInt(opcion);
			}
			// Verifica si alguno es cero para salirse de la opcion
			if (comprobOpc == 0) {
				controlError = true;
				System.out.println(" ");
			} else if (comprobOpc == 1) {
				// Se ejecuta el codigo cuando el usuario decide continuar
				Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
				if (!comp.getCarrito().getProductos().isEmpty()) {
					System.out.println("\nSu carrito tiene " + comp.getCarrito().getTotalproductos() + " productos ");
					System.out.println("El costo total: " + comp.getCarrito().getPrecioTotal());
					System.out.println("Su saldo disponible es: " + comp.getCuentaBancaria().getSaldo());
					String str = comp.getCarrito().comprarProductos();
					System.out.println("\n"+str + "\n");
				} else {
					System.out.println("\nSu carrito de compras esta vacio \n");
				}
				controlError = true;
			} else {
				/*
				 Si ingresa un numero diferente pero no es ninguna de las disponibles debe
				 empezar de nuevo (Empezara de nuevo el control)
				*/
				System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo");
			}
		}
	}

	@Override
	public String toString() {
		return "Comprar productos en el carrito";
	}

}