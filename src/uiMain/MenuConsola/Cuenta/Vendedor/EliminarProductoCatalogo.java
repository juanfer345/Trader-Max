/* 
   Clase EliminarProductoCatalogo (pública, hereda de OpcionDeMenu) 

   Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
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
//		  Propósito: Ejecutar el método eliminarProductoCatalogo() haciendo los
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
//				//Impresión del mensaje principal
//				System.out.println(sb);
//
//				//Ingreso del código del producto
//				idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto que desea eliminar del catálogo", "Por favor ingrese un número entero positivo");
//				if (controlError) {System.out.println(); return;}
//				
//				System.out.println(vend.eliminarProductoCatalogo(idProducto));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
//			}
//		}
//		else {
//			System.out.println("Usted aún no ha subido ningún producto.\n");
//		}
//	}
//
//	public String toString() {return "Eliminar producto";}
}