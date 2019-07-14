package uiMain;

import java.io.IOException;
import java.util.ArrayList;
import gestorAplicacion.InicializacionAplicacion;

public class MenuDeConsola {

	private ArrayList <OpcionDeMenu> opcionesActivas = new ArrayList <OpcionDeMenu>();
	public static ArrayList <OpcionDeMenu> opcionesUsuarioActivo;
	public static boolean SalirApp = false;

	public static void LanzarMenu() throws IOException {
		
		byte opcionSeleccionada = 0;
		opcionesUsuarioActivo = InicializacionAplicacion.usuarioActivo.getOpcionesDeMenu();
		
		while (!SalirApp) {
			
			OpcionDeMenu.sb.append("Elija una opción:\n");
			for (int i = 0; i < opcionesUsuarioActivo.size(); i++) {
				OpcionDeMenu.sb.append((i + 1) + ". " + opcionesUsuarioActivo.get(i).toString() + ".\n");
			}
			
			while (true) {
				System.out.print(OpcionDeMenu.sb.toString() + "=> ");
				opcionSeleccionada = (byte) esNumeroEntero(OpcionDeMenu.br.readLine().trim());
				
				if (opcionSeleccionada > 0 && opcionSeleccionada <= opcionesUsuarioActivo.size()) {
					break;
				}
				else {
					System.out.println("Por favor ingrese un número entero en el rango [1," + opcionesUsuarioActivo.size() + "]\n");
				}
			}
			OpcionDeMenu.controlError = false;
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
			
			opcionesUsuarioActivo.get(opcionSeleccionada - 1).ejecutar();
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
		}
	}

	//Método para comprobar si una entrada de tipo String es numérica
	public static long esNumeroEntero(String input) {

		try {
			Long.parseLong(input);
			return Long.parseLong(input);

		} catch (NumberFormatException e) {
			try {
				Integer.parseInt(input);
				return Long.parseLong(input);

			} catch (NumberFormatException f) {
				try {
					Byte.parseByte(input);
					return Long.parseLong(input);	

				} catch (NumberFormatException g) {
					return -1;
				}
			}
		}
	}
	public ArrayList <OpcionDeMenu> getOpcionesActivas() {
		return opcionesActivas;
	}

	public void setOpcionesActivas(ArrayList <OpcionDeMenu> opcionesActivas) {
		this.opcionesActivas = opcionesActivas;
	}
}