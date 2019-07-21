/* 
   Clase EliminarProductoCatalogo (p�blica, hereda de OpcionDeMenu) 

   Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
		  Prop�sito: Ejecutar el m�todo eliminarProductoCatalogo() haciendo los
		             respectivos controles de error del ingreso de datos
		 */

		// Atributos

		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		int idProducto;

		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() == 0) {

			//Guardado de mensaje principal (incluyendo lista de productos)
			sb.append("\nEsta opci�n es para eliminar un producto del c�talogo");
			sb.append("\nRecuerde que el producto a eliminar debe ser de su propiedad");
			sb.append(vend.mostrarProductos());

			while (!controlError) {

				//Impresi�n del mensaje principal
				System.out.println(sb);

				//Ingreso del c�digo del producto
				idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto que desea eliminar del cat�logo", "Por favor ingrese un n�mero entero positivo");
				if (controlError) {System.out.println(); return;}

				System.out.println(vend.eliminarProductoCatalogo(idProducto));
			}
		}
	}

	public String toString() {return "Eliminar producto";}
}