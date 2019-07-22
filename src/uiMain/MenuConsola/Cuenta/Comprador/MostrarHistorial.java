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

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		byte seleccion;

		//Guardado de mensaje principal

		if (!comp.getHistorial().isEmpty()) {

			System.out.println();
			sb.append("Usted ha elegido la opcion para mostrar su historial de compras. �Que desea hacer?");
			sb.append("\n1. Continuar con el proceso.");
			sb.append("\n2. Volver al men� y cancelar el proceso.\n");
			sb.append("Selecci�n");

			// Ingreso del dato por parte del usuario
			seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
			if (controlError || seleccion == 2) {System.out.println(); return;}

			// Ejecuci�n del m�todo
			System.out.println(comp.mostrarHistorial());
		}
		else {
			System.out.println("Su historial se encuentra vac�o, no hay rese�as para mostrar.\n");
		}
	}

	@Override
	public String toString() {return "Mostrar historial";}
}