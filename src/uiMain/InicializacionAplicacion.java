/*
	Clase InicializacionAplicacion (pública)

	Propósito: Contiene la rutina principal del programa.
 */
package uiMain;

import java.io.IOException;
import java.util.HashMap;

import baseDatos.LecturaBD;
import control.MenuDeConsola;
import gestorAplicacion.Materiales.CuentaBancaria;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Vendedor;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.vista.VentanaAplicacion;

public class InicializacionAplicacion {

	private static HashMap <Integer, Comprador> BDCompradores = new HashMap <> ();
	private static HashMap <Integer, Vendedor> BDVendedores = new HashMap <> ();
	private static HashMap <Integer, Administrador> BDAdministradores = new HashMap <> ();
	private static HashMap <Integer, CuentaBancaria> BDCuentasBancarias = new HashMap <> ();
	private static HashMap <Integer, Producto> BDProductos = new HashMap <> ();
	private static HashMap <Integer, Resena> BDResenas = new HashMap <> ();
	public static Cuenta usuarioActivo;

	public static void main(String[] args) throws IOException {

		//Creación de objetos de lectura y escritura
		LecturaBD Lector = new LecturaBD();

		//Creación de un usuario visitante
		setUsuarioActivo (new Visitante());

		//Creación de nueva ventana
		VentanaAplicacion interfaz = new VentanaAplicacion();

		//Ejecución de la lectura de la base de datos
		Lector.PrincipalLecturaBD("Compradores", "Vendedores", "Administradores", "Cuentas Bancarias", "Catálogo", "Productos", "Reseñas");

		// Lanzando el menú
		interfaz.lanzar();

	}

	public static HashMap <Integer, Comprador> getBDCompradores() {return BDCompradores;}
	public static void setBDCompradores(int idComprador, Comprador comp) {BDCompradores.put(idComprador, comp);}
	public static HashMap <Integer, Vendedor> getBDVendedores() {return BDVendedores;}
	public static HashMap <Integer, Administrador> getBDAdministradores() {return BDAdministradores;}
	public static HashMap <Integer, CuentaBancaria> getBDCuentasBancarias() {return BDCuentasBancarias;}
	public static HashMap <Integer, Producto> getBDProductos() {return BDProductos;}
	public static HashMap <Integer, Resena> getBDResenas() {return BDResenas;}

	public static void setUsuarioActivo(Cuenta usuario) {
		usuarioActivo = usuario;
		MenuDeConsola.menuActivo = usuario.getMenu();
	}
}