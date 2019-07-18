package gestorAplicacion.Materiales;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Vendedor;

import java.util.Deque;
import java.util.HashMap;

public class Producto {

	public static String categorias[] = { "Belleza", "Vehículos", "Deportes", "Electrodomésticos", "Hogar", "Juegos",
			"Libros", "Música", "Tecnología", "Vestimenta", "Vivienda" };

	public HashMap<Integer, Resena> resenas;
	private Vendedor vendedor;
	private String nombreProducto;
	private String categoria;
	private double precio;
	private int id, cantidad;
	private static int contador;
	
	//Constructor para productos existentes
	public Producto(int codigoProducto, String nombreProducto, String categoria, double precio, int cantidad) {
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.precio = precio;
		this.id = codigoProducto;
		this.cantidad = cantidad;
	}
	
	//Constructor para productos nuevos
	public Producto(String nombreProducto, String categoria, Vendedor vendedor, double precio, int cantidad) {
		this.vendedor = vendedor;
		this.precio = precio;
		this.cantidad = cantidad;
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.id = contador++;
		resenas = new HashMap<>();
	}

	public int getCantidad() {return cantidad;}
	public void setCantidad(int cantidad) {this.cantidad = cantidad;}

	public Vendedor getVendedor() {return vendedor;}

	public double getPrecio() {return precio;}
	public void setPrecio(double precio) {this.precio = precio;}

	public String getNombreProducto() {return nombreProducto;}
	public void setNombreProducto(String nombreProducto) {this.nombreProducto = nombreProducto;}

	public String getCategoria() {return categoria;}
	public void setCategoria(String categoria) {this.categoria = categoria;}

	public HashMap<Integer, Resena> getResenas() {return resenas;}
	public void setResenas(Deque <Integer> idResenas) {
		resenas = new HashMap <> ();
		int aux;
    	while(!idResenas.isEmpty()) {
    		aux = idResenas.poll();
    		resenas.put(aux, InicializacionAplicacion.getBDResenas().get(aux));
    	}
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public static void setMaxID(int contador) {
		Producto.contador = contador + 1;
	}
	
	public static String[] getCategorias() {
		String mostrar[] = new String[10];
		for (int i = 0; i < 10; i++) { // Recorrer el Array de categorias
			mostrar[i] = categorias[i];
		}
		//Creo que el to String de los arreglos debería hacer lo mismo no?
		return mostrar;
	}

	@Override
	public String toString() {
		return "Producto [Nombre: " + nombreProducto + ", Categoria: " + categoria + ", Precio: " + precio
				+ ", Código: " + id + ", Cantidad: " + cantidad + "]";
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
