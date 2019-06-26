package uiMain.Funcionalidades.Cuenta.Administrador;

import java.io.IOException;
import java.util.ArrayList;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.*;

public class AgregarOpcion extends OpcionDeMenu {
	
	public void ejecutar() throws NumberFormatException, IOException {
		
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
	    StringBuilder sb = new StringBuilder();
	    int seleccion, idUsuario;
	    byte tipoUsuario;

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		int codigoProd, cantidadProd;

	    //Guardado de mensaje principal
		sb.append("Elija el tipo de cuenta a la cual se le desea agregar la opci�n:\n");
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
					System.out.println("\nPor favor ingrese el identificador del comprador");
					System.out.print("=> ");
					idUsuario = Integer.parseInt(MenuDeConsola.br.readLine().trim());
					
					//Mostrado de opciones de men� del usuario
					System.out.println(usuario.mostrarOpcionesDeMenu(idUsuario, tipoUsuario));
					
					//Selecci�n de opci�n a agregar en caso de que la cuenta exista
					if (OpcionDeMenu.controlError) {
						OpcionDeMenu.controlError = false;
						
						//Impresi�n de las opciones disponibles a agregar
						while (!OpcionDeMenu.controlError) {
							System.out.println(usuario.comprobarCantidadOpciones(idUsuario, tipoUsuario, (byte) 1));

							if (OpcionDeMenu.controlError) {
								OpcionDeMenu.controlError = false;
								
								}
							else {
								System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");
							}
						
						}
						
						
						System.out.println("Ingrese el indice de la opcion que desea agregar");
						System.out.print("=> ");
						
						}
					else {
						System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");
					}
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
		return "Agregar opci�n de men�";
	}

}