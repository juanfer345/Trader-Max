package control.Errores;

/*
 * Prop�sito: Error dependiendo del tipo de dato 
 */

public class ErrorTipodeDato extends ErrorAplicacion {
	
	public ErrorTipodeDato(String mensaje) {
		super(", error de tipo de dato: " + mensaje);
	}
}