package control.Errores;

import java.io.IOException;

import uiMain.MenuConsola.OpcionDeMenu;

/*
 * Propósito: Error dependiendo del tipo de dato 
 */

public class ErrorTipodeDato extends ErrorAplicacion {
	
	public ErrorTipodeDato(String mensaje) {
		super(", error de tipo de dato: " + mensaje);
	}
}