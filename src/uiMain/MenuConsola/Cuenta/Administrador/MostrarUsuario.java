/*	Clase MostrarUsuario (p�blica)         

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos (Funcionalidad solo usuario administrador)
 */

package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import control.Errores.ErrorAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class MostrarUsuario {
	
//	public void ejecutar() throws NumberFormatException, IOException {
//
//		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
//		int idCuenta;
//		byte tipoDeCuenta;
//
//		if (Cuenta.getTotalCuentas() != 0) {
//
//			//Guardado de mensaje principal
//			System.out.println();
//			sb.append("Por favor elija el tipo de usuario:\n");
//			sb.append("1: Comprador\n");
//			sb.append("2: Vendedor\n");
//			sb.append("3: Administrador\n");
//			sb.append("Selecci�n");
//
//			while (!controlError) {
//				//Control de ingreso tipo de usuario
//				tipoDeCuenta = ErrorAplicacion.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un n�mero entero positivo");
//				if (controlError) {System.out.println(); return;}
//
//				//Control de ingreso de identificaci�n de usuario
//				idCuenta = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese el n�mero identificador del usuario", "Por favor ingrese un n�mero entero positivo");
//				if (controlError) {System.out.println(); return;}
//
//				//Ejecuci�n del m�todo
//				System.out.println(usuario.mostrarUsuario(idCuenta, tipoDeCuenta));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
//			}
//		}
//		else {
//			System.out.println("No hay usuarios resgistrados a parte de tu cuenta.\n");
//		}
//	}
//	
//	@Override
//	public String toString() {return "Mostrar informaci�n de un usuario";}
}