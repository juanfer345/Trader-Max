package gestorAplicacion.Materiales;

import gestorAplicacion.Usuarios.Vendedor;
import java.util.HashMap;

public class Producto {

	public static String categorias[] = { "Belleza", "Veh�culos", "Deportes", "Electrodom�sticos", "Hogar", "Juegos",
			"Libros", "M�sica", "Tecnolog�a", "Vestimenta", "Vivienda" };

	public HashMap<Integer, Resena> Resenas = new HashMap<>();
	private Vendedor vendedor;
	private String nombreProducto;
	private String categoria;
	private double precio;
	private int codigoProducto;
	private static int cont;
	private int cantidad;

	public Producto() {
	}

	public Producto(Vendedor vendedor, double precio, int cant, String nombre, String categoria) {
		this.vendedor = vendedor;
		this.precio = precio;
		this.cantidad = cant;
		this.nombreProducto = nombre;
		this.categoria = categoria;
		this.codigoProducto = cont++;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public HashMap<Integer, Resena> getResenas() {
		return this.Resenas;
	}

	public int getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public static String[] getCategorias() {
		String mostrar[] = new String[10];
		for (int i = 0; i < 10; i++) { // Recorrer el Array de categorias
			mostrar[i] = categorias[i];
		}
		return mostrar;
	}

	@Override
	public String toString() {
		return "Producto [Nombre: " + nombreProducto + ", Categoria: " + categoria + ", Precio: " + precio
				+ ", C�digo: " + codigoProducto + ", Cantidad: " + cantidad + "]";
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
