/*	Clase MostrarPorCategoria (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
		 Prop�sito: Ejecutar el m�todo mostrarCategoria() haciendo los respectivos
		            controles de error del ingreso de datos
		 */

		byte seleccion;

		if (!Cuenta.getCatalogo().isEmpty()) {

			//Guardado de mensaje principal
			System.out.println();
			sb.append("Por favor elija la categor�a ingresando su �ndice:\n");
			sb.append(Producto.getCategorias());
			sb.append("Seleccion");
			
			//Selecci�n por parte del usuario
			seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) Producto.categorias.length, sb.toString(), "Por favor ingrese un n�mero entero");
			if (controlError) {System.out.println(); return;}
			
			//Ejecuci�n del m�todo
			System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCategoria((byte) (seleccion - 1)));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			
		}
		else {
			System.out.println("El cat�logo se encuentra vac�o.\n");
		}
	}

	@Override
	public String toString() {return "Mostrar productos por categor�a";}
}