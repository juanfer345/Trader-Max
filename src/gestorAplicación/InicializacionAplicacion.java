/*
	Clase InicializacionAplicacion (pública)
	
	Propósito: Contiene la rutina principal del programa.
*/
package gestorAplicación;

import uiMain.MenuDeConsola;

import java.io.IOException;
import java.util.HashMap;
import baseDatos.*;
import gestorAplicación.Materiales.*;
import gestorAplicación.Usuarios.*;

public class InicializacionAplicacion {

    private static HashMap <Integer, Comprador> BDCompradores = new HashMap <> ();
    private static HashMap <Integer, Vendedor> BDVendedores = new HashMap <> ();
    private static HashMap <Integer, Administrador> BDAdministradores = new HashMap <> ();
    private static HashMap <Integer, CuentaBancaria> BDCuentasBancarias = new HashMap <> ();
    private static HashMap <Integer, CarritoDeCompras> BDCarritos = new HashMap <> ();
    private static HashMap <Integer, Producto> BDProductos = new HashMap <> ();
    private static HashMap <Integer, Reseña> BDReseñas = new HashMap <> ();
    
	public static void main(String[] args) throws IOException {
		
		
		//Aquí debería ir una primera entrada que permita ingresar el nombre de una base de datos para cargar o que indique que no existe
	    
		//Ejecución de la lectura de la base de datos
		LecturaBD.PrincipalLecturaBD("BaseDeDatos");
		
		//Ciclo de control para ejecutar el menú hasta que se desee salir de la aplicación
		while (!MenuDeConsola.SalirApp) {
			//ejecutar menú
		}
		
		//Ejecución de la escritura en la base de datos
		EscrituraBD.PrincipalEscrituraBD("BaseDeDatos");
		
		//Cerrado de la aplicación (pendiente)
	}

	public static HashMap<Integer, Comprador> getBDCompradores() {
		return BDCompradores;
	}

	public static HashMap<Integer, Vendedor> getBDVendedores() {
		return BDVendedores;
	}

	public static HashMap<Integer, Administrador> getBDAdministradores() {
		return BDAdministradores;
	}

	public static HashMap<Integer, CuentaBancaria> getBDCuentasBancarias() {
		return BDCuentasBancarias;
	}

	public static HashMap<Integer, CarritoDeCompras> getBDCarritos() {
		return BDCarritos;
	}

	public static HashMap<Integer, Producto> getBDProductos() {
		return BDProductos;
	}

	public static HashMap<Integer, Reseña> getBDReseñas() {
		return BDReseñas;
	}
}