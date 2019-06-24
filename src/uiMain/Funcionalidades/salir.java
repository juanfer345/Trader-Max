package uiMain.Funcionalidades;

import uiMain.OpcionDeMenu;

public class salir extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		SalirApp = true; 
	}

	@Override
	public String toString() {
		return "Salir";
	}

}
