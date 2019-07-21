/* 
   Clase EliminarProductoCatalogo (pública, hereda de OpcionDeMenu) 

   Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
              manipulando sus atributos y elementos
 */

package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class EliminarProductoCatalogo extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {

		/*
		  Propósito: Ejecutar el método eliminarProductoCatalogo() haciendo los
		             respectivos controles de error del ingreso de datos
		 */

		// Atributos

		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		int idProducto;

		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() == 0) {

			//Guardado de mensaje principal (incluyendo lista de productos)
			sb.append("\nEsta opción es para eliminar un producto del cátalogo");
			sb.append("\nRecuerde que el producto a eliminar debe ser de su propiedad");
			sb.append(vend.mostrarProductos());

			while (!controlError) {

				//Impresión del mensaje principal
				System.out.println(sb);

				//Ingreso del código del producto
				idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto que desea eliminar del catálogo", "Por favor ingrese un número entero positivo");
				if (controlError) {System.out.println(); return;}

				System.out.println(vend.eliminarProductoCatalogo(idProducto));
			}
		}
	}

	public String toString() {return "Eliminar producto";}
}