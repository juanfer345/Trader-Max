/*	Clase AgregarReseña (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class AgregarResena extends OpcionDeMenu{

	@Override
	public void ejecutar() throws IOException {
		/*
		 Propósito: Ejecutar el metodo AgregarReseña() haciendo los respectivos 
		            controles de error del ingresó de datos
		 */

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		int idProducto, cantEst;
		String comentario = "";

		if (!comp.getHistorial().isEmpty()) {

			sb.append("Historial de productos comprados:\n");
			sb.append(comp.mostrarHistorial());
			while (!controlError) {

				//Impresión del historial
				System.out.println(sb);

				//Ingreso del código
				idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto", "El dato que ingresó como código es invalido, vuelva a intentarlo");
				if (controlError) {System.out.println(); return;}

				//Ingreso de las estrellas
				cantEst = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el numero de estrellas", "El dato que ingresó como numero de estrellas es invalido, vuelva a intentarlo");
				if (controlError) {System.out.println(); return;}

				//Ingreso del comentario
				comentario = ControlErrorDatos.controlString("Ingrese el comentario", "Ha ingresado un número en lugar de texto");
				if (controlError) {System.out.println(); return;}

				//Ejecución del método
				System.out.println(comp.anadirResena(idProducto, cantEst, comentario));
			}
		} else {
			System.out.println("Su historial está vacio, no puede agregar reseñas.\n");
			controlError = true;
		}
	}

	@Override
	public String toString() {return "Agregar reseña";}
}