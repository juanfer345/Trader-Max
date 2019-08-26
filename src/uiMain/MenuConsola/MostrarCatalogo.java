/*	Clase MostrarCatalogo (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
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
//		 Propósito: Ejecutar el método mostrarCatalogo() haciendo los respectivos
//		            controles de error del ingreso de datos
//		 */
//
//		byte seleccion; 
//		
//		if (!Cuenta.getCatalogo().isEmpty()) {
//			
//			System.out.println();
//			sb.append("Usted ha elegido la opción para mostrar el catálogo de productos. ¿Qué desea hacer?");
//			sb.append("\n1. Continuar con el proceso.");
//			sb.append("\n2. Volver al menú y cancelar el proceso.\n");
//			sb.append("Seleccion");
//			
//			//Selección por parte del usuario
//			seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un número entero");
//			if (controlError || seleccion == 2) {System.out.println(); return;}
//
//			System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
//			if (!OpcionDeMenu.controlError)
//				System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
//		}
//		else {
//			System.out.println("El catálogo se encuentra vacío.\n");
//		}
//	}
//
//	@Override
//	public String toString() {return "Mostrar todos los productos";}
}