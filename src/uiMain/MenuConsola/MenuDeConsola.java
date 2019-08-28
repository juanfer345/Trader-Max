/*
	Clase MenuDeConsola (p�blica)   
	
	Prop�sito: Es el men� general del programa donde el usuario interacciona
	           con las opciones que tiene en la aplicaion
	          
	Estructuras de datos relevantes:
	- ArrayList <OpcionDeMenu> menuActivo: Estructura que contiene las opciones de men� del usuario
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
	
	//Crea el arreglo de opciones de men� del usuario
	public MenuDeConsola() {menuUsuario = new ArrayList<>();}
	
	// Devuelve las opciones de menu de cada usuario
	public ArrayList<OpcionDeMenu> getmenuUsuario(){return this.menuUsuario;}
	
	// Modificacion de opciones de menu de cada usuario
	public void setmenuUsuario(ArrayList<OpcionDeMenu> menuUsuario) {this.menuUsuario = menuUsuario;}

	public String mostrarOpcionesDisponibles(byte tipoUsuario) {
		/*
		Proposito: Mostrar las opciones disponibles del men� de un tipo de usuario.

		Variables de entrada:
		- int idUsuario: N�mero de identificaci�n del usuario.
		- byte tipoUsuario: N�mero {1, 2, 3} del tipo de usuario sobre el cual se realiza el m�todo.

		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
		  En caso de que sea exitoso se muestra el men� que tiene el tipo usuario.
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

		sb.append("\nA continuaci�n se muestran todas las opciones de men� disponibles para los usuarios de tipo " + cuenta + ":\n");
		sb.append("\n" + "|-------------------------Inicio men�--------------------------|" + "\n\n");
		sb.append(menu);
		sb.append("\n" + "|--------------------------Fin men�----------------------------|" + "\n");
		return sb.toString();
	}
	
	public String mostrarOpcionesDeMenu(int idUsuario, byte tipoUsuario) {
		/*
		Proposito: Mostrar las opciones de men� del usuario.

		Variables de entrada:
		- int idUsuario: N�mero de identificaci�n del usuario.
		- byte tipoUsuario: N�mero {1, 2, 3} del tipo de usuario sobre el cual se realiza el m�todo.

		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
		  En caso de que sea exitoso se muestra el men� que tiene el usuario.
		 */

		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		String usuario = null;

		//Selecci�n de la base de datos correcta
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
			sb.append("A continuaci�n se muestra el men� del usuario: " + baseDeDatos.get(idUsuario).toString() + "\n\n");
			sb.append(prepararMenuImpresion(baseDeDatos.get(idUsuario).getMenu()) + "\n");
			OpcionDeMenu.controlError = true;
		} else {
			sb.append("El usuario de tipo " + usuario + " no fue encontrado, por favor revise el c�digo ingresado.");
		}
		return sb.toString();
	}

	public String comprobarCantidadOpciones(int idUsuario, byte tipoUsuario, byte borradoAgregado) {
		/*
		Proposito: Mostrar las opciones de men� del usuario, paso previo para cuando
		           se desee agregar o eliminar una opci�n.

		Variables de entrada:
		- int idUsuario: N�mero de identificaci�n del usuario.
		- byte tipoUsuario: N�mero {1, 2, 3} del tipo de usuario sobre el cual se realiza el m�todo.
		- byte borradoAgregado: N�mero {1, 2} que se ingresa dependiendo si es agregar o eliminar opci�n.

		Variables de salida:
		- String con mensaje del proceso dependiendo de la operaci�n que desea realizar.
		 */

		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap <>();
		ArrayList <OpcionDeMenu> menu;
		Deque <OpcionDeMenu> cola = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		//Selecci�n de la base de datos correcta
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
		
		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtenci�n de opciones de men� del usuario

		// Condicional para identificar si es el caso de agregado o eliminaci�n de opciones
		if (borradoAgregado == 1) {

			// Caso A: Se est� agregando una opci�n - [Inicio]

			// Resultado seg�n cantidad de opciones del usuario seleccionado
			if (menu.size() < baseDeDatos.get(idUsuario).getTotalDeOpcionesDisponibles()) {

				// Caso A.a: El men� del usuario no tiene la cantidad m�xima posible de opciones
				if(tipoUsuario != 3) {
					opcionComp = baseDeDatos.get(idUsuario).getMenuPredeterminado();
				}
				else {
					opcionComp = ((Administrador) baseDeDatos.get(idUsuario)).getMenuDisponible();
				}

				// Ciclo para descartar las opciones que ya posee el men� del usuario
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

				sb.append("A continuaci�n se muestran las opciones disponibles que pueden agregarse:\n");
				sb.append("\n" + "|----------------------Opciones Disponibles---------------------|" + "\n\n");
				sb.append(prepararMenuImpresion(opcionComp));
				sb.append("\n" + "|--------------------Fin Opciones Disponibles-------------------|" + "\n\n");
				OpcionDeMenu.controlError = true;
			}
			else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDisponibles()) {

				// Caso A.b: El men� del usuario tiene la cantidad m�xima posible de opciones
				sb.append("Esta cuenta ya posee la m�xima cantidad de opciones de men�, intente con otra cuenta.\n");
			}
			// Caso A: Se est� agregando una opci�n - [Fin]
		} else if (borradoAgregado == 2) {

			// Caso B: Se est� eliminando una opci�n - [Inicio]

			// Resultado seg�n cantidad de opciones del usuario seleccionado
			if (menu.size() > 0) {

				// Caso B.a: El men� del usuario tiene al menos una opci�n disponible
				if(tipoUsuario != 3) {
					opcionComp = baseDeDatos.get(idUsuario).getMenu();
				}
				else {
					opcionComp = ((Administrador) baseDeDatos.get(idUsuario)).getMenu();
				}
				OpcionDeMenu.controlError = true;
				
			} else if (menu.size() == 0) {

				// Caso B.b: El men� del usuario se encuentra vac�o
				sb.append("Esta cuenta ya no posee ninguna opci�n de men�, no es posible borrar m�s, intente con otra cuenta.\n");
			}
			// Caso B: Se est� eliminando una opci�n - [Fin]
		}
		return sb.toString();
	}

	public String agregarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
		/*
		Proposito: Agregar una opci�n de men� a un usuario

		Variables de entrada:
		- int idUsuario: N�mero de identificaci�n del usuario
		- byte tipoUsuario: N�mero {1, 2, 3} del tipo de usuario sobre el cual se realiza el m�todo
		- byte indice: N�mero de la opci�n de men� que se desea agregar

		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
		 */
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap <>();
		ArrayList<OpcionDeMenu> menu;
		StringBuilder sb = new StringBuilder();

		//Selecci�n de la base de datos correcta
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

		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtenci�n de opciones de men� del usuario

		menu.add(opcionComp.get(indice)); 							// Adici�n de la opci�n correspondiente
		sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); 	// Guardado del mensaje mostrando el nuevo men�
		OpcionDeMenu.controlError = true;
		return sb.append("\nSe ha agregado la opci�n correctamente\n").toString();
	}

	public String eliminarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
		/*
			Proposito: Eliminar una opci�n de men� de un usuario

			Variables de entrada:
			- int idUsuario: N�mero de identificaci�n del usuario 
			- byte tipoUsuario: N�mero {1, 2, 3} del tipo de usuario sobre el cual se realiza el m�todo
			- byte indice: N�mero de la opci�n de men� que se desea eliminar

			Variables de salida:
			- String con mensaje dependiendo si el proceso fue o no exitoso.
		 */
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = new HashMap <>();
		ArrayList<OpcionDeMenu> menu;
		StringBuilder sb = new StringBuilder();

		//Selecci�n de la base de datos correcta
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
		
		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtenci�n de opciones de men� del usuario

		menu.remove(menu.get(indice)); 								// Agregado de la opci�n correspondiente
		sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); 	// Guardado del mensaje mostrando el nuevo men�
		OpcionDeMenu.controlError = true;
		sb.append("\nSe ha eliminado la opci�n correctamente\n");
			
		return sb.toString();
	}
	
	//Se devuelven las opciones de menu de un menu dado con su respectivo �ndice para su posterior impresi�n
	public static String prepararMenuImpresion(ArrayList<OpcionDeMenu> menu) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < menu.size(); i++) {
			sb.append((i + 1) + ". " + menu.get(i).toString() + ".\n");
		}
		return sb.toString();
	}
	
	//Devuelve el tama�o del arreglo de las opciones de men� usadas en los m�todos para agregar o eliminar opciones de men� con fines de impresi�n
	public static byte getsizeOpcionesComp() {return (byte) opcionComp.size();}
}