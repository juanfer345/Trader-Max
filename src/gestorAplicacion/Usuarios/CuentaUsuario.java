/* 
   Clase CuentaUsuario (p�blica abstracta, hereda de Cuenta)
   
   Prop�sito:
   Clase intermediaria entre Cuenta y CuentaConBanco
   Contiene el metodo cerrarSesion
   
   Estructuras de datos relevantes:
 */

package gestorAplicacion.Usuarios;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;

abstract public class CuentaUsuario extends Cuenta {

	// Atributos
	abstract public int getTotalDeOpcionesDefault();

	// Constructor para usuarios existentes (Llama al super)
	public CuentaUsuario(int id, String nombre, String correo, String password, int cedula) {
		super(id, nombre, correo, password, cedula);
	}

	// Constructor para usuarios nuevos (Llama al super)
	public CuentaUsuario(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
	}

	// M�todo para cerrar sesi�n
	public String cerrarSesion(byte seleccion) {
		/*
		   Prop�sito: Desloguea al usuario y termina su sesi�n
		   
		   Par�metros de entrada: 
		   - byte seleccion: Verif�ca si el usuario s� se quiere salir de su cuenta
		   
		   Par�metros de salida:
		   - String: Retorna un mensaje el cual sera el que se mostrara al usuario
		             dependiendo de la opci�n que haya elegido
		 */
		if (seleccion == 1) {
			InicializacionAplicacion.setUsuarioActivo(new Visitante());
			OpcionDeMenu.controlError = true;
			return "\nSe ha cerrado sesi�n correctamente mijin\n" + "\nBienvenido invitado.\n";
		} else if (seleccion == 2) {
			OpcionDeMenu.controlError = true;
			return "";
		} else {
			return "Por favor ingrese un n�mero entero en el rango [1,2].";
		}
	}
}