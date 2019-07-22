/* 
   Clase ModificarCantidad (p�blica, hereda de OpcionDeMenu)
   
   Prop�sito:
   Opci�n de men� del usuario, le permite realizar acciones en el programa 
   manipulando sus atributos y elementos
   
   Estructuras de datos relevantes:
 */

package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class ModificarCantidad extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		
		/*
		   Prop�sito: Ejecutar el m�todo ModificarCantidad() haciendo los respectivos 
		              controles de error del ingreso de datos
		 */
		
		//Atributos
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		int idProducto, cantidad;
		byte operacion;

		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() == 0) {

			//Guardado de mensaje principal (incluyendo lista de productos)
			System.out.println();
			sb.append("Esta opci�n es para cambiar la cantidad un producto del cat�logo");
			sb.append("\nRecuerde que el producto debe ser de su propiedad \n");
			sb.append(vend.mostrarProductos());

			while(!controlError) {

				//Impresi�n del mensaje principal
				System.out.println(sb);

				//Ingreso del c�digo del producto
				idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto al que le desea cambiar el precio", "Por favor ingrese un n�mero entero positivo");
				if (controlError) {System.out.println(); return;}

				//Ingreso de la cantidad del producto
				cantidad = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el nuevo precio del producto", "Por favor ingrese un n�mero entero positivo");
				if (controlError) {System.out.println(); return;}

				//Ingreso del tipo de operaci�n
				operacion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, "Ingrese 1 para sumar la cantidad y 2 para restarla", "Por favor ingrese un n�mero entero positivo");
				if (controlError) {System.out.println(); return;}
				
				//Ejecuci�n del m�todo
				System.out.println(vend.modificarCantidad(idProducto, cantidad, operacion));
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			}
		}
	}

	public String toString() {
		return "Modificar la cantidad de un producto";
	}
}