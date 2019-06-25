package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public abstract class Cuenta {
	
	protected static MenuDeConsola menu;
	private String nombre, correo, password;
	public int id;
	private int cedula;
	static protected int contador;
	static int totalCuentas;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCedula() {
		return cedula;
	}
	
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String salir (int seleccion) {
		if (seleccion == 1) {
			OpcionDeMenu.controlError = true; MenuDeConsola.SalirApp = true;
			return "\n La aplicación será cerrada \n";
		}
		else if (seleccion == 2) {
			OpcionDeMenu.controlError = true; MenuDeConsola.SalirApp = false;
			return "";
		}
		else {
			OpcionDeMenu.controlError = false; MenuDeConsola.SalirApp = false;
			return "\n Por favor ingrese un número válido \n";
		}
	}

	public StringBuilder buscarProducto(int codigo) {
		
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
			
			return sb;
		}
		else {
			return sb.append("Producto no encontrado.");
		}
	}
		
	public Deque <Producto> buscarProducto(String nombre) {
		Deque<Producto> Prod = new LinkedList<Producto>();
		(Vendedor.catalogo).forEach((k, v) -> {
			Producto p = Vendedor.catalogo.get(k);
			if (p.getNombreProducto().contains(nombre)) {
				Prod.add(p);
			}
		});
		

		if(Prod != null) {
			System.out.println(Prod);
		} else {
			System.out.println("Producto no encontrado");
		}
		
		return Prod;
	}
	
	public Deque <Producto> mostrarCategoria(int cat) {
		Deque <Producto> colaProd = new LinkedList<Producto>();
		(Vendedor.catalogo).forEach((k, v) -> {
			Producto p = Vendedor.catalogo.get(k);
			if (p.getCategoria() == Producto.categorias[cat]) {
				colaProd.add(p);
			}
		});
		return colaProd;
	}
	
	public abstract ArrayList <OpcionDeMenu> getOpcionesDeMenu();
	abstract void setMenuPredeterminado();
}