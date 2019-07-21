/* 
   Clase CuentaUsuario (pública abstracta, hereda de Cuenta)
   
   Propósito:
   Clase intermediaria entre Cuenta y CuentaConBanco
   Contiene el metodo cerrarSesion
   
   Estructuras de datos relevantes:
 */

package gestorAplicacion.Usuarios;

import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;

abstract public class CuentaUsuario extends Cuenta implements InterfazCategorias{
    
	// Atributos
	abstract public int getTotalDeOpcionesDisponibles();

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
				
				Comprador comp = ((Comprador) InicializacionAplicacion.usuarioActivo); //se obtiene el catalogo
				HashMap<Integer, Producto> cat = comp.getCatalogo();
				
				if (comp.getCarrito().getTotalproductos() > 0) {
					//Se buscan los productos en el carrito
					for (Map.Entry<Integer, Integer> entry : comp.getCarrito().getProductos().entrySet()) {
						int cant = entry.getValue(); 					// Extracción de la cantidad en la hash
						int cod = entry.getKey(); 						// el codigo del producto
						Producto prod = cat.get(cod);  					//se obtiene el producto correspondiente al codigo 
						prod.setCantidad(prod.getCantidad() + cant); 	//se asigna la cantidad que estaba al principio
					}
				}
			}
			InicializacionAplicacion.setUsuarioActivo(new Visitante());
			OpcionDeMenu.controlError = true;
			return "\nSe ha cerrado sesión correctamente.\n" + "\nBienvenido invitado.\n";
		} else if (seleccion == 2) {
			OpcionDeMenu.controlError = true;
			return "";
		} else {
			return "Por favor ingrese un número entero en el rango [1,2].";
		}
	}
}