package uiMain;

import java.util.*;
import gestorAplicación.Usuarios.Cuenta;
import gestorAplicación.Usuarios.Visitante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuDeConsola {
	
	public static ArrayList <OpcionDeMenu> opcionesActivas = new ArrayList<OpcionDeMenu>();
	public static Cuenta usuarioActivo = new Visitante();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static boolean SalirApp = false;
	
	public MenuDeConsola (ArrayList <OpcionDeMenu> opcionesActivas, Cuenta usuarioActivo) {
		this.opcionesActivas = opcionesActivas;
		MenuDeConsola.usuarioActivo = usuarioActivo;
		MenuDeConsola.SalirApp = false;
	}
	
	public void cambiarMenu (ArrayList <OpcionDeMenu> opcionesActivas, Cuenta usuarioActivo) {
		this.opcionesActivas = opcionesActivas;
		MenuDeConsola.usuarioActivo = usuarioActivo;
		MenuDeConsola.SalirApp = false;
	}
	
	public static void LanzarMenu() throws IOException {
		System.out.println("Ingrese la opción:");
		for (int i = 0; i < opcionesActivas.size(); i++) {
			System.out.println((i + 1) + opcionesActivas.get(i).toString());
		}
		System.out.println("=> ");
		opcionesActivas.get(Byte.parseByte(br.readLine().trim()) - 1).ejecutar();
	}
}