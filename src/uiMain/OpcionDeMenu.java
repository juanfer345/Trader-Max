package uiMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import uiMain.Funcionalidades.BuscarProducto;
import uiMain.Funcionalidades.MostrarCatalogo;
import uiMain.Funcionalidades.MostrarPorCategoria;
import uiMain.Funcionalidades.Salir;
import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Administrador.AgregarOpcion;
import uiMain.MenuConsola.Cuenta.Administrador.CuentasAdmin;
import uiMain.MenuConsola.Cuenta.Administrador.EliminarCuenta;
import uiMain.MenuConsola.Cuenta.Administrador.EliminarOpcion;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarMenu;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarUsuario;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarACarrito;
import uiMain.MenuConsola.Cuenta.Comprador.AgregarResena;
import uiMain.MenuConsola.Cuenta.Comprador.BorrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.ComprarProducto;
import uiMain.MenuConsola.Cuenta.Comprador.MostrarHistorial;
import uiMain.MenuConsola.Cuenta.Comprador.QuitarProductoCarrito;
import uiMain.MenuConsola.Cuenta.Comprador.VaciarCarrito;
import uiMain.MenuConsola.Cuenta.Vendedor.AumentarCantidad;
import uiMain.MenuConsola.Cuenta.Vendedor.CambiarPrecio;
import uiMain.MenuConsola.Cuenta.Vendedor.EliminarProductoCatalogo;
import uiMain.MenuConsola.Cuenta.Vendedor.SubirProducto;
import uiMain.MenuConsola.Visitante.IniciarSesion;
import uiMain.MenuConsola.Visitante.Registrar;

public abstract class OpcionDeMenu {
	
	public static boolean controlError;
	protected static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    protected static StringBuilder sb = new StringBuilder();
	
	abstract public void ejecutar() throws IOException;

	abstract public String toString();
	
	public static ArrayList<OpcionDeMenu> getTodasLasOpciones(){

		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
					new BuscarProducto(), new MostrarCatalogo(), new MostrarPorCategoria(), 
					new AgregarACarrito(), new AgregarResena(), new BorrarHistorial(), 
					new ComprarProducto(), new MostrarHistorial(), new QuitarProductoCarrito(), 
					new VaciarCarrito(), new AumentarCantidad(), new CambiarPrecio(), 
					new EliminarProductoCatalogo(), new SubirProducto(), 
					new BuscarProducto(), new AgregarOpcion(), new CuentasAdmin(), 
					new EliminarCuenta(), new EliminarOpcion(), new MostrarMenu(), 
					new MostrarUsuario(), new IniciarSesion(), new CerrarSesion(), 
					new Registrar(), new Salir()}));
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

	// Método para comprobar si una entrada de tipo String es numérica
	public static byte esByte(String input) {
		try {
			Byte.parseByte(input);
			return Byte.parseByte(input);

		} catch (NumberFormatException g) {
			return -1;
		}
	}
}