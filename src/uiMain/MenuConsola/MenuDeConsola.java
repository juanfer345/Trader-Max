/*
	Clase MenuDeConsola (pública)   
	
	Propósito: Es el menú general del programa donde el usuario interacciona
	           con las opciones que tiene en la aplicaion
	          
	Estructuras de datos relevantes:
	- ArrayList <OpcionDeMenu> menuActivo: Estructura que contiene las opciones de menú del usuario
*/
package uiMain.MenuConsola;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.CuentaUsuario;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;

public class MenuDeConsola {

	public static ArrayList<OpcionDeMenu> menuActivo;
	private ArrayList<OpcionDeMenu> menuUsuario;
	public static boolean SalirApp = false;
	private static ArrayList<OpcionDeMenu> opcionComp;

	public boolean buscarOpcionDeMenu(OpcionDeMenu opcionBuscada) {
		for (OpcionDeMenu opcionDeMenu : menuActivo) {
			if (opcionBuscada.getClass().equals(opcionDeMenu.getClass())) {
				return true;
			}
		}
		return false;
	}
	
	//Crea el arreglo de opciones de menú del usuario
	public MenuDeConsola() {menuUsuario = new ArrayList<>();}
	
	// Devuelve las opciones de menu de cada usuario
	public ArrayList<OpcionDeMenu> getmenuUsuario(){return this.menuUsuario;}
	
	// Modificacion de opciones de menu de cada usuario
	public void setmenuUsuario(ArrayList<OpcionDeMenu> menuUsuario) {this.menuUsuario = menuUsuario;}

	public String mostrarOpcionesDisponibles(byte tipoUsuario) {
		/*
		Proposito: Mostrar las opciones disponibles del menú de un tipo de usuario.

		Variables de entrada:
		- int idUsuario: Número de identificación del usuario.
		- byte tipoUsuario: Número {1, 2, 3} del tipo de usuario sobre el cual se realiza el método.

		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
		  En caso de que sea exitoso se muestra el menú que tiene el tipo usuario.
		 */

		StringBuilder sb = new StringBuilder();
		String cuenta = null, menu = null;

		// Condicional para distinguir entre comprador, vendedor y administrador
		if (tipoUsuario == 1) {
			// Caso A: Comprador
			menu = prepararMenuImpresion((new Comprador()).getMenuPredeterminado());
			cuenta = "COMPRADOR";
		} else if (tipoUsuario == 2) {
			// Caso B: Vendedor
			menu = prepararMenuImpresion((new Vendedor()).getMenuPredeterminado());
			cuenta = "VENDEDOR";
		} else if (tipoUsuario == 3) {
			// Caso C: Administrador
			menu = prepararMenuImpresion((new Administrador()).getMenuDisponible());
			cuenta = "ADMINISTRADOR";
		}

		sb.append("\nA continuación se muestran todas las opciones de menú disponibles para los usuarios de tipo " + cuenta + ":\n");
		sb.append("\n" + "|-------------------------Inicio menú--------------------------|" + "\n\n");
		sb.append(menu);
		sb.append("\n" + "|--------------------------Fin menú----------------------------|" + "\n");
		return sb.toString();
	}
	
	public String mostrarOpcionesDeMenu(int idUsuario, byte tipoUsuario) {
		/*
		Proposito: Mostrar las opciones de menú del usuario.

		Variables de entrada:
		- int idUsuario: Número de identificación del usuario.
		- byte tipoUsuario: Número {1, 2, 3} del tipo de usuario sobre el cual se realiza el método.

		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
		  En caso de que sea exitoso se muestra el menú que tiene el usuario.
		 */

		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		String usuario = null;

		//Selección de la base de datos correcta
		switch (tipoUsuario) {
		case 1:
			// Caso A: Comprador
			usuario = "comprador";
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			// Caso B: Vendedor
			usuario = "vendedor";
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			// Caso C: Administrador
			usuario = "administrador";
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}

		if (baseDeDatos.containsKey(idUsuario)) {
			sb.append("A continuación se muestra el menú del usuario: " + baseDeDatos.get(idUsuario).toString() + "\n\n");
			sb.append(prepararMenuImpresion(baseDeDatos.get(idUsuario).getMenu()) + "\n");
			OpcionDeMenu.controlError = true;
		} else {
			sb.append("El usuario de tipo " + usuario + " no fue encontrado, por favor revise el código ingresado.");
		}
		return sb.toString();
	}

	public String comprobarCantidadOpciones(int idUsuario, byte tipoUsuario, byte borradoAgregado) {
		/*
		Proposito: Mostrar las opciones de menú del usuario, paso previo para cuando
		           se desee agregar o eliminar una opción.

		Variables de entrada:
		- int idUsuario: Número de identificación del usuario.
		- byte tipoUsuario: Número {1, 2, 3} del tipo de usuario sobre el cual se realiza el método.
		- byte borradoAgregado: Número {1, 2} que se ingresa dependiendo si es agregar o eliminar opción.

		Variables de salida:
		- String con mensaje del proceso dependiendo de la operación que desea realizar.
		 */

		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap <>();
		ArrayList <OpcionDeMenu> menu;
		Deque <OpcionDeMenu> cola = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		//Selección de la base de datos correcta
		switch (tipoUsuario) {
		case 1:
			// Caso A: Comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			// Caso B: Vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			// Caso C: Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}
		
		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtención de opciones de menú del usuario

		// Condicional para identificar si es el caso de agregado o eliminación de opciones
		if (borradoAgregado == 1) {

			// Caso A: Se está agregando una opción - [Inicio]

			// Resultado según cantidad de opciones del usuario seleccionado
			if (menu.size() < baseDeDatos.get(idUsuario).getTotalDeOpcionesDisponibles()) {

				// Caso A.a: El menú del usuario no tiene la cantidad máxima posible de opciones
				if(tipoUsuario != 3) {
					opcionComp = baseDeDatos.get(idUsuario).getMenuPredeterminado();
				}
				else {
					opcionComp = ((Administrador) baseDeDatos.get(idUsuario)).getMenuDisponible();
				}

				// Ciclo para descartar las opciones que ya posee el menú del usuario
				for (OpcionDeMenu opcionMenu: menu) {
					for (OpcionDeMenu opcionTotal : opcionComp) {
						if (opcionTotal.getClass().equals(opcionMenu.getClass())) {
							cola.add(opcionTotal);
						}
					}
				}
				while (!cola.isEmpty()) {
					opcionComp.remove(cola.poll());
				}

				sb.append("A continuación se muestran las opciones disponibles que pueden agregarse:\n");
				sb.append("\n" + "|----------------------Opciones Disponibles---------------------|" + "\n\n");
				sb.append(prepararMenuImpresion(opcionComp));
				sb.append("\n" + "|--------------------Fin Opciones Disponibles-------------------|" + "\n\n");
				OpcionDeMenu.controlError = true;
			}
			else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDisponibles()) {

				// Caso A.b: El menú del usuario tiene la cantidad máxima posible de opciones
				sb.append("Esta cuenta ya posee la máxima cantidad de opciones de menú, intente con otra cuenta.\n");
			}
			// Caso A: Se está agregando una opción - [Fin]
		} else if (borradoAgregado == 2) {

			// Caso B: Se está eliminando una opción - [Inicio]

			// Resultado según cantidad de opciones del usuario seleccionado
			if (menu.size() > 0) {

				// Caso B.a: El menú del usuario tiene al menos una opción disponible
				if(tipoUsuario != 3) {
					opcionComp = baseDeDatos.get(idUsuario).getMenu();
				}
				else {
					opcionComp = ((Administrador) baseDeDatos.get(idUsuario)).getMenu();
				}
				OpcionDeMenu.controlError = true;
				
			} else if (menu.size() == 0) {

				// Caso B.b: El menú del usuario se encuentra vacío
				sb.append("Esta cuenta ya no posee ninguna opción de menú, no es posible borrar más, intente con otra cuenta.\n");
			}
			// Caso B: Se está eliminando una opción - [Fin]
		}
		return sb.toString();
	}

	public String agregarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
		/*
		Proposito: Agregar una opción de menú a un usuario

		Variables de entrada:
		- int idUsuario: Número de identificación del usuario
		- byte tipoUsuario: Número {1, 2, 3} del tipo de usuario sobre el cual se realiza el método
		- byte indice: Número de la opción de menú que se desea agregar

		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
		 */
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap <>();
		ArrayList<OpcionDeMenu> menu;
		StringBuilder sb = new StringBuilder();

		//Selección de la base de datos correcta
		switch (tipoUsuario) {
		case 1:
			// Caso A: Comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			// Caso B: Vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			// Caso C: Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}

		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtención de opciones de menú del usuario

		menu.add(opcionComp.get(indice)); 							// Adición de la opción correspondiente
		sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); 	// Guardado del mensaje mostrando el nuevo menú
		OpcionDeMenu.controlError = true;
		return sb.append("\nSe ha agregado la opción correctamente\n").toString();
	}

	public String eliminarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
		/*
			Proposito: Eliminar una opción de menú de un usuario

			Variables de entrada:
			- int idUsuario: Número de identificación del usuario 
			- byte tipoUsuario: Número {1, 2, 3} del tipo de usuario sobre el cual se realiza el método
			- byte indice: Número de la opción de menú que se desea eliminar

			Variables de salida:
			- String con mensaje dependiendo si el proceso fue o no exitoso.
		 */
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap <>();
		ArrayList<OpcionDeMenu> menu;
		StringBuilder sb = new StringBuilder();

		//Selección de la base de datos correcta
		switch (tipoUsuario) {
		case 1:
			// Caso A: Comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			// Caso B: Vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			// Caso C: Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}
		
		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtención de opciones de menú del usuario

		menu.remove(menu.get(indice)); 								// Agregado de la opción correspondiente
		sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); 	// Guardado del mensaje mostrando el nuevo menú
		OpcionDeMenu.controlError = true;
		sb.append("\nSe ha eliminado la opción correctamente\n");
			
		return sb.toString();
	}
	
	//Se devuelven las opciones de menu de un menu dado con su respectivo índice para su posterior impresión
	public static String prepararMenuImpresion(ArrayList<OpcionDeMenu> menu) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < menu.size(); i++) {
			sb.append((i + 1) + ". " + menu.get(i).toString() + ".\n");
		}
		return sb.toString();
	}
	
	//Devuelve el tamaño del arreglo de las opciones de menú usadas en los métodos para agregar o eliminar opciones de menú con fines de impresión
	public static byte getsizeOpcionesComp() {return (byte) opcionComp.size();}
}