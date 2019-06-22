package gestorAplicación.Usuarios;

import java.util.HashMap;
import gestorAplicación.Materiales.Producto;

public class Vendedor extends Cuenta {

    public static HashMap <Integer, Producto> catalogo = new HashMap<>();
	private HashMap <Integer, Producto> CatalogoPrivado = new HashMap<>();

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
		catalogo.put(producto.getCodigoProducto(), producto);
		CatalogoPrivado.put(producto.getCodigoProducto(), producto);
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
	
	public HashMap<Integer, Producto> verProductosPrivados(Vendedor vendedor){
		return vendedor.CatalogoPrivado;
	}
    
	public HashMap<Integer, Producto> verProductos() {
		return Vendedor.catalogo;
	}
	
}