package gestorAplicación.Materiales;

import java.util.HashMap;
import java.util.Map;

import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.Vendedor;

public class CarritoDeCompras {
	private int totalProductos;
	private double precioTotal;
	private Comprador titular;
	public HashMap<Integer, Integer> productos = new HashMap<>();// Carrito {Codigo, Cantidad};
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

	public String comprarProductos() {
		double total = 0;
		for (Map.Entry<Integer, Integer> entry : productos.entrySet()) {
			int codigo = entry.getKey();
			int cantidad = entry.getValue();
			Producto p = Vendedor.catalogo.get(codigo);
			setPrecioTotal(getPrecioTotal() + (p.getPrecio() * cantidad));
		}
		total = getPrecioTotal();
		if (titular.getCuentaBancaria().getSaldo() >= total) {
			for (Map.Entry<Integer, Integer> entry : productos.entrySet()) {
				int codigo = entry.getKey();
				int cantidad = entry.getValue();
				Producto p = Vendedor.catalogo.get(codigo);
				double precio = p.getPrecio() * cantidad;
				titular.getCuentaBancaria().Transaccion(titular.getCuentaBancaria(),
						p.getVendedor().getCuentaBancaria(), precio);
				p.setCantidad(p.getCantidad() - cantidad);
				if (p.getCantidad() == 0) {
					Vendedor.catalogo.remove(codigo);
				}
			}
			productos.clear();
			totalProductos = 0;
			return "Se han comprado los productos. Saldo restante: " + titular.getCuentaBancaria().getSaldo();
		} else {
			return "Saldo insuficiente, no se pueden comprar los productos";
		}
	}

	public String vaciarCarrito() {
		productos.clear();
		totalProductos = 0;
		return "Su carrito está vacío";
	}

	public String quitarProducto(int codigo, int cantidad) {
		if (cantidad > 0) {
			if (productos.containsKey(codigo)) {
				if (productos.get(codigo) >= cantidad) {
					productos.put(codigo, productos.get(codigo) - cantidad);
					if (cantidad == 1) {
						return "Se ha quitado el producto " + Vendedor.catalogo.get(codigo).getNombreProducto()
								+ " del carrito";
					} else {
						return "Se han quitado " + cantidad + " " + Vendedor.catalogo.get(codigo).getNombreProducto()
								+ " del carrito";
					}
				} else {
					return "La cantidad ingresada excede la existente";
				}
			} else {
				return "El producto no está en el carrito";
			}
		} else {
			return "La cantidad ingresada debe ser mayor a cero";
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
