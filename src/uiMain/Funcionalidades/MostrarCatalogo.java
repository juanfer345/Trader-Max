package uiMain.Funcionalidades;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class MostrarCatalogo extends OpcionDeMenu {
	// Recorre toda la tabla Hash mostrando los productos

	@Override
	public void ejecutar() throws IOException {

		sb.append("\n Usted ha elegido la opcion para mostrar el catalogo de los productos");
		sb.append("\n Para regresar y cancelar el proceso ingrese el '0'");
		sb.append("\n Para continuar con el proceso ingrese '1'");

		controlError = false;
		String opcion;
		int comprobOpc;

		while (!controlError) {

			System.out.println(sb);
			opcion = br.readLine().trim();
			comprobOpc = (int) MenuDeConsola.esNumeroEntero(opcion);

			while (comprobOpc == -1) {
				System.out.println("El dato que ingreso es invalido, vuelva a intentarlo");
				opcion = br.readLine().trim();
				comprobOpc = (int) MenuDeConsola.esNumeroEntero(opcion);
			}
			if (comprobOpc == 0) {
				// ver si es un 0 para devolverse
				controlError = true;
			} else if (comprobOpc == 1) {
				System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
				controlError = true;
			} else {
				/*
				 * Si ingresa un numero diferente pero no es ninguna de las disponibles debe
				 * empezar de nuevo (Empezara de nuevo el control)
				 */
				System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo");
			}
		}
	}

	@Override
	public String toString() {
		return "Mostrar todos los productos";
	}

}
