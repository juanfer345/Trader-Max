package gestorAplicación.Materiales;

import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicación.Usuarios.Comprador;

public class CarritoDeCompras {
	private int totalproductos;
	private double precioTotal;
	private Comprador titular;

	public ArrayList<Producto> productos = new ArrayList<>();

	public int getTotalproductos() {
		return totalproductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void comprarProductos() {
		Iterator<Producto> it = productos.iterator();
		while (it.hasNext()) {
			Producto p = it.next();
			double precio = p.getPrecio();
			titular.getCuentaBancaria().Transaccion(titular.getCuentaBancaria(), p.getVendedor().getCuentaBancaria(), precio);
			p.cantidad--;
		}
	}
	public void vaciarCarrito() {
		productos.clear();
	}
	
	public void quitarProducto(Producto p) {
		Iterator<Producto> it = productos.iterator();
		while (it.hasNext()) {
			Producto pr = it.next();
			if(pr == p) {
				productos.remove(pr);
			}
		}
	}
}
