/* 
   Clase CambiarPrecio (p�blica, hereda de OpcionDeMenu) 

   Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
              manipulando sus atributos y elementos
 */

package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class CambiarPrecio extends OpcionDeMenu {

	public void ejecutar() throws IOException {

		/*
		 * Prop�sito: Ejecutar el m�todo cambiarPrecio() haciendo los respectivos
		 * controles de error del ingreso de datos
		 */

		// Atributos
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		double precio;
		int idProducto;

		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() == 0) {

			//Guardado de mensaje principal (incluyendo lista de productos)
			sb.append("\nEsta opci�n es para cambiar el precio de un producto del cat�logo");
			sb.append("\nRecuerde que el producto debe ser de su propiedad \n");
			sb.append(vend.mostrarProductos());

			while(!controlError) {

				//Impresi�n del mensaje principal
				System.out.println(sb);

				//Ingreso del c�digo del producto
				idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto al que le desea cambiar el precio", "El dato que ingres� no es v�lido");
				if (controlError) {System.out.println(); return;}

				//Ingreso del precio del producto
				precio = ControlErrorDatos.controlReal(0.1, Double.MAX_VALUE, "Ingrese el nuevo precio del producto", "El dato que ingres� no es v�lido");
				if (controlError) {System.out.println(); return;}

				//Ejecuci�n del m�todo
				System.out.println(vend.cambiarPrecio(idProducto, precio));
			}
		}
		else {
			System.out.println("Usted a�n no ha subido ning�n producto\n");
		}
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}