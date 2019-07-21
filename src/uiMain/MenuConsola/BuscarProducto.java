/*	Clase BuscarProducto (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class BuscarProducto extends OpcionDeMenu {

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		/*
		 Prop�sito: Ejecutar el metodo buscarProducto() haciendo los respectivos
		            controles de error del ingreso de datos
		            (Dependiendo del par�metro se ejecuta el m�todo que corresponde)
		 */

		String nombreProducto;
		int idProducto;
		byte seleccion;

		// Verificaci�n de catalogo no vac�o
		if (!Cuenta.getCatalogo().isEmpty()) {

			//Guardado de mensaje principal
			sb.append("\nPor favor elija el m�todo de b�squeda:\n");
			sb.append("1: Por c�digo.\n");
			sb.append("2: Por nombre.\n");

			//Selecci�n por parte del usuario
			seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
			if (seleccion == 0) {System.out.println(); return;}

			//Condicional seg�n selecci�n
			if (seleccion == 1) {

				// Selecci�n 1: B�squeda del producto por c�digo
				while (!controlError) {

					//Control del ingreso de datos
					idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto", "El dato que ingreso como c�digo es invalido, vuelva a intentarlo");
					if (controlError) {System.out.println(); return;}

					//B�squeda por c�digo
					System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(idProducto));
				}
			}
			else if (seleccion == 2) {
				// Selecci�n 2: B�squeda del producto por nombre
				while (!controlError) {

					//Control del ingreso de datos
					nombreProducto = ControlErrorDatos.controlString("Ingrese el nombre del producto", "Ha ingresado un n�mero en lugar de texto");
					if (controlError) {System.out.println(); return;}

					//B�squeda por nombre
					System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(nombreProducto));
				}
			}
		}
		else {
			System.out.println("El cat�logo se encuentra vac�o.\n");
		}
	}

	@Override
	public String toString() {return "Buscar producto.";}
}