package uiMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import gestorAplicacion.InicializacionAplicacion;

public class MenuDeConsola {
	private ArrayList <OpcionDeMenu> opcionesActivas = new ArrayList <OpcionDeMenu>();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static boolean SalirApp = false;
	
	public static void LanzarMenu() throws IOException {
		
		ArrayList <OpcionDeMenu> aux = InicializacionAplicacion.usuarioActivo.getOpcionesDeMenu();
	    StringBuilder sb = new StringBuilder();
		
		System.out.println("Elija una opción:");
		for (int i = 0; i < aux.size(); i++) {
			sb.append((i + 1) + ". " + aux.get(i).toString() + "/n");
		}
		System.out.println("=> ");
		
		OpcionDeMenu.controlError = false;
		aux.get(Byte.parseByte(br.readLine().trim()) - 1).ejecutar();
	}

	public ArrayList <OpcionDeMenu> getOpcionesActivas() {
		return opcionesActivas;
	}

	public void setOpcionesActivas(ArrayList <OpcionDeMenu> opcionesActivas) {
		this.opcionesActivas = opcionesActivas;
	}
}