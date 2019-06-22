package gestorAplicación.Materiales;

import gestorAplicación.Usuarios.Vendedor;
import java.util.HashMap;

public class Producto {

	private static String categorias [] = {"Belleza", "Carros", "Deportes", "Electrodomesticos", "Hogar", "Juegos", "Libros", "Musica", "Tecnologia", "Vestimenta"};
	private HashMap<Integer, Reseña> Reseñas = new HashMap<>();
	private Vendedor vendedor;
	private String nombreProducto;
	public String categoria;
	private double precio;
	private int codigoProducto; 
	private static int cont;
	private int cantidad;
	
	public Producto() {
	
	}
	
	public Producto(Vendedor v, double precio, int cant, String nombre, String categoria) {
		this.vendedor = v;
		this.precio = precio;
		this.cantidad = cant;
		this.nombreProducto = nombre;
		this.categoria = categoria;
		this.codigoProducto = cont++;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void añadirReseña(Reseña x) {
		int indice = Reseñas.size();
		Reseñas.put(indice, x);
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public HashMap<Integer, Reseña> getReseñas() {
		return Reseñas;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	
	@Override
	public String toString() {
		return "Producto [nombreProducto=" + nombreProducto + ", categoria=" + categoria + ", precio=" + precio
				+ ", codigoProducto=" + codigoProducto + ", cantidad=" + cantidad + "]";
	}

}


