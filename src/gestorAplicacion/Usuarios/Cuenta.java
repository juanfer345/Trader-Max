/*	Clase Cuenta (p�blica abstracta, implementa InterfazCategorias y Comparable )      

	Prop�sito: Tipo de usuario general del sistema, recoge caracteristicas comunes de los usuarios

	Estructuras de datos relevantes:
	- HashMap cat�logo: Estructura para almacenar todos los productos existentes en el programa
	- ArrayList<OpcionDeMenu> menu: Estructura para guardar las opciones de men� del usuario
 */

package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import control.MenuDeConsola;
import control.OpcionDeMenu;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.Producto;
import uiMain.InicializacionAplicacion;

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
		Prop�sito: Constructor de Cuenta para usuarios existentes			

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
	    Prop�sito: Constructor de Cuenta para usuarios nuevos		

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

	//Constructor vac�o
	public Cuenta() {setMenuPredeterminado();}

	// Metodos de retorno y modificaci�n de los atributos de la clase
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

	// Devuelve el cat�logo (HashMap) con todos los productos disponibles
	public static HashMap<Integer, Producto> getCatalogo() {return catalogo;}

	//Devuelve el menu de consola del usuario 
	public MenuDeConsola getMenuDeConsola() {return menu;}

	// Devuelve el men� del usuario (ArrayList de opciones de men�)
	public ArrayList<OpcionDeMenu> getMenu() {return menu.getmenuUsuario();}

	public void setMenu(Deque<Integer> idOpciones) {
		/*
	    Prop�sito: Modificar el men� que tiene el usuario ingresando las opciones
	               por las que se desea cambiar 	

		Variables de entrada:
		- Deque<Integer> idOpciones: Contiene las opciones para hacer el cambio
		 */
		ArrayList<OpcionDeMenu> menuTotal = OpcionDeMenu.getTodasLasOpciones();
		menu = new MenuDeConsola(); // Creacion de nuevo men�
		ArrayList<OpcionDeMenu> opciones = menu.getmenuUsuario();
		while (!idOpciones.isEmpty()) {
			opciones.add(menuTotal.get(idOpciones.poll()));
			// Se pasan los elementos de una estructura a otra
		}
	}

	public abstract ArrayList<OpcionDeMenu> getMenuPredeterminado(); // M�todo que deben implmentar las clases derivadas

	// Cambio del men� predeterminado 
	void setMenuPredeterminado() {
		menu = new MenuDeConsola();
		menu.setmenuUsuario(getMenuPredeterminado());
	}

	public String salir() {
		/*
	    Prop�sito: Dar la posibilidad al usuario de salir de la aplicaci�n	           

		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso
		 */
		OpcionDeMenu.controlError = true;
		//Devolviendo los productos no comprados en caso de ser comprador
		if (InicializacionAplicacion.usuarioActivo instanceof Comprador) {
			CarritoDeCompras.vaciarCarrito();
		}
		return "\nLa aplicaci�n ser� cerrada";}

	public String buscarProducto(int codigo) {
		/*
	    Prop�sito: Buscar el producto por c�digo para obtener informaci�n sobre �l.

		Variables de entrada:
		- int codigo: N�mero que indica el codigo del producto que se desea buscar   

	    Variables de salida:
	    - String con mensaje dependiendo de si el proceso fue o no exitoso
	      Busqueda exitosa ---> Devuelve la informacion del producto {C�digo, nombre, precio, categor�a, cantidad}
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
	    Prop�sito: Buscar el producto por nombre para obtener informaci�n sobre �l.

		Variables de entrada:
		- String nombre: Nombre del producto a buscar 

	    Variables de salida: 
	    - String con mensaje dependiendo de si el proceso fue o no exitoso
	      Busqueda exitosa ---> Devuelve la informacion del producto {C�digo, nombre, precio, categor�a, cantidad}
		 */
		StringBuilder sb = new StringBuilder();
		Producto prod;

		// B�squeda de cada producto
		for (Map.Entry<Integer, Producto> entry: catalogo.entrySet()) {
			prod = entry.getValue();
			if (prod.getNombreProducto().contains(nombre)) {
				sb.append(prod.toString()).append(", Cantidad: ").append(prod.getCantidad()).append("]\n");
			}
		}

		// Comprobaci�n del resultado
		if (sb.length() > 0) {
			OpcionDeMenu.controlError = true;
			return "\nSu busqueda produjo resultados: \n" + sb.toString();
		} else {
			return "\nNombre de producto no encontrado, intentalo de nuevo.";
		}
	}

	public String mostrarCatalogo() {
		/*
	    Prop�sito: mostrar cat�logo (todos los productos)

	    Variables de salida: 
	    - String con mensaje dependiendo de si el proceso fue o no exitoso
	      Busqueda exitosa ---> devuelve la informacion de todos los productos 
	                             {C�digo, nombre, precio, categor�a, cantidad..}
		 */

		StringBuilder sb = new StringBuilder();
		Producto prod;

		sb.append("\n \n");
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			prod = entry.getValue();
			sb.append(prod.toString()).append(", Cantidad: ").append(prod.getCantidad()).append("\n");
		}
		OpcionDeMenu.controlError = true;
		return sb.toString();
	}

	public String mostrarCategoria(byte cat) {
		/*
	    Prop�sito: Mostrar todos los productos de una categoria

		Variables de entrada:
		- byte cat: selecci�n (n�mero) dependiendo de la categor�a

	    Variables de salida: 
	    - String con mensaje dependiendo de si el proceso fue o no exitoso
	      Busqueda exitosa ---> Devuelve la informacion los productos encontrados de acuerdo a la categoria
	                            {C�digo, nombre, precio, cantidad..}
		 */
		StringBuilder sb = new StringBuilder();
		Producto prod;

		// Verificaci�n de �ndice v�lido 
		if (cat >= 0 && cat < categorias.length) {

			// Ciclo para hallar cada producto de la categor�a adecuada
			for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
				prod = entry.getValue();
				if (prod.getCategoria().equals(Producto.categorias[cat])) {
					sb.append(prod.toString()).append(", Cantidad: ").append(prod.getCantidad()).append("]\n");
				}
			}
			OpcionDeMenu.controlError = true;
			if (sb.length() > 0) {
				return "\nCategor�a " + Producto.categorias[cat] + ":\n" + sb.toString();
			} else {
				return "La categor�a \"" + Producto.categorias[cat] + "\" se encuentra vacia.\n";
			} 

		} else {
			return "Categoria inv�lida, por favor ingrese un �ndice dentro del rango establecido.";
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
		return "[C�digo: " + id + ", Nombre: " + nombre + ", Correo: " + correo + ", Contrase�a: " + password + ", C�dula: " + cedula;
	}
}