/*
	Clase EscrituraBD (pública)
	
	Propósito: Realizar toda la escritura de datos necesaria para preservar 
	  		   una base de datos del último estado de la aplicación, guardando
	  		   los datos de los usuarios y los demás objetos respectivos.
*/

package baseDatos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import gestorAplicación.Materiales.*;
import gestorAplicación.Usuarios.*;

public class EscrituraBD {
	
	public static void PrincipalEscrituraBD(String NombreBD, HashMap <Integer, Comprador> BDCompradores, HashMap <Integer, Vendedor> BDVendedores,
										    HashMap <Integer, Administrador> BDAdministradores, HashMap <Integer, CuentaBancaria> BDCuentasBancarias,
										    HashMap <Integer, Producto> BDProductos, HashMap <Integer, Reseña> BDReseñas) {
		/*
	  		Método PrincipalEscrituraBD (público)
		   	
	   		Propósito: Ejecutar el proceso de escritura paso a paso.
	   	*/
		
		File BD;
		PrintWriter pw = null;
		
		//Creación o sobreescritura de la base de datos
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
		// pendiente: verificar que no se está escribiendo algo ya guardado
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