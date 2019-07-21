package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarTodasLasOpciones extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {

		//Guardado de mensaje principal
		sb.append("Usted ha elegido mostrar todas las opciones de menu:\n");
		sb.append("0: Cancelar\n");
		sb.append("1: Continuar\n");

		// Ingreso del dato por parte del usuario
		ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "El dato que ingresó es inválido, vuelva a intentarlo");
		if (controlError) {System.out.println(); return;}

		//Mostrado de todas las opciones
		System.out.println(ImprimirTodasLasOpciones());
	}

	@Override
	public String toString() {return "Mostrar todas las opciones disponibles de todas las cuentas";}
}