/*	Clase MostrarTodasLasOpciones (pública)         

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos (Funcionalidad solo usuario administrador)
 */

package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import control.Errores.ErrorAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class MostrarTodasLasOpciones {

	public void ejecutar() throws NumberFormatException, IOException {

		byte seleccion;
		
//		//Guardado de mensaje principal
//		System.out.println();
//		sb.append("Usted ha elegido mostrar todas las opciones de menu existentes. ¿Que desea hacer?\n");
//		sb.append("1. Continuar con el proceso\n");
//		sb.append("2. Volver al menú y cancelar el proceso\n");
//		sb.append("Selección");
//
//		// Ingreso del dato por parte del usuario
//		seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingresó es inválido, vuelva a intentarlo");
//		if (controlError || seleccion == 2) {System.out.println(); return;}
//
//		//Mostrado de todas las opciones
//		System.out.println(ImprimirTodasLasOpciones());
	}

	public String toString() {return "Mostrar todas las opciones disponibles de todas las cuentas";}
}