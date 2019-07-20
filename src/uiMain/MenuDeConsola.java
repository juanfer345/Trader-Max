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


public class MenuDeConsola {

	public static ArrayList<OpcionDeMenu> menuActivo;
	public static boolean SalirApp = false;
	
//
// public String mostrarOpcionesDeMenu(int idUsuario, byte tipoUsuario) {
//	/*
//		Proposito: Mostrar las opciones de men� del usuario.
//		
//		Variables de entrada:
//		- int idUsuario: N�mero de identificaci�n del usuario.
//		- byte tipoUsuario: N�mero {1, 2} del tipo de usuario sobre el cual se realiza el m�todo.
//		
//		Variables de salida:
//		- String con mensaje dependiendo si el proceso fue o no exitoso.
//		  En caso de que sea exitoso se muestra el men� que tiene el usuario.
//    */
//
//		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
//		ArrayList<OpcionDeMenu> menu;
//		StringBuilder sb = new StringBuilder();
//		String usuario = null;
//		int i;
//
//		// Condicional para distinguir entre comprador y vendedor
//		if (tipoUsuario == 1) {
//			// Caso A: Comprador
//			baseDeDatos = InicializacionAplicacion.getBDCompradores();
//			usuario = "comprador";
//		} else if (tipoUsuario == 2) {
//			// Caso B: Vendedor
//			baseDeDatos = InicializacionAplicacion.getBDVendedores();
//			usuario = "vendedor";
//		}
//
//		if (baseDeDatos.containsKey(idUsuario)) {
//			menu = baseDeDatos.get(idUsuario).getMenu();
//			sb.append("A continuaci�n se muestra el men� del " + usuario + "\n");
//			for (i = 0; i < menu.size(); i++) {
//				sb.append((i + 1) + ". " + menu.get(i).toString() + "\n");
//			}
//			OpcionDeMenu.controlError = true;
//		} else {
//			sb.append("El " + usuario + " no fue encontrado, por favor revise el c�digo ingresado");
//		}
//		return sb.toString();
//	}
// 
//	public String comprobarCantidadOpciones(int idUsuario, byte tipoUsuario, byte borradoAgregado) {
//	/*
//		Proposito: Mostrar las opciones de men� del usuario, paso previo para cuando
//		           se desee agregar o eliminar una opci�n.
//		
//		Variables de entrada:
//		- int idUsuario: N�mero de identificaci�n del usuario.
//		- byte tipoUsuario: N�mero {1, 2} del tipo de usuario sobre el cual se realiza el m�todo.
//		- byte borradoAgregado: N�mero {1, 2} que se ingresa dependiendo si es agregar o eliminar opci�n.
//		
//		Variables de salida:
//		- String con mensaje del proceso dependiendo de la operaci�n que desea realizar.
// */
//
//		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
//		ArrayList<OpcionDeMenu> menu;
//		StringBuilder sb = new StringBuilder();
//		int i;
//
//		// Condicional para distinguir entre comprador y vendedor
//		if (tipoUsuario == 1) {
//			// Caso A: Comprador
//			baseDeDatos = InicializacionAplicacion.getBDCompradores();
//		} else if (tipoUsuario == 2) {
//			// Caso B: Vendedor
//			baseDeDatos = InicializacionAplicacion.getBDVendedores();
//		}
//		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtenci�n de opciones de men� del usuario
//
//		// Condicional para identificar si es el caso de agregado o eliminaci�n de opciones
//		if (borradoAgregado == 1) {
//
//			// Caso A: Se est� agregando una opci�n - [Inicio]
//
//			// Resultado seg�n cantidad de opciones del usuario seleccionado
//			if (menu.size() < baseDeDatos.get(idUsuario).getTotalDeOpcionesDefault()) {
//
//				// Caso A.a: El men� del usuario no tiene la cantidad m�xima posible de opciones
//				opcionComp = baseDeDatos.get(idUsuario).getMenuPredeterminado();
//
//				// Ciclo para descartar las opciones que ya posee el men� del usuario
//				for (i = 0; i < menu.size(); i++) {
//					if (opcionComp.contains(menu.get(i))) {
//						opcionComp.remove(menu.get(i));
//					}
//				}
//				Cuenta.setCambioOpDeMen(opcionComp); // Guardado de las opciones que no posee el men� del usuario
//
//				// Ciclo para retornarla como string cada opci�n disponible
//				sb.append("\nA continuaci�n se muestran las opciones disponibles que pueden agregarse:\n");
//				for (i = 0; i < opcionComp.size(); i++) {
//					sb.append((i + 1) + ". " + opcionComp.get(i).toString() + "\n");
//				}
//				sb.append("Ingrese el indice de la opci�n que desea agregar \n");
//				sb.append("=> ");
//				OpcionDeMenu.controlError = true;
//			} else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDefault()) {
//
//				// Caso A.b: El men� del usuario tiene la cantidad m�xima posible de opciones
//				sb.append("\nEsta cuenta ya posee la m�xima cantidad de opciones de men�\n");
//			}
//			// Caso A: Se est� agregando una opci�n - [Fin]
//		} else if (borradoAgregado == 2) {
//
//			// Caso B: Se est� eliminando una opci�n - [Inicio]
//
//			// Resultado seg�n cantidad de opciones del usuario seleccionado
//			if (menu.size() > 0) {
//
//				// Caso B.a: El men� del usuario tiene al menos una opci�n disponible
//				sb.append("Ingrese el indice de la opci�n que desea eliminar \n");
//				sb.append("=> ");
//				OpcionDeMenu.controlError = true;
//			} else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDefault()) {
//
//				// Caso B.b: El men� del usuario se encuentra vac�o
//				sb.append("\nEsta cuenta ya no posee ninguna opci�n de men�, no es posible borrar m�s\n");
//			}
//			// Caso B: Se est� eliminando una opci�n - [Fin]
//		}
//		return sb.toString();
//	}
//	
//	public String agregarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
//	/*
//		Proposito: Agregar una opci�n de men� a un usuario
//		
//		Variables de entrada:
//		- int idUsuario: N�mero de identificaci�n del usuario
//		- byte tipoUsuario: N�mero {1, 2} del tipo de usuario sobre el cual se realiza el m�todo
//		- byte indice: N�mero de la opci�n de men� que se desea agregar
//		
//		Variables de salida:
//		- String con mensaje dependiendo si el proceso fue o no exitoso.
//    */
//		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
//		ArrayList<OpcionDeMenu> menu;
//		StringBuilder sb = new StringBuilder();
//
//		// Condicional para distinguir entre comprador y vendedor
//		if (tipoUsuario == 1) {
//			// Caso A: Comprador
//			baseDeDatos = InicializacionAplicacion.getBDCompradores();
//		} else if (tipoUsuario == 2) {
//			// Caso B: Vendedor
//			baseDeDatos = InicializacionAplicacion.getBDVendedores();
//		}
//		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtenci�n de opciones de men� del usuario
//
//		try {
//			menu.add(opcionComp.get(indice)); // Agregado de la opci�n correspondiente
//			opcionComp.clear(); // Eliminaci�n de las opciones de comparaci�n para evitar errores
//
//			sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); // Guardado del mensaje mostrando el nuevo men�
//			OpcionDeMenu.controlError = true;
//			return sb.append("/nSe ha agregado la opci�n correctamente/n").toString();
//		} catch (IndexOutOfBoundsException e) {
//			return "Por favor elija un �ndice dentro del rango mostrado anteriormente";
//		}
//	}
//	
//	public String eliminarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
//		/*
//			Proposito: Eliminar una opci�n de men� de un usuario
//			
//			Variables de entrada:
//			- int idUsuario: N�mero de identificaci�n del usuario 
//			- byte tipoUsuario: N�mero {1, 2} del tipo de usuario sobre el cual se realiza el m�todo
//			- byte indice: N�mero de la opci�n de men� que se desea eliminar
//			
//			Variables de salida:
//			- String con mensaje dependiendo si el proceso fue o no exitoso.
//	    */
//			HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
//			ArrayList<OpcionDeMenu> menu;
//			StringBuilder sb = new StringBuilder();
//
//			// Condicional para distinguir entre comprador y vendedor
//			if (tipoUsuario == 1) {
//				// Caso A: Comprador
//				baseDeDatos = InicializacionAplicacion.getBDCompradores();
//			} else if (tipoUsuario == 2) {
//				// Caso B: Vendedor
//				baseDeDatos = InicializacionAplicacion.getBDVendedores();
//			}
//			menu = baseDeDatos.get(idUsuario).getMenu(); // Obtenci�n de opciones de men� del usuario
//
//			try {
//				menu.remove(menu.get(indice)); // Agregado de la opci�n correspondiente
//
//				sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); // Guardado del mensaje mostrando el nuevo men�
//				OpcionDeMenu.controlError = true;
//				sb.append("/nSe ha eliminado la opci�n correctamente/n");
//			} catch (IndexOutOfBoundsException e) {
//				sb.append("Por favor elija un �ndice dentro del rango mostrado anteriormente");
//			}
//			return sb.toString();
//		}
//	
//	
	
	
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
			for (int i = 0; i < menuActivo.size(); i++) {
				OpcionDeMenu.sb.append((i + 1) + ". " + menuActivo.get(i).toString() + ".\n");
			} // Ciclo para listar por pantalla las opciones de men�

			while (true) {
				System.out.print(OpcionDeMenu.sb.toString() + "=> ");
				opcionSeleccionada = OpcionDeMenu.esByte(OpcionDeMenu.br.readLine().trim());
				// Se realiza la eleccion de la opcion

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

			// El ciclo sigue hasta que el usuario ingrese la opcion Salir
		}
	}

	// PASAR A�ADIR Y ELMINIAR OPCION DE MENU AQUI
	public ArrayList<OpcionDeMenu> getMenuActivo() {
		return menuActivo;
	}
}