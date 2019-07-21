package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarMenuDisponible extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {

		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		byte tipoDeCuenta;

		tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un número entero positivo");
		if (controlError) {System.out.println(); return;}

		//Ejecución del método
		System.out.println(usuario.getMenuDeConsola().mostrarOpcionesDisponibles(tipoDeCuenta));
	}

	@Override
	public String toString() {
		return "Mostrar las opciones disponibles de cada tipo de cuenta";
	}
}