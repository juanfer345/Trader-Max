package gestorAplicación.Materiales;

import gestorAplicación.Usuarios.Vendedor;
import java.util.HashMap;

public class Producto {

	private HashMap<Integer, Reseña> Reseñas = new HashMap<>();
	private ArrayList<Reseña> Reseñas = new LinkedList<>();
	private Vendedor vendedor;
	private String nombreProducto;
	private String categoria;
	private double precio;
	int codigoProducto;
	private static int cont = 0;
	int cantidad;
	//Lo puse para poder usarlo en la interfaz
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

}