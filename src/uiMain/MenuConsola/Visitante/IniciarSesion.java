/* 
   Clase IniciarSesion (pública, hereda de ControlErrorDatosUsuario)
   
   Propósito:
   Opción de menú del usuario, se encarga de loguear al Usuario 
   en su respectiva cuenta
   
   Estructuras de datos relevantes:
 */

package uiMain.MenuConsola.Visitante;

import java.io.IOException;

import control.Errores.ErrorAplicacion;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class IniciarSesion {
	
//	public void ejecutar() throws IOException {
//		
//		/*
//		   Propósito: Ejecutar el método iniciarSesion() haciendo los respectivos 
//		              controles de error del ingreso de datos
//		 */
//		
//		// Atributos
//		Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
//		String correoIngresado, contrasenaIngresada;
//		byte tipoDeCuenta;
//
//		if (Cuenta.getTotalCuentas() != 0) {
//			
//			// Guardado de mensaje
//			System.out.println();
//			sb.append("Por favor elija su tipo de usuario:\n");
//			sb.append("1: Comprador.\n");
//			sb.append("2: Vendedor.\n");
//			sb.append("3: Administrador.\n");
//			sb.append("Seleccion");
//			
//			// Control de ingreso tipo de usuario
//			tipoDeCuenta = ErrorAplicacion.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un número entero positivo");
//			if (controlError) {System.out.println(); return;}
//
//			// Ejecución del método principal con control de error
//			while (!controlError) {
//
//				// Control de ingreso de correo
//				correoIngresado = ErrorAplicacion.controlCorreo();
//				if (controlError) {System.out.println();return;}
//
//				// Ingreso de contraseña
//				System.out.print("Contraseña => ");
//				if (esByte(contrasenaIngresada = br.readLine().trim()) == 0) {
//					System.out.println(); return;
//				}
//
//				//Inicio de sesión
//				System.out.println(usuario.iniciarSesion(tipoDeCuenta, correoIngresado, contrasenaIngresada));
//				if (!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
//			}
//		}
//		else {
//			System.out.println("No hay cuentas registradas en la base de datos.\n");	
//		}
//	}
//
//	public String toString() {
//		return "Iniciar sesión";
//	}
}