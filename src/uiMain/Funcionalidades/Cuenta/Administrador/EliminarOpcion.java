package uiMain.Funcionalidades.Cuenta.Administrador;

import java.io.IOException;

import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class EliminarOpcion extends OpcionDeMenu { // opci gestorAplicación.Usuarios.Vendedoron 12

	public void ejecutar() throws NumberFormatException, IOException {
		for (int i = 0; i < MenuDeConsola.opcionesActivas.size(); i++) {
			System.out.println(MenuDeConsola.opcionesActivas.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int Aeliminar = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		MenuDeConsola.opcionesActivas.remove(Aeliminar);
	}

	public String toString() {
		return "Eliminar opción";
	}

}