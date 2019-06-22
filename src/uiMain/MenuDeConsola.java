package uiMain;

import java.util.*;
import gestorAplicaci�n.*;
import gestorAplicaci�n.Usuarios.Administrador;
import gestorAplicaci�n.Usuarios.Comprador;
import gestorAplicaci�n.Usuarios.Cuenta;
import gestorAplicaci�n.Usuarios.Vendedor;
import gestorAplicaci�n.Usuarios.Visitante;
import gestorAplicaci�n.InicializacionAplicacion;
import gestorAplicaci�n.Materiales.CarritoDeCompras;
import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Materiales.Rese�a;

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
		System.out.println("Ingrese la opci�n");
		int recibido = MenuDeConsola.e.nextInt();
		OpcionDeMenu op = opciones.get(recibido-1);
		op.ejecutar();
		
	}

}