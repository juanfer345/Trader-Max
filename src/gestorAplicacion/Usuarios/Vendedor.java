/* 
   Clase Vendedor (p�blica, hereda de CuentaConBanco)

   Prop�sito:
   Tipo de usuario en el programa, el cual podra subir los productos a un cat�logo para la venta de estos,
   tambi�n podra modificar los atributos de los Productos que haya subido.

   Estructuras de datos relevantes:
 */

package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import control.ControlBuscarProducto;
import control.ControlCerrarSesion;
import control.ControlMostrarCatalogo;
import control.ControlMostrarPorCategoria;
import control.ControlMostrarResenas;
import control.ControlSalir;
import control.OpcionDeMenu;
import control.Cuenta.Vendedor.ControlCambiarPrecio;
import control.Cuenta.Vendedor.ControlEliminarProdCatalogo;
import control.Cuenta.Vendedor.ControlModificarCantidad;
import control.Cuenta.Vendedor.ControlSubirProducto;
import control.Cuenta.Vendedor.ControlVerProductos;
import gestorAplicacion.Materiales.Producto;

public class Vendedor extends CuentaConBanco implements InterfazCategorias{

	// Atributos
	private int totalDeProductosSubidos = 0;
	private static final int totalDeOpcionesDisponibles = 11;
	public HashMap<Integer,Producto> misProductos = new HashMap<Integer,Producto>();

	// Constructor para usuarios existentes (Llama al super)
	public Vendedor(int idCuenta, String nombre, String correo, String password, int cedula, boolean activa) {
		super(idCuenta, nombre, correo, password, cedula, activa);
	}

	// Constructor para usuarios existentes con cuenta repetida (Llama al super)
	public Vendedor(int idCuenta, String nombre, String correo, String password, int cedula, int idCuentaBancaria) {
		super(idCuenta, nombre, correo, password, cedula, idCuentaBancaria);
	}

	// Constructor para usuarios nuevos (Llama al super)
	public Vendedor(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
	}

	//Constructor vac�o
	public Vendedor() {}

	// Crea un nuevo men� por defecto
	public ArrayList<OpcionDeMenu> getMenuPredeterminado() {
		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] {
				new ControlBuscarProducto(), new ControlMostrarCatalogo(), new ControlMostrarPorCategoria(), 
				new ControlMostrarResenas(), new ControlSubirProducto(), new ControlVerProductos(), 
				new ControlModificarCantidad(), new ControlCambiarPrecio(), new ControlEliminarProdCatalogo(), 
				new ControlCerrarSesion(), new ControlSalir()}));
	}

	public int getTotalDeOpcionesDisponibles() {
		return totalDeOpcionesDisponibles;
	}

	public int getTotalDeProductosSubidos() {return totalDeProductosSubidos;}
	public void setTotalDeProductosSubidos(int total) {totalDeProductosSubidos += total;}

	//Muestra la informaci�n de todos los productos subidos que se encuentran en el cat�logo
	public String mostrarProductos() {

		StringBuilder sb = new StringBuilder();

		sb.append("\nTotal de productos subidos: ").append(totalDeProductosSubidos).append('\n');

		for (Map.Entry<Integer, Producto> entry : Cuenta.getCatalogo().entrySet()) {
			if (entry.getValue().getVendedor().getId() == getId()) {
				sb.append(entry.getValue().toString()).append(", Cantidad: ").
				append(entry.getValue().getCantidad()).append("\n");
			}
		}
		return sb.toString();
	}
	//intento para poner en la tabla esa
	public HashMap<Integer,Producto> verProductos(){
		for (Map.Entry<Integer, Producto> entry : Cuenta.getCatalogo().entrySet()) {
			if (entry.getValue().getVendedor().getId() == getId()) {
				misProductos.put(entry.getValue().getId(),entry.getValue());
			}
		}
		return misProductos;
	}
	// Crea e ingresa un nuevo producto al cat�logo
	public String subirProducto(String nombreProducto, byte categoria, double precio, int cantidad) {
		/*
		  Prop�sito: Crea un nuevo producto con los Par�metros ingresados y lo agrega al cat�logo

		  Par�metros de entrada: 
		  -Vendedor vendedor: El que esta crea el Producto
		  -String nombreProducto, String categoria, dobule precio, int cantidad: Caracter�sticas del Producto
		 */

		Producto prod = new Producto(nombreProducto, categorias[categoria], this, precio, cantidad);
		catalogo.put(prod.getId(), prod);
		totalDeProductosSubidos ++;
		return "\nSe ha agregado correctamente el producto al cat�logo con la siguiente informaci�n: \n" + 
		prod.toString() + ", Cantidad: " + cantidad + "]\n";

	}

	public String cambiarPrecio(int codigoProducto, double precio) {
		/*
			  Prop�sito: Poderle cambiar el precio a un Producto en caso de ser necesario

			  Par�metros de entrada: 
			  -String nombre: El nombre del producto al cual se le modificar� precio 
			  -dobule precio: Nuevo precio

			  Par�metros de salida: 
			  -String: Un mensaje que indica si se cambio el precio
		 */

		Producto prod = null;

		// Comprobar que el producto este en el catalogo
		if (catalogo.containsKey(codigoProducto)) {

			prod = catalogo.get(codigoProducto);

			//Comprobar que el vendedor es due�o del producto
			if (prod.getVendedor().equals(this)) {
				prod.setPrecio(precio);

				OpcionDeMenu.controlError = true;
				return "Se ha cambiado el precio del producto \"" + prod.getNombreProducto() + "\". Nuevo precio: " + prod.getPrecio() + "\n";
			}
			else {
				return "\nUsted no es propietario de este producto.";
			}

		} else {
			return "\nProducto no encontrado, no se puede cambiar el precio.";
		}
	}

	public String modificarCantidad(int codigoProducto, int cantidad, byte operador) {
		/*
		  Prop�sito: Poderle cambiar la cantidad del un Producto

		  Par�metros de entrada: 
		  -String nombre: El nombre del producto al cual se le modificar� la cantidad 
		  -int valorOperar: Cuantos productos van a agregar o quitar 
		  -String operador: Decide si se van a sumar o restar a la cantidad  actual

		   Par�metros de salida: 
		   -String: Un mensaje que indica lo que sucedio con el proceso
		 */

		Producto prod = catalogo.get(codigoProducto);
		if (operador == 1) {
			//Sumando la cantidad
			prod.setCantidad(prod.getCantidad() + cantidad);
			return "Se aument� la cantidad del producto \"" + prod.getNombreProducto() + "\". Nueva cantidad: " + prod.getCantidad() + "\n";
		}
		else {
			//Disminuyendo la cantidad

			//Condicional para cantidades resultantes negativas
			if (prod.getCantidad() - cantidad >= 0) {
				prod.setCantidad(prod.getCantidad() - cantidad);
				return "Se redujo la cantidad del producto \"" + prod.getNombreProducto() + "\". Nueva cantidad: " + prod.getCantidad() + "\n";
			} else {
				return "No se puede";
			}
		}
	}

	// Elimina un producto por codigo
	public String eliminarProductoCatalogo(int codigoProducto) {
		/*
		  Prop�sito: Poder eliminar un producto del cat�logo propio mediante el codigo

		  Par�metros de entrada: 
		  -int cod: C�digo del Producto

		  Par�metros de salida: 
		  -String: Un mensaje que indica si se elimin� elproducto
		 */

		Producto prod = null;

		// Comprobar que el producto este en el catalogo
		if (catalogo.containsKey(codigoProducto)) {

			prod = catalogo.get(codigoProducto);

			//Comprobar que el vendedor es due�o del producto
			if (prod.getVendedor().equals(this)) {

				catalogo.remove(codigoProducto);
				misProductos.remove(codigoProducto);
				totalDeProductosSubidos --;
				OpcionDeMenu.controlError = true;
				return "Se ha eliminado el producto \"" + prod.getNombreProducto() + "\" del cat�logo\n";
			}
			else {
				return "Usted no es propietario de este producto";
			}

		} else {
			return "Producto no encontrado, no se puede eliminar.";
		}
	}

	@Override
	public String toString() {
		return "Vendedor:" + super.toString() + ", Publicaciones en el cat�logo: " + totalDeProductosSubidos + "]";
	}
}