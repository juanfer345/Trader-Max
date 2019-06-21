package gestorAplicación.Materiales;

import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicación.Usuarios.Comprador;

public class CarritoDeCompras {
	public int totalproductos;
	private double precioTotal;
	private Comprador titular;
	public ArrayList<Producto> productos = new ArrayList<>();
	private int id;
	
	//para usar en la interfaz
	public CarritoDeCompras() {
		
	}
	public CarritoDeCompras(Comprador c) {
		this.titular = c;
	}
	
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
	
	public void quitarProducto(int codigo) {
		Iterator<Producto> it = productos.iterator();
		while (it.hasNext()) {
			Producto pr = it.next();
			if(pr.getCodigoProducto() == codigo) {
				productos.remove(pr);
			}
		}
	}

	// Generado de aqui para abajo para la BD (Juanfer)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setTotalproductos(int totalproductos) {
		this.totalproductos = totalproductos;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

}
