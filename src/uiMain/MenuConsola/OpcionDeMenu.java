/* 
   Clase OpcionDeMenu (pública abstracta)
   
   Propósito:
   Es la base para todas las opciones de menú existentes
   Tambien contiene algunos metodos para comprobar el tipo de dato ingresado
   
   Estructuras de datos relevantes:
   - ArrayList<OpcionDeMenu>: Contiene a todas las opciones de menú del programa
 */

package uiMain.MenuConsola;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Administrador.AgregarOpcion;
import uiMain.MenuConsola.Cuenta.Administrador.BloqueoDeCuenta;
import uiMain.MenuConsola.Cuenta.Administrador.EliminarOpcion;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarCuentas;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarMenu;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarMenuDisponible;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarTodasLasOpciones;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarUsuario;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarACarrito;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarResena;
import uiMain.MenuConsola.Cuenta.Comprador.BorrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.ComprarProducto;
import uiMain.MenuConsola.Cuenta.Comprador.MostrarCarrito;
import uiMain.MenuConsola.Cuenta.Comprador.MostrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.QuitarProductoCarrito;
import uiMain.MenuConsola.Cuenta.Comprador.VaciarCarrito;
import uiMain.MenuConsola.Cuenta.Vendedor.CambiarPrecio;
import uiMain.MenuConsola.Cuenta.Vendedor.EliminarProductoCatalogo;
import uiMain.MenuConsola.Cuenta.Vendedor.ModificarCantidad;
import uiMain.MenuConsola.Cuenta.Vendedor.SubirProducto;
import uiMain.MenuConsola.Cuenta.Vendedor.VerProductos;
import uiMain.MenuConsola.Visitante.IniciarSesion;
import uiMain.MenuConsola.Visitante.Registrar;

public abstract class OpcionDeMenu implements ActionListener {

	//Atributos
	public static boolean controlError;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	protected static StringBuilder sb = new StringBuilder();

	abstract public void ejecutar() throws IOException;

	abstract public String toString();

	// Lista de todas las opciones de menú
	public static ArrayList<OpcionDeMenu> getTodasLasOpciones() {
		/*
		   Propósito: Crear todas las opciones de menú y meterlas a una ArrayList
		   
		   Parámetros de salida:
		   - ArrayList<OpcionDeMenu>: Con todas las opciones
		 */

		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
				new IniciarSesion(), new Registrar(), new BuscarProducto(), new MostrarCatalogo(), 
				new MostrarPorCategoria(), new MostrarResenas(), new AgregarACarrito(), new AgregarResena(), 
				new BorrarHistorial(), new ComprarProducto(), new MostrarCarrito(), new MostrarHistorial(), 
				new QuitarProductoCarrito(), new VaciarCarrito(), new CambiarPrecio(), new EliminarProductoCatalogo(), 
				new ModificarCantidad(), new SubirProducto(), new VerProductos(), new AgregarOpcion(), 
				new MostrarCuentas(), new BloqueoDeCuenta(), new EliminarOpcion(), new MostrarMenu(), 
				new MostrarMenuDisponible(), new MostrarTodasLasOpciones(), new MostrarUsuario(), new CerrarSesion(), 
				new Salir() }));
	}
	
	//Mostrar todas las opciones disponibles 
	protected static String ImprimirTodasLasOpciones() {
     
		StringBuilder sb = new StringBuilder();

		sb.append("\nA continuación se muestran todas las opciones de menú existentes:\n");
		sb.append("\n" + "|-------------------------Inicio menú--------------------------|" + "\n\n");
		sb.append(MenuDeConsola.prepararMenuImpresion(getTodasLasOpciones()));
		sb.append("\n" + "|--------------------------Fin menú----------------------------|" + "\n");

		return sb.toString();
	}
	
	// Método para comprobar si una entrada de tipo String es numérica (double)
	public static double esDouble(String input) {
		try {
			Double.parseDouble(input);
			return Double.parseDouble(input);

		} catch (NumberFormatException g) {
			return -1;
		}
	}
	
	// Método para comprobar si una entrada de tipo String es numérica (long)
	public static long esLong(String input) {
		try {
			Long.parseLong(input);
			return Long.parseLong(input);

		} catch (NumberFormatException g) {
			return -1;
		}
	}

	// Método para comprobar si una entrada de tipo String es numérica (int)
	public static int esInt(String input) {
		try {
			Integer.parseInt(input);
			return Integer.parseInt(input);

		} catch (NumberFormatException g) {
			return -1;
		}
	}

	// Método para comprobar si una entrada de tipo String es numérica (byte)
	public static byte esByte(String input) {
		try {
			Byte.parseByte(input);
			return Byte.parseByte(input);

		} catch (NumberFormatException g) {
			return -1;
		}
	}
}