/*	Clase MostrarMen�Disponible (p�blica)         

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos (Funcionalidad solo usuario administrador)
 */

package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class MostrarMenuDisponible extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {

		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		byte tipoDeCuenta;

		//Guardado de mensaje principal
		System.out.println();
		sb.append("Elija el tipo de cuenta de la cual desea ver las opciones de men� disponibles:\n");
		sb.append("1: Comprador.\n");
		sb.append("2: Vendedor.\n");
		sb.append("3: Administrador.\n");
		sb.append("Selecci�n");

		tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un n�mero entero positivo");
		if (controlError) {System.out.println(); return;}

		//Ejecuci�n del m�todo
		System.out.println(usuario.getMenuDeConsola().mostrarOpcionesDisponibles(tipoDeCuenta));
	}

	@Override
	public String toString() {
		return "Mostrar las opciones disponibles de cada tipo de cuenta";
	}
}