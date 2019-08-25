/*	Clase BloqueoDeCuenta (pública)         

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */

package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class BloqueoDeCuenta {

//	@Override
//	public void ejecutar() throws IOException {
//		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
//		int idCuenta;
//		byte tipoDeCuenta, modificacion;
//
//
//		if (Cuenta.getTotalCuentas() != 0) {
//
//			//Guardado de mensaje principal
//			System.out.println();
//			sb.append("Elija el tipo de cuenta a la cual se le desea modificar su estado (las cuentas inactivas no pueden iniciar sesión)\n");
//			sb.append("1: Comprador.\n");
//			sb.append("2: Vendedor.\n");
//			sb.append("3: Administrador.\n");
//			sb.append("Selección");
//
//			while (!controlError) {
//
//				//Control de ingreso tipo de usuario
//				tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un número entero positivo");
//				if (controlError) {System.out.println(); return;}
//
//				//Control de ingreso de identificación de usuario
//				idCuenta = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "ID de usuario", "Por favor ingrese un número entero positivo");
//				if (controlError) {System.out.println(); return;}
//
//				//Control de ingreso de tipo de modificación
//				modificacion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, "Ingrese 1 para desbloquear la cuenta y 2 para bloquearla", "Por favor ingrese un número entero positivo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ejecución del método
//				System.out.println(usuario.bloquearCuenta(idCuenta, tipoDeCuenta, modificacion));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
//			}
//		}
//		else {
//			System.out.println("No hay usuarios resgistrados a parte de tu cuenta.\n");
//		}
//	}
//
//	@Override
//	public String toString() {return "Bloquear/Desbloquear la cuenta de un usuario";}
}
