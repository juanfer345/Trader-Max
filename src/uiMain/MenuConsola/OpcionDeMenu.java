/* 
   Clase OpcionDeMenu (p�blica abstracta)
   
   Prop�sito:
   Es la base para todas las opciones de men� existentes
   Tambien contiene algunos metodos para comprobar el tipo de dato ingresado
   
   Estructuras de datos relevantes:
   - ArrayList<OpcionDeMenu>: Contiene a todas las opciones de men� del programa
 */

package uiMain.MenuConsola;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import control.ControlBuscarProducto;
import control.ControlCerrarSesion;
import control.ControlInicioSesion;
import control.ControlMostrarCatalogo;
import control.ControlMostrarPorCategoria;
import control.ControlMostrarResenas;
import control.ControlSalir;
import control.Cuenta.Administrador.ControlAgregarOpcion;
import control.Cuenta.Administrador.ControlBloqueoDeCuenta;
import control.Cuenta.Administrador.ControlEliminarOpcion;
import control.Cuenta.Administrador.ControlMostrarCuentas;
import control.Cuenta.Administrador.ControlMostrarMenu;
import control.Cuenta.Administrador.ControlMostrarMenuDisponible;
import control.Cuenta.Administrador.ControlMostrarTodasLasOpciones;
import control.Cuenta.Administrador.ControlMostrarUsuario;
import control.Cuenta.Comprador.ControlAgregarACarrito;
import control.Cuenta.Comprador.ControlAgregarResena;
import control.Cuenta.Comprador.ControlBorrarHistorial;
import control.Cuenta.Comprador.ControlComprarProductos;
import control.Cuenta.Comprador.ControlMostrarCarrito;
import control.Cuenta.Comprador.ControlMostrarHistorial;
import control.Cuenta.Comprador.ControlQuitarProductoCarrito;
import control.Cuenta.Comprador.ControlVaciarCarrito;
import control.Cuenta.Vendedor.ControlCambiarPrecio;
import control.Cuenta.Vendedor.ControlEliminarProdCatalogo;
import control.Cuenta.Vendedor.ControlModificarCantidad;
import control.Cuenta.Vendedor.ControlSubirProducto;
import control.Cuenta.Vendedor.ControlVerProductos;
import control.Visitante.ControlRegistrar;

public abstract class OpcionDeMenu implements ActionListener {

	//Atributos
	public static boolean controlError;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	protected static StringBuilder sb = new StringBuilder();

	abstract public String toString();

	// Lista de todas las opciones de men�
	public static ArrayList<OpcionDeMenu> getTodasLasOpciones() {
		/*
		   Prop�sito: Crear todas las opciones de men� y meterlas a una ArrayList
		   
		   Par�metros de salida:
		   - ArrayList<OpcionDeMenu>: Con todas las opciones
		 */

		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
				new ControlInicioSesion(), new ControlRegistrar(), new ControlBuscarProducto(), 
				new ControlMostrarCatalogo(), new ControlMostrarPorCategoria(), new ControlMostrarResenas(), 
				new ControlAgregarACarrito(), new ControlAgregarResena(), new ControlBorrarHistorial(), 
				new ControlComprarProductos(), new ControlMostrarCarrito(), new ControlMostrarHistorial(), 
				new ControlQuitarProductoCarrito(), new ControlVaciarCarrito(), new ControlCambiarPrecio(), 
				new ControlEliminarProdCatalogo(), new ControlModificarCantidad(), new ControlSubirProducto(), 
				new ControlVerProductos(), new ControlAgregarOpcion(), new ControlMostrarCuentas(), 
				new ControlBloqueoDeCuenta(), new ControlEliminarOpcion(), new ControlMostrarMenu(), 
				new ControlMostrarMenuDisponible(), new ControlMostrarTodasLasOpciones(), 
				new ControlMostrarUsuario(), new ControlCerrarSesion(), new ControlSalir()}));
	}
	
	//Mostrar todas las opciones disponibles 
	public static String ImprimirTodasLasOpciones() {
     
		StringBuilder sb = new StringBuilder();

		sb.append("\nA continuaci�n se muestran todas las opciones de men� existentes:\n");
		sb.append("\n" + "|-------------------------Inicio men�--------------------------|" + "\n\n");
		sb.append(MenuDeConsola.prepararMenuImpresion(getTodasLasOpciones()));
		sb.append("\n" + "|--------------------------Fin men�----------------------------|" + "\n");

		return sb.toString();
	}
	
	// M�todo para comprobar si una entrada de tipo String es num�rica (double)
	public static double esDouble(String input) {
		try {
			Double.parseDouble(input);
			return Double.parseDouble(input);

		} catch (NumberFormatException g) {
			return -1;
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

	// M�todo para comprobar si una entrada de tipo String es num�rica (byte)
	public static byte esByte(String input) {
		try {
			Byte.parseByte(input);
			return Byte.parseByte(input);

		} catch (NumberFormatException g) {
			return -1;
		}
	}
}