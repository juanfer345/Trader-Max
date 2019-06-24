package uiMain.Funcionalidades;

import uiMain.OpcionDeMenu;

public class Salir extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		SalirApp = true; 
	}

	@Override
	public String toString() {
		return "Salir";
	}

}
