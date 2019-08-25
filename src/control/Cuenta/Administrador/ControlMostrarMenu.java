package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarMenu implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		int idCuenta;
		byte tipoDeCuenta;

		if (Cuenta.getTotalCuentas() != 0) {

			//Guardado de mensaje principal
			System.out.println();
//			sb.append("Elija el tipo de cuenta de la cual desea ver sus opciones de menú:\n");
//			sb.append("1: Comprador.\n");
//			sb.append("2: Vendedor.\n");
//			sb.append("3: Administrador.\n");
//			sb.append("Selección");

			while (!OpcionDeMenu.controlError) {
				//Control de ingreso tipo de usuario
				tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un número entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Control de ingreso de identificación de usuario
				idCuenta = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "ID de usuario", "Por favor ingrese un número entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ejecución del método
				System.out.println(usuario.getMenuDeConsola().mostrarOpcionesDeMenu(idCuenta, tipoDeCuenta));
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
			}
		}
		else {
			System.out.println("No hay usuarios resgistrados a parte de tu cuenta.\n");
		}
	}

	
}