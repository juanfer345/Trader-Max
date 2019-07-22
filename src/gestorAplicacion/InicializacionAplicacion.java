/*
	Clase InicializacionAplicacion (p�blica)
	
	Prop�sito: Contiene la rutina principal del programa.
*/
package gestorAplicacion;

import java.io.IOException;
import java.util.HashMap;

import baseDatos.EscrituraBD;
import baseDatos.LecturaBD;
import gestorAplicacion.Materiales.CuentaBancaria;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Vendedor;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.MenuDeConsola;

public class InicializacionAplicacion {

    private static HashMap <Integer, Comprador> BDCompradores = new HashMap <> ();
    private static HashMap <Integer, Vendedor> BDVendedores = new HashMap <> ();
    private static HashMap <Integer, Administrador> BDAdministradores = new HashMap <> ();
    private static HashMap <Integer, CuentaBancaria> BDCuentasBancarias = new HashMap <> ();
    private static HashMap <Integer, Producto> BDProductos = new HashMap <> ();
    private static HashMap <Integer, Resena> BDResenas = new HashMap <> ();
	public static Cuenta usuarioActivo;
    
	public static void main(String[] args) throws IOException {
		
		//Ejecuci�n de la lectura de la base de datos
		LecturaBD.PrincipalLecturaBD("Compradores", "Vendedores", "Administradores", "Cuentas Bancarias", "Cat�logo", "Productos", "Rese�as");
		
		//Mensaje de inicializaci�n
		System.out.println("           TRADER-MAX INC           \n");
		System.out.println("Bienvenido invitado.\n");
		
		//Creaci�n de un usuario visitante
		setUsuarioActivo (new Visitante());
		
		//Ciclo de control para ejecutar el men� hasta que se desee salir de la aplicaci�n
		MenuDeConsola.LanzarMenu();
		
		//Ejecuci�n de la escritura en la base de datos
		EscrituraBD.PrincipalEscrituraBD("Compradores", "Vendedores", "Administradores", "Cuentas Bancarias", "Cat�logo", "Productos", "Rese�as");
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