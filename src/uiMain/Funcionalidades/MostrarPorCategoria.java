package uiMain.Funcionalidades;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class MostrarPorCategoria extends OpcionDeMenu { // opcion 3

	public void ejecutar() throws NumberFormatException, IOException { //pa la logica

	    StringBuilder sb = new StringBuilder();
	    byte seleccion, i;
	    
	    //Guardado de mensaje principal
		sb.append("\nPor favor elija la categor�a con su �ndice\n");
		for (i = 0; i < Producto.categorias.length; i++) {
			sb.append((i + 1) + ". " + Producto.categorias[i] + '\n');
		}

		//Ciclo para control de error
		while (!OpcionDeMenu.controlError) {
		    
			//Impresi�n de mensaje y recepci�n de datos
			System.out.println(sb);
			seleccion = Byte.parseByte(MenuDeConsola.br.readLine().trim());
			
			//Ejecuci�n del m�todo e impresi�n de respuesta
			if (seleccion != 0) {
				System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCategoria(seleccion));
			}
			else {
				OpcionDeMenu.controlError = true;
			}
			//Impresi�n de mensaje de cancelaci�n en caso de que se haya producido un error
			if (!OpcionDeMenu.controlError) {System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");}
		}
	}

	public String toString() {
		return "Mostrar por categoria.";
	}
}