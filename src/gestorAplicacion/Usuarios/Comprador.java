/*	Clase Comprador (pública, hereda de CuentaConBanco)        
	
	Propósito: Tipo de usuario del sistema que podrá adquirir productos
	
	Estructuras de datos relevantes:
	- HashMap historial: Estructura para almacenar historial del comprador, contiene todos
	                     los productos que ha comprado
*/

package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import control.ControlBuscarProducto;
import control.ControlCerrarSesion;
import control.ControlMostrarCatalogo;
import control.ControlMostrarPorCategoria;
import control.ControlMostrarResenas;
import control.ControlSalir;
import control.Cuenta.Comprador.ControlAgregarACarrito;
import control.Cuenta.Comprador.ControlAgregarResena;
import control.Cuenta.Comprador.ControlBorrarHistorial;
import control.Cuenta.Comprador.ControlComprarProducto;
import control.Cuenta.Comprador.ControlMostrarCarrito;
import control.Cuenta.Comprador.ControlMostrarHistorial;
import control.Cuenta.Comprador.ControlQuitarProductoCarrito;
import control.Cuenta.Comprador.ControlVaciarCarrito;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class Comprador extends CuentaConBanco {

	private static CarritoDeCompras carrito;
	private HashMap<Integer, Integer> historial;
	private static final int totalDeOpcionesDisponibles = 14;

	public Comprador(int idCuenta, String nombre, String correo, String password, int cedula, boolean activa) {
		/*
		  Propósito: Constructor de Comprador para usuarios existentes
		  
		 Variables de entrada: 
		 - int idCuenta: Identificador de la cuenta como comprador 
		 - String nombre, int cedula: Datos personales del usuario 
		 - String correo, password: Datos asignados al usuario para ingreso al programa
		 */
		super(idCuenta, nombre, correo, password, cedula, activa); // Llamado a contructor de CuentaConBanco
		historial = new HashMap<>();
	}

	public Comprador(int idCuenta, String nombre, String correo, String password, int cedula, int idCuentaBancaria) {
		/*
		  Propósito: Constructor de Comprador para usuarios nuevos con cuenta repetida
		  
		 Variables de entrada: 
		 - int idCuenta: Identificador de la cuenta como comprador 
		 - String nombre, int cedula: Datos personales del usuario 
		 - String correo, password: Datos asignados al usuario para ingreso al programa
		 */
		super(idCuenta, nombre, correo, password, cedula, idCuentaBancaria); // Llamado a contructor de CuentaConBanco
		carrito = new CarritoDeCompras(this);
		historial = new HashMap<>();
	}
	
	public Comprador(String nombre, String correo, String password, int cedula) {
		/*
			 Propósito: Constructor de Comprador para usuarios nuevos
			  
			 Variables de entrada: 
			 - String nombre, int cedula: Datos personales del usuario 
			 - String correo, password: Datos asignados al usuario para ingreso al programa
			 - boolean match: Condicional para el caso de cuentas existentes con el mismo correo
		 */
		super(nombre, correo, password, cedula); // LLamado al contructor de CuentaConBanco
		carrito = new CarritoDeCompras(this);
		historial = new HashMap<>();
	}
	
	//Constructor vacío
	public Comprador() {}
	
	public ArrayList<OpcionDeMenu> getMenuPredeterminado() {

		/*
		 Propósito: Asignar al comprador un menú predeterminado de acuerdo a su perfil
		 
		 Variables de salida: 
		 - ArrayList con las opciones de menú que tendrá predeterminadas el usuario.
		 */

		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
				new ControlBuscarProducto(), new ControlMostrarCatalogo(), new ControlMostrarPorCategoria(), 
				new ControlMostrarResenas(), new ControlAgregarACarrito(), new ControlMostrarCarrito(), 
				new ControlComprarProducto(), new ControlQuitarProductoCarrito(), new ControlVaciarCarrito(), 
				new ControlAgregarResena(), new ControlMostrarHistorial(), new ControlBorrarHistorial(), 
				new ControlCerrarSesion()}));
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

	// Devuelve un HashMap que contiene los productos del historial (Productos que han sido comprados)
	public HashMap<Integer, Integer> getHistorial() {return historial;}

	public void setHistorial(int codigoProducto, int cantidadProducto) {historial.put(codigoProducto, cantidadProducto);}

	public String mostrarHistorial() {
		/*
		 Propósito: Mostrar los productos que el usuario ha comprado
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("\nEl historial posee un total de ").append(historial.size());
		
		if (historial.size() > 1) {sb.append(" productos.\n");}
		else {sb.append(" producto.\n");}
		
		historial.forEach((k, v) -> { // Ciclo para obtención e impresión de los productos
			sb.append(InicializacionAplicacion.getBDProductos().get(k)).append(", Cantidad comprada: " + v + "]\n");
		});

		return sb.toString();
	}

	public String borrarHistorial() {
		/*
		 Propósito: Borrar el historial de compras del usuario
		 */
		historial.clear();
		return "\nEl historial se ha borrado exitosamente.\n";
	}

	public String anadirResena(int codigo, int estrellas, String comentario) {
		/*
		 Propósito: Añadir una reseña a un producto comprado
		  
		 Variables de entrada: 
		 - int codigo: Código del producto al cual se le agregará una reseña 
		 - Reseña r: Reseña (comentario, estrellas) que se le quiere agregar al producto
		 
		 Variables de salida: 
		 - String con mensaje dependiendo si el proceso fue o no exitoso.
		 */
		
		//Comprobación de que el producto ya fue comprado
		if (historial.containsKey(codigo)) {

			Producto prod = catalogo.get(codigo);								//Obtención del apuntador al producto
			Resena rese = new Resena(this, comentario, estrellas);				//Creación nueva reseña
			prod.setResenas(rese);												//Añadido de la reseña al producto
			InicializacionAplicacion.getBDResenas().put(rese.getId(), rese);	//Añadido de las reseñas en la base de datos
			OpcionDeMenu.controlError = true;
			return "La reseña del producto \"" + prod.getNombreProducto() + "\" ha sido añadida.\n";
		} 
		else {
			return "No has comprado el producto identificado con este código, no puedes añadir una reseña.\n";
		}
	}

	@Override
	public String toString() {
		return "Comprador:" + super.toString() + ", Productos comprados: " + historial.size() + "]";
	}
}