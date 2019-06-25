
package gestorAplicación.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import gestorAplicación.Materiales.CarritoDeCompras;
import gestorAplicación.Materiales.Producto;
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
	
	public Comprador(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
		Cuenta.menu = new MenuDeConsola(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new iniciarSesion(), new registrar(), 
				  		new buscarProducto(), new buscarCategoria(),new salir()})), this);
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
	
	public/*static*/ HashMap<Integer, Producto> getHistorial() {
		return historial;
	}
	
	public CarritoDeCompras getCarrito() {
		return carrito;
	}
	
	public void setCarrito(CarritoDeCompras carrito) {
		this.carrito = carrito;
	}
}