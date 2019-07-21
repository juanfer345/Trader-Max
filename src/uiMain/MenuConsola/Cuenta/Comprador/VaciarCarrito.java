/*	Clase VaciarCarrito (p�blica)        
	
	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class VaciarCarrito extends OpcionDeMenu { // opcion 8

	@Override
	public void ejecutar() throws IOException {
		/*
		  Prop�sito: Ejecutar el metodo vaciarCarrito() haciendo los respectivos
		             controles de error del ingreso de datos
		 */
		sb.append("\nUsted ha elegido la opci�n para vaciar su carrito de compras. �Qu� desea hacer?");
		sb.append("\n0. Devolverse al men� y cancelar el proceso. ");
		sb.append("\n1. Continuar con el proceso. ");

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
			 Ciclo de control de error para la opcion ingresada, pide un n�mero hasta que
			 sea v�lido (puede ingresar el 0 para salir)
			*/
			while (comprobOpc == -1) {
				System.out.println("\nEl dato que ingres� es inv�lido, vuelva a intentarlo.");
				System.out.print("Ingrese su elecci�n \n=> ");
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
				System.out.println("\nSu carrito tiene " + comp.getCarrito().getTotalproductos() + " productos. ");
				String str = comp.getCarrito().vaciarCarrito();
				System.out.println(str + "\n");
				controlError = true;
			} else {
				/*
				 Si ingresa un numero diferente pero no es ninguna de las disponibles debe
				 empezar de nuevo (Empezara de nuevo el control)
				*/
				System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo.");
			}
		}
	}

	@Override
	public String toString() {
		return "Vaciar el carrito";
	}
}