package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlBloqueoDeCuenta extends OpcionDeMenu implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		int idCuenta;
		byte tipoDeCuenta, modificacion;

		if (Cuenta.getTotalCuentas() != 0) {

			// Guardado de mensaje principal
			System.out.println();

			while (!OpcionDeMenu.controlError) {

				// Control de ingreso tipo de usuario
				// tipoDeCuenta = ErrorAplicacion.controlByte((byte) 1, (byte) 3,
				// sb.toString(), "Por favor ingrese un n�mero entero positivo");
				if (OpcionDeMenu.controlError) {
					System.out.println();
					return;
				}

				// Control de ingreso de identificaci�n de usuario
				// idCuenta = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "ID de
				// usuario", "Por favor ingrese un n�mero entero positivo");
				if (OpcionDeMenu.controlError) {
					System.out.println();
					return;
				}

				// Control de ingreso de tipo de modificaci�n
				// modificacion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, "Ingrese 1
				// para desbloquear la cuenta y 2 para bloquearla", "Por favor ingrese un n�mero
				// entero positivo");
				if (OpcionDeMenu.controlError) {
					System.out.println();
					return;
				}

				// Ejecuci�n del m�todo
				// System.out.println(usuario.bloquearCuenta(idCuenta, tipoDeCuenta,
				// modificacion));
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			}
		} else {
			System.out.println("No hay usuarios resgistrados a parte de tu cuenta.\n");
		}
	}

	public String toString() {
		return "Bloqueo de cuentas";
	}

}