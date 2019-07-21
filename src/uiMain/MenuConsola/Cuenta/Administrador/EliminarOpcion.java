package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.OpcionDeMenu;

public class EliminarOpcion extends OpcionDeMenu {
	public void ejecutar() throws NumberFormatException, IOException {
		
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		int idUsuario = 0;
		byte tipoUsuario = 0, opcionUsuario = 0;

	    //Guardado de mensaje principal
		sb.append("Elija el tipo de cuenta a la cual se le desea agregar la opci�n:\n");
		sb.append("1: Comprador\n");
		sb.append("2: Vendedor\n");
		sb.append("=> ");
		
		//Verificacion de tipo de usuario
		while (true) {
			// Impresi�n de mensaje y recepci�n de datos
			System.out.print(sb);
			tipoUsuario =esByte(br.readLine().trim());

			// Control de error
			if (tipoUsuario != 0) {
				if (tipoUsuario >= 1 && tipoUsuario <= 3) {
					break;
				} else {
					System.out.println("Por favor ingrese un n�mero entero en el rango [1,3]");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			} else {
				System.out.println(); controlError = true;
			}
		}

		//Mostrado de opciones de men� del usuario
		while (!controlError) {
			//Impresi�n de mensaje y recepci�n de datos
			System.out.println("\nPor favor ingrese el identificador del usuario");
			System.out.print("=> ");
			idUsuario = esInt(br.readLine().trim());
			if(idUsuario!=0) {
				if(idUsuario!=-1) {
					System.out.println(usuario.getMenuDeConsola().mostrarOpcionesDeMenu(idUsuario, tipoUsuario));
				}
				else {
					System.out.println("El identificador de usuario debe ser un n�mero entero");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {
				System.out.println(); controlError = true;
			}
		}

		//Impresi�n de las opciones disponibles a agregar
		System.out.println(usuario.getMenuDeConsola().comprobarCantidadOpciones(idUsuario, tipoUsuario, (byte) 2));

		//Agregado de la opci�n seleccionada
		while (!controlError) {
			opcionUsuario = esByte(br.readLine().trim());
			if(opcionUsuario!=0) {
				if (opcionUsuario != -1) {
					System.out.println(usuario.getMenuDeConsola().eliminarOpcion(idUsuario, tipoUsuario, (byte) (opcionUsuario - 1)));
				}
				else {
					System.out.println("El identificador de usuario debe ser un n�mero entero");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {
				System.out.println(); controlError = true;
			}
		}
	}
	
	@Override
	public String toString() {return "Eliminar opci�n de men�";}
}