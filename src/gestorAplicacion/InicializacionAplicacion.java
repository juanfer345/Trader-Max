/*
	Clase InicializacionAplicacion (p�blica)
	
	Prop�sito: Contiene la rutina principal del programa.
*/
package gestorAplicacion;

import uiMain.MenuDeConsola;

import java.io.IOException;
import java.util.HashMap;
import baseDatos.*;
import gestorAplicacion.Materiales.*;
import gestorAplicacion.Usuarios.*;

public class InicializacionAplicacion {

    private static HashMap <Integer, Comprador> BDCompradores = new HashMap <> ();
    private static HashMap <Integer, Vendedor> BDVendedores = new HashMap <> ();
    private static HashMap <Integer, Administrador> BDAdministradores = new HashMap <> ();
    private static HashMap <Integer, CuentaBancaria> BDCuentasBancarias = new HashMap <> ();
    private static HashMap <Integer, CarritoDeCompras> BDCarritos = new HashMap <> ();
    private static HashMap <Integer, Producto> BDProductos = new HashMap <> ();
    private static HashMap <Integer, Resena> BDResenas = new HashMap <> ();
	public static Cuenta usuarioActivo;
    
	public static void main(String[] args) throws IOException {
		
		//Aqu� deber�a ir una primera entrada que permita ingresar el nombre de una base de datos para cargar o que indique que no existe (pendiente)
	    
		//Ejecuci�n de la lectura de la base de datos
		System.out.println("LECTURA DE BASE DE DATOS - [INICIO]\n");
		LecturaBD.PrincipalLecturaBD("Compradores", "Vendedores", "Administradores", "Cuentas Bancarias", "Carritos de Compras", "Cat�logo", "Productos", "Rese�as");
		System.out.println("\nLECTURA DE BASE DE DATOS - [FIN]\n");
		
		//Mensaje de inicializaci�n
		System.out.println("           TRADER-MAX INC           \n");
		System.out.println("Bienvenido invitado.\n");
		
		//Creaci�n de un usuario visitante
		usuarioActivo = new Visitante();
		
		//Ciclo de control para ejecutar el men� hasta que se desee salir de la aplicaci�n
		MenuDeConsola.LanzarMenu();
		
		//Ejecuci�n de la escritura en la base de datos
		System.out.println("\nGUARDADO DE BASE DE DATOS - [INICIO]\n");
		EscrituraBD.PrincipalEscrituraBD("Compradores", "Vendedores", "Administradores", "Cuentas Bancarias", "Carritos de Compras", "Cat�logo", "Productos", "Rese�as");
		System.out.println("\nGUARDADO DE BASE DE DATOS - [FIN]\n");
		
		//Cerrado de la aplicaci�n (pendiente)
	}

	public static HashMap <Integer, Comprador> getBDCompradores() {return BDCompradores;}

	public static HashMap <Integer, Vendedor> getBDVendedores() {return BDVendedores;}

	public static HashMap <Integer, Administrador> getBDAdministradores() {return BDAdministradores;}

	public static HashMap <Integer, CuentaBancaria> getBDCuentasBancarias() {return BDCuentasBancarias;}

	public static HashMap <Integer, CarritoDeCompras> getBDCarritos() {return BDCarritos;}

	public static HashMap <Integer, Producto> getBDProductos() {return BDProductos;}

	public static HashMap <Integer, Resena> getBDResenas() {return BDResenas;}
}