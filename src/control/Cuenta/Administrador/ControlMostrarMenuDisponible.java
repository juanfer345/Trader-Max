package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestorAplicacion.Usuarios.Administrador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarMenuDisponible extends OpcionDeMenu implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		byte tipoDeCuenta;

		//Guardado de mensaje principal
		System.out.println();
//		sb.append("Elija el tipo de cuenta de la cual desea ver las opciones de men� disponibles:\n");
//		sb.append("1: Comprador.\n");
//		sb.append("2: Vendedor.\n");
//		sb.append("3: Administrador.\n");
//		sb.append("Selecci�n");

	//	tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un n�mero entero positivo");
		if (OpcionDeMenu.controlError) {System.out.println(); return;}

		//Ejecuci�n del m�todo
//		System.out.println(usuario.getMenuDeConsola().mostrarOpcionesDisponibles(tipoDeCuenta));
	}
	public String toString() {
		return "Mostrar men� disponible";
	}
}