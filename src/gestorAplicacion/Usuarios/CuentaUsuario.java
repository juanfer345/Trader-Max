/* 
   Clase CuentaUsuario (p�blica abstracta, hereda de Cuenta)
   
   Prop�sito:
   Clase intermediaria entre Cuenta y CuentaConBanco
   Contiene el metodo cerrarSesion
   
   Estructuras de datos relevantes:
 */

package gestorAplicacion.Usuarios;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.OpcionDeMenu;

abstract public class CuentaUsuario extends Cuenta implements InterfazCategorias{

	abstract public int getTotalDeOpcionesDisponibles();

	// Constructor para usuarios existentes (Llama al super)
	public CuentaUsuario(int id, String nombre, String correo, String password, int cedula) {
		super(id, nombre, correo, password, cedula);
	}

	// Constructor para usuarios nuevos (Llama al super)
	public CuentaUsuario(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
	}

	//Constructor vac�o
	public CuentaUsuario() {}
	
	// M�todo para cerrar sesi�n
	public String cerrarSesion(byte seleccion) {
		/*
		 * Prop�sito: le cierra la sesi�n al usuario
		 * 
		 * Par�metros de entrada: - byte seleccion: Verifica si el usuario s� se quiere
		 * salir de su cuenta
		 * 
		 * Par�metros de salida: - String: Retorna un mensaje el cual sera el que se
		 * mostrara al usuario dependiendo de la opci�n que haya elegido
		 */
		
		if (seleccion == 1) {
			// se devuelve la cantidad de productos que ten�a el carrito.
			if (InicializacionAplicacion.usuarioActivo instanceof Comprador) {
				CarritoDeCompras.devolverProductos();
			}
			InicializacionAplicacion.setUsuarioActivo(new Visitante());
			OpcionDeMenu.controlError = true;

			System.out.println();
			return "Se ha cerrado sesi�n correctamente.\n" + "\n           TRADER-MAX INC           \n" + "\nBienvenido invitado.\n";
		} else if (seleccion == 2) {
			OpcionDeMenu.controlError = true;
			return "";
		} else {
			return "Por favor ingrese un n�mero entero en el rango [1,2].";
		}
	}
}