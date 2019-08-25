package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarUsuario extends OpcionDeMenu implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		int idCuenta;
		byte tipoDeCuenta;

		if (Cuenta.getTotalCuentas() != 0) {

			//Guardado de mensaje principal
			System.out.println();
//			sb.append("Por favor elija el tipo de usuario:\n");
//			sb.append("1: Comprador\n");
//			sb.append("2: Vendedor\n");
//			sb.append("3: Administrador\n");
//			sb.append("Selecci�n");

			while (!OpcionDeMenu.controlError) {
				//Control de ingreso tipo de usuario
				//tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un n�mero entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Control de ingreso de identificaci�n de usuario
				//idCuenta = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el n�mero identificador del usuario", "Por favor ingrese un n�mero entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ejecuci�n del m�todo
			//	System.out.println(usuario.mostrarUsuario(idCuenta, tipoDeCuenta));
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			}
		}
		else {
			System.out.println("No hay usuarios resgistrados a parte de tu cuenta.\n");
		}
	}
	public String toString() {
		return "Mostrar usuario";
	}
	
}
