/*
	Clase InicializacionAplicacion (p�blica)
	
	Prop�sito: Contiene la rutina principal del programa.
*/
package gestorAplicaci�n;

import uiMain.MenuDeConsola;

import java.util.HashMap;

import baseDatos.*;
import gestorAplicaci�n.Materiales.*;
import gestorAplicaci�n.Usuarios.*;

public class InicializacionAplicacion {

	public static void main(String[] args) {

	    HashMap <Integer, Comprador> BDCompradores = new HashMap <> ();
	    HashMap <Integer, Vendedor> BDVendedores = new HashMap <> ();
	    HashMap <Integer, Administrador> BDAdministradores = new HashMap <> ();
	    HashMap <Integer, CuentaBancaria> BDCuentasBancarias = new HashMap <> ();
	    HashMap <Integer, Producto> BDProductos = new HashMap <> ();
	    HashMap <Integer, Rese�a> BDRese�as = new HashMap <> ();
	    
		//Ejecuci�n de la lectura de la base de datos
		LecturaBD.PrincipalLecturaBD("BaseDeDatos");
		
		//Ciclo de control para ejecutar el men� hasta que se desee salir de la aplicaci�n
		while (!MenuDeConsola.SalirApp) {
			//ejecutar men�
		}
		
		//Ejecuci�n de la escritura en la base de datos
		EscrituraBD.PrincipalEscrituraBD("BaseDeDatos", BDCompradores, BDVendedores, BDAdministradores, BDCuentasBancarias, BDProductos, BDRese�as);
		
		//Cerrado de la aplicaci�n (pendiente)
	}

}
