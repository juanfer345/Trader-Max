/*
	Clase MenuDeConsola (pública)   
	
	Propósito: Es el menú general del programa donde el usuario interacciona
	           con las opciones que tiene en la aplicaion
	          
	Estructuras de datos relevantes:
	- ArrayList <OpcionDeMenu> menuActivo: Estructura que contiene las opciones de menú del usuario
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
//		Proposito: Mostrar las opciones de menú del usuario.
//		
//		Variables de entrada:
//		- int idUsuario: Número de identificación del usuario.
//		- byte tipoUsuario: Número {1, 2} del tipo de usuario sobre el cual se realiza el método.
//		
//		Variables de salida:
//		- String con mensaje dependiendo si el proceso fue o no exitoso.
//		  En caso de que sea exitoso se muestra el menú que tiene el usuario.
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
//			sb.append("A continuación se muestra el menú del " + usuario + "\n");
//			for (i = 0; i < menu.size(); i++) {
//				sb.append((i + 1) + ". " + menu.get(i).toString() + "\n");
//			}
//			OpcionDeMenu.controlError = true;
//		} else {
//			sb.append("El " + usuario + " no fue encontrado, por favor revise el código ingresado");
//		}
//		return sb.toString();
//	}
// 
//	public String comprobarCantidadOpciones(int idUsuario, byte tipoUsuario, byte borradoAgregado) {
//	/*
//		Proposito: Mostrar las opciones de menú del usuario, paso previo para cuando
//		           se desee agregar o eliminar una opción.
//		
//		Variables de entrada:
//		- int idUsuario: Número de identificación del usuario.
//		- byte tipoUsuario: Número {1, 2} del tipo de usuario sobre el cual se realiza el método.
//		- byte borradoAgregado: Número {1, 2} que se ingresa dependiendo si es agregar o eliminar opción.
//		
//		Variables de salida:
//		- String con mensaje del proceso dependiendo de la operación que desea realizar.
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
//		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtención de opciones de menú del usuario
//
//		// Condicional para identificar si es el caso de agregado o eliminación de opciones
//		if (borradoAgregado == 1) {
//
//			// Caso A: Se está agregando una opción - [Inicio]
//
//			// Resultado según cantidad de opciones del usuario seleccionado
//			if (menu.size() < baseDeDatos.get(idUsuario).getTotalDeOpcionesDefault()) {
//
//				// Caso A.a: El menú del usuario no tiene la cantidad máxima posible de opciones
//				opcionComp = baseDeDatos.get(idUsuario).getMenuPredeterminado();
//
//				// Ciclo para descartar las opciones que ya posee el menú del usuario
//				for (i = 0; i < menu.size(); i++) {
//					if (opcionComp.contains(menu.get(i))) {
//						opcionComp.remove(menu.get(i));
//					}
//				}
//				Cuenta.setCambioOpDeMen(opcionComp); // Guardado de las opciones que no posee el menú del usuario
//
//				// Ciclo para retornarla como string cada opción disponible
//				sb.append("\nA continuación se muestran las opciones disponibles que pueden agregarse:\n");
//				for (i = 0; i < opcionComp.size(); i++) {
//					sb.append((i + 1) + ". " + opcionComp.get(i).toString() + "\n");
//				}
//				sb.append("Ingrese el indice de la opción que desea agregar \n");
//				sb.append("=> ");
//				OpcionDeMenu.controlError = true;
//			} else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDefault()) {
//
//				// Caso A.b: El menú del usuario tiene la cantidad máxima posible de opciones
//				sb.append("\nEsta cuenta ya posee la máxima cantidad de opciones de menú\n");
//			}
//			// Caso A: Se está agregando una opción - [Fin]
//		} else if (borradoAgregado == 2) {
//
//			// Caso B: Se está eliminando una opción - [Inicio]
//
//			// Resultado según cantidad de opciones del usuario seleccionado
//			if (menu.size() > 0) {
//
//				// Caso B.a: El menú del usuario tiene al menos una opción disponible
//				sb.append("Ingrese el indice de la opción que desea eliminar \n");
//				sb.append("=> ");
//				OpcionDeMenu.controlError = true;
//			} else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDefault()) {
//
//				// Caso B.b: El menú del usuario se encuentra vacío
//				sb.append("\nEsta cuenta ya no posee ninguna opción de menú, no es posible borrar más\n");
//			}
//			// Caso B: Se está eliminando una opción - [Fin]
//		}
//		return sb.toString();
//	}
//	
//	public String agregarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
//	/*
//		Proposito: Agregar una opción de menú a un usuario
//		
//		Variables de entrada:
//		- int idUsuario: Número de identificación del usuario
//		- byte tipoUsuario: Número {1, 2} del tipo de usuario sobre el cual se realiza el método
//		- byte indice: Número de la opción de menú que se desea agregar
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
//		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtención de opciones de menú del usuario
//
//		try {
//			menu.add(opcionComp.get(indice)); // Agregado de la opción correspondiente
//			opcionComp.clear(); // Eliminación de las opciones de comparación para evitar errores
//
//			sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); // Guardado del mensaje mostrando el nuevo menú
//			OpcionDeMenu.controlError = true;
//			return sb.append("/nSe ha agregado la opción correctamente/n").toString();
//		} catch (IndexOutOfBoundsException e) {
//			return "Por favor elija un índice dentro del rango mostrado anteriormente";
//		}
//	}
//	
//	public String eliminarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
//		/*
//			Proposito: Eliminar una opción de menú de un usuario
//			
//			Variables de entrada:
//			- int idUsuario: Número de identificación del usuario 
//			- byte tipoUsuario: Número {1, 2} del tipo de usuario sobre el cual se realiza el método
//			- byte indice: Número de la opción de menú que se desea eliminar
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
//			menu = baseDeDatos.get(idUsuario).getMenu(); // Obtención de opciones de menú del usuario
//
//			try {
//				menu.remove(menu.get(indice)); // Agregado de la opción correspondiente
//
//				sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); // Guardado del mensaje mostrando el nuevo menú
//				OpcionDeMenu.controlError = true;
//				sb.append("/nSe ha eliminado la opción correctamente/n");
//			} catch (IndexOutOfBoundsException e) {
//				sb.append("Por favor elija un índice dentro del rango mostrado anteriormente");
//			}
//			return sb.toString();
//		}
//	
//	
	
	
	public static void LanzarMenu() throws IOException {
		/*
		  Propósito: Mostrar al usuario las opciones de menú disponibles para que este
		             decida qué desea hacer (posterior llamada a metodo ejecutar(). El metodo
		             permite que el usuario tenga constantes acciones en el programa hasta que
		             desee salir.
		 */

		byte opcionSeleccionada = 0;

		while (!SalirApp) {

			OpcionDeMenu.sb.append("Elija una opción:\n");
			for (int i = 0; i < menuActivo.size(); i++) {
				OpcionDeMenu.sb.append((i + 1) + ". " + menuActivo.get(i).toString() + ".\n");
			} // Ciclo para listar por pantalla las opciones de menú

			while (true) {
				System.out.print(OpcionDeMenu.sb.toString() + "=> ");
				opcionSeleccionada = OpcionDeMenu.esByte(OpcionDeMenu.br.readLine().trim());
				// Se realiza la eleccion de la opcion

				if (opcionSeleccionada > 0 && opcionSeleccionada <= menuActivo.size()) {
					break;
				} else {
					System.out.println("Por favor ingrese un número entero en el rango [1," + menuActivo.size() + "]\n");
				}
			}
			OpcionDeMenu.controlError = false;
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
			menuActivo.get(opcionSeleccionada - 1).ejecutar();
			// Llamado al metodo ejecutar de la opción de menú elegida
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());

			// El ciclo sigue hasta que el usuario ingrese la opcion Salir
		}
	}

	// PASAR AÑADIR Y ELMINIAR OPCION DE MENU AQUI
	public ArrayList<OpcionDeMenu> getMenuActivo() {
		return menuActivo;
	}
}