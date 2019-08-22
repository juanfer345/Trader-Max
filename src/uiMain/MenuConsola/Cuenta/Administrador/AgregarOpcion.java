/*	Clase AgregarOpcion (p�blica)         

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos (Funcionalidad solo usuario administrador)
 */
package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.MenuConsola.OpcionDeMenu;

public class AgregarOpcion extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {

		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		String menuOpcionesDisponibles = null, auxiliar;
		int idUsuario = 0;
		byte tipoDeCuenta = 0, opcionUsuario = 0;

		if (Cuenta.getTotalCuentas() != 0) {

			//Guardado de mensaje principal
			System.out.println();
			sb.append("Elija el tipo de cuenta a la cual se le desea agregar la opci�n\n");
			sb.append("1: Comprador.\n");
			sb.append("2: Vendedor.\n");
			sb.append("3: Administrador.\n");
			sb.append("Selecci�n");

			//Control de ingreso tipo de usuario
			tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un n�mero entero");
			if (controlError) {System.out.println(); return;}

			while (!controlError) {
				//Control de ingreso de identificaci�n de usuario
				idUsuario = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Por favor ingrese el n�mero identificador del usuario", "El identificador del usuario debe ser un n�mero entero");
				if (controlError) {System.out.println(); return;}

				if (idUsuario == usuario.getId() && tipoDeCuenta == 3) {

					System.out.println("\nNo es permitido que elimines opciones de tu propia cuenta, ingresa otra identificaci�n.\n");
				}
				else {
					//Impresi�n de las opciones de men� del usuario
					auxiliar = usuario.getMenuDeConsola().mostrarOpcionesDeMenu(idUsuario, tipoDeCuenta);
					if (controlError) {

						System.out.println(auxiliar);
						controlError = false;

						//Guardado de las opciones disponibles a agregar
						menuOpcionesDisponibles = usuario.getMenuDeConsola().comprobarCantidadOpciones(idUsuario, tipoDeCuenta, (byte) 1);
						if (controlError) {controlError = false; break;}
						System.out.println(menuOpcionesDisponibles);
					}
					else {
						System.out.println("\n" + auxiliar);
						System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
					}
				}
			}

			//Eliminaci�n de la opci�n seleccionada
			while (!controlError) {

				System.out.print(menuOpcionesDisponibles);

				//Elecci�n de la opci�n por parte del usuario
				opcionUsuario = ControlErrorDatos.controlByte((byte) 1, MenuDeConsola.getsizeOpcionesComp(), "Ingrese el indice de la opci�n que desea agregar", "Por favor ingrese un n�mero entero");
				if (controlError) {System.out.println(); return;}

				//Ejecuci�n del m�todo principal
				System.out.println(usuario.getMenuDeConsola().agregarOpcion(idUsuario, tipoDeCuenta, (byte) (opcionUsuario - 1)));
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			}
		}
		else {
			System.out.println("No hay usuarios resgistrados a parte de tu cuenta.\n");
		}
	}

	@Override
	public String toString() {return "Agregar opci�n de men� a un usuario";}
}