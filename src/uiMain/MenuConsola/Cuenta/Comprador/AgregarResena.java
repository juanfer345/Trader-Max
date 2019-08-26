/*	Clase AgregarReseña (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import control.ErrorAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class AgregarResena {

//	@Override
//	public void ejecutar() throws IOException {
//		/*
//		 Propósito: Ejecutar el metodo AgregarReseña() haciendo los respectivos 
//		            controles de error del ingresó de datos
//		 */
//
//		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
//		int idProducto;
//		byte cantEst;
//		String comentario = "";
//
//		if (!comp.getHistorial().isEmpty()) {
//
//			System.out.println();
//			sb.append("A continuación se muestra el historial con los productos que compraste. \n");
//			sb.append(comp.mostrarHistorial());
//			
//			while (!controlError) {
//
//				//Impresión del historial
//				System.out.println(sb);
//
//				//Ingreso del código
//				idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto al que le desea añadir la reseña", "El dato que ingresó como código es invalido, vuelva a intentarlo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ingreso de las estrellas
//				cantEst = ErrorAplicacion.controlByte((byte) 1, (byte) 5, "Ingrese el numero de estrellas", "El dato que ingresó como numero de estrellas es invalido, vuelva a intentarlo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ingreso del comentario
//				comentario = ErrorAplicacion.controlString("Ingrese el comentario", "Ha ingresado un número en lugar de texto");
//				if (controlError) {System.out.println(); return;}
//
//				//Ejecución del método
//				System.out.println(comp.anadirResena(idProducto, cantEst, comentario));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
//			}
//		} else {
//			System.out.println("Su historial está vacio, no puede agregar reseñas.\n");
//		}
//	}
//
//	@Override
//	public String toString() {return "Agregar reseña";}
}