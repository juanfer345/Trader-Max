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