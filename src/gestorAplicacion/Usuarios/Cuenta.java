/*	Clase Cuenta (pública abstracta, implementa InterfazCategorias )      
	
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

import gestorAplicacion.Materiales.Producto;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public abstract class Cuenta implements InterfazCategorias {

	public static HashMap<Integer, Producto> catalogo = new HashMap<>();
	MenuDeConsola menu;
	protected static ArrayList<OpcionDeMenu> cambioOpDeMen;
	private String nombre, correo, password;
	public int id;
	private int cedula;
	static int contador;
	static int totalCuentas;


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
	
	// Metodos de retorno y modificación de los atributos de la clase
	public Cuenta() {setMenuPredeterminado();}
	
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

	public static void setMaxID(int contador) {Cuenta.contador = contador + 1;}

	// Devuelve el catálogo (HashMap) con todos los productos disponibles
	public HashMap<Integer, Producto> getCatalogo() {
		return catalogo;
	}

	//Devuelve el menu de consola del usuario 
	public MenuDeConsola getMenuDeConsola() {
		return menu;
	}
	
	// Devuelve el menú del usuario (ArrayList de opciones de menú)
	public ArrayList<OpcionDeMenu> getMenu() {
        return menu.getmenuUsuario();
	}

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

	// Devuelve el ArrayList con las opciones de menú
	public static ArrayList<OpcionDeMenu> getCambioOpDeMen() {
		return cambioOpDeMen;
	}
    
	// Modificación del menú ingresando el ArrayList por el cual se desea cambiar
	public static void setCambioOpDeMen(ArrayList<OpcionDeMenu> cambioOpDeMen) {
		Cuenta.cambioOpDeMen = cambioOpDeMen;
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
			return "\nLa aplicación será cerrada.";
		} else if (seleccion == 2) { // 2 para continuar en la aplicación
			OpcionDeMenu.controlError = true;
			return "";
		} else {
			return "Por favor ingrese un número entero en el rango [1,2].";
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
			return prod.toString() + "\n";
		} else if (catalogo.isEmpty()) {
			OpcionDeMenu.controlError = true;
			return "El catálogo se encuentra vacío.\n";
		} else {
			return "Producto no encontrado.\n";
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

		// Búsqueda de cada producto
		catalogo.forEach((k, v) -> {
			Producto prod = catalogo.get(k);
			if (prod.getNombreProducto().contains(nombre)) {
				sb.append(prod.toString()).append('\n');
			}
		});

		// Comprobación del resultado
		if (sb.length() > 0) {
			OpcionDeMenu.controlError = true;
			return "\nEl producto fue encontrado: \n" + sb.toString();
		} else if (catalogo.isEmpty()) {
			OpcionDeMenu.controlError = true;
			return "El catálogo se encuentra vacío.\n";
		} else {
			return "Producto no encontrado.\n";
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

		if (!catalogo.isEmpty()) {
			sb.append("\nCatálogo de TRADER-MAX: \n");
			for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
				sb.append(entry.getValue().toString() + '\n');
			}
			OpcionDeMenu.controlError = true;
			return sb.toString();
		} else {
			OpcionDeMenu.controlError = true;
			return "El catálogo se encuentra vacío.\n";
		}
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

		// Verificación de catalogo no vacío
		if (!catalogo.isEmpty()) {
			// Verificación de índice válido 
			cat--;
			if (cat >= 0 && cat < categorias.length) {

				// Ciclo para hallar cada producto de la categoría adecuada
				for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
					Producto prod = entry.getValue();
					if (prod.getCategoria() == Producto.categorias[cat]) {
						sb.append(prod.toString() + '\n');
					}
				}
				OpcionDeMenu.controlError = true;
				if (sb.length() > 0) {
					return "Categoría " + Producto.categorias[cat] + ":\n" + sb.toString();
				} else {
					return "La categoría se enguentra vacia.\n";
				} 
				
			} else {
				return "Categoria inválida, por favor ingrese un índice dentro del rango establecido.";
			}
		} else {
			OpcionDeMenu.controlError = true;
			return "El catálogo se encuentra vacío.\n";
		}
	}

	@Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", id=" + id + ", cedula="
				+ cedula;
	}
}