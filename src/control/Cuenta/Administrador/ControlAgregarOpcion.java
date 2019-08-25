package control.Cuenta.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.MenuConsola.OpcionDeMenu;


public class ControlAgregarOpcion extends OpcionDeMenu implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		String menuOpcionesDisponibles = null, auxiliar;
		int idUsuario = 0;
		byte tipoDeCuenta = 0, opcionUsuario = 0;

		if (Cuenta.getTotalCuentas() != 0) {

			//Guardado de mensaje principal
			System.out.println();
		

			//Control de ingreso tipo de usuario
//			tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, OpcionDeMenu.sb.toString(), "Por favor ingrese un n�mero entero");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			while (!OpcionDeMenu.controlError) {
				//Control de ingreso de identificaci�n de usuario
//				idUsuario = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Por favor ingrese el n�mero identificador del usuario", "El identificador del usuario debe ser un n�mero entero");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				if (idUsuario == usuario.getId() && tipoDeCuenta == 3) {

					System.out.println("\nNo es permitido que elimines opciones de tu propia cuenta, ingresa otra identificaci�n.\n");
				}
				else {
					//Impresi�n de las opciones de men� del usuario
					auxiliar = usuario.getMenuDeConsola().mostrarOpcionesDeMenu(idUsuario, tipoDeCuenta);
					if (OpcionDeMenu.controlError) {

						System.out.println(auxiliar);
						OpcionDeMenu.controlError = false;

						//Guardado de las opciones disponibles a agregar
						menuOpcionesDisponibles = usuario.getMenuDeConsola().comprobarCantidadOpciones(idUsuario, tipoDeCuenta, (byte) 1);
						if (OpcionDeMenu.controlError) {OpcionDeMenu.controlError = false; break;}
						System.out.println(menuOpcionesDisponibles);
					}
					else {
						System.out.println("\n" + auxiliar);
						System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
					}
				}
			}

			//Eliminaci�n de la opci�n seleccionada
			while (!OpcionDeMenu.controlError) {

				System.out.print(menuOpcionesDisponibles);

				//Elecci�n de la opci�n por parte del usuario
//				opcionUsuario = ControlErrorDatos.controlByte((byte) 1, MenuDeConsola.getsizeOpcionesComp(), "Ingrese el indice de la opci�n que desea agregar", "Por favor ingrese un n�mero entero");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

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


