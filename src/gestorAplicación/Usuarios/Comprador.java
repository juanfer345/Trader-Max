
package gestorAplicación.Usuarios;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


import gestorAplicación.Materiales.CarritoDeCompras;
import gestorAplicación.Materiales.Producto;

public class Comprador extends Cuenta {

	private CarritoDeCompras carrito;
	private HashMap<Integer, Producto> historial = new HashMap<>();

	public Comprador(String nombre, String correo, String password, String cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		this.id = contador++;
		totalCuentas++;
	}

	public Comprador() {
		totalCuentas++;
	}

	public HashMap<Integer, Producto> verProductos() {
		return Vendedor.catalogo;
	}

	public void agregarACarrito(Producto producto) {
		if (producto.getCantidad() > 0) {
			carrito.productos.add(producto);
			carrito.setTotalproductos(carrito.getTotalproductos() + 1);
			carrito.setPrecioTotal(carrito.getPrecioTotal() + producto.getPrecio());
		}
	}

	public Producto buscar(int codigo) {
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

	public Deque<Producto> buscarCategoria(String cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		(Vendedor.catalogo).forEach((k, v) -> {
			Producto p = Vendedor.catalogo.get(k);
			if (p.categoria == cat) {
				colaProd.add(p);
			}
		});

		return colaProd;

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