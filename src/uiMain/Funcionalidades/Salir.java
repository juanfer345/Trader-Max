package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class Salir extends OpcionDeMenu {

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		
	    StringBuilder sb = new StringBuilder();
	    byte seleccion;
	    
		while (!OpcionDeMenu.controlError) {
			
		    //Ingreso de valores
			sb.append("Desea salir de la aplicación?\n");
			sb.append("1: Si\n");
			sb.append("2: No\n");
			sb.append("=> ");
			System.out.println(sb);
			seleccion = Byte.parseByte(MenuDeConsola.br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			System.out.println(InicializacionAplicacion.usuarioActivo.salir(seleccion));
		}
	}
	
	@Override
	public String toString() {
		return "Salir";
	}

}
