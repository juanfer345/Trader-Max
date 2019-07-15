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
			
			OpcionDeMenu.sb.append("Elija una opci�n:\n");
			for (int i = 0; i < opcionesUsuarioActivo.size(); i++) {
				OpcionDeMenu.sb.append((i + 1) + ". " + opcionesUsuarioActivo.get(i).toString() + ".\n");
			}
			
			while (true) {
				System.out.print(OpcionDeMenu.sb.toString() + "=> ");
				opcionSeleccionada = esByte(OpcionDeMenu.br.readLine().trim());
				
				if (opcionSeleccionada > 0 && opcionSeleccionada <= opcionesUsuarioActivo.size()) {
					break;
				}
				else {
					System.out.println("Por favor ingrese un n�mero entero en el rango [1," + opcionesUsuarioActivo.size() + "]\n");
				}
			}
			OpcionDeMenu.controlError = false;
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
			
			opcionesUsuarioActivo.get(opcionSeleccionada - 1).ejecutar();
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
		}
	}

	// M�todo para comprobar si una entrada de tipo String es num�rica (long)
	public static long esLong(String input) {
		try {
			Long.parseLong(input);
			return Long.parseLong(input);

		} catch (NumberFormatException g) {
			return -1;
		}
	}

	// M�todo para comprobar si una entrada de tipo String es num�rica (int)
	public static int esInt(String input) {
		try {
			Integer.parseInt(input);
			return Integer.parseInt(input);

		} catch (NumberFormatException g) {
			return -1;
		}
	}

	// M�todo para comprobar si una entrada de tipo String es num�rica
	public static byte esByte(String input) {
		try {
			Byte.parseByte(input);
			return Byte.parseByte(input);

		} catch (NumberFormatException g) {
			return -1;
		}
	}

	public ArrayList<OpcionDeMenu> getOpcionesActivas() {return opcionesActivas;}

	public void setOpcionesActivas(ArrayList<OpcionDeMenu> opcionesActivas) {
		this.opcionesActivas = opcionesActivas;
	}
}