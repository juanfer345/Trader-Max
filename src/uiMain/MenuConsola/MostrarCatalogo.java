/*	Clase MostrarCatalogo (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola;

import java.io.IOException;

import control.ErrorAplicacion;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;

public class MostrarCatalogo {
	// Recorre toda la tabla Hash mostrando los productos

//	@Override
//	public void ejecutar() throws IOException {
//		/*
//		 Prop�sito: Ejecutar el m�todo mostrarCatalogo() haciendo los respectivos
//		            controles de error del ingreso de datos
//		 */
//
//		byte seleccion; 
//		
//		if (!Cuenta.getCatalogo().isEmpty()) {
//			
//			System.out.println();
//			sb.append("Usted ha elegido la opci�n para mostrar el cat�logo de productos. �Qu� desea hacer?");
//			sb.append("\n1. Continuar con el proceso.");
//			sb.append("\n2. Volver al men� y cancelar el proceso.\n");
//			sb.append("Seleccion");
//			
//			//Selecci�n por parte del usuario
//			seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
//			if (controlError || seleccion == 2) {System.out.println(); return;}
//
//			System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
//			if (!OpcionDeMenu.controlError)
//				System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
//		}
//		else {
//			System.out.println("El cat�logo se encuentra vac�o.\n");
//		}
//	}
//
//	@Override
//	public String toString() {return "Mostrar todos los productos";}
}