/* 
   Clase Producto (pública implementa InterfazCategorias)
   
   Propósito:
   Se definen todos los metodos y atributos que tendra cada Producto
   Tambien se podran obtener y modificar estos productos
   
   Estructuras de datos relevantes:
   - Lista que contiene cada una de las categorias disponibles en la aplicación
     (Predeterminadas)
   - HashMap<Integer, Resena> resenas: Contiene las reseñas de un Producto
 */

package gestorAplicacion.Materiales;

import java.util.Deque;
import java.util.HashMap;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.InterfazCategorias;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class Producto implements InterfazCategorias {

	// Atributos
	public HashMap<Integer, Resena> resenas;
	private Vendedor vendedor;
	private String nombreProducto;
	private String categoria;
	private double precio;
	private int id, cantidad;
	private static int contador;

	// Constructor para productos existentes
	public Producto(int codigoProducto, String nombreProducto, String categoria, double precio, int cantidad) {
		/*
		  Propósito: Modificar algunos datos de un Producto ya existente
		  
		  Parámetros de entrada: 
		  - int codigoProducto: Codigo del producto a crear 
		  - String nombreProducto: Nombre del producto 
          - String categoria: Categoría en la cual encaja el producto 
          - double precio: Precio del producto 
          - int cantidad: Cantidad de unidades del producto
		 */
		this.id = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	// Constructor para productos nuevos
	public Producto(String nombreProducto, String categoria, Vendedor vendedor, double precio, int cantidad) {
		/*
		  Propósito: Crear un nuevo producto con todos sus datos 
		  Parámetros de entrada: 
		  - String nombreProducto: Nombre del producto 
		  - String categoria: Categoría en la cual encaja el producto 
		  - Vendedor vendedor: Vendedor al cual se le asignará el producto 
		  - double precio: Precio del producto 
		  - int cantidad: Cantidad de unidades del producto
		 */
		this.vendedor = vendedor;
		this.precio = precio;
		this.cantidad = cantidad;
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.id = contador++;
		resenas = new HashMap<>();
		InicializacionAplicacion.getBDProductos().put(id, this);
	}

	// Retorna el atributo cantidad
	public int getCantidad() {
		return cantidad;
	}

	// Modifica el atributo cantidad
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	// Retorna el atributo vendedor
	public Vendedor getVendedor() {
		return vendedor;
	}

	// Retorna el atributo precio
	public double getPrecio() {
		return precio;
	}

	// Modifica el atributo precio
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	// Retorna el atributo nombreProdcuto
	public String getNombreProducto() {
		return nombreProducto;
	}

	// Modifica el atributo nombreProducto
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	// Retorna el atributo categoria
	public String getCategoria() {
		return categoria;
	}

	// Modifica el atributo categoria
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	// Retorna el atributo resenas el cual es una tabla hash que trae las reseñas de
	// un producto
	public HashMap<Integer, Resena> getResenas() {
		return resenas;
	}

	// Funciona para agregar reseñas a una tabla hash usando sus códigos
	public void setResenas(Deque<Integer> idResenas) {
		resenas = new HashMap<>();
		int aux;
		while (!idResenas.isEmpty()) {
			aux = idResenas.poll();
			resenas.put(aux, InicializacionAplicacion.getBDResenas().get(aux));
		}
	}

	//Funciona para agregar una reseña a un producto
	public void setResenas(Resena res) {
		resenas.put(res.getId(), res);
	}
	
	// Retorna el atributo id
	public int getId() {
		return id;
	}

	// Modifica el atributo id
	public void setId(int id) {
		this.id = id;
	}

	// Modifica el atributo contador
	public static void setMaxID(int contador) {Producto.contador = contador + 1;}

	// Para mostrar la reseñas de un producto en caso de que tenga
	public String mostrarResenas() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("\nLas reseñas del producto: \n" + toString() + ", Cantidad: " + cantidad + "]\n" + "Se muestran a continuación:\n\n");
		
		if (!resenas.isEmpty()) {
			resenas.forEach((k, v) -> {
				int i = 1;
				sb.append(i++).append(". ").append(v).append('\n');
			});
			OpcionDeMenu.controlError = true;
			return sb.toString();
		} else {
			OpcionDeMenu.controlError = true;
			return "\nEl producto no posee reseñas:\n" + toString() + ", Cantidad: " + cantidad + "]\n";
		}
	}

	// Retorna la una lista de las categorías con fines de impresión
	public static String getCategorias() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < categorias.length; i++) {
			sb.append((i + 1) + ". " + categorias[i] + '\n');
		}
		return sb.toString();
	}

	// Para imprimir un Producto
	public String toString() {
		return "[Código: " + id + ", Nombre: " + nombreProducto + ", Categoria: " + categoria + ", Precio: " + precio + ", Reseñas: " + resenas.size();
	}

	// Para cambiar el atributo vendedor
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
