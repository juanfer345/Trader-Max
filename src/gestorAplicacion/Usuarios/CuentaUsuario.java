/* 
   Clase CuentaUsuario (p�blica abstracta, hereda de Cuenta)

   Prop�sito:
   Clase intermediaria entre Cuenta y CuentaConBanco
   Contiene el metodo cerrarSesion

   Estructuras de datos relevantes:
 */

package gestorAplicacion.Usuarios;

import control.OpcionDeMenu;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.InicializacionAplicacion;

abstract public class CuentaUsuario extends Cuenta implements InterfazCategorias{

	private boolean cuentaActiva;

	//Este booleano se utiliza para saber si la cuenta est� o no activa
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

	//Constructor vac�o
	public CuentaUsuario() {}

	// M�todo para cerrar sesi�n
	public String cerrarSesion() {
		/*
		 * Prop�sito: le cierra la sesi�n al usuario
		 * 
		 * Par�metros de entrada: - byte seleccion: Verifica si el usuario s� se quiere
		 * salir de su cuenta
		 * 
		 * Par�metros de salida: - String: Retorna un mensaje el cual sera el que se
		 * mostrara al usuario dependiendo de la opci�n que haya elegido
		 */

		// se devuelve la cantidad de productos que ten�a el carrito.
		if (InicializacionAplicacion.usuarioActivo instanceof Comprador) {
			CarritoDeCompras.vaciarCarrito();
		}
		InicializacionAplicacion.setUsuarioActivo(new Visitante());
		OpcionDeMenu.controlError = true;

		return "Se ha cerrado sesi�n correctamente.";
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