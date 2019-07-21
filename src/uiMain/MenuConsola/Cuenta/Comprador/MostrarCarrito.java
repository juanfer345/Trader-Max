package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class MostrarCarrito extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		/*
		 Propósito: Ejecutar el método mostrar carrito haciendo los respectivos 
		            controles de error del ingreso de datos
		 */
		
		sb.append("\nUsted ha elegido la opción para mostrar los elementos en el carrito. ¿Qué desea hacer?");
		sb.append("\n0. Devolverse al menú y cancelar el proceso. ");
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
			 Ciclo de control de error para la opcion ingresada, pide un número
			 hasta que sea válido (puede ingresar el 0 para salir)
			*/
			while (comprobOpc == -1) {
				System.out.println("\nEl dato que ingresó es inválido, vuelva a intentarlo.");
				System.out.print("Ingrese su elección \n=> ");
				opcion = br.readLine().trim();
				comprobOpc = esInt(opcion);
			}
			
			// Verifica si alguno es cero para salirse de la opción
			if (comprobOpc == 0) {
				controlError = true;
				System.out.println(" ");
			} else if (comprobOpc == 1) {
				// Se ejecuta el codigo cuando el usuario decide continuar
				Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
				comp.mostrarCarrito();
				controlError = true;
			} else {
				/*
				  Si ingresa un número diferente pero no corresponde a ninguna de las opciones 
				  disponibles debe empezar de nuevo (Empezará de nuevo el control)
				*/
				System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo.");
			}
		}
		
	}

	@Override
	public String toString() {
		return "Ver el carrito de compras";
		
	}

}
