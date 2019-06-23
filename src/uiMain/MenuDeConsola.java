package uiMain;

import java.util.*;
import gestorAplicación.*;
import gestorAplicación.Usuarios.Administrador;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.Cuenta;
import gestorAplicación.Usuarios.Vendedor;
import gestorAplicación.Usuarios.Visitante;
import gestorAplicación.InicializacionAplicacion;
import gestorAplicación.Materiales.CarritoDeCompras;
import gestorAplicación.Materiales.Producto;
import gestorAplicación.Materiales.Reseña;

public class MenuDeConsola {

	ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>();// lista de metodos para el admin
	ArrayList<OpcionDeMenu> activo = new ArrayList<OpcionDeMenu>();
	Cuenta usuario = new Visitante();
	public static boolean SalirApp = false;
	public static Scanner e = new Scanner(System.in);
	public static int compradores = 0;
	public static int vendedores = 0;
	public static int administradores = 0;

	public void LanzarMenu() {
		activo.add(new iniciarSesion());
		activo.add(new registrar());
		activo.add(new salir());
		
		for (int i = 0; i < activo.size(); i++) {
			System.out.println((i+1)+ activo.get(i).toString());
		}
		System.out.println("Ingrese la opción");
		int recibido = MenuDeConsola.e.nextInt();
		OpcionDeMenu op = opciones.get(recibido-1);
		op.ejecutar();
		
	}

}