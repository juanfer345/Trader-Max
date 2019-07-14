package uiMain;

import java.io.IOException;
import java.util.ArrayList;
import gestorAplicacion.InicializacionAplicacion;

public class MenuDeConsola {

	private ArrayList<OpcionDeMenu> opcionesActivas = new ArrayList<OpcionDeMenu>();
	public static ArrayList<OpcionDeMenu> opcionesUsuarioActivo = InicializacionAplicacion.usuarioActivo
			.getOpcionesDeMenu();
	public static boolean SalirApp = false;

	public static void LanzarMenu() throws IOException {

		while (!MenuDeConsola.SalirApp) {
			System.out.println("Elija una opción:");
			for (int i = 0; i < opcionesUsuarioActivo.size(); i++) {
				OpcionDeMenu.sb.append((i + 1) + ". " + opcionesUsuarioActivo.get(i).toString() + ".\n");
			}
			System.out.print(OpcionDeMenu.sb.toString() + "=> ");

			OpcionDeMenu.controlError = false;
			opcionesUsuarioActivo.get(Byte.parseByte(OpcionDeMenu.br.readLine().trim()) - 1).ejecutar();
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
		}
	}

	// Método para comprobar si una entrada de tipo String es numérica
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

	public ArrayList<OpcionDeMenu> getOpcionesActivas() {
		return opcionesActivas;
	}

	public void setOpcionesActivas(ArrayList<OpcionDeMenu> opcionesActivas) {
		this.opcionesActivas = opcionesActivas;
	}
}