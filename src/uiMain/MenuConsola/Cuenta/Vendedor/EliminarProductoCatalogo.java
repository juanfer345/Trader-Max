/* 
   Clase EliminarProductoCatalogo (p�blica, hereda de OpcionDeMenu) 

   Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
              manipulando sus atributos y elementos
 */

package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;

import control.ErrorAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class EliminarProductoCatalogo {

//	public void ejecutar() throws NumberFormatException, IOException {
//
//		/*
//		  Prop�sito: Ejecutar el m�todo eliminarProductoCatalogo() haciendo los
//		             respectivos controles de error del ingreso de datos
//		 */
//
//		// Atributos
//
//		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
//		int idProducto;
//
//		//Condicional para vendedores sin productos subidos
//		if (vend.getTotalDeProductosSubidos() != 0) {
//
//			//Guardado de mensaje principal (incluyendo lista de productos)
//			System.out.println();
//			System.out.println("Recuerde que el producto a eliminar debe ser de su propiedad.");
//			sb.append(vend.mostrarProductos());
//
//			while (!controlError) {
//
//				//Impresi�n del mensaje principal
//				System.out.println(sb);
//
//				//Ingreso del c�digo del producto
//				idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto que desea eliminar del cat�logo", "Por favor ingrese un n�mero entero positivo");
//				if (controlError) {System.out.println(); return;}
//				
//				System.out.println(vend.eliminarProductoCatalogo(idProducto));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
//			}
//		}
//		else {
//			System.out.println("Usted a�n no ha subido ning�n producto.\n");
//		}
//	}
//
//	public String toString() {return "Eliminar producto";}
}