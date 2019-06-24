package uiMain.Funcionalidades;

import gestorAplicación.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class borrarHistorial extends OpcionDeMenu { // opcion 5

	@Override
	public void ejecutar() {
		usuario.borrarHistorial();
	}

	@Override
	public String toString() {
		return "Borrar Historial";
	}

}