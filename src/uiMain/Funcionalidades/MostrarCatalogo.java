package uiMain.Funcionalidades;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class MostrarCatalogo extends OpcionDeMenu{
	//Recorre toda la tabla Hash mostrando los productos

	@Override
	public void ejecutar() throws IOException {
		
		StringBuilder sb = new StringBuilder();

		sb.append("\n Usted ha elegido la opcion para mostrar el catalogo de los productos");
		sb.append("\n Para regresar y cancelar el proceso ingrese el '0'");
		sb.append("\n Para continuar con el proceso ingrese '1'");

		int opcion;
		OpcionDeMenu.controlError = false;

		while (!OpcionDeMenu.controlError) {

			System.out.println(sb);

			try {
				opcion = Integer.parseInt(MenuDeConsola.br.readLine().trim());
				
				if (opcion == 0) {
					OpcionDeMenu.controlError = true;
				} else if (opcion == 1) {
					System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
					OpcionDeMenu.controlError = true;
				}else {
					System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo");
				}
				
			} catch (NumberFormatException nfe) {
				// Por si se ingresa un tipo de dato diferente
				System.out.println("\n El dato que ingreso es invalido ");
			}
		}
	}

	@Override
	public String toString() {
		return "Mostrar todos los productos.";
	}

}
