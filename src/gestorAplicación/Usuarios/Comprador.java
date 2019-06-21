package gestorAplicación.Usuarios;

import java.util.Deque;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;

import gestorAplicación.Materiales.CarritoDeCompras;
import gestorAplicación.Materiales.Producto;

public class Comprador extends Cuenta {

	public CarritoDeCompras carrito;
	private ArrayList<Producto> historial = new ArrayList<>();
	private CarritoDeCompras carrito;		// Lo convertí a privado (Juanfer)
	private HashMap <Integer, Producto> historial = new HashMap <>();

	public Comprador(String nombre, String correo, String password, String cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		this.id = contador++;
	}

	
	// Se necesita el constructor por default para la BD (Juanfer)
	public Comprador() {
	}

	public void agregarACarrito(Producto producto) {
		if (producto.getCantidad() > 0) {
			carrito.productos.add(producto);
			carrito.totalproductos++;
		}
	}

	public Producto buscarPorCodigo(int codigo) {
		Iterator<Producto> it = Vendedor.catalogo.iterator();
		Producto mens = null;
		boolean x = true;
		while (it.hasNext()) {
			Producto p = it.next();
			if (p.codigoProducto == codigo) {
				historial.add(p);
				mens = p;
			}
		}
		if (x) {
			return mens;
		} else {
			return null;
		}
	}

	public Deque buscarCategoria(String cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		Iterator<Producto> it = Vendedor.catalogo.iterator();
		while (it.hasNext()) {
			Producto p = it.next();
			if (p.categoria == cat) {
				colaProd.add(p);
			}
		}
		return colaProd;
	}

	public void borrarHistorial() {
		historial.clear();
	}

	public void mostrarHistorial() {
		/*
		 * Metodo a implementar desde interfaz recorriendo el arreglo historial e
		 * imprimiendo cada producto con la informacion basica
		 */

	}

	// Generado el get de historial para la base de datos (Juanfer)
	public HashMap <Integer, Producto> getHistorial() {
		return historial;
	}
	
	// Generado set y get del carrito (Juanfer)
	public CarritoDeCompras getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoDeCompras carrito) {
		this.carrito = carrito;
	}
}