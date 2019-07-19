/* 
   Clase IniciarSesion (pública, hereda de ControlErrorDatosUsuario)
   
   Propósito:
   Opción de menú del usuario, se encarga de loguear al Usuario 
   en su respectiva cuenta
   
   Estructuras de datos relevantes:
 */

package uiMain.MenuConsola.Visitante;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Visitante;

public class IniciarSesion extends ControlErrorDatosUsuario {
	
	public void ejecutar() throws IOException {
		
		/*
		   Propósito: Ejecutar el método iniciarSesion() haciendo los respectivos 
		              controles de error del ingreso de datos
		 */
		
		// Atributos
		Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
		String correoIngresado, contrasenaIngresada;
		byte tipoDeCuenta;

		// Control de ingreso tipo de usuario
		tipoDeCuenta = controlTipoDeCuenta();
		if (controlError) {
			System.out.println();
			return;
		}

		// Ejecución del método principal con control de error
		while (!controlError) {

			// Control de ingreso de correo
			correoIngresado = controlCorreo();
			if (controlError) {
				System.out.println();
				return;
			}

			// Ingreso de contraseña
			System.out.print("Contraseña: ");
			if (esByte(contrasenaIngresada = br.readLine().trim()) == 0) {
				System.out.println();
				return;
			}

			// Ejecución e impresión del método
			System.out.println(usuario.iniciarSesion(tipoDeCuenta, correoIngresado, contrasenaIngresada));
			if (!controlError)
				System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
		}
	}

	public String toString() {
		return "Iniciar sesión";
	}
}