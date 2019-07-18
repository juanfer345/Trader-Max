package gestorAplicacion.Usuarios;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;

abstract public class CuentaUsuario extends Cuenta {

	abstract public int getTotalDeOpcionesDefault();
	
	//Constructor para usuarios existentes	
	public CuentaUsuario(int id, String nombre, String correo, String password, int cedula) {
		super(id, nombre, correo, password, cedula);
	}

	//Constructor para usuarios nuevos
	public CuentaUsuario(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
	}
	
	public CuentaUsuario() {}
	
	//Método para cerrar sesión
	public String cerrarSesion(byte seleccion) {
		if (seleccion == 1) {
			InicializacionAplicacion.setUsuarioActivo(new Visitante());
			OpcionDeMenu.controlError = true;
			return "\nSe ha cerrado sesión correctamente mijin\n" + 
					"\nBienvenido invitado.\n";
		} else if (seleccion == 2) {
			OpcionDeMenu.controlError = true;
			return "";
		} else {
			return "Por favor ingrese un número entero en el rango [1,2].";
		}
	}
}