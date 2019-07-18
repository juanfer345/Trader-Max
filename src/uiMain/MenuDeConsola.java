package uiMain;

import java.io.IOException;
import java.util.ArrayList;

public class MenuDeConsola {

	public static ArrayList <OpcionDeMenu> menuActivo;
	public static boolean SalirApp = false;

	public static void LanzarMenu() throws IOException {
		
		byte opcionSeleccionada = 0;
		
		while (!SalirApp) {
			
			OpcionDeMenu.sb.append("Elija una opción:\n");
			for (int i = 0; i < menuActivo.size(); i++) {
				OpcionDeMenu.sb.append((i + 1) + ". " + menuActivo.get(i).toString() + ".\n");
			}
			
			while (true) {
				System.out.print(OpcionDeMenu.sb.toString() + "=> ");
				opcionSeleccionada = OpcionDeMenu.esByte(OpcionDeMenu.br.readLine().trim());
				
				if (opcionSeleccionada > 0 && opcionSeleccionada <= menuActivo.size()) {
					break;
				}
				else {
					System.out.println("Por favor ingrese un número entero en el rango [1," + menuActivo.size() + "]\n");
				}
			}
			OpcionDeMenu.controlError = false;
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
			menuActivo.get(opcionSeleccionada - 1).ejecutar();
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
		}
	}

	//PASAR AÑADIR Y ELMINIAR OPCION DE MENU AQUI
	public ArrayList<OpcionDeMenu> getMenuActivo() {return menuActivo;}
}