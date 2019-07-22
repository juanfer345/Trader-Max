/*	Clase MostrarPorCategoria (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */

package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarPorCategoria extends OpcionDeMenu { // opcion 3

	public void ejecutar() throws NumberFormatException, IOException { 
		/*
		 Propósito: Ejecutar el método mostrarCategoria() haciendo los respectivos
		            controles de error del ingreso de datos
		 */

		byte seleccion;

		if (!Cuenta.getCatalogo().isEmpty()) {

			//Guardado de mensaje principal
			System.out.println();
			sb.append("Por favor elija la categoría ingresando su índice:\n");
			sb.append(Producto.getCategorias());
			sb.append("Seleccion");
			
			//Selección por parte del usuario
			seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) Producto.categorias.length, sb.toString(), "Por favor ingrese un número entero");
			if (controlError) {System.out.println(); return;}
			
			//Ejecución del método
			System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCategoria((byte) (seleccion - 1)));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
			
		}
		else {
			System.out.println("El catálogo se encuentra vacío.\n");
		}
	}

	@Override
	public String toString() {return "Mostrar productos por categoría";}
}