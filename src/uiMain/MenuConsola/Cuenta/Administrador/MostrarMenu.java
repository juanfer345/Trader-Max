package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.OpcionDeMenu;

public class MostrarMenu extends OpcionDeMenu {
	public void ejecutar() throws NumberFormatException, IOException {
		
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
	    int idUsuario;
	    byte tipoUsuario;

	    //Guardado de mensaje principal
		sb.append("Elija el tipo de cuenta de la cual desea ver sus opciones de menú:\n");
		sb.append("1: Comprador\n");
		sb.append("2: Vendedor\n");
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!controlError) {
			
			//Impresión de mensaje y recepción de datos
			System.out.println(sb);
			tipoUsuario = Byte.parseByte(br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			if (tipoUsuario != 0) {

				while (!controlError) {

					//Impresión de mensaje y recepción de datos
					System.out.println("\nPor favor ingrese el identificador del usuario");
					System.out.print("=> ");
					idUsuario = Integer.parseInt(br.readLine().trim());
					
					//Mostrado de opciones de menú del usuario
					System.out.println(usuario.getMenuDeConsola().mostrarOpcionesDeMenu(idUsuario, tipoUsuario));
				}
			}
			else {
				controlError = true;
			}
			//Impresión de mensaje de cancelación en caso de que se haya producido un error
			if (!controlError) {System.out.println("NOTA: se puede cancelar la operación ingresando el número '0' \n");}
		}
	}
	
	@Override
	public String toString() {return "Mostrar menú";}
}