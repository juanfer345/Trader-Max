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
		  Propósito: Mostrar al usuario las opciones de menú disponibles para que este
		             decida qué desea hacer (posterior llamada a metodo ejecutar(). El metodo
		             permite que el usuario tenga constantes acciones en el programa hasta que
		             desee salir.
		 */

		byte opcionSeleccionada = 0;

		while (!SalirApp) {

			OpcionDeMenu.sb.append("Elija una opción:\n");
			
			// Ciclo para listar por pantalla las opciones de menú
			OpcionDeMenu.sb.append(prepararMenuImpresion(menuActivo));

			while (true) {
				System.out.print(OpcionDeMenu.sb.toString() + "=> ");
				opcionSeleccionada = OpcionDeMenu.esByte(OpcionDeMenu.br.readLine().trim());
				
				// Se realiza la eleccion de la opción
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

			// El ciclo sigue hasta que el usuario ingrese la opción Salir
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
		Proposito: Mostrar las opciones disponibles del menú de un tipo de usuario.

		Variables de entrada:
		- int idUsuario: Número de identificación del usuario.
		- byte tipoUsuario: Número {1, 2, 3} del tipo de usuario sobre el cual se realiza el método.

		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
		  En caso de que sea exitoso se muestra el menú que tiene el tipo usuario.
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
		return "A continuación se muestran todas las opciones de menú disponubles para los usuarios " + cuenta + ":" + menu;
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
			sb.append("A continuación se muestra el menú del " + usuario + "\n");
			sb.append(prepararMenuImpresion(menu));
			OpcionDeMenu.controlError = true;
		} else {
			sb.append("El " + usuario + " no fue encontrado, por favor revise el código ingresado");
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
					opcionComp = ((Administrador)baseDeDatos.get(idUsuario)).getMenuDisponible();
				}

				// Ciclo para descartar las opciones que ya posee el menú del usuario
				for (i = 0; i < menu.size(); i++) {
					if (opcionComp.contains(menu.get(i))) {
						opcionComp.remove(menu.get(i));
					}
				}

				// Ciclo para retornarla como string cada opción disponible
				sb.append("\nA continuación se muestran las opciones disponibles que pueden agregarse:\n");
				for (i = 0; i < opcionComp.size(); i++) {
					sb.append((i + 1) + ". " + opcionComp.get(i).toString() + "\n");
				}
				OpcionDeMenu.controlError = true;
			}
			else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDisponibles()) {

				// Caso A.b: El menú del usuario tiene la cantidad máxima posible de opciones
				sb.append("\nEsta cuenta ya posee la máxima cantidad de opciones de menú\n");
			}
			// Caso A: Se está agregando una opción - [Fin]
		} else if (borradoAgregado == 2) {

			// Caso B: Se está eliminando una opción - [Inicio]

			// Resultado según cantidad de opciones del usuario seleccionado
			if (menu.size() > 0) {

				// Caso B.a: El menú del usuario tiene al menos una opción disponible
				sb.append("Ingrese el indice de la opción que desea eliminar \n");
				sb.append("=> ");
				OpcionDeMenu.controlError = true;
			} else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDisponibles()) {

				// Caso B.b: El menú del usuario se encuentra vacío
				sb.append("\nEsta cuenta ya no posee ninguna opción de menú, no es posible borrar más\n");
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
		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtención de opciones de menú del usuario

		try {
			menu.add(opcionComp.get(indice)); // Adición de la opción correspondiente
			opcionComp.clear(); // Eliminación de las opciones de comparación para evitar errores

			sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); // Guardado del mensaje mostrando el nuevo menú
			OpcionDeMenu.controlError = true;
			return sb.append("/nSe ha agregado la opción correctamente/n").toString();
		} catch (IndexOutOfBoundsException e) {
			return "Por favor elija un índice dentro del rango mostrado anteriormente";
		}
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
		
		menu = baseDeDatos.get(idUsuario).getMenu(); // Obtención de opciones de menú del usuario

		try {
			menu.remove(menu.get(indice)); 								// Agregado de la opción correspondiente
			sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario)); 	// Guardado del mensaje mostrando el nuevo menú
			OpcionDeMenu.controlError = true;
			sb.append("/nSe ha eliminado la opción correctamente/n");
		} catch (IndexOutOfBoundsException e) {
			sb.append("Por favor elija un índice dentro del rango mostrado anteriormente");
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