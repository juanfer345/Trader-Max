/* 
   Clase ControlErrorDatosUsuario (abstracta, hereda de OpcionDeMenu)
   
   Propósito:
   Opción de menú del usuario, controla errores que pueden surgir 
   en los datos de un Usuario
   
   Estructuras de datos relevantes:
 */

package control.Errores;

import java.io.IOException;

import uiMain.MenuConsola.OpcionDeMenu;

public abstract class ErrorAplicacion extends Exception {

	public ErrorAplicacion(String mensaje) {
		super("Manejo de errores de la aplicación" + mensaje);
	}
}