package control.Errores;

import java.io.IOException;

import uiMain.MenuConsola.OpcionDeMenu;

public class ErrorTipodeDato extends ErrorAplicacion {
	
	public ErrorTipodeDato(String mensaje) {
		super(", error de tipo de dato: " + mensaje);
	}
}