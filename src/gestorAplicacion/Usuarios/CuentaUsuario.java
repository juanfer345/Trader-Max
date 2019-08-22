/* 
   Clase CuentaUsuario (pública abstracta, hereda de Cuenta)
   
   Propósito:
   Clase intermediaria entre Cuenta y CuentaConBanco
   Contiene el metodo cerrarSesion
   
   Estructuras de datos relevantes:
 */

package gestorAplicacion.Usuarios;

import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

abstract public class CuentaUsuario extends Cuenta implements InterfazCategorias{

	private boolean cuentaActiva;
	
	//Este booleano se utiliza para saber si la cuenta está o no activa
	public boolean isCuentaActiva() {return cuentaActiva;}
	public void setCuentaActiva(boolean cuentaActiva) {this.cuentaActiva = cuentaActiva;}

	abstract public int getTotalDeOpcionesDisponibles();

	// Constructor para usuarios existentes (Llama al super)
	public CuentaUsuario(int id, String nombre, String correo, String password, int cedula, boolean activa) {
		super(id, nombre, correo, password, cedula);
		cuentaActiva = activa;
	}

	// Constructor para usuarios nuevos (Llama al super)
	public CuentaUsuario(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
		cuentaActiva = true;
	}

	//Constructor vacío
	public CuentaUsuario() {}
	
	// Método para cerrar sesión
	public String cerrarSesion(byte seleccion) {
		/*
		 * Propósito: le cierra la sesión al usuario
		 * 
		 * Parámetros de entrada: - byte seleccion: Verifica si el usuario sí se quiere
		 * salir de su cuenta
		 * 
		 * Parámetros de salida: - String: Retorna un mensaje el cual sera el que se
		 * mostrara al usuario dependiendo de la opción que haya elegido
		 */
		
		if (seleccion == 1) {
			// se devuelve la cantidad de productos que tenía el carrito.
			if (InicializacionAplicacion.usuarioActivo instanceof Comprador) {
				CarritoDeCompras.vaciarCarrito();
			}
			InicializacionAplicacion.setUsuarioActivo(new Visitante());
			OpcionDeMenu.controlError = true;

			System.out.println();
			return "Se ha cerrado sesión correctamente.\n" + "\n           TRADER-MAX INC           \n" + "\nBienvenido invitado.\n";
		} else if (seleccion == 2) {
			OpcionDeMenu.controlError = true;
			return "";
		} else {
			return "Por favor ingrese un número entero en el rango [1,2].";
		}
	}
	@Override
	public String toString() {		
		if (isCuentaActiva()) {
			return " (Activo) " + super.toString();
		}
		else {
			return " (Inactivo) " + super.toString();
		}
	}
}