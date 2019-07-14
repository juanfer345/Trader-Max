package gestorAplicacion.Usuarios;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Map;
import gestorAplicacion.Materiales.Producto;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public abstract class Cuenta {

	public static HashMap <Integer, Producto> catalogo = new HashMap <> ();
	protected static MenuDeConsola menu = new MenuDeConsola();
	protected static ArrayList <OpcionDeMenu> cambioOpDeMen;
	protected int totalDeOpcionesDefault;
	private String nombre, correo, password;
	public int id;
	private int cedula;
	static protected int contador;
	static int totalCuentas;
	
	public String getNombre() {return nombre;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public String getCorreo() {return correo;}
	
	public void setCorreo(String correo) {this.correo = correo;}
	
	public int getId() {return id;}
	
	public void setId(int id) {this.id = id;}
	
	public int getCedula() {return cedula;}
	
	public void setCedula(int cedula) {this.cedula = cedula;}
	
	public String getPassword() {return password;}
	
	public void setPassword(String password) {this.password = password;}
		
	public abstract ArrayList <OpcionDeMenu> getOpcionesDeMenu();
	
	abstract void setOpcionesDeMenuPredeterminadas();
	abstract ArrayList <OpcionDeMenu> getOpcionesDeMenuPredeterminadas();
	
	//Comando para salir de la aplicación
	public String salir (byte seleccion) {
		if (seleccion == 1) {
			OpcionDeMenu.controlError = true; 
			MenuDeConsola.SalirApp = true;
			return "\nLa aplicación será cerrada\n";
		}
		else if (seleccion == 2) {
			OpcionDeMenu.controlError = true; 
			MenuDeConsola.SalirApp = false;
			return "";
		}
		else {
			OpcionDeMenu.controlError = false; 
			MenuDeConsola.SalirApp = false;
			return "\nPor favor ingrese un número válido [1 ó 2].";
		}
	}
	
	//Búsqueda de producto por código
	public String buscarProducto(int codigo) {
		
		Producto prod;
	    StringBuilder sb = new StringBuilder();
		
		if (Vendedor.catalogo.containsKey(codigo)) {

			prod = Vendedor.catalogo.get(codigo);
			sb.append("\nEl producto fue encontrado: \n");
			sb.append("[Nombre: " + prod.getNombreProducto() + ",/n");
			sb.append("Categoria: " + prod.getCategoria() + ",/n");
			sb.append("Precio: " + prod.getPrecio() + ",/n");
			sb.append("Código: " + codigo + ",/n");
			sb.append("Cantidad: " + prod.getCantidad() + "]/n");
			OpcionDeMenu.controlError = true;
			return sb.toString();
		}
		else {
			return sb.append("Producto no encontrado.").toString();
		}
	}
	
	//Búsqueda de producto por nombre (puede retornar varios resultados)
	public String buscarProducto(String nombre) {
		
	    StringBuilder sb = new StringBuilder();
	    
	    //Búsqueda de cada producto
		Vendedor.catalogo.forEach((k, v) -> {
			Producto prod = Vendedor.catalogo.get(k);
			if (prod.getNombreProducto().contains(nombre)) {
				sb.append(prod.toString() + '\n');
			}
		});
		
		//Comprobación del resultado
		if (sb.length() > 0) {
			OpcionDeMenu.controlError = true;
			return sb.append("\nEl producto fue encontrado: \n" + sb).toString();
		}
		else {
			return sb.append("Producto no encontrado.").toString();
		}
	}
	
	//Mostrar catálogo (todos los productos)
	public String mostrarCatalogo() {
		
	    StringBuilder sb = new StringBuilder();
		for (Map.Entry <Integer, Producto> entry : catalogo.entrySet()) {
			sb.append(entry.getValue().toString() + '\n');
		}
		return sb.append("\nCatálogo de Trader-Max: \n" + sb).toString();
	}
	
	//Mostrar todos los productos de una categoria
	public String mostrarCategoria(byte cat) {
		
	    StringBuilder sb = new StringBuilder();
	    
		//Verificación de índice válido
		if (cat > 0 && cat < Producto.categorias.length) {
			
			//Ciclo para hallar cada producto de la categoría adecuada
			(Vendedor.catalogo).forEach((k, v) -> {
				Producto prod = Vendedor.catalogo.get(k);
				if (prod.getCategoria() == Producto.categorias[cat]) {
					sb.append(prod.toString() + '\n');
				}
			});
		} else {
			sb.append("Categoria inválida, por favor ingrese un índice dentro del rango establecido.");
		}
		return sb.toString();
	}

	public int getTotalDeOpcionesDefault() {
		return totalDeOpcionesDefault;
	}

	public static ArrayList<OpcionDeMenu> getCambioOpDeMen() {
		return cambioOpDeMen;
	}

	public static void setCambioOpDeMen(ArrayList<OpcionDeMenu> cambioOpDeMen) {
		Cuenta.cambioOpDeMen = cambioOpDeMen;
	}

	@Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", id=" + id + ", cedula="
				+ cedula;
	}
}