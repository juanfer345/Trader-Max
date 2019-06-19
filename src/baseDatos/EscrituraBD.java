/*
	Clase EscrituraBD (p�blica)
	
	Prop�sito: Realizar toda la escritura de datos necesaria para preservar 
	  		   una base de datos del �ltimo estado de la aplicaci�n, guardando
	  		   los datos de los usuarios y los dem�s objetos respectivos.
*/

package baseDatos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import gestorAplicaci�n.Materiales.*;
import gestorAplicaci�n.Usuarios.*;

public class EscrituraBD {
	
	public static void PrincipalEscrituraBD(String NombreBD, HashMap <Integer, Comprador> BDCompradores, HashMap <Integer, Vendedor> BDVendedores,
										    HashMap <Integer, Administrador> BDAdministradores, HashMap <Integer, CuentaBancaria> BDCuentasBancarias,
										    HashMap <Integer, Producto> BDProductos, HashMap <Integer, Rese�a> BDRese�as) {
		/*
	  		M�todo PrincipalEscrituraBD (p�blico)
		   	
	   		Prop�sito: Ejecutar el proceso de escritura paso a paso.
	   	*/
		
		File BD;
		PrintWriter pw = null;
		
		//Creaci�n o sobreescritura de la base de datos
		try {
			BD = new File("/temp" + NombreBD);
			if (!BD.exists()) {BD.createNewFile();}
			pw = new PrintWriter(BD);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Escritura de los objetos tipo cuenta
		EscrituraCompradores(pw, BDCompradores);
		
		//Cerrado de archivo de base de datos
		pw.close();
	}
	
	private static void EscrituraCompradores(PrintWriter pw, HashMap <Integer, Comprador> HM) {
		
		//Escritura de elementos nuevos
		// pendiente: verificar que no se est� escribiendo algo ya guardado
        for (Map.Entry <Integer, Comprador> entry : HM.entrySet()) {
            Comprador comp = entry.getValue();
    		pw.println(comp.getCedula());
    		pw.println(comp.getCorreo());
    		pw.println(comp.getId());
    		pw.println(comp.getNombre());
    		pw.println(comp.getPassword());
        }
		
		//Pendiente: borrar en el archivo todo lo que no se encuentre en la tabla hash
		
	}
	
}