/* 
   Clase Vendedor (pública, hereda de CuentaConBanco)
   
   Propósito:
   Tipo de usuario en el programa, el cual podra subir los productos a un catálogo para la venta de estos,
   también podra modificar los atributos de los Productos que haya subido.
   
   Estructuras de datos relevantes:
 */

package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;
import uiMain.MenuConsola.Salir;
import uiMain.MenuConsola.MostrarResenas;
import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Vendedor.CambiarPrecio;
import uiMain.MenuConsola.Cuenta.Vendedor.EliminarProductoCatalogo;
import uiMain.MenuConsola.Cuenta.Vendedor.ModificarCantidad;
import uiMain.MenuConsola.Cuenta.Vendedor.SubirProducto;

public class Vendedor extends CuentaConBanco {

	// Atributos
	private static final int totalDeOpcionesDisponibles = 8;

	// Constructor para usuarios existentes (Llama al super)
	public Vendedor(int idCuenta, String nombre, String correo, String password, int cedula) {
		super(idCuenta, nombre, correo, password, cedula);
	}

	// Constructor para usuarios nuevos (Llama al super)
	public Vendedor(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
	}

	// Crea un nuevo menú por defecto
	public ArrayList<OpcionDeMenu> getMenuPredeterminado() {

		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
				new ModificarCantidad(), new MostrarResenas(),new CambiarPrecio(), new EliminarProductoCatalogo(), 
				new SubirProducto(),new MostrarResenas(), new CerrarSesion(), new Salir() }));

	}

	public int getTotalDeOpcionesDisponibles() {
		return totalDeOpcionesDisponibles;
	}

	// Crea e ingresa un nuevo producto al catálogo
	public static void subirProducto(Vendedor vendedor, String nombreProducto, String categoria, double precio,
			int cantidad) {
		/* Propósito: Crea un nuevo producto con los Parámetros ingresados y lo agrega al catálogo
		   
		   Parámetros de entrada:
		   -Vendedor vendedor: El que esta crea el Producto
		   -String nombreProducto, String categoria, dobule precio, int cantidad: Características del Producto
		 */
		Producto p = new Producto(nombreProducto, categoria, vendedor, precio, cantidad);
		catalogo.put(p.getId(), p);
	}

	// Cambia el precio de un Producto
	public static String cambiarPrecio(String nombre, double precio) {
		/* Propósito: Poderle cambiar el precio a un Producto en caso de ser necesario 
		   
		   Parámetros de entrada:
		   -String nombre: El nombre del producto al cual se le modificará precio
		   -dobule precio: Nuevo precio
		   
		   Parámetros de salida:
		   -String: Un mensaje que indica si se cambio el precio
		 */
		
		Producto comprobarProducto = null;
		// Comprobar que el producto este en el catalogo
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto iteradorCatalogo = entry.getValue();
			if (iteradorCatalogo.getNombreProducto().equals(nombre)
					&& iteradorCatalogo.getVendedor().getId() == InicializacionAplicacion.usuarioActivo.getId()) {
				comprobarProducto = iteradorCatalogo;
				break;
			}
		}
		if (comprobarProducto == null) {
			return "El producto no existe, no se puede cambiar el precio\n";
		}
		// Cambiar precio
		else {
			comprobarProducto.setPrecio(precio);
			return "Se ha cambiado el precio del producto: " + comprobarProducto.getNombreProducto()
					+ ". Precio actual: " + comprobarProducto.getPrecio() + "\n";
		}
	}

	// Modifica la cantidad de un Producto
	public static String ModificarCantidad(String nombre, int valorOperar, String operador) {
		/* Propósito: Poderle cambiar la cantidad del un Producto
		   
		   Parámetros de entrada:
		   -String nombre: El nombre del producto al cual se le modificará la cantidad
		   -int valorOperar: Cuantos productos van a agregar o quitar
		   -String operador: Decide si se van a sumar o restar a la cantidad actual
		   
		   Parámetros de salida:
		   -String: Un mensaje que indica lo que sucedio con el proceso
		 */
		
		Producto comprobarProducto = null;
		// Comprobar que el producto esta en el catalogo
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto iteradorCatalogo = entry.getValue();
			if (iteradorCatalogo.getNombreProducto().equals(nombre)
					&& iteradorCatalogo.getVendedor().getId() == InicializacionAplicacion.usuarioActivo.getId()) {
				comprobarProducto = iteradorCatalogo;
				break;
			}
		}
		if (comprobarProducto == null) {
			return "El producto no existe, no se puede modificar la cantidad\n";
		} else {
			// Aumentar cantidad
			if (operador.equals("+")) {
				int can_final = comprobarProducto.getCantidad() + valorOperar;
				comprobarProducto.setCantidad(comprobarProducto.getCantidad() + valorOperar);
				return "Se aumentó la cantidad del producto: " + comprobarProducto.getNombreProducto()
						+ " cantidad actual: " + can_final + "\n";
			}
			// Disminuir cantidad
			else {
				int can_final = comprobarProducto.getCantidad() - valorOperar;
				if (can_final >= 0) {
					comprobarProducto.setCantidad(comprobarProducto.getCantidad() - valorOperar);
					return "Se redujo la cantidad del producto: " + comprobarProducto.getNombreProducto()
							+ " cantidad actual: " + can_final + "\n";
				} else {
					return "No hay suficientes productos, no se puede disminuir su cantidad";
				}
			}
		}
	}

	// Elimina un producto por codigo
	public String eliminarProductoCatalogo(int cod) {
		/* Propósito: Poder eliminar un producto del catálogo propio mediante el codigo
		   
		   Parámetros de entrada:
		   -int cod: Código del Producto
		   
		   Parámetros de salida:
		   -String: Un mensaje que indica si se eliminó el producto
		 */
		
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getId() == cod) {
				mens = p;
				break;
			}
		}
		if (mens == null) {
			return "No existe el producto";
		} else {
			int id = this.id;
			int id_mens = mens.getVendedor().getId();
			if (id == id_mens) {
				catalogo.remove(cod);
				return "Se eliminó el producto exitosamente";
			} else {
				return "No es un producto propio, no puede ser eliminado";
			}
		}
	}
}