/*	Clase MostrarPorCategoria (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */

package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.InterfazCategorias;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarPorCategoria extends OpcionDeMenu implements InterfazCategorias { // opcion 3

	public void ejecutar() throws NumberFormatException, IOException { 
		/*
		 Prop�sito: Ejecutar el m�todo mostrarCategoria() haciendo los respectivos
		            controles de error del ingreso de datos
		 */

		byte seleccion, i;

		if (!Cuenta.getCatalogo().isEmpty()) {

			//Guardado de mensaje principal
			sb.append("\nPor favor elija la categor�a ingresando su �ndice:\n");
			for (i = 0; i < categorias.length; i++) {
				sb.append((i + 1) + ". " + categorias[i] + '\n');
			}
			
			//Selecci�n por parte del usuario
			seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) Producto.categorias.length, sb.toString(), "Por favor ingrese un n�mero entero");
			if (controlError) {System.out.println(); return;}
			
			//Ejecuci�n del m�todo
			System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCategoria(seleccion));
			
		}
		else {
			System.out.println("El cat�logo se encuentra vac�o.\n");
		}
	}

	@Override
	public String toString() {return "Mostrar productos por categor�a";}
}