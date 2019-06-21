package gestorAplicaci�n.Materiales;

import gestorAplicaci�n.Usuarios.Vendedor;

import java.util.ArrayList;

public class Producto {

	private ArrayList<Rese�a> Rese�as = new ArrayList<>();
	private HashMap<Integer, Rese�a> Rese�as = new HashMap<>();
	//private ArrayList<Rese�a> Rese�as = new LinkedList<>();  porque lo declaron dos veces? (Juanfer9
	private Vendedor vendedor;
	private String nombreProducto;
	public String categoria;
	private double precio;
	public final int codigoProducto;
	private int codigoProducto; // Esto deber�a de ser privado (Nota de Juanfer)
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

	public void a�adirRese�a(Rese�a x) {
		Rese�as.add(x);
		int indice = Rese�as.size();
		Rese�as.put(indice, x);
	}
	
	// A�adido de aqui pa abajo para la BD (Juanfer)
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
	public HashMap<Integer, Rese�a> getRese�as() {
		return Rese�as;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	}
	/*
	 * public String informacionBasica() { return "Producto [nombreProducto=" +
	 * nombreProducto + ", categoria=" + categoria + ", precio=" + precio +
	 * ", codigoProducto=" + codigoProducto + ", cantidad=" + cantidad + "]"; }
	 */
	// Informacion basica para usar en el historial

}
