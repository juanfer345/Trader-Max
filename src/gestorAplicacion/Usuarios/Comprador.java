/*	Clase Comprador (p�blica)        
	
	Prop�sito: Tipo de usuario del sistema que podr� adquirir productos
	
	Estructuras de datos relevantes:
	- HashMap historial: Estructura para almacenar historial del comprador, contiene todos
	                     los productos que ha comprado
*/

package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import uiMain.OpcionDeMenu;
import uiMain.MenuConsola.BuscarProducto;
import uiMain.MenuConsola.MostrarCatalogo;
import uiMain.MenuConsola.MostrarPorCategoria;
import uiMain.MenuConsola.Salir;
import uiMain.MenuConsola.MostrarResenas;
import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarACarrito;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarResena;
import uiMain.MenuConsola.Cuenta.Comprador.BorrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.ComprarProducto;
import uiMain.MenuConsola.Cuenta.Comprador.MostrarCarrito;
import uiMain.MenuConsola.Cuenta.Comprador.MostrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.QuitarProductoCarrito;
import uiMain.MenuConsola.Cuenta.Comprador.VaciarCarrito;

public class Comprador extends CuentaConBanco {

	private CarritoDeCompras carrito;
	private HashMap<Integer, Producto> historial;
	private static final int totalDeOpcionesDisponibles = 14;

	public Comprador(int idCuenta, String nombre, String correo, String password, int cedula) {
		/*
		 * Prop�sito: Constructor de Comprador para usuarios existentes
		 * 
		 * Variables de entrada: - int idCuenta: Identificador de la cuenta como
		 * comprador - String nombre, int cedula: Datos personales del usuario - String
		 * correo, password: Datos asignados al usuario para ingreso al programa
		 */
		super(idCuenta, nombre, correo, password, cedula); // Llamado a contructor de CuentaConBanco
		historial = new HashMap<>();
	}

	public Comprador(String nombre, String correo, String password, int cedula) {
		/*
		 * Prop�sito: Constructor de Comprador para usuarios nuevos
		 * 
		 * Variables de entrada: - String nombre, int cedula: Datos personales del
		 * usuario - String correo, password: Datos asignados al usuario para ingreso al
		 * programa
		 */
		super(nombre, correo, password, cedula); // LLamado al contructor de CuentaConBanco
		carrito = new CarritoDeCompras(this);
		historial = new HashMap<>();
	}

	public ArrayList<OpcionDeMenu> getMenuPredeterminado() {

		/*
		 * Prop�sito: Asignar al comprador un men� predeterminado de acuerdo a su perfil
		 * 
		 * Variables de salida: - ArrayList con las opciones de men� que tendr�
		 * predeterminadas el usuario.
		 */

		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { new BuscarProducto(),
				new MostrarCatalogo(), new MostrarPorCategoria(), new AgregarACarrito(), new AgregarResena(),
				new BorrarHistorial(), new ComprarProducto(), new MostrarHistorial(), new MostrarResenas(),
				new QuitarProductoCarrito(), new VaciarCarrito(), new MostrarCarrito(), new MostrarResenas(), new CerrarSesion(), new Salir() }));
	}

	// Devuelve el numero total de opciones que tiene por defecto
	public int getTotalDeOpcionesDisponibles() {
		return totalDeOpcionesDisponibles;
	}

	// Devuelve el carrito que le corresponde al comprador
	public CarritoDeCompras getCarrito() {
		return carrito;
	}

	// Cambia el carrito de compras
	public void setCarrito(CarritoDeCompras carrito) {
		this.carrito = carrito;
	}

	// Devuelve un HashMap que contiene los productos del historial (Productos qu
	// han sido comprados)
	public HashMap<Integer, Producto> getHistorial() {
		return historial;
	}

	public String agregarACarrito(int codigo, int cantidad) {
		/*
		 * Prop�sito: Agregar al carrito cierta cantidad de un producto espec�fico
		 * 
		 * Variables de entrada: - int codigo: C�digo del producto que se desea agregar
		 * - int cantidad: Cantidad de elementos que desea agregar del respectivo
		 * producto
		 * 
		 * Variables de salida: - String con mensaje dependiendo si el proceso fue o no
		 * exitoso. Se mostrar� el fallo que tiene el usuario en el ingreso de los datos
		 */
		if (!catalogo.isEmpty()) {
			if (cantidad > 0 && codigo > 0) {
				if (catalogo.containsKey(codigo)) {
					Producto p = catalogo.get(codigo);
					if (p.getCantidad() >= cantidad) {
						// Verificaci�n de que se tiene la cantidad del producto en el cat�logo
						carrito.setProductos(codigo, cantidad);
						carrito.setTotalproductos(carrito.getTotalproductos() + cantidad);
						// Se cambia el total de productos que tiene el carrito
						carrito.setPrecioTotal(carrito.getPrecioTotal() + (cantidad * p.getPrecio()));
						// Se le va aumentando el precio al carrito a medida que se agregan productos
						
						//	Se obtiene la cantidad actual del producto en el catalogo
						//	Se resta esta cantidad a la que ingreso el comprador mientras la sesion esto activa
						p.setCantidad(p.getCantidad()-cantidad);
						
						OpcionDeMenu.controlError = true;
						if (cantidad == 1) {
							return "Se ha agregado el producto " + p.getNombreProducto() + " al carrito exitosamente.";
						} else {
							return "Se han agregado " + cantidad + " " + p.getNombreProducto()
									+ " al carrito exitosamente.";
						}
					} else {
						OpcionDeMenu.controlError = true;
						return "La cantidad ingresada es mayor a la existente en el cat�logo.";
					}
				} else {
					OpcionDeMenu.controlError = true;
					return "El producto no existe, c�digo inv�lido.";
				}
			} else {
				OpcionDeMenu.controlError = true;
				return "Tanto la cantidad como el codigo ingresado deben ser mayor a cero.";
			}
		} else {
			OpcionDeMenu.controlError = true;
			return "El cat�logo est� vac�o";
		}
	}

	public void mostrarHistorial() {
		/*
		 * Prop�sito: Mostrar los productos que el usuario ha comprado
		 */
		if (!historial.isEmpty()) {
			historial.forEach((k, v) -> { // Ciclo para obtenci�n e impresi�n de los productos
				System.out.println(v);
			});
		} else {
			System.out.println("El historial est� vac�o. ");
		}
	}

	public String borrarHistorial() {
		/*
		 * Prop�sito: Borrar el historial de compras del usuario
		 */
		historial.clear();
		return "El historial se ha borrado exitosamente";
	}

	public void mostrarCarrito() {
		if (!carrito.getProductos().isEmpty()) {
			for (Map.Entry<Integer, Integer> entry : carrito.getProductos().entrySet()) {
				int cod = entry.getKey(); // el codigo del producto
				int cant = entry.getValue();
				Producto prod = catalogo.get(cod); // se obtiene el producto correspondiente al codigo
				System.out.println(prod);
				System.out.println("En el carrito: "+cant);
			}
		} else {
			System.out.println("El carrito est� vacio");
		}
	}

	public String anadirResena(int codigo, Resena r) {
		/*
		 * Prop�sito: A�adir una rese�a a un producto comprado
		 * 
		 * Variables de entrada: - int codigo: C�digo del producto al cual se le
		 * agregar� una rese�a - Rese�a r: Rese�a (comentario, estrellas) que se le
		 * quiere agregar al producto
		 * 
		 * Variables de salida: - String con mensaje dependiendo si el proceso fue o no
		 * exitoso.
		 */
		if (historial.containsKey(codigo)) {
			Producto p = historial.get(codigo);
			int indice = p.getResenas().size();
			p.getResenas().put(indice, r);
			InicializacionAplicacion.getBDResenas().put(indice, r);
			return "Rese�a del producto: " + p.getNombreProducto() + "ha sido a�adida";
		} else {
			return "No ha comprado este producto, no puede a�adir una rese�a";
		}

	}

	@Override
	public String toString() {
		return super.toString() + ", carrito#=" + carrito.getId() + "]";
	}
}