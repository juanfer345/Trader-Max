
package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.BuscarProducto;
import uiMain.Funcionalidades.MostrarPorCategoria;
import uiMain.Funcionalidades.Salir;
import uiMain.Funcionalidades.Cuenta.CerrarSesion;
import uiMain.Funcionalidades.Cuenta.Comprador.AgregarACarrito;
import uiMain.Funcionalidades.Cuenta.Comprador.AgregarResena;
import uiMain.Funcionalidades.Cuenta.Comprador.BorrarHistorial;
import uiMain.Funcionalidades.Cuenta.Comprador.ComprarProducto;
import uiMain.Funcionalidades.Cuenta.Comprador.MostrarHistorial;
import uiMain.Funcionalidades.Cuenta.Comprador.QuitarProductoCarrito;
import uiMain.Funcionalidades.Cuenta.Comprador.VaciarCarrito;

public class Comprador extends CuentaUsuario {

	private CarritoDeCompras carrito;
	private HashMap<Integer, Producto> historial = new HashMap<>();

	public Comprador() {
		super();
		this.totalDeOpcionesDefault = 11;
		setOpcionesDeMenuPredeterminadas();
	}

	public Comprador(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
		this.totalDeOpcionesDefault = 11;
		setOpcionesDeMenuPredeterminadas();
	}

	public void setOpcionesDeMenuPredeterminadas() {
		Cuenta.menu.setOpcionesActivas(new ArrayList<OpcionDeMenu>(
				Arrays.asList(new OpcionDeMenu[] { new AgregarACarrito(), new BorrarHistorial(), new MostrarHistorial(),
						new VaciarCarrito(), new ComprarProducto(), new QuitarProductoCarrito(), new AgregarResena(),
						new MostrarPorCategoria(), new BuscarProducto(), new CerrarSesion(), new Salir() })));
	}

	public ArrayList<OpcionDeMenu> getOpcionesDeMenuPredeterminadas() {
		return new ArrayList<OpcionDeMenu>(
				Arrays.asList(new OpcionDeMenu[] { new AgregarACarrito(), new BorrarHistorial(), new MostrarHistorial(),
						new VaciarCarrito(), new ComprarProducto(), new QuitarProductoCarrito(), new AgregarResena(),
						new MostrarPorCategoria(), new BuscarProducto(), new CerrarSesion(), new Salir() }));
	}

	public ArrayList<OpcionDeMenu> getOpcionesDeMenu() {
		return menu.getOpcionesActivas();
	}

	public String agregarACarrito(int codigo, int cantidad) {

		if (cantidad > 0) {
			if (catalogo.containsKey(codigo)) {
				Producto p = catalogo.get(codigo);
				if (p.getCantidad() >= cantidad) {
					carrito.productos.put(codigo, cantidad);
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
	}

	public String borrarHistorial() {
		historial.clear();
		return "El historial se ha borrado exitosamente";
	}

	public HashMap<Integer, Producto> getHistorial() {
		return historial;
	}

	public CarritoDeCompras getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoDeCompras carrito) {
		this.carrito = carrito;
	}

	public String añadirReseña(int codigo, Resena r) {
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