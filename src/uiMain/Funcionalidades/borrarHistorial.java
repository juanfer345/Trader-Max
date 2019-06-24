package uiMain.Funcionalidades;

import uiMain.OpcionDeMenu;

public class borrarHistorial extends OpcionDeMenu { // opcion 5

	@Override
	public void ejecutar() {
		String str =usuario.borrarHistorial();
		System.out.println(str);
	}

	@Override
	public String toString() {
		return "Borrar Historial";
	}

}