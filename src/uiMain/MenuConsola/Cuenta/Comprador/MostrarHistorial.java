/*	Clase MostrarHistorial (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */

package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarHistorial extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		/*
		 * Prop�sito: Ejecutar el metodo mostrarHistorial() haciendo los respectivos
		 * controles de error del ingreso de datos
		 */

		StringBuilder sb = new StringBuilder();
		sb.append("\nUsted ha elegido la opcion para mostrar su historial de compras. �Que desea hacer?");
		sb.append("\n0. Devolverse al men� y cancelar el proceso. ");
		sb.append("\n1. Continuar con el proceso. ");

		if (!comp.getHistorial().isEmpty()) {

			sb.append("\nUsted ha elegido la opcion para mostrar su historial de compras. �Que desea hacer?");
			sb.append("\n0. Volver al men� y cancelar el proceso\n");
			sb.append("\n1. Continuar con el proceso\n");

			// Ingreso del dato por parte del usuario
			ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
			if (controlError) {System.out.println(); return;}

			// Ejecuci�n del m�todo
			System.out.println(comp.mostrarHistorial());
		}
		else {
			System.out.println("El historial est� vac�o.\n");
		}
	}

	@Override
	public String toString() {return "Mostrar historial";}
}