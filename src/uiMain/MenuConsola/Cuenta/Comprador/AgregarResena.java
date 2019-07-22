/*	Clase AgregarRese�a (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class AgregarResena extends OpcionDeMenu{

	@Override
	public void ejecutar() throws IOException {
		/*
		 Prop�sito: Ejecutar el metodo AgregarRese�a() haciendo los respectivos 
		            controles de error del ingres� de datos
		 */

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		int idProducto, cantEst;
		String comentario = "";

		if (!comp.getHistorial().isEmpty()) {

			sb.append("Historial de productos comprados:\n");
			sb.append(comp.mostrarHistorial());
			while (!controlError) {

				//Impresi�n del historial
				System.out.println(sb);

				//Ingreso del c�digo
				idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto", "El dato que ingres� como c�digo es invalido, vuelva a intentarlo");
				if (controlError) {System.out.println(); return;}

				//Ingreso de las estrellas
				cantEst = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el numero de estrellas", "El dato que ingres� como numero de estrellas es invalido, vuelva a intentarlo");
				if (controlError) {System.out.println(); return;}

				//Ingreso del comentario
				comentario = ControlErrorDatos.controlString("Ingrese el comentario", "Ha ingresado un n�mero en lugar de texto");
				if (controlError) {System.out.println(); return;}

				//Ejecuci�n del m�todo
				System.out.println(comp.anadirResena(idProducto, cantEst, comentario));
			}
		} else {
			System.out.println("Su historial est� vacio, no puede agregar rese�as.\n");
			controlError = true;
		}
	}

	@Override
	public String toString() {return "Agregar rese�a";}
}