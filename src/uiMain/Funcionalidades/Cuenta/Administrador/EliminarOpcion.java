package uiMain.Funcionalidades.Cuenta.Administrador;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.OpcionDeMenu;

public class EliminarOpcion extends OpcionDeMenu {
	public void ejecutar() throws NumberFormatException, IOException {
		
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
	    int idUsuario;
	    byte tipoUsuario, opcionUsuario;

	    //Guardado de mensaje principal
		sb.append("Elija el tipo de cuenta a la cual se le desea agregar la opción:\n");
		sb.append("1: Comprador\n");
		sb.append("2: Vendedor\n");
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!OpcionDeMenu.controlError) {
			
			//Impresión de mensaje y recepción de datos
			System.out.println(sb);
			tipoUsuario = Byte.parseByte(br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			if (tipoUsuario != 0) {

				while (!OpcionDeMenu.controlError) {

					//Impresión de mensaje y recepción de datos
					System.out.println("\nPor favor ingrese el identificador del usuario");
					System.out.print("=> ");
					idUsuario = Integer.parseInt(br.readLine().trim());
					
					//Mostrado de opciones de menú del usuario
					System.out.println(usuario.mostrarOpcionesDeMenu(idUsuario, tipoUsuario));
					
					//Selección de opción a agregar en caso de que la cuenta exista
					if (OpcionDeMenu.controlError) {
						OpcionDeMenu.controlError = false;
						
						//Impresión de las opciones disponibles a agregar
						while (!OpcionDeMenu.controlError) {
							System.out.println(usuario.comprobarCantidadOpciones(idUsuario, tipoUsuario, (byte) 2));

							if (OpcionDeMenu.controlError) {
								OpcionDeMenu.controlError = false;
								//Eliminación de la opción seleccionada
								opcionUsuario = (byte) (Byte.parseByte(br.readLine().trim()) - 1);
								System.out.println(usuario.eliminarOpcion(idUsuario, tipoUsuario, opcionUsuario));								
								}
							else {
								System.out.println("NOTA: se puede cancelar la operación ingresando el número '0' \n");
							}
						}
					}
					else {
						System.out.println("NOTA: se puede cancelar la operación ingresando el número '0' \n");
					}
				}
			}
			else {
				OpcionDeMenu.controlError = true;
			}
			//Impresión de mensaje de cancelación en caso de que se haya producido un error
			if (!OpcionDeMenu.controlError) {System.out.println("NOTA: se puede cancelar la operación ingresando el número '0' \n");}
		}
	}

	public String toString() {
		return "Eliminar opción de menú";
	}
}