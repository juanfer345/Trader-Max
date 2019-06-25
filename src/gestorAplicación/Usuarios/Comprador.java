
package gestorAplicación.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import gestorAplicación.Materiales.CarritoDeCompras;
import gestorAplicación.Materiales.Producto;
import gestorAplicación.Materiales.Resena;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.*;

public class Comprador extends CuentaUsuario {
	
	private CarritoDeCompras carrito;
	private HashMap <Integer, Producto> historial = new HashMap <> ();
	
	public void setMenuPredeterminado() {
		Cuenta.menu.cambiarMenu(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new agregarACarrito(), new borrarHistorial(), 
										  new mostrarHistorial(), new vaciarCarrito(), new comprarProducto(), new quitarProducto, 
										  new agregarReseña(), new buscarCategoria(), new buscarProducto(), new cerrarSesion, new salir()})), this);
	}
	
	public void setMenu(ArrayList <OpcionDeMenu> opcionesActivas) {
		Cuenta.menu.cambiarMenu(opcionesActivas, this);
	}

	public Comprador(String nombre, String correo, String password, String cedula) {
		super(nombre, correo, password, cedula);
		Cuenta.menu = new MenuDeConsola(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new iniciarSesion(), new registrar(), 
				  		new buscarProducto(), new buscarCategoria(),new salir()})), this);
	}
	
	public Comprador() {
		super();
	}

	public String agregarACarrito(int codigo, int cantidad) {

		if (cantidad > 0) {
			if(catalogo.containsKey(codigo)) {
				Producto p = catalogo.get(codigo);
				if (p.getCantidad() >= cantidad) {
					carrito.productos.put(codigo, cantidad);
					carrito.setTotalproductos(carrito.getTotalproductos() + cantidad);
					carrito.setPrecioTotal(carrito.getPrecioTotal() + (cantidad * p.getPrecio()));
					if (cantidad == 1) {
						return "Se ha agregado el producto " + p.getNombreProducto() + " al carrito";
					}
					else {
						return "Se han agregado " + cantidad + " " + p.getNombreProducto() + " al carrito";
					}
				}
				else {
					return "La cantidad ingresada es mayor a la existente";
				}
			}else {
				return "El producto no existe";
			}
		} else {
			return "La cantidad ingresada debe ser mayor a cero";
		}
	}
	
	public static Producto buscar(int codigo) {
		boolean x = false;
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : Vendedor.catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getCodigoProducto() == codigo) {
				mens = p;
				x = true;
			}
		}
		if (x) {
			return mens;
		} else {
			return null;
		}
	}

	public static Deque<Producto> buscarCategoria(int cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		(Vendedor.catalogo).forEach((k, v) -> {
			Producto p = Vendedor.catalogo.get(k);
			if (p.getCategoria() == Producto.categorias[cat]) {
				colaProd.add(p);
			}
		});
		return colaProd;
	}

	public static Deque<Producto> buscar(String nombre) {
		Deque<Producto> Prod = new LinkedList<Producto>();
		(Vendedor.catalogo).forEach((k, v) -> {
			Producto p = Vendedor.catalogo.get(k);
			if (p.getNombreProducto().contains(nombre)) {
				Prod.add(p);
			}
		});
		return Prod;
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
		if(historial.containsKey(codigo)) {
			Producto p = historial.get(codigo);
			int indice = p.Resenas.size();
			p.Resenas.put(indice, r);
			return "Reseña del producto: " + p.getNombreProducto() + "ha sido añadida";
		}else {
			return "No ha comprado este producto, no puede añadir una reseña";
		}

	}
}