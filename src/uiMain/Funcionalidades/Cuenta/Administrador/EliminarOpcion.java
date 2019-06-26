package uiMain.Funcionalidades.Cuenta.Administrador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class EliminarOpcion extends OpcionDeMenu { // opci gestorAplicación.Usuarios.Vendedoron 12

	public void ejecutar() throws NumberFormatException, IOException {
		for (int i = 0; i < InicializacionAplicacion.usuarioActivo.getOpcionesDeMenu().size(); i++) {
			System.out.println(InicializacionAplicacion.usuarioActivo.getOpcionesDeMenu().get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int Aeliminar = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		InicializacionAplicacion.usuarioActivo.getOpcionesDeMenu().remove(Aeliminar);
	}

	public String toString() {
		return "Eliminar opción";
	}

}