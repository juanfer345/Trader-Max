
package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.BuscarProducto;
import uiMain.Funcionalidades.MostrarCatalogo;
import uiMain.Funcionalidades.MostrarPorCategoria;
import uiMain.Funcionalidades.Salir;
import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarACarrito;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarResena;
import uiMain.MenuConsola.Cuenta.Comprador.BorrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.ComprarProducto;
import uiMain.MenuConsola.Cuenta.Comprador.MostrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.QuitarProductoCarrito;
import uiMain.MenuConsola.Cuenta.Comprador.VaciarCarrito;

public class Comprador extends CuentaConBanco {

	private CarritoDeCompras carrito;
	private HashMap<Integer, Producto> historial;
	private static final int totalDeOpcionesDefault = 11;
	
	//Constructor para usuarios existentes
	public Comprador(int idCuenta, String nombre, String correo, String password, int cedula) {
		super(idCuenta, nombre, correo, password, cedula);
		historial = new HashMap<>();
	}

	//Constructor para usuarios nuevos
	public Comprador(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
		carrito = new CarritoDeCompras(this);
		historial = new HashMap<>();
		InicializacionAplicacion.getBDCarritos().put(carrito.getId(), carrito);
	}
	
	public ArrayList<OpcionDeMenu> getMenuPredeterminado() {
		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
					new BuscarProducto(), new MostrarCatalogo(), new MostrarPorCategoria(),
					new AgregarACarrito(), new AgregarResena(), new BorrarHistorial(), 
					new ComprarProducto(), new MostrarHistorial(), new QuitarProductoCarrito(), 
					new VaciarCarrito(), new CerrarSesion(), new Salir()}));
	}
	
	public int getTotalDeOpcionesDefault() {
		return totalDeOpcionesDefault;
	}
	
	public CarritoDeCompras getCarrito() {return carrito;}
	public void setCarrito(CarritoDeCompras carrito) {this.carrito = carrito;}
	
	public HashMap<Integer, Producto> getHistorial() {return historial;}
	
	public String agregarACarrito(int codigo, int cantidad) {
		if (!catalogo.isEmpty()) {
			if (cantidad > 0) {
				if (catalogo.containsKey(codigo)) {
					Producto p = catalogo.get(codigo);
					if (p.getCantidad() >= cantidad) {
						carrito.setProductos(codigo, cantidad);
						carrito.setTotalproductos(carrito.getTotalproductos() + cantidad);
						carrito.setPrecioTotal(carrito.getPrecioTotal() + (cantidad * p.getPrecio()));
						OpcionDeMenu.controlError = true;
						if (cantidad == 1) {
							return "Se ha agregado el producto " + p.getNombreProducto() + " al carrito exitosamente.";
						} else {
							return "Se han agregado " + cantidad + " " + p.getNombreProducto()
									+ " al carrito exitosamente.";
						}
					} else {
						return "La cantidad ingresada es mayor a la existente en el catálogo.";
					}
				} else {
					return "El producto no existe, código inválido.";
				}
			} else {
				return "La cantidad ingresada debe ser mayor a cero.";
			}
		} else {
			return "El catálogo está vacío";
		}
	}
	
	public void mostrarHistorial() {
		if(!historial.isEmpty()) {
			historial.forEach((k, v) -> {
				System.out.println(v);
			});
		}else {
			System.out.println("El historial está vacío. ");
		}
	}
	public String borrarHistorial() {
		historial.clear();
		return "El historial se ha borrado exitosamente";
	}

	public String anadirResena(int codigo, Resena r) {
		if (historial.containsKey(codigo)) {
			Producto p = historial.get(codigo);
			int indice = p.getResenas().size();
			p.getResenas().put(indice, r);
			return "Reseña del producto: " + p.getNombreProducto() + "ha sido añadida";
		} else {
			return "No ha comprado este producto, no puede añadir una reseña";
		}

	}

	@Override
	public String toString() {
		return super.toString() + ", carrito#=" + carrito.getId() + "]";
	}
}