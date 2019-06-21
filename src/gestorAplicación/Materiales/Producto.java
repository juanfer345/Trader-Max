package gestorAplicación.Materiales;

import gestorAplicación.Usuarios.Vendedor;

import java.util.ArrayList;

public class Producto {

	private ArrayList<Reseña> Reseñas = new ArrayList<>();
	private Vendedor vendedor;
	private String nombreProducto;
	public String categoria;
	private double precio;
	public final int codigoProducto;
	private static int cont = 0;
	int cantidad;

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
		Reseñas.add(x);

	}
	/*
	 * public String informacionBasica() { return "Producto [nombreProducto=" +
	 * nombreProducto + ", categoria=" + categoria + ", precio=" + precio +
	 * ", codigoProducto=" + codigoProducto + ", cantidad=" + cantidad + "]"; }
	 */
	// Informacion basica para usar en el historial

}
