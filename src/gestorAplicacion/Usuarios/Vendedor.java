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

import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;
import uiMain.MenuConsola.BuscarProducto;
import uiMain.MenuConsola.MostrarCatalogo;
import uiMain.MenuConsola.MostrarPorCategoria;
import uiMain.MenuConsola.MostrarResenas;
import uiMain.MenuConsola.Salir;
import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Vendedor.CambiarPrecio;
import uiMain.MenuConsola.Cuenta.Vendedor.EliminarProductoCatalogo;
import uiMain.MenuConsola.Cuenta.Vendedor.ModificarCantidad;
import uiMain.MenuConsola.Cuenta.Vendedor.SubirProducto;
import uiMain.MenuConsola.Cuenta.Vendedor.VerProductos;

public class Vendedor extends CuentaConBanco implements InterfazCategorias{

	// Atributos
	private int totalDeProductosSubidos = 0;
	private static final int totalDeOpcionesDisponibles = 8;

	// Constructor para usuarios existentes (Llama al super)
	public Vendedor(int idCuenta, String nombre, String correo, String password, int cedula) {
		super(idCuenta, nombre, correo, password, cedula);
	}

	// Constructor para usuarios existentes con cuenta repetida (Llama al super)
	public Vendedor(int idCuenta, String nombre, String correo, String password, int cedula, int idCuentaBancaria) {
		super(idCuenta, nombre, correo, password, cedula, idCuentaBancaria);
	}
	
	// Constructor para usuarios nuevos (Llama al super)
	public Vendedor(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
	}

	//Constructor vacío
	public Vendedor() {}
	
	// Crea un nuevo menú por defecto
	public ArrayList<OpcionDeMenu> getMenuPredeterminado() {
		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] {
				new SubirProducto(), new EliminarProductoCatalogo(), new ModificarCantidad(), 
				new CambiarPrecio(), new BuscarProducto(), new MostrarCatalogo(), new MostrarPorCategoria(), 
				new MostrarResenas(), new VerProductos(), new CerrarSesion(), new Salir()}));
	}

	public int getTotalDeOpcionesDisponibles() {
		return totalDeOpcionesDisponibles;
	}

	public int getTotalDeProductosSubidos() {return totalDeProductosSubidos;}

	//Muestra la información de todos los productos subidos que se encuentran en el catálogo
	public String mostrarProductos() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nTotal de productos subidos: ").append(totalDeProductosSubidos).append('\n');
		
		for (Map.Entry<Integer, Producto> entry : Cuenta.getCatalogo().entrySet()) {
			if (entry.getValue().getVendedor().getId() == getId()) {
				sb.append(entry.getValue().toString()).append(", Cantidad: ").
				append(entry.getValue().getCantidad()).append("]\n");
			}
		}
		return sb.toString();
	}
	
	// Crea e ingresa un nuevo producto al catálogo
	public String subirProducto(String nombreProducto, byte categoria, double precio, int cantidad) {
		/*
		  Propósito: Crea un nuevo producto con los Parámetros ingresados y lo agrega al catálogo
		  
		  Parámetros de entrada: 
		  -Vendedor vendedor: El que esta crea el Producto
		  -String nombreProducto, String categoria, dobule precio, int cantidad: Características del Producto
		 */
		
		Producto prod = new Producto(nombreProducto, categorias[categoria], this, precio, cantidad);
		catalogo.put(prod.getId(), prod);
		totalDeProductosSubidos ++;
		return "\nSe ha agregado correctamente el producto al catálogo con la siguiente información: " + 
		prod.toString() + ", Cantidad: " + cantidad + "]\n";
		
	}

	public String cambiarPrecio(int codigoProducto, double precio) {
		/*
			  Propósito: Poderle cambiar el precio a un Producto en caso de ser necesario
			  
			  Parámetros de entrada: 
			  -String nombre: El nombre del producto al cual se le modificará precio 
			  -dobule precio: Nuevo precio
			 
			  Parámetros de salida: 
			  -String: Un mensaje que indica si se cambio el precio
		 */

		Producto prod = null;

		// Comprobar que el producto este en el catalogo
		if (catalogo.containsKey(codigoProducto)) {

			prod = catalogo.get(codigoProducto);
			
			//Comprobar que el vendedor es dueño del producto
			if (prod.getVendedor().equals(this)) {
				prod.setPrecio(precio);
				
				OpcionDeMenu.controlError = true;
				return "Se ha cambiado el precio del producto: " + prod.getNombreProducto() + ". Precio nuevo: " + prod.getPrecio() + "\n";
			}
			else {
				return "Usted no es propietario de este producto";
			}
			
		} else {
			return "Producto no encontrado, no se puede cambiar el precio.\n";
		}
	}

	public String modificarCantidad(int codigoProducto, int cantidad, byte operador) {
		/*
		  Propósito: Poderle cambiar la cantidad del un Producto
		  
		  Parámetros de entrada: 
		  -String nombre: El nombre del producto al cual se le modificará la cantidad 
		  -int valorOperar: Cuantos productos van a agregar o quitar 
		  -String operador: Decide si se van a sumar o restar a la cantidad  actual
		 
		   Parámetros de salida: 
		   -String: Un mensaje que indica lo que sucedio con el proceso
		 */

		Producto prod = null;

		// Comprobar que el producto este en el catalogo
		if (catalogo.containsKey(codigoProducto)) {

			prod = catalogo.get(codigoProducto);

			//Comprobar que el vendedor es dueño del producto
			if (prod.getVendedor().equals(this)) {
				if (operador == 1) {
					//Sumando la cantidad
					prod.setCantidad(prod.getCantidad() + cantidad);
					OpcionDeMenu.controlError = true;
					return "Se aumentó la cantidad del producto: " + prod.getNombreProducto() + ". Cantidad actual: " + prod.getCantidad() + "\n";
				}
				else {
					//Disminuyendo la cantidad

					//Condicional para cantidades resultantes negativas
					if (prod.getCantidad() - cantidad >= 0) {
						prod.setCantidad(prod.getCantidad() + cantidad);
						OpcionDeMenu.controlError = true;
						return "Se redujo la cantidad del producto: " + prod.getNombreProducto() + ". Cantidad actual: " + prod.getCantidad() + "\n";
					} else {
						return "No hay suficientes productos, no se puede disminuir esta cantidad";
					}
				}
			}
			else {
				return "Usted no es propietario de este producto.\n";
			}
		} else {
			return "Producto no encontrado, no se puede cambiar su cantidad.\n";
		}
	}

	// Elimina un producto por codigo
	public String eliminarProductoCatalogo(int codigoProducto) {
		/*
		  Propósito: Poder eliminar un producto del catálogo propio mediante el codigo
		  
		  Parámetros de entrada: 
		  -int cod: Código del Producto
		 
		  Parámetros de salida: 
		  -String: Un mensaje que indica si se eliminó elproducto
		 */

		Producto prod = null;

		// Comprobar que el producto este en el catalogo
		if (catalogo.containsKey(codigoProducto)) {

			prod = catalogo.get(codigoProducto);
			
			//Comprobar que el vendedor es dueño del producto
			if (prod.getVendedor().equals(this)) {
				
				catalogo.remove(codigoProducto);
				totalDeProductosSubidos --;
				OpcionDeMenu.controlError = true;
				return "Se ha cambiado eliminado el producto: " + prod.getNombreProducto() + " del catálogo\n";
			}
			else {
				return "Usted no es propietario de este producto";
			}
			
		} else {
			return "Producto no encontrado, no se puede eliminar.\n";
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Publicaciones en el catálogo:" + totalDeProductosSubidos + "]";
	}
}