package uiMain.Funcionalidades;

import gestorAplicación.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class BorrarHistorial extends OpcionDeMenu { // opcion 5

	@Override
	public void ejecutar() {
		Comprador x = (Comprador) usuario;
		String str = x.borrarHistorial();
		System.out.println(str);
	}

	@Override
	public String toString() {
		return "Borrar Historial";
	}

}