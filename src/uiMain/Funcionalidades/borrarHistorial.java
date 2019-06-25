package uiMain.Funcionalidades;

import uiMain.OpcionDeMenu;

public class borrarHistorial extends OpcionDeMenu { // opcion 5

	@Override
	public void ejecutar() {
		usuarioActivo.borrarHistorial();
	}

	@Override
	public String toString() {
		return "Borrar Historial";
	}

}