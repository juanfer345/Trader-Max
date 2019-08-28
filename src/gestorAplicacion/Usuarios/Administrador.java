/*
	Clase Administrador (pública, hereda de CuentaUsuario)   

	Propósito: Usuario que tendrá control sobre el programa y sobre las acciones de los usuarios
 */

package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import control.ControlBuscarProducto;
import control.ControlCerrarSesion;
import control.ControlMostrarCatalogo;
import control.ControlMostrarPorCategoria;
import control.ControlMostrarResenas;
import control.ControlSalir;
import control.OpcionDeMenu;
import control.Cuenta.Administrador.ControlAgregarOpcion;
import control.Cuenta.Administrador.ControlBloqueoDeCuenta;
import control.Cuenta.Administrador.ControlEliminarOpcion;
import control.Cuenta.Administrador.ControlMostrarCuentas;
import control.Cuenta.Administrador.ControlMostrarMenu;
import control.Cuenta.Administrador.ControlMostrarMenuDisponible;
import control.Cuenta.Administrador.ControlMostrarTodasLasOpciones;
import control.Cuenta.Administrador.ControlMostrarUsuario;
import uiMain.InicializacionAplicacion;


public class Administrador extends CuentaUsuario {

	private static String codigoSecreto = "Es un secretooo";
	private static final int totalDeOpcionesDisponibles = 14;

	public Administrador(int idCuenta, String nombre, String correo, String password, int cedula, boolean activa) {
		/*
		Propósito: Constructor de Administrador para usuarios existentes			

		Variables de entrada:
		- int idCuenta: Identificacdor de la cuenta como adminitrador
		- String nombre, int cedula: Datos personales del usuario
		- String correo, password: Datos asignados al usuario para ingreso al programa
		 */
		super(idCuenta, nombre, correo, password, cedula, activa); // Se llama al constructor de CuentaUsuario
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
				new ControlMostrarUsuario(), new ControlMostrarMenu(), new ControlMostrarMenuDisponible(), 
				new ControlMostrarTodasLasOpciones(), new ControlAgregarOpcion(), new ControlEliminarOpcion(),
				new ControlBloqueoDeCuenta(), new ControlMostrarCuentas(), new ControlCerrarSesion(), new ControlSalir()
		}));
	}

	//Constructor vacío
	public Administrador() {}

	// Devuelve el total de opciones por defecto que tiene este tipo de usuario
	public int getTotalDeOpcionesDisponibles() {return totalDeOpcionesDisponibles;}


	public ArrayList<OpcionDeMenu> getMenuDisponible() {
		/*
		Proposito: Asignar un menú predeterminado con las opciones de menú que se 
		           pueden agregar al menu de administrador.

		Variables de salida:
		- ArrayList <OpcionDeMenu>: Arraylist con las opciones de menú que podran agragarse
		 */
		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
				new ControlBuscarProducto(), new ControlMostrarCatalogo(),new ControlMostrarPorCategoria(),
				new ControlMostrarResenas(), new ControlMostrarUsuario(), new ControlMostrarMenu(), 
				new ControlMostrarMenuDisponible(),	new ControlMostrarTodasLasOpciones(), 
				new ControlAgregarOpcion(), new ControlEliminarOpcion(), new ControlBloqueoDeCuenta(), 
				new ControlMostrarCuentas(), new ControlCerrarSesion()}));
	}

	public static String getCodigoSecreto() {return codigoSecreto;}

	public String mostrarUsuario(byte activas) {
		/*
			Proposito: Mostrar los datos de todos los usuarios

			Variable de entrada:
			- byte activas: Número de acuerdo a la accion que se desea hacer

			Variable de salida:
			- String con informacion de acuerdo a opción elegida

		 */
		StringBuilder sb = new StringBuilder();
		String salida = null;
		boolean sali = false;

		switch (activas) {
		case 1:
			//Caso A: Se muestran todas las cuentas
			for (Map.Entry<Integer, Comprador> entry: InicializacionAplicacion.getBDCompradores().entrySet()) {
				sb.append(entry.getValue() + "\n"); sali = true;
			}
			for (Map.Entry<Integer, Vendedor> entry: InicializacionAplicacion.getBDVendedores().entrySet()) {
				sb.append(entry.getValue() + "\n"); sali = true;
			}
			for (Map.Entry<Integer, Administrador> entry: InicializacionAplicacion.getBDAdministradores().entrySet()) {
				sb.append(entry.getValue() + "\n"); sali = true;
			}
			salida = "\nA continuación se muestran todas las cuentas inscritas en la aplicación, existe un total de " 
					+ totalCuentas + " cuentas, de las cuales " + totalCuentasActivas + " están activas:\n" + sb.toString();
			break;

		case 2:
			//Caso B: Se muestran todas las cuentas activas
			for (Map.Entry<Integer, Comprador> entry: InicializacionAplicacion.getBDCompradores().entrySet()) {
				if (entry.getValue().isCuentaActiva()) sb.append(entry.getValue() + "\n"); sali = true;
			}
			for (Map.Entry<Integer, Vendedor> entry: InicializacionAplicacion.getBDVendedores().entrySet()) {
				if (entry.getValue().isCuentaActiva()) sb.append(entry.getValue() + "\n"); sali = true;
			}
			for (Map.Entry<Integer, Administrador> entry: InicializacionAplicacion.getBDAdministradores().entrySet()) {
				if (entry.getValue().isCuentaActiva()) sb.append(entry.getValue() + "\n"); sali = true;
			}

			salida = "\nA continuación se muestran todas las cuentas activas inscritas en la aplicación, existe un total de " 
					+ totalCuentasActivas + " cuentas:\n" + sb.toString();
			break;

		case 3:
			//Caso C: Se muestran todas las cuentas inactivas
			for (Map.Entry<Integer, Comprador> entry: InicializacionAplicacion.getBDCompradores().entrySet()) {
				if (!entry.getValue().isCuentaActiva()) sb.append(entry.getValue() + "\n"); sali = true;
			}
			for (Map.Entry<Integer, Vendedor> entry: InicializacionAplicacion.getBDVendedores().entrySet()) {
				if (!entry.getValue().isCuentaActiva()) sb.append(entry.getValue() + "\n"); sali = true;
			}
			for (Map.Entry<Integer, Administrador> entry: InicializacionAplicacion.getBDAdministradores().entrySet()) {
				if (!entry.getValue().isCuentaActiva()) sb.append(entry.getValue() + "\n"); sali = true;
			}

			salida = "\nA continuación se muestran todas las cuentas inactivas inscritas en la aplicación, existe un total de " 
					+ (totalCuentas - totalCuentasActivas) + " cuentas:\n" + sb.toString();
			break;	
		}

		if (sali) {
			return salida; 
		}
		else {
			return "\nNo existen cuentas en esta categoría.\n";
		}
	}

	public String mostrarUsuario(byte tipoUsuario, byte activas) {
		/*
			Proposito: Mostrar los datos de todos los usuarios de una categoría específica

			Variables de entrada:
			- byte tipoUsuario: {1, 2, 3} Dependiendo si es comprador, vendedor o administrador
			- byte activas: Número de acuerdo a la accion que se desea hacer

			Variable de salida:
			- String con informacion de acuerdo a opción elegida

		 */
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap <>();
		String tipo = null, salida = null;
		int contador = 0;

		//Selección de la base de datos correcta
		switch (tipoUsuario) {
		case 1:
			// Caso A: Comprador
			tipo = "comprador";
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			// Caso B: Vendedor
			tipo = "vendedor";
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			// Caso C: Administrador
			tipo = "administrador";
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}

		switch (activas) {
		case 1:
			//Caso A: Se muestran todas las cuentas
			for (Map.Entry<Integer, ? extends CuentaUsuario> entry: baseDeDatos.entrySet()) {
				sb.append(entry.getValue() + "\n"); contador++;
			}
			salida = "\nA continuación se muestran todas las cuentas de tipo \"" + tipo + "\""
					+ " existe un total de \"" + contador + "\" cuentas:\n" + sb.toString();
			break;

		case 2:
			//Caso B: Se muestran las cuentas activas
			for (Map.Entry<Integer, ? extends CuentaUsuario> entry: baseDeDatos.entrySet()) {
				if (entry.getValue().isCuentaActiva()) {
					sb.append(entry.getValue() + "\n"); contador++;
				}
			}
			salida = "\nA continuación se muestran todas las cuentas activas de tipo \"" + tipo + "\" inscritas en la aplicación, "
					+ "existe un total de " + contador + " cuentas:\n" + sb.toString();
			break;

		case 3:
			//Caso C: Se muestran las cuentas inactivas
			for (Map.Entry<Integer, ? extends CuentaUsuario> entry: baseDeDatos.entrySet()) {
				if (!entry.getValue().isCuentaActiva()) {
					sb.append(entry.getValue() + "\n"); contador++;
				}
			}

			salida = "\nA continuación se muestran todas las cuentas inactivas de tipo \"" + tipo + "\" inscritas en la aplicación, "
					+ "existe un total de " + contador + " cuentas:\n" + sb.toString();
			break;
		}

		if (contador != 0) {
			return salida; 
		}
		else {
			return "\nNo existen cuentas en esta categoría.\n";
		}
	}

	public String mostrarUsuario(int idUsuario, byte tipoUsuario) {
		/*
			Proposito: Mostrar datos de un usuario específico 

			Variables de entrada:
			- int idUsuario: Número de identificación del usuario 
			- byte tipoUsuario: Número {1, 2, 3} del tipo de usuario sobre el cual se realiza el método

			Variables de salida:
			- String con mensaje dependiendo si el proceso fue o no exitoso.
		 */
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
		String cuenta = null;

		//Selección de la base de datos correcta
		switch (tipoUsuario) {
		case 1:
			// Caso A: Comprador
			cuenta = "comprador";
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			// Caso B: Vendedor
			cuenta = "vendedor";
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			// Caso C: Administrador
			cuenta = "administrador";
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}

		//Condicional que verifica existencia del usuario en la base de datos
		if (baseDeDatos.containsKey(idUsuario)) {
			OpcionDeMenu.controlError = true;
			return "\nEl usuario ha sido encontrado:\n" + baseDeDatos.get(idUsuario).toString() + "\n";
		} else {
			return "\nEl usuario " + cuenta + " no fue encontrado, por favor revise el código ingresado.";
		}
	}

	public String bloquearCuenta(int idUsuario, byte tipoUsuario, byte modificacion) {
		/*
		Proposito: Bloquear el inicio de sesión de un usuario

		Variables de entrada:
		- int idUsuario: Número de identificación del usuario 
		- byte tipoUsuario: Número {1, 2} del tipo de usuario sobre el cual se realiza el método

		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
		 */
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap<>();
		CuentaUsuario cuenta;
		StringBuilder sb = new StringBuilder();
		String tipo = null;

		switch (tipoUsuario) {
		case 1:
			// Caso A: Comprador
			tipo = "comprador";
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			// Caso B: Vendedor
			tipo = "vendedor";
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			// Caso C: Administrador
			tipo = "administrador";
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}

		if (baseDeDatos.containsKey((idUsuario))) {

			cuenta = baseDeDatos.get(idUsuario);

			if (modificacion == 1 && !cuenta.isCuentaActiva()) {
				cuenta.setCuentaActiva(true);
				totalCuentasActivas++;
				OpcionDeMenu.controlError = true;
				return "\nSe ha desbloqueado la cuenta:\n" + cuenta.toString() + "\n";
			}
			else if (modificacion == 1 && cuenta.isCuentaActiva()) {
				return "\nEsta cuenta ya se encuentra activa, intentalo con otra cuenta:\n" + cuenta.toString() + "\n";
			}
			else if (modificacion == 2 && cuenta.isCuentaActiva()) {
				baseDeDatos.get(idUsuario).setCuentaActiva(false);
				totalCuentasActivas--;
				OpcionDeMenu.controlError = true;
				return "\nSe ha bloqueado la cuenta:\n" + cuenta.toString() + "\n";
			}
			else if (modificacion == 2 && !cuenta.isCuentaActiva()) {
				return "\nEsta cuenta ya se encuentra inactiva, intentalo con otra cuenta:\n" + cuenta.toString() + "\n";
			}
		} else {
			sb.append("\nEl usuario de tipo " + tipo + " no fue encontrado, por favor revise el código ingresado.");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Administrador:" + super.toString() + "]";
	}
}