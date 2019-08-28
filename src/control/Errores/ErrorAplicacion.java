/* 
   Clase ControlErrorDatosUsuario (abstracta, hereda de OpcionDeMenu)
   
   Prop�sito:
   Opci�n de men� del usuario, controla errores que pueden surgir 
   en los datos de un Usuario
   
   Estructuras de datos relevantes:
 */

package control.Errores;

public abstract class ErrorAplicacion extends Exception {

	public ErrorAplicacion(String mensaje) {
		super("Manejo de errores de la aplicaci�n" + mensaje);
	}
}