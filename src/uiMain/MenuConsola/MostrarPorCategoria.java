package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;

public class MostrarPorCategoria extends OpcionDeMenu { // opcion 3

	public void ejecutar() throws NumberFormatException, IOException { //pa la logica

	    byte seleccion, i;
	    
	    //Guardado de mensaje principal
		sb.append("\nPor favor elija la categoría ingresando su índice:\n");
		for (i = 0; i < Producto.categorias.length; i++) {
			sb.append((i + 1) + ". " + Producto.categorias[i] + '\n');
		}
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!controlError) {
		    
			//Impresión de mensaje y recepción de datos
			System.out.print(sb);
			seleccion = esByte(br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			if (seleccion != 0) {
				if (seleccion != -1) {
					System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCategoria(seleccion));
				}
				else {
					System.out.println("Por favor ingrese un número entero en el rango [1," + Producto.categorias.length + "]");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			}
			else {System.out.println(); return;}
		}
	}
	
	@Override
	public String toString() {return "Mostrar productos por categoria";}
}