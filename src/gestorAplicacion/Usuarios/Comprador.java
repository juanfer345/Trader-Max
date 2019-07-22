/*	Clase Comprador (p�blica, hereda de CuentaConBanco)        
	
	Prop�sito: Tipo de usuario del sistema que podr� adquirir productos
	
	Estructuras de datos relevantes:
	- HashMap historial: Estructura para almacenar historial del comprador, contiene todos
	                     los productos que ha comprado
*/

package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import uiMain.OpcionDeMenu;
import uiMain.MenuConsola.BuscarProducto;
import uiMain.MenuConsola.MostrarCatalogo;
import uiMain.MenuConsola.MostrarPorCategoria;
import uiMain.MenuConsola.MostrarResenas;
import uiMain.MenuConsola.Salir;
import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarACarrito;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarResena;
import uiMain.MenuConsola.Cuenta.Comprador.BorrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.ComprarProducto;
import uiMain.MenuConsola.Cuenta.Comprador.MostrarCarrito;
import uiMain.MenuConsola.Cuenta.Comprador.MostrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.QuitarProductoCarrito;
import uiMain.MenuConsola.Cuenta.Comprador.VaciarCarrito;

public class Comprador extends CuentaConBanco {

	private static CarritoDeCompras carrito;
	private HashMap<Integer, Integer> historial;
	private static final int totalDeOpcionesDisponibles = 14;

	public Comprador(int idCuenta, String nombre, String correo, String password, int cedula) {
		/*
		  Prop�sito: Constructor de Comprador para usuarios existentes
		  
		 Variables de entrada: 
		 - int idCuenta: Identificador de la cuenta como comprador 
		 - String nombre, int cedula: Datos personales del usuario 
		 - String correo, password: Datos asignados al usuario para ingreso al programa
		 */
		super(idCuenta, nombre, correo, password, cedula); // Llamado a contructor de CuentaConBanco
		historial = new HashMap<>();
	}

	public Comprador(String nombre, String correo, String password, int cedula) {
		/*
		 Prop�sito: Constructor de Comprador para usuarios nuevos
		  
		 Variables de entrada: 
		 - String nombre, int cedula: Datos personales del usuario 
		 - String correo, password: Datos asignados al usuario para ingreso al programa
		 */
		super(nombre, correo, password, cedula); // LLamado al contructor de CuentaConBanco
		carrito = new CarritoDeCompras(this);
		historial = new HashMap<>();
	}
	
	//Constructor vac�o
	public Comprador() {}
	
	public ArrayList<OpcionDeMenu> getMenuPredeterminado() {

		/*
		 Prop�sito: Asignar al comprador un men� predeterminado de acuerdo a su perfil
		 
		 Variables de salida: 
		 - ArrayList con las opciones de men� que tendr� predeterminadas el usuario.
		 */

		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
				new BuscarProducto(), new MostrarCatalogo(), new MostrarPorCategoria(), new AgregarACarrito(), 
				new AgregarResena(), new BorrarHistorial(), new ComprarProducto(), new MostrarHistorial(), 
				new MostrarResenas(), new QuitarProductoCarrito(), new VaciarCarrito(), new MostrarCarrito(), 
				new CerrarSesion(), new Salir() }));
	}

	// Devuelve el numero total de opciones que tiene por defecto
	public int getTotalDeOpcionesDisponibles() {
		return totalDeOpcionesDisponibles;
	}

	// Devuelve el carrito que le corresponde al comprador
	public static CarritoDeCompras getCarrito() {
		return carrito;
	}

	// Cambia el carrito de compras
	public void setCarrito() {
		Comprador.carrito = new CarritoDeCompras(this);
	}

	// Devuelve un HashMap que contiene los productos del historial (Productos qu
	// han sido comprados)
	public HashMap<Integer, Integer> getHistorial() {return historial;}

	public void setHistorial(int codigoProducto, int cantidadProducto) {historial.put(codigoProducto, cantidadProducto);}

	public String mostrarHistorial() {
		/*
		 Prop�sito: Mostrar los productos que el usuario ha comprado
		 */
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nTotal de productos en el historial = ").append(historial.size()).append('\n');
		
		historial.forEach((k, v) -> { // Ciclo para obtenci�n e impresi�n de los productos
			sb.append(v).append('\n');
		});

		OpcionDeMenu.controlError = true;
		return sb.toString();
	}

	public String borrarHistorial() {
		/*
		 Prop�sito: Borrar el historial de compras del usuario
		 */
		historial.clear();
		return "El historial se ha borrado exitosamente";
	}

	public String anadirResena(int codigo, int estrellas, String comentario) {
		/*
		 Prop�sito: A�adir una rese�a a un producto comprado
		  
		 Variables de entrada: 
		 - int codigo: C�digo del producto al cual se le agregar� una rese�a 
		 - Rese�a r: Rese�a (comentario, estrellas) que se le quiere agregar al producto
		 
		 Variables de salida: 
		 - String con mensaje dependiendo si el proceso fue o no exitoso.
		 */
		
		//Comprobaci�n de que el producto ya fue comprado
		if (historial.containsKey(codigo)) {

			Producto prod = catalogo.get(codigo);								//Obtenci�n del apuntador al producto
			Resena rese = new Resena(this, comentario, estrellas);				//Creaci�n nueva rese�a
			prod.setResenas(new Resena(this, comentario, estrellas));			//A�adido de la rese�a al producto
			InicializacionAplicacion.getBDResenas().put(rese.getId(), rese);	//A�adido de las rese�as en la base de datos
			
			return "La rese�a del producto: " + prod.getNombreProducto() + "ha sido a�adida.\n";
		} 
		else {
			return "No ha comprado este producto, no puede a�adir una rese�a.\n";
		}
	}
}