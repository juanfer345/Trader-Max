/*
	Clase InicializacionAplicacion (pública)
	
	Propósito: Contiene la rutina principal del programa.
*/
package gestorAplicación;

import uiMain.MenuDeConsola;

import java.util.HashMap;

import baseDatos.*;
import gestorAplicación.Materiales.*;
import gestorAplicación.Usuarios.*;

public class InicializacionAplicacion {

	public static void main(String[] args) {

	    HashMap <Integer, Comprador> BDCompradores = new HashMap <> ();
	    HashMap <Integer, Vendedor> BDVendedores = new HashMap <> ();
	    HashMap <Integer, Administrador> BDAdministradores = new HashMap <> ();
	    HashMap <Integer, CuentaBancaria> BDCuentasBancarias = new HashMap <> ();
	    HashMap <Integer, Producto> BDProductos = new HashMap <> ();
	    HashMap <Integer, Reseña> BDReseñas = new HashMap <> ();
	    
		//Ejecución de la lectura de la base de datos
		LecturaBD.PrincipalLecturaBD("BaseDeDatos");
		
		//Ciclo de control para ejecutar el menú hasta que se desee salir de la aplicación
		while (!MenuDeConsola.SalirApp) {
			//ejecutar menú
		}
		
		//Ejecución de la escritura en la base de datos
		EscrituraBD.PrincipalEscrituraBD("BaseDeDatos", BDCompradores, BDVendedores, BDAdministradores, BDCuentasBancarias, BDProductos, BDReseñas);
		
		//Cerrado de la aplicación (pendiente)
	}

}
