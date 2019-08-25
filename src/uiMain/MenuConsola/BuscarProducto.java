/*	Clase BuscarProducto (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola;

import java.io.IOException;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;

public class BuscarProducto {

//	@Override
//	public void ejecutar() throws NumberFormatException, IOException {
//		/*
//		 Propósito: Ejecutar el metodo buscarProducto() haciendo los respectivos
//		            controles de error del ingreso de datos
//		            (Dependiendo del parámetro se ejecuta el método que corresponde)
//		 */
//
//		String nombreProducto;
//		int idProducto;
//		byte seleccion;
//
//		// Verificación de catalogo no vacío
//		if (!Cuenta.getCatalogo().isEmpty()) {
//
//			//Guardado de mensaje principal
//			System.out.println();
//			sb.append("Por favor elija el método de búsqueda:\n");
//			sb.append("1: Por código.\n");
//			sb.append("2: Por nombre.\n");
//			sb.append("selección");
//			
//			//Selección por parte del usuario
//			seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un número entero");
//			if (controlError) {System.out.println(); return;}
//
//			//Condicional según selección
//			if (seleccion == 1) {
//
//				// Selección 1: Búsqueda del producto por código
//				while (!controlError) {
//
//					//Control del ingreso de datos
//					idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto", "El dato que ingresó como código es invalido, vuelva a intentarlo");
//					if (controlError) {System.out.println(); return;}
//
//					//Búsqueda por código
//					System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(idProducto));
//					if (!OpcionDeMenu.controlError)
//						System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
//				}
//			}
//			else if (seleccion == 2) {
//				// Selección 2: Búsqueda del producto por nombre
//				while (!controlError) {
//
//					//Control del ingreso de datos
//					nombreProducto = ControlErrorDatos.controlString("Ingrese el nombre del producto", "Ha ingresado un número en lugar de texto");
//					if (controlError) {System.out.println(); return;}
//
//					//Búsqueda por nombre
//					System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(nombreProducto));
//					if (!OpcionDeMenu.controlError)
//						System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
//				}
//			}
//		}
//		else {
//			System.out.println("El catálogo se encuentra vacío.\n");
//		}
//	}
//
//	@Override
//	public String toString() {return "Buscar producto";}
}