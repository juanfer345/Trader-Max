/* 
   Clase ModificarCantidad (pública, hereda de OpcionDeMenu)
   
   Propósito:
   Opción de menú del usuario, le permite realizar acciones en el programa 
   manipulando sus atributos y elementos
   
   Estructuras de datos relevantes:
 */

package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;

import control.ErrorAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ModificarCantidad {

//	public void ejecutar() throws IOException {
//		
//		/*
//		   Propósito: Ejecutar el método ModificarCantidad() haciendo los respectivos 
//		              controles de error del ingreso de datos
//		 */
//		
//		//Atributos
//		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
//		int idProducto, cantidad;
//		byte operacion;
//
//		//Condicional para vendedores sin productos subidos
//		if (vend.getTotalDeProductosSubidos() != 0) {
//
//			//Guardado de mensaje principal (incluyendo lista de productos)
//			System.out.println("\nEsta opción es para cambiar la cantidad un producto del catálogo." + 
//			                   "\nRecuerde que el producto debe ser de su propiedad.");
//			sb.append(vend.mostrarProductos());
//
//			while(!controlError) {
//
//				//Impresión del mensaje principal
//				System.out.println(sb);
//
//				//Ingreso del código del producto
//				idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto al que le desea cambiar su cantidad", "Por favor ingrese un número entero positivo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ingreso de la cantidad del producto
//				cantidad = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese cantidad a sumar o restar", "Por favor ingrese un número entero positivo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ingreso del tipo de operación
//				operacion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, "Ingrese 1 para sumar la cantidad y 2 para restarla", "Por favor ingrese un número entero positivo");
//				if (controlError) {System.out.println(); return;}
//				
//				//Ejecución del método
//				System.out.println(vend.modificarCantidad(idProducto, cantidad, operacion));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
//			}
//		}
//		else {
//			System.out.println("Usted aún no ha subido ningún producto.\n");
//		}
//	}
//
//	public String toString() {
//		return "Modificar la cantidad de un producto";
//	}
}