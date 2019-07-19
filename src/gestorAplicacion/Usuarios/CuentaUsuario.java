/* 
   Clase CuentaUsuario (pública abstracta, hereda de Cuenta)
   
   Propósito:
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

	// Método para cerrar sesión
	public String cerrarSesion(byte seleccion) {
		/*
		   Propósito: Desloguea al usuario y termina su sesión
		   
		   Parámetros de entrada: 
		   - byte seleccion: Verifíca si el usuario sí se quiere salir de su cuenta
		   
		   Parámetros de salida:
		   - String: Retorna un mensaje el cual sera el que se mostrara al usuario
		             dependiendo de la opción que haya elegido
		 */
		if (seleccion == 1) {
			InicializacionAplicacion.setUsuarioActivo(new Visitante());
			OpcionDeMenu.controlError = true;
			return "\nSe ha cerrado sesión correctamente mijin\n" + "\nBienvenido invitado.\n";
		} else if (seleccion == 2) {
			OpcionDeMenu.controlError = true;
			return "";
		} else {
			return "Por favor ingrese un número entero en el rango [1,2].";
		}
	}
}