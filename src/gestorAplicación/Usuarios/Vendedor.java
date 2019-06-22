package gestorAplicación.Usuarios;

import java.util.HashMap;
import java.util.LinkedList;
import gestorAplicación.Materiales.Producto;

public class Vendedor extends Cuenta {

    public static HashMap <Integer, Producto> catalogo = new HashMap<>();
	//public static LinkedList<Producto> catalogo = new LinkedList<>();


	public static LinkedList<Producto> catalogo = new LinkedList<>();
	private LinkedList<Producto> CatalogoPrivado = new LinkedList<>();

	public Vendedor(String nombre, String correo, String password, String cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		this.id = contador++;
		totalCuentas++;
	}
	
	public Vendedor() {
		totalCuentas++;
	}

	public void subirProducto(Producto producto) {
		catalogo.add(producto);
		CatalogoPrivado.add(producto);
	}
	
	public double obtenerPrecio(Producto producto) {
		return producto.getPrecio();
	}

	public void ponerPrecio(Producto producto, double precio) {
		producto.setPrecio(precio);
	}
	
	public void aumentarCantidad(Producto producto, int aumentar) {
		producto.setCantidad(producto.getCantidad()+aumentar);
	}
	
	public LinkedList<Producto> verProductosPrivados(Vendedor vendedor){
		return vendedor.CatalogoPrivado;
	}
    
	public LinkedList<Producto> verProductos() {
		return Vendedor.catalogo;
	}
	
}