/*	Clase BorrarHistorial (p�blica)         

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
//		 Prop�sito: Ejecutar el metodo BorrarHistorial() haciendo los respectivos 
//		            controles de error del ingreso de datos
//		 */
//
//		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
//		byte seleccion;
//		
//		if (!comp.getHistorial().isEmpty()) {
//			
//			System.out.println();
//			sb.append("Usted ha elegido la opci�n para borrar su historial de compras. �Que desea hacer?");
//			sb.append("\n1. Continuar con el proceso.");
//			sb.append("\n2. Volver al men� y cancelar el proceso.\n");
//			sb.append("Selecci�n");
//			
//			// Ingreso del dato por parte del usuario
//			seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
//			if (controlError || seleccion == 2) {System.out.println(); return;}
//		
//			//Ejecuci�n del m�todo
//			System.out.println(comp.borrarHistorial());
//			
//		} else {
//			System.out.println("Su historial ya se encuentra vac�o.\n");
//		}
//	}
//
//	public String toString() {
//		return "Borrar Historial";
//	}
}