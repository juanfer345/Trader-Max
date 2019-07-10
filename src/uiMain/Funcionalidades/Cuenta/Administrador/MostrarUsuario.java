package uiMain.Funcionalidades.Cuenta.Administrador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class MostrarUsuario {
	public void ejecutar() throws NumberFormatException, IOException {
		
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
	    StringBuilder sb = new StringBuilder();
	    int idUsuario;
	    byte tipoUsuario;

	    //Guardado de mensaje principal
		sb.append("Elija el tipo de cuenta de la cual desea obtener informaci�n:\n");
		sb.append("1: Comprador\n");
		sb.append("2: Vendedor\n");
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!OpcionDeMenu.controlError) {
			
			//Impresi�n de mensaje y recepci�n de datos
			System.out.println(sb);
			tipoUsuario = Byte.parseByte(MenuDeConsola.br.readLine().trim());
			
			//Ejecuci�n del m�todo e impresi�n de respuesta
			if (tipoUsuario != 0) {

				while (!OpcionDeMenu.controlError) {

					//Impresi�n de mensaje y recepci�n de datos
					System.out.println("\nPor favor ingrese el identificador del usuario");
					System.out.print("=> ");
					idUsuario = Integer.parseInt(MenuDeConsola.br.readLine().trim());
					
					//Mostrado de informaci�n del usuario
					System.out.println(usuario.mostrarUsuario(idUsuario, tipoUsuario));
				}
			}
			else {
				OpcionDeMenu.controlError = true;
			}
			//Impresi�n de mensaje de cancelaci�n en caso de que se haya producido un error
			if (!OpcionDeMenu.controlError) {System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");}
		}
	}
	
	public String toString() {
		return "Mostrar informaci�n de usuario.";
	}
}