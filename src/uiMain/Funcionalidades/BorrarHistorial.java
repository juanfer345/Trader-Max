package uiMain.Funcionalidades;

import uiMain.OpcionDeMenu;

public class BorrarHistorial extends OpcionDeMenu { // opcion 5

	public void ejecutar() {
		Comprador x = (Comprador) usuario;
		String str = x.borrarHistorial();
		System.out.println(str);
	}

	public String toString() {
		return "Borrar Historial";
	}

}