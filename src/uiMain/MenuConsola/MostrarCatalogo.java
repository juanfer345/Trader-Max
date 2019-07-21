/*	Clase MostrarCatalogo (pública)        
	
	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;

public class MostrarCatalogo extends OpcionDeMenu {
	// Recorre toda la tabla Hash mostrando los productos

	@Override
	public void ejecutar() throws IOException {
		/*
		 Propósito: Ejecutar el método mostrarCatalogo() haciendo los respectivos
		            controles de error del ingreso de datos
		 */

		byte comprobOpc;
		
		sb.append("\nUsted ha elegido la opcion para mostrar el catalogo de productos. ¿Que desea hacer?");
		sb.append("\n0. Volver al menú y cancelar el proceso ");
		sb.append("\n1. Continuar con el proceso ");

		while (!controlError) {
			
			// Ingreso del dato por parte del usuario
			System.out.println(sb);
			System.out.print("=> ");
			comprobOpc = esByte(br.readLine().trim());
			
			if (comprobOpc != 0) {
				if (comprobOpc == 1) {
					System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
				}
				else {
					System.out.println("El dato que ingresó es inválido, solo puede ingresar '0' o '1', "
							           + " vuelva a intentarlo");
				}
			}
			else {System.out.println(); return;} // Si es 0 se devuelve al menú principal
		}
	}

	@Override
	public String toString() {return "Mostrar todos los productos";}
}