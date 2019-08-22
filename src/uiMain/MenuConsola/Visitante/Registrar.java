/* 
   Clase Registrar (pública, hereda de ControlErrorDatosUsuario)

   Propósito:
   Opción de menú del usuario, se encarga de registrar a un nuevo Usuario 
   en su respectiva cuenta

   Estructuras de datos relevantes:
 */

package uiMain.MenuConsola.Visitante;

import java.io.IOException;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class Registrar extends OpcionDeMenu {

	public void ejecutar() throws IOException {

		/*
		   Propósito: Ejecutar el método registrarse() haciendo los respectivos 
		              controles de error del ingreso de datos
		 */

		// Atributos
		Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
		String nombreIngresado = null, correoIngresado = null, contrasenaIngresada = null;
		int cedulaIngresada = 0;
		byte tipoDeCuenta;

		// Guardado de mensaje
		System.out.println();
		sb.append("Por favor elija su tipo de usuario:\n");
		sb.append("1: Comprador.\n");
		sb.append("2: Vendedor.\n");
		sb.append("3: Administrador.\n");
		sb.append("Seleccion");

		// Control de ingreso tipo de cuenta
		tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un número entero");
		if (controlError) {System.out.println(); return;}

		// Control de ingreso de contraseña secreta para usuarios administradores
		if (tipoDeCuenta == 3) {
			while (true) {
				System.out.print("Contraseña secreta para registro de administradores => ");
				String contrasenaSecreta;
				if (esByte(contrasenaSecreta = br.readLine().trim()) != 0) {
					if (contrasenaSecreta.equals(Administrador.getCodigoSecreto())) {
						break;
					} else {
						System.out.println("Contraseña incorrecta, el FBI pronto llegará a su casa.");
					}
				} else {
					System.out.println();
					return;
				}
			}
		}

		// Ejecución del método de registro con control de error
		while (!controlError) {

			// Control de ingreso de nombre
			nombreIngresado = ControlErrorDatos.controlString("Nombre", "Ha ingresado un número en lugar de texto");
			if (controlError) {System.out.println(); return;}

			// Control de ingreso de cedula
			cedulaIngresada = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Cédula", "Por favor ingrese una cédula válida");
			if (controlError) {System.out.println(); return;}

			// Control de ingreso de correo
			correoIngresado = ControlErrorDatos.controlCorreo();
			if (controlError) {System.out.println(); return;}

			// Control de ingreso de contraseña
			System.out.print("Contraseña => ");
			if (esByte(contrasenaIngresada = br.readLine().trim()) == 0) {System.out.println(); return;}
			if (!ControlErrorDatos.controlContrasena(contrasenaIngresada)) {System.out.println(); return;}

			// Ejecución e impresión del método
			System.out.println(usuario.registrarse(tipoDeCuenta, nombreIngresado, correoIngresado, cedulaIngresada, contrasenaIngresada));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
		}
	}

	@Override
	public String toString() {
		return "Registrarse";
	}
}