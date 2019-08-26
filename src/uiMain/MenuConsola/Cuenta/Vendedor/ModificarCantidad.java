/* 
   Clase ModificarCantidad (p�blica, hereda de OpcionDeMenu)
   
   Prop�sito:
   Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
//		   Prop�sito: Ejecutar el m�todo ModificarCantidad() haciendo los respectivos 
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
//			System.out.println("\nEsta opci�n es para cambiar la cantidad un producto del cat�logo." + 
//			                   "\nRecuerde que el producto debe ser de su propiedad.");
//			sb.append(vend.mostrarProductos());
//
//			while(!controlError) {
//
//				//Impresi�n del mensaje principal
//				System.out.println(sb);
//
//				//Ingreso del c�digo del producto
//				idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto al que le desea cambiar su cantidad", "Por favor ingrese un n�mero entero positivo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ingreso de la cantidad del producto
//				cantidad = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese cantidad a sumar o restar", "Por favor ingrese un n�mero entero positivo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ingreso del tipo de operaci�n
//				operacion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, "Ingrese 1 para sumar la cantidad y 2 para restarla", "Por favor ingrese un n�mero entero positivo");
//				if (controlError) {System.out.println(); return;}
//				
//				//Ejecuci�n del m�todo
//				System.out.println(vend.modificarCantidad(idProducto, cantidad, operacion));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
//			}
//		}
//		else {
//			System.out.println("Usted a�n no ha subido ning�n producto.\n");
//		}
//	}
//
//	public String toString() {
//		return "Modificar la cantidad de un producto";
//	}
}