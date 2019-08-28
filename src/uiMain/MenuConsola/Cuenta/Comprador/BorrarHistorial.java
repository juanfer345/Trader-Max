/*	Clase BorrarHistorial (pública)         

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */

package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import control.Errores.ErrorAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class BorrarHistorial {

//	public void ejecutar() throws IOException {
//		/*
//		 Propósito: Ejecutar el metodo BorrarHistorial() haciendo los respectivos 
//		            controles de error del ingreso de datos
//		 */
//
//		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
//		byte seleccion;
//		
//		if (!comp.getHistorial().isEmpty()) {
//			
//			System.out.println();
//			sb.append("Usted ha elegido la opción para borrar su historial de compras. ¿Que desea hacer?");
//			sb.append("\n1. Continuar con el proceso.");
//			sb.append("\n2. Volver al menú y cancelar el proceso.\n");
//			sb.append("Selección");
//			
//			// Ingreso del dato por parte del usuario
//			seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingresó es inválido, vuelva a intentarlo");
//			if (controlError || seleccion == 2) {System.out.println(); return;}
//		
//			//Ejecución del método
//			System.out.println(comp.borrarHistorial());
//			
//		} else {
//			System.out.println("Su historial ya se encuentra vacío.\n");
//		}
//	}
//
//	public String toString() {
//		return "Borrar Historial";
//	}
}