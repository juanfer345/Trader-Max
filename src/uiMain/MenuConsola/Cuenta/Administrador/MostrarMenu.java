package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarMenu extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {

		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		int idCuenta;
		byte tipoDeCuenta;

		while (!controlError) {
			//Control de ingreso tipo de usuario
			tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un n�mero entero positivo");
			if (controlError) {System.out.println(); return;}

			//Control de ingreso de identificaci�n de usuario
			idCuenta = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "ID de usuario", "Por favor ingrese un n�mero entero positivo");
			if (controlError) {System.out.println(); return;}

			//Ejecuci�n del m�todo
			System.out.println(usuario.getMenuDeConsola().mostrarOpcionesDeMenu(idCuenta, tipoDeCuenta));
		}
	}

	@Override
	public String toString() {return "Mostrar men� de un usuaio";}
}