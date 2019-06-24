package uiMain;

import java.util.*;
import gestorAplicación.Usuarios.Cuenta;
import gestorAplicación.Usuarios.Visitante;
import uiMain.Funcionalidades.buscarCategoria;
import uiMain.Funcionalidades.buscarProducto;
import uiMain.Funcionalidades.iniciarSesion;
import uiMain.Funcionalidades.registrar;
import uiMain.Funcionalidades.salir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuDeConsola {

	public ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>();// lista de metodos para el admin
	public ArrayList<OpcionDeMenu> activo = new ArrayList<OpcionDeMenu>();
	public static Cuenta usuario = new Visitante();
	public static boolean SalirApp = false;
	public static Scanner scn = new Scanner(System.in);
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int compradores = 0;
	public static int vendedores = 0;
	public static int administradores = 0;
	
	MenuDeConsola () {
		activo.add(new iniciarSesion());
		activo.add(new registrar());
		activo.add(new buscarProducto());
		activo.add(new buscarCategoria());
		activo.add(new salir());
	}
	
	public void LanzarMenu() throws IOException {
		
		
		for (int i = 0; i < activo.size(); i++) {
			System.out.println((i+1)+ activo.get(i).toString());
		}
		System.out.println("Ingrese la opción");
		int recibido = MenuDeConsola.scn.nextInt();
		OpcionDeMenu op = opciones.get(recibido-1);
		op.ejecutar();
		
		
	}

}