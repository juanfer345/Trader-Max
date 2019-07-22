/*
	Clase MenuDeConsola (p�blica)   
	
	Prop�sito: Es el men� general del programa donde el usuario interacciona
	           con las opciones que tiene en la aplicaion
	          
	Estructuras de datos relevantes:
	- ArrayList <OpcionDeMenu> menuActivo: Estructura que contiene las opciones de men� del usuario
*/
package uiMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.CuentaUsuario;
import gestorAplicacion.Usuarios.Vendedor;

public class MenuDeConsola {

	public static ArrayList<OpcionDeMenu> menuActivo;
	private ArrayList<OpcionDeMenu>  menuUsuario;
	public static boolean SalirApp = false;
	private static ArrayList<OpcionDeMenu> opcionComp;
	
	public MenuDeConsola() {
		menuUsuario = new ArrayList<>();
	}
	
	public static void LanzarMenu() throws IOException {
		/*
		  Prop�sito: Mostrar al usuario las opciones de men� disponibles para que este
		             decida qu� desea hacer (posterior llamada a metodo ejecutar(). El metodo
		             permite que el usuario tenga constantes acciones en el programa hasta que
		             desee salir.
		 */

		byte opcionSeleccionada = 0;

		while (!SalirApp) {

			OpcionDeMenu.sb.append("Elija una opci�n:\n");
			
			// Ciclo para listar por pantalla las opciones de men�
			OpcionDeMenu.sb.append(prepararMenuImpresion(menuActivo));

			while (true) {
				System.out.print(OpcionDeMenu.sb.toString() + "=> ");
				opcionSeleccionada = OpcionDeMenu.esByte(OpcionDeMenu.br.readLine().trim());
				
				// Se realiza la eleccion de la opci�n
				if (opcionSeleccionada > 0 && opcionSeleccionada <= menuActivo.size()) {
					break;
				} else {
					System.out.println("Por favor ingrese un n�mero entero en el rango [1," + menuActivo.size() + "]\n");
				}
			}
			OpcionDeMenu.controlError = false;
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
			menuActivo.get(opcionSeleccionada - 1).ejecutar();
			// Llamado al metodo ejecutar de la opci�n de men� elegida
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());

			// El ciclo sigue hasta que el usuario ingrese la opci�n Salir
		}
	}

	// Devuelve las opciones de menu activas
	public ArrayList<OpcionDeMenu> getMenuActivo() {return menuActivo;}
	
	// Devuelve las opciones de menu de cada usuario
	public  ArrayList<OpcionDeMenu> getmenuUsuario(){return this.menuUsuario;}
	
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
		
		String cuenta = null, menu = null;

		// Condicional para distinguir entre comprador, vendedor y administrador
		if (tipoUsuario == 1) {
			// Caso A: Comprador
			menu = prepararMenuImpresion((new Comprador()).getMenuPredeterminado());
			cuenta = "compradores";
		} else if (tipoUsuario == 2) {
			// Caso B: Vendedor
			menu = prepararMenuImpresion((new Vendedor()).getMenuPredeterminado());
			cuenta = "vendedores";
		} else if (tipoUsuario == 3) {
			// Caso C: Administrador
			menu = prepararMenuImpresion((new Administrador()).getMenuPredeterminado());
			cuenta = "administradores";
		}
		return "A continuaci�n se muestran todas las opciones de men� disponubles para los usuarios " + cuenta + ":" + menu;
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

		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
		ArrayList<OpcionDeMenu> menu;
		StringBuilder sb = new StringBuilder();
		String usuario = null;

		// Condicional para distinguir entre comprador, vendedor y administrador
		if (tipoUsuario == 1) {
			// Caso A: Comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			usuario = "comprador";
		} else if (tipoUsuario == 2) {
			// Caso B: Vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			usuario = "vendedor";
		} else if (tipoUsuario == 3) {
			// Caso C: Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			usuario = "administrador";
		}

		if (baseDeDatos.containsKey(idUsuario)) {
			menu = baseDeDatos.get(idUsuario).getMenu();
			sb.append("A continuaci�n se muestra el men� del " + usuario + "\n");
			sb.append(prepararMenuImpresion(menu));
			OpcionDeMenu.controlError = true;
		} else {
			sb.append("El " + usuario + " no fue encontrado, por favor revise el c�digo ingresado");
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

		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
		ArrayList<OpcionDeMenu> menu;
		StringBuilder sb = new StringBuilder();
		int i;

		// Condicional para distinguir entre comprador, vendedor y administrador
		if (tipoUsuario == 1) {
			// Caso A: Comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
		} else if (tipoUsuario == 2) {
			// Caso B: Vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
		} else if (tipoUsuario == 3) {
			// Caso C: Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
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
					opcionComp = ((Administrador)baseDeDatos.get(idUsuario)).getMenuDisponible();
				}

				// Ciclo para descartar las opciones que ya posee el men� del usuario
				for (i = 0; i < menu.size(); i++) {
					if (opcionComp.contains(menu.get(i))) {
						opcionComp.remove(menu.get(i));
					}
				}

				// Ciclo para retornarla como string cada opci�n disponible
				sb.append("\nA continuaci�n se muestran las opciones disponibles que pueden agregarse:\n");
				for (i = 0; i < opcionComp.size(); i++) {
					sb.append((i + 1) + ". " + opcionComp.get(i).toString() + "\n");
				}
				OpcionDeMenu.controlError = true;
			}
			else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDisponibles()) {

				// Caso A.b: El men� del usuario tiene la cantidad m�xima posible de opciones
				sb.append("\nEsta cuenta ya posee la m�xima cantidad de opciones de men�\n");
			}
			// Caso A: Se est� agregando una opci�n - [Fin]
		} else if (borradoAgregado == 2) {

			// Caso B: Se est� eliminando una opci�n - [Inicio]

			// Resultado seg�n cantidad de opciones del usuario seleccionado
			if (menu.size() > 0) {

				// Caso B.a: El men� del usuario tiene al menos una opci�n disponible
				sb.append("Ingrese el indice de la opci�n que desea eliminar \n");
				sb.append("=> ");
				OpcionDeMenu.controlError = true;
			} else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDisponibles()) {

				// Caso B.b: El men� del usuario se encuentra vac�o
				sb.append("\nEsta cuenta ya no posee ninguna opci�n de men�, no es posible borrar m�s\n");
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
		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
		ArrayList<OpcionDeMenu> menu;
		StringBuilder sb = new StringBuilder();

		// Condicional para distinguir entre comprador, vendedor y administrador
		if (tipoUsuario == 1) {
			// Caso A: Comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
		} else if (tipoUsuario == 2) {
			// Caso B: Vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
		} else if (tipoUsuario == 3) {
			// Caso C: Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
		}
		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtenci�n de opciones de men� del usuario

		try {
			menu.add(opcionComp.get(indice)); // Adici�n de la opci�n correspondiente
			opcionComp.clear(); // Eliminaci�n de las opciones de comparaci�n para evitar errores

			sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); // Guardado del mensaje mostrando el nuevo men�
			OpcionDeMenu.controlError = true;
			return sb.append("/nSe ha agregado la opci�n correctamente/n").toString();
		} catch (IndexOutOfBoundsException e) {
			return "Por favor elija un �ndice dentro del rango mostrado anteriormente";
		}
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
		String h = null;
		
		// Condicional para distinguir entre comprador, vendedor y administrador
//		if (tipoUsuario == 1) {
//			// Caso A: Comprador
//			baseDeDatos = InicializacionAplicacion.getBDCompradores();
//		} else if (tipoUsuario == 2) {
//			// Caso B: Vendedor
//			baseDeDatos = InicializacionAplicacion.getBDVendedores();
//		} else if (tipoUsuario == 3) {
//			// Caso C: Administrador
//			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
//		}
		getBDUsuario(baseDeDatos, tipoUsuario, h);
		
		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtenci�n de opciones de men� del usuario

		try {
			menu.remove(menu.get(indice)); 								// Agregado de la opci�n correspondiente
			sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); 	// Guardado del mensaje mostrando el nuevo men�
			OpcionDeMenu.controlError = true;
			sb.append("/nSe ha eliminado la opci�n correctamente/n");
		} catch (IndexOutOfBoundsException e) {
			sb.append("Por favor elija un �ndice dentro del rango mostrado anteriormente");
		}
		return sb.toString();
	}
	
	private void getBDUsuario (HashMap<Integer, ? extends CuentaUsuario> baseDeDatos, byte tipoUsuario, String usuario){
		// Condicional para distinguir entre comprador, vendedor o administrador
		if (tipoUsuario == 1) {
			// Caso A: Comprador
			usuario = "comprador";
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
		} else if (tipoUsuario == 2) {
			// Caso B: Vendedor
			usuario = "vendedor";
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
		} else if (tipoUsuario == 3) {
			// Caso C: Administrador
			usuario = "administrador";
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
		}
	}
	
//	private HashMap<Integer, CuentaUsuario> getBDUsuario (byte tipoUsuario, String usuario){
//		// Condicional para distinguir entre comprador, vendedor o administrador
//		if (tipoUsuario == 1) {
//			// Caso A: Comprador
//			usuario = "comprador";
//			return InicializacionAplicacion.getBDCompradores();
//		} else if (tipoUsuario == 2) {
//			// Caso B: Vendedor
//			usuario = "vendedor";
//			return InicializacionAplicacion.getBDVendedores();
//		} else if (tipoUsuario == 3) {
//			// Caso C: Administrador
//			usuario = "administrador";
//			return InicializacionAplicacion.getBDAdministradores();
//		}
//	}
	
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