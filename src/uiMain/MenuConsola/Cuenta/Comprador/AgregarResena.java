/*	Clase AgregarRese�a (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
//		 Prop�sito: Ejecutar el metodo AgregarRese�a() haciendo los respectivos 
//		            controles de error del ingres� de datos
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
//			sb.append("A continuaci�n se muestra el historial con los productos que compraste. \n");
//			sb.append(comp.mostrarHistorial());
//			
//			while (!controlError) {
//
//				//Impresi�n del historial
//				System.out.println(sb);
//
//				//Ingreso del c�digo
//				idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto al que le desea a�adir la rese�a", "El dato que ingres� como c�digo es invalido, vuelva a intentarlo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ingreso de las estrellas
//				cantEst = ErrorAplicacion.controlByte((byte) 1, (byte) 5, "Ingrese el numero de estrellas", "El dato que ingres� como numero de estrellas es invalido, vuelva a intentarlo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ingreso del comentario
//				comentario = ErrorAplicacion.controlString("Ingrese el comentario", "Ha ingresado un n�mero en lugar de texto");
//				if (controlError) {System.out.println(); return;}
//
//				//Ejecuci�n del m�todo
//				System.out.println(comp.anadirResena(idProducto, cantEst, comentario));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
//			}
//		} else {
//			System.out.println("Su historial est� vacio, no puede agregar rese�as.\n");
//		}
//	}
//
//	@Override
//	public String toString() {return "Agregar rese�a";}
}