package gestorAplicación.Materiales;

import java.util.ArrayList;
import java.util.Iterator;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.Vendedor;

public class CarritoDeCompras {
	private int totalProductos;
	private double precioTotal;
	private Comprador titular;
	public ArrayList<Producto> productos = new ArrayList<>();
	private int id;

	public CarritoDeCompras() {
	}

	public CarritoDeCompras(Comprador c) {
		this.titular = c;
	}

	public int getTotalproductos() {
		return totalProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void comprarProductos() {
		Iterator<Producto> it = productos.iterator();
		while (it.hasNext()) {
			Producto p = it.next();
			double precio = p.getPrecio();
			titular.getCuentaBancaria().Transaccion(titular.getCuentaBancaria(), p.getVendedor().getCuentaBancaria(),
					precio);
			p.setCantidad(p.getCantidad() - 1);
			if (p.getCantidad() == 0) {
				Vendedor.catalogo.remove(p);
			}
		}
		productos.clear();
		totalProductos = 0;
	}

	public void vaciarCarrito() {
		productos.clear();
		totalProductos = 0;
	}

	public void quitarProducto(int codigo) {
		Iterator<Producto> it = productos.iterator();
		while (it.hasNext()) {
			Producto pr = it.next();
			if (pr.getCodigoProducto() == codigo) {
				productos.remove(pr);
				totalProductos--;
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTotalproductos(int totalproductos) {
		this.totalProductos = totalproductos;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public String toString() {
		return "CarritoDeCompras [totalProductos=" + totalProductos + ", precioTotal=" + precioTotal + "]";
	}

}
