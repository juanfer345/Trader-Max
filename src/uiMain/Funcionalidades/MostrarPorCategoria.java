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
		sb.append("\nPor favor elija la categoría con su índice\n");
		for (i = 0; i < Producto.categorias.length; i++) {
			sb.append((i + 1) + ". " + Producto.categorias[i] + '\n');
		}

		//Ciclo para control de error
		while (!OpcionDeMenu.controlError) {
		    
			//Impresión de mensaje y recepción de datos
			System.out.println(sb);
			seleccion = Byte.parseByte(MenuDeConsola.br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			if (seleccion != 0) {
				System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCategoria(seleccion));
			}
			else {
				OpcionDeMenu.controlError = true;
			}
			//Impresión de mensaje de cancelación en caso de que se haya producido un error
			if (!OpcionDeMenu.controlError) {System.out.println("NOTA: se puede cancelar la operación ingresando el número '0' \n");}
		}
	}

	public String toString() {
		return "Mostrar por categoria.";
	}
}