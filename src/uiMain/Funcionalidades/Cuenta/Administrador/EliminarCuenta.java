package uiMain.Funcionalidades.Cuenta.Administrador;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.CuentaUsuario;
import uiMain.OpcionDeMenu;

public class EliminarCuenta extends OpcionDeMenu {
	boolean z = false;
	CuentaUsuario c;
	int llave = -1;
	
	@Override
	public void ejecutar() throws IOException {
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
	    int idUsuario;
	    byte tipoUsuario;

	    //Guardado de mensaje principal
		sb.append("Elija el tipo de cuenta que desea eliminar:\n");
		sb.append("1: Comprador\n");
		sb.append("2: Vendedor\n");
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!controlError) {
			
			//Impresi�n de mensaje y recepci�n de datos
			System.out.println(sb);
			tipoUsuario = Byte.parseByte(br.readLine().trim());
			
			//Ejecuci�n del m�todo e impresi�n de respuesta
			if (tipoUsuario != 0) {

				while (!controlError) {

					//Impresi�n de mensaje y recepci�n de datos
					System.out.println("\nPor favor ingrese el identificador del usuario");
					System.out.print("=> ");
					idUsuario = Integer.parseInt(br.readLine().trim());
					
					//Eliminaci�n de la cuenta
					System.out.println(usuario.eliminarCuenta(idUsuario, tipoUsuario));
				}
			}
			else {
				controlError = true;
			}
			//Impresi�n de mensaje de cancelaci�n en caso de que se haya producido un error
			if (!controlError) {System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");}
		}
	}

	@Override
	public String toString() {
		return "Eliminar cuenta de usuario";
	}

}
