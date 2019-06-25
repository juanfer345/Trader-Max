package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class BuscarProducto extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {

	    StringBuilder sb = new StringBuilder();
	    String selecc;
	    byte seleccion;
		
		while (!OpcionDeMenu.controlError) {

			sb.append("Por favor elija el m�todo de b�squeda\n");
			sb.append("1: Por c�digo\n");
			sb.append("2: Por nombre\n");
			sb.append("=> ");
			System.out.println(sb);
			seleccion = Byte.parseByte(MenuDeConsola.br.readLine().trim());

			//Ejecuci�n del m�todo e impresi�n de respuesta
			if (seleccion != 0) {
				if (seleccion == 1) {
					while (!OpcionDeMenu.controlError) {
						System.out.print("Ingrese el c�digo del producto: ");
						seleccion = Byte.parseByte(MenuDeConsola.br.readLine().trim());
						System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(seleccion));
						if (!OpcionDeMenu.controlError) {System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");}
					}
				}
				else if (seleccion == 2) {
					while (!OpcionDeMenu.controlError) {
						System.out.print("Ingrese el nombre del producto: ");
						selecc = MenuDeConsola.br.readLine().trim();
						System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(selecc));
						if (!OpcionDeMenu.controlError) {System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");}
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
		return "Buscar producto.";
	}
}