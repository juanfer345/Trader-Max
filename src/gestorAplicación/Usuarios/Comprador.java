
package gestorAplicación.Usuarios;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import gestorAplicación.Materiales.CarritoDeCompras;
import gestorAplicación.Materiales.Producto;

public class Comprador extends CuentaUsuarios {

	private CarritoDeCompras carrito;
	private HashMap<Integer, Producto> historial = new HashMap<>();

	public Comprador(String nombre, String correo, String password, String cedula) {
		super(nombre, correo, password, cedula);
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

	public static Deque<Producto> buscarCategoria(String cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		(Vendedor.catalogo).forEach((k, v) -> {
			Producto p = Vendedor.catalogo.get(k);
			if (p.getCategoria() == cat) {
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

	public void borrarHistorial() {
		historial.clear();
	}

	public/* static */ HashMap<Integer, Producto> getHistorial() {
		return historial;
	}

	public CarritoDeCompras getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoDeCompras carrito) {
		this.carrito = carrito;
	}

}