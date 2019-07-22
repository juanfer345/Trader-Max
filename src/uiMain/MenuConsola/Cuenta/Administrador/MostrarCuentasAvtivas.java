package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarCuentasAvtivas extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {

		System.out.println();
		sb.append("Usted ha elegido la opci�n para mostrar el n�mero total de cuentas.");
		sb.append("\n0: Volver al men�");
		sb.append("\n1: Continuar\n");
		
		// Ingreso del dato por parte del usuario
		ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
		if (controlError) {System.out.println(); return;}

		//Impresi�n del total de cuentas
		System.out.println(((Administrador) InicializacionAplicacion.usuarioActivo).numeroCuentas());
		if (!OpcionDeMenu.controlError)
			System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
	}

	@Override
	public String toString() {return "Mostrar el numero de cuentas activas en la aplicaci�n";}
}