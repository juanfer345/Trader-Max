/* 
   Clase IniciarSesion (p�blica, hereda de ControlErrorDatosUsuario)
   
   Prop�sito:
   Opci�n de men� del usuario, se encarga de loguear al Usuario 
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
		   Prop�sito: Ejecutar el m�todo iniciarSesion() haciendo los respectivos 
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

		// Ejecuci�n del m�todo principal con control de error
		while (!controlError) {

			// Control de ingreso de correo
			correoIngresado = controlCorreo();
			if (controlError) {
				System.out.println();
				return;
			}

			// Ingreso de contrase�a
			System.out.print("Contrase�a: ");
			if (esByte(contrasenaIngresada = br.readLine().trim()) == 0) {
				System.out.println();
				return;
			}

			// Ejecuci�n e impresi�n del m�todo
			System.out.println(usuario.iniciarSesion(tipoDeCuenta, correoIngresado, contrasenaIngresada));
			if (!controlError)
				System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
		}
	}

	public String toString() {
		return "Iniciar sesi�n";
	}
}