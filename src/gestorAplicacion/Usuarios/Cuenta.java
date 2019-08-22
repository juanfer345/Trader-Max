/*	Clase Cuenta (pública abstracta, implementa InterfazCategorias y Comparable )      
	
	Propósito: Tipo de usuario general del sistema, recoge caracteristicas comunes de los usuarios
	
	Estructuras de datos relevantes:
	- HashMap catálogo: Estructura para almacenar todos los productos existentes en el programa
	- ArrayList<OpcionDeMenu> menu: Estructura para guardar las opciones de menú del usuario
*/

package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.Producto;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.MenuConsola.OpcionDeMenu;

public abstract class Cuenta implements InterfazCategorias, Comparable<Cuenta> {

	protected static HashMap<Integer, Producto> catalogo = new HashMap<>();
	MenuDeConsola menu;
	private String nombre, correo, password;
	private int id;
	private int cedula;
	static int contador;
	static int totalCuentas;
	static int totalCuentasActivas;

	public Cuenta(int id, String nombre, String correo, String password, int cedula) {
	/*
		Propósito: Constructor de Cuenta para usuarios existentes			
		           
		Variables de entrada:
		- int id: Identificador de la cuenta como comprador
		- String nombre, int cedula: Datos personales del usuario
		- String correo, password: Datos asignados al usuario para ingreso al programa
    */
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.cedula = cedula;
	}

	Cuenta(String nombre, String correo, String password, int cedula) {
	/*
	    Propósito: Constructor de Cuenta para usuarios nuevos		
		           
		Variables de entrada:
		- String nombre, int cedula: Datos personales del usuario
		- String correo, password: Datos asignados al usuario para ingreso al programa
    */
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.cedula = cedula;
		this.id = contador++;
		totalCuentas++;
		setMenuPredeterminado();
	}
	
	//Constructor vacío
	public Cuenta() {setMenuPredeterminado();}
	
	// Metodos de retorno y modificación de los atributos de la clase
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

	public static int getTotalCuentas() {return totalCuentas;}
	public static void setTotalCuentas(int totalCuentas) {Cuenta.totalCuentas = totalCuentas;}

	public static int getTotalCuentasActivas() {return totalCuentasActivas;}
	public static void setTotalCuentasActivas(int totalCuentasActivas) {Cuenta.totalCuentasActivas += totalCuentasActivas;}

	public static void setMaxID(int contador) {Cuenta.contador = contador + 1;}

	// Devuelve el catálogo (HashMap) con todos los productos disponibles
	public static HashMap<Integer, Producto> getCatalogo() {return catalogo;}

	//Devuelve el menu de consola del usuario 
	public MenuDeConsola getMenuDeConsola() {return menu;}
	
	// Devuelve el menú del usuario (ArrayList de opciones de menú)
	public ArrayList<OpcionDeMenu> getMenu() {return menu.getmenuUsuario();}

	public void setMenu(Deque<Integer> idOpciones) {
	/*
	    Propósito: Modificar el menú que tiene el usuario ingresando las opciones
	               por las que se desea cambiar 	
		           
		Variables de entrada:
		- Deque<Integer> idOpciones: Contiene las opciones para hacer el cambio
    */
		ArrayList<OpcionDeMenu> menuTotal = OpcionDeMenu.getTodasLasOpciones();
		menu = new MenuDeConsola(); // Creacion de nuevo menú
		ArrayList<OpcionDeMenu> opciones = menu.getmenuUsuario();
		while (!idOpciones.isEmpty()) {
			opciones.add(menuTotal.get(idOpciones.poll())); 
			// Se pasan los elementos de una estructura a otra
		}
	}

	public abstract ArrayList<OpcionDeMenu> getMenuPredeterminado(); // Método que deben implmentar las clases derivadas

	// Cambio del menú predeterminado 
	void setMenuPredeterminado() {
		menu = new MenuDeConsola();
		menu.setmenuUsuario(getMenuPredeterminado());
	}
	
	public String salir(byte seleccion) {
	/*
	    Propósito: Dar la posibilidad al usuario de salir de la aplicación
		           
		Variables de entrada:
		- byte seleccion: número que se ingresa dependiendo de si desea o no salir {1, 2}
		
		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso
    */
		if (seleccion == 1) { // 1 para salir de la aplicación
			OpcionDeMenu.controlError = true;
			MenuDeConsola.SalirApp = true;
			//Devolviendo los productos no comprados en caso de ser comprador
			if (InicializacionAplicacion.usuarioActivo instanceof Comprador) {
				CarritoDeCompras.vaciarCarrito();
			}
			return "\nLa aplicación será cerrada";
		} else { // 2 para continuar en la aplicación
			OpcionDeMenu.controlError = true;
			return "";
		}
	}

	public String buscarProducto(int codigo) {
	/*
	    Propósito: Buscar el producto por código para obtener información sobre él.
		           
		Variables de entrada:
		- int codigo: Número que indica el codigo del producto que se desea buscar   
		
	    Variables de salida:
	    - String con mensaje dependiendo de si el proceso fue o no exitoso
	      Busqueda exitosa ---> Devuelve la informacion del producto {Código, nombre, precio, categoría, cantidad}
    */
		Producto prod;

		if (catalogo.containsKey(codigo)) {
			prod = catalogo.get(codigo);
			OpcionDeMenu.controlError = true;
			return "\nEl producto ha sido encontrado:\n" + prod.toString() + ", Cantidad: " + prod.getCantidad() + "]\n";
		} else {
			return "\nProducto no encontrado, intentalo de nuevo.";
		}
	}

	public String buscarProducto(String nombre) {
	/*
	    Propósito: Buscar el producto por nombre para obtener información sobre él.
		           
		Variables de entrada:
		- String nombre: Nombre del producto a buscar 
		
	    Variables de salida: 
	    - String con mensaje dependiendo de si el proceso fue o no exitoso
	      Busqueda exitosa ---> Devuelve la informacion del producto {Código, nombre, precio, categoría, cantidad}
    */
		StringBuilder sb = new StringBuilder();
		Producto prod;
		
		// Búsqueda de cada producto
		for (Map.Entry<Integer, Producto> entry: catalogo.entrySet()) {
			prod = entry.getValue();
			if (prod.getNombreProducto().contains(nombre)) {
				sb.append(prod.toString()).append(", Cantidad: ").append(prod.getCantidad()).append("]\n");
			}
		}

		// Comprobación del resultado
		if (sb.length() > 0) {
			OpcionDeMenu.controlError = true;
			return "\nSu busqueda produjo resultados: \n" + sb.toString();
		} else {
			return "\nNombre de producto no encontrado, intentalo de nuevo.";
		}
	}

	public String mostrarCatalogo() {
	/*
	    Propósito: mostrar catálogo (todos los productos)
		           
	    Variables de salida: 
	    - String con mensaje dependiendo de si el proceso fue o no exitoso
	      Busqueda exitosa ---> devuelve la informacion de todos los productos 
	                             {Código, nombre, precio, categoría, cantidad..}
    */

		StringBuilder sb = new StringBuilder();
		Producto prod;
		
		sb.append("\nCatálogo de TRADER-MAX: \n");
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
		prod = entry.getValue();
			sb.append(prod.toString()).append(", Cantidad: ").append(prod.getCantidad()).append("]\n");
		}
		OpcionDeMenu.controlError = true;
		return sb.toString();
	}

	public String mostrarCategoria(byte cat) {
	/*
	    Propósito: Mostrar todos los productos de una categoria
		           
		Variables de entrada:
		- byte cat: selección (número) dependiendo de la categoría
		
	    Variables de salida: 
	    - String con mensaje dependiendo de si el proceso fue o no exitoso
	      Busqueda exitosa ---> Devuelve la informacion los productos encontrados de acuerdo a la categoria
	                            {Código, nombre, precio, cantidad..}
    */
		StringBuilder sb = new StringBuilder();
		Producto prod;
		
		// Verificación de índice válido 
		if (cat >= 0 && cat < categorias.length) {
				
			// Ciclo para hallar cada producto de la categoría adecuada
			for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
				prod = entry.getValue();
				if (prod.getCategoria().equals(Producto.categorias[cat])) {
					sb.append(prod.toString()).append(", Cantidad: ").append(prod.getCantidad()).append("]\n");
				}
			}
			OpcionDeMenu.controlError = true;
			if (sb.length() > 0) {
				return "\nCategoría " + Producto.categorias[cat] + ":\n" + sb.toString();
			} else {
				return "La categoría \"" + Producto.categorias[cat] + "\" se encuentra vacia.\n";
			} 

		} else {
			return "Categoria inválida, por favor ingrese un índice dentro del rango establecido.";
		}
	}

	@Override
	//Comparador de cuentas (devuelve 0 si las cuentas tienen los mismos atributos comunes)
	public int compareTo(Cuenta cuenta) {
		int result;
		result = nombre.compareTo(cuenta.nombre);
		if (result == 0) {result = correo.compareTo(cuenta.correo);}
		if (result == 0) {result = password.compareTo(cuenta.password);}
		if (result == 0) {result = Integer.compare(cedula, cuenta.cedula);}
		return result;
	}

	@Override
	public String toString() {
		return "[Código: " + id + ", Nombre: " + nombre + ", Correo: " + correo + ", Contraseña: " + password + ", Cédula: " + cedula;
	}
}