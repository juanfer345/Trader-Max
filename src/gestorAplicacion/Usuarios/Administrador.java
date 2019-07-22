/*
	Clase Administrador (pública, hereda de CuentaUsuario)   
	
	Propósito: Usuario que tendrá control sobre el programa y sobre las acciones de los usuarios
*/

package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;
import uiMain.MenuConsola.BuscarProducto;
import uiMain.MenuConsola.MostrarCatalogo;
import uiMain.MenuConsola.MostrarPorCategoria;
import uiMain.MenuConsola.MostrarResenas;
import uiMain.MenuConsola.Salir;
import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Administrador.AgregarOpcion;
import uiMain.MenuConsola.Cuenta.Administrador.BloquearCuenta;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarCuentasAvtivas;
import uiMain.MenuConsola.Cuenta.Administrador.EliminarOpcion;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarMenu;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarMenuDisponible;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarTodasLasOpciones;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarUsuario;

/*PROPUESTA por juanfer: ya que administrador debería heredar algunos atributos de cuenta (pero no todos), 
						 que les parece si se quita cuenta y en su remplazo creamos dos interfaces, de tal manera que una interfaz tenga todo lo de cuenta, pero sin 
						 ciertos atributos y otra interfaz tenga todo lo que le falte (además de esta manera vamos llenando los requisitos del trabajo)
*/

public class Administrador extends CuentaUsuario {
    
	private static String codigoSecreto = "Es un secretooo";
	private static final int totalDeOpcionesDisponibles = 14;

	public Administrador(int idCuenta, String nombre, String correo, String password, int cedula) {
	/*
		Propósito: Constructor de Administrador para usuarios existentes			
		           
		Variables de entrada:
		- int idCuenta: Identificacdor de la cuenta como adminitrador
		- String nombre, int cedula: Datos personales del usuario
		- String correo, password: Datos asignados al usuario para ingreso al programa
    */
		super(idCuenta, nombre, correo, password, cedula); // Se llama al constructor de CuentaUsuario
	}

	public Administrador(String nombre, String correo, String password, int cedula) {
	/*
	    Propósito: Constructor de Administrador para usuarios nuevos		
		           
		Variables de entrada:
		- String nombre, int cedula: Datos personales del usuario
		- String correo, password: Datos asignados al usuario para ingreso al programa
    */
		super(nombre, correo, password, cedula); // Se llama al constructor de CuentaUsuario 
	}

	public ArrayList<OpcionDeMenu> getMenuPredeterminado() {
	/*
		Proposito: Asignar un menú predeterminado con las opciones de menú que tiene un administrador.
		
		Variables de salida:
		- ArrayList <OpcionDeMenu>: Arraylist con las opciones de menú por defecto que 
		                           tendrá un usuario administrador
    */
		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
				new MostrarUsuario(), new MostrarMenu(), new MostrarMenuDisponible(), 
				new MostrarTodasLasOpciones(), new AgregarOpcion(), new EliminarOpcion(),
				new BloquearCuenta(), new MostrarCuentasAvtivas(), new CerrarSesion(), new Salir()}));
	}

	//Constructor vacío
	public Administrador() {}
	
	// Devuelve el total de opciones por defecto que tiene este tipo de usuario
	public int getTotalDeOpcionesDisponibles() {
		return totalDeOpcionesDisponibles;
	}
    //
	public ArrayList<OpcionDeMenu> getMenuDisponible() {
		/*
		Proposito: Asignar un menú predeterminado con las opciones de menú que se pueden agregar al menu de administrador.
		
		Variables de salida:
		- ArrayList <OpcionDeMenu>: Arraylist con las opciones de menú que podran agragarse
    */
		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
				new BuscarProducto(), new MostrarCatalogo(),new MostrarPorCategoria(),
				new MostrarResenas(),new AgregarOpcion(), new MostrarCuentasAvtivas(),
				new BloquearCuenta(), new EliminarOpcion(), new MostrarMenu(),
				new MostrarUsuario(), new MostrarTodasLasOpciones(),new CerrarSesion(),
				new Salir() }));
	}
	// Devuelve el numero total de cuentas existentes 
	public static int getNumeroCuentas() {
		return Cuenta.totalCuentas;
	}
	
	public String numeroCuentas() {
	/*
		Proposito: Mostrar el número de cuentas actuales en el programa
		
		Variables de salida:
		- String con mensaje con el numero de cuentas existentes
     */
		int cuentas = Administrador.getNumeroCuentas();
		return "Actualmente hay " + cuentas + " cuentas";
	}

	public String mostrarUsuario(int idUsuario, byte tipoUsuario) {
	/*
		Proposito: Mostrar datos de un usuario específico 
		
		Variables de entrada:
		- int idUsuario: Número de identificación del usuario 
		- byte tipoUsuario: Número {1, 2} del tipo de usuario sobre el cual se realiza el método
		
		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
    */
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
		StringBuilder sb = new StringBuilder();
		String usuario = null;

		// Condicional para distinguir entre comprador y vendedor
		if (tipoUsuario == 1) {
			// Caso A: Comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			usuario = "comprador";
		} else if (tipoUsuario == 2) {
			// Caso B: Vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			usuario = "vendedor";
		}
		//Condicional que verifica existencia del usuario en la base de datos
		if (baseDeDatos.containsKey(idUsuario)) {
			sb.append(baseDeDatos.get(idUsuario).toString());
			OpcionDeMenu.controlError = true;
		} else {
			sb.append("El " + usuario + " no fue encontrado, por favor revise el código ingresado");
		}
		return sb.toString();
	}

	public String eliminarCuenta(int idUsuario, byte tipoUsuario) {
	/*
		Proposito: Eliminar una cuenta de un usuario
		
		Variables de entrada:
		- int idUsuario: Número de identificación del usuario 
		- byte tipoUsuario: Número {1, 2} del tipo de usuario sobre el cual se realiza el método
		
		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
    */
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
		StringBuilder sb = new StringBuilder();
		String usuario = null;

		// Condicional para distinguir entre comprador y vendedor
		if (tipoUsuario == 1) {
			// Caso A: Comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			usuario = "comprador";
		} else if (tipoUsuario == 2) {
			// Caso B: Vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			usuario = "vendedor";
		}

		if (baseDeDatos.containsKey(idUsuario)) {
			baseDeDatos.remove(idUsuario);
			sb.append("Se ha removido la cuenta correctamente.");
			OpcionDeMenu.controlError = true;
		} else {
			sb.append("El " + usuario + " no fue encontrado, por favor revise el código ingresado.");
		}
		return sb.toString();
	}

	public static String getCodigoSecreto() {
		return codigoSecreto;
	}
}