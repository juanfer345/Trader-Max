package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class BuscarProducto extends OpcionDeMenu {

	@Override
	public void ejecutar() throws NumberFormatException, IOException {

	    String selecc;
	    byte seleccion;
	    
	    //Guardado de mensaje principal
		sb.append("Por favor elija el m�todo de b�squeda\n");
		sb.append("1: Por c�digo\n");
		sb.append("2: Por nombre\n");
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!controlError) {
			
			//Impresi�n de mensaje y recepci�n de datos
			System.out.println(sb);
			seleccion = Byte.parseByte(br.readLine().trim());
			
			//Ejecuci�n del m�todo e impresi�n de respuesta
			if (seleccion != 0) {
				if (seleccion == 1) {
					while (!controlError) {
						System.out.print("Ingrese el c�digo del producto: ");
						seleccion = Byte.parseByte(br.readLine().trim());
						System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(seleccion));
						if (!controlError) {
							System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");}
					}
				}
				else if (seleccion == 2) {
					while (!controlError) {
						System.out.print("Ingrese el nombre del producto: ");
						selecc = br.readLine().trim();
						System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(selecc));
						if (!controlError) {
							System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");}
					}
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
		return "Buscar producto";
	}
}