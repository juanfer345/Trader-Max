
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

	public void agregarACarrito(Producto producto) {
		if (producto.getCantidad() > 0) {
			carrito.productos.add(producto);
			carrito.setTotalproductos(carrito.getTotalproductos() + 1);
			carrito.setPrecioTotal(carrito.getPrecioTotal() + producto.getPrecio());
		}
	}

	public static Producto buscar(int codigo) {
		boolean x = true;
		Producto mens = null; 
		for(Map.Entry <Integer, Producto> entry : Vendedor.catalogo.entrySet()) {
			Producto p = entry.getValue();
			if(p.getCodigoProducto() == codigo) {
				mens = p;
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
			if (p.categoria == cat) {
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

	public HashMap<Integer, Producto> getHistorial() {
		return historial;
	}

	public CarritoDeCompras getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoDeCompras carrito) {
		this.carrito = carrito;
	}

}