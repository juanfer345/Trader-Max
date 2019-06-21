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
import gestorAplicaci�n.InicializacionAplicacion;

import gestorAplicaci�n.Materiales.*;
import gestorAplicaci�n.Usuarios.*;

public class EscrituraBD {
	
	public static void PrincipalEscrituraBD(String NombreBD) {
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
		
		// INTENT� REDUCIR LA CANTIDAD DE M�TODOS USANDO POO PERO NO PUDE (CONSULTAR CON EL MONITOR), Juanfer
		
		//Escritura de las cuentas
		EscrituraCompradores(pw, InicializacionAplicacion.getBDCompradores());
		EscrituraVendedores(pw, InicializacionAplicacion.getBDVendedores());				//En este m�todo se guarda tambi�n el cat�logo
		EscrituraAdministradores(pw, InicializacionAplicacion.getBDAdministradores());
		
		//Escritura de los carritos de compras
		
		//Escritura de las cuentas bancarias
		EscrituraCuentasBancarias(pw, InicializacionAplicacion.getBDCuentasBancarias());
		
		//Escritura de los productos
		EscrituraCarritos(pw, InicializacionAplicacion.getBDCarritos());
		
		//Escritura de los productos
		EscrituraProductos(pw, InicializacionAplicacion.getBDProductos());
		
		//Escritura de las rese�as
		EscrituraRese�as(pw, InicializacionAplicacion.getBDRese�as());
		
		//Cerrado de la base de datos
		pw.close();
	}
	
	private static void EscrituraCompradores(PrintWriter pw, HashMap <Integer, Comprador> HM) {
		
		Comprador val;
		int i, j;
		
		//Escritura de elementos nuevos
		// pendiente: verificar que no se est� escribiendo algo ya guardado
        pw.println("INICIO COMPRADORES\n");
        for (Map.Entry <Integer, Comprador> entry : HM.entrySet()) {
        	val = entry.getValue();
            i = entry.getKey();
            pw.println("COMPRADOR " + i + "\n");
    		pw.println("nombre: " + val.getNombre());
    		pw.println("correo: " + val.getCorreo());
    		pw.println("contrase�a: " + val.getPassword());
    		pw.println("c�dula: " + val.getCedula());
    		pw.println("cuenta bancaria #: " + val.getCuentaBancaria().getId());
    		
            pw.println("HISTORIAL INICIO");
    		for (Map.Entry <Integer, Producto> cat: entry.getValue().getHistorial().entrySet()) {
                pw.println("producto #: " + cat.getValue().codigoProducto);
    		}
    		for (j = 1; j < val.carrito.productos.size(); j++) {
        		pw.println("producto #: " + val.carrito.productos.get(j).codigoProducto);
    		}
            pw.println("HISTORIAL FIN");
            pw.println("COMPRADOR " + i + " FIN" +"\n");
        }
        pw.println("FIN COMPRADORES\n");
		//Pendiente: borrar en el archivo todo lo que no se encuentre en la tabla hash
	}
	
	private static void EscrituraVendedores(PrintWriter pw, HashMap <Integer, Vendedor> HM) {
		
		Vendedor val;
		int i;

        pw.println("INICIO CAT�LOGO\n");
		for (Map.Entry <Integer, Producto> entry : Vendedor.catalogo.entrySet()) {
            pw.println("producto #: " + entry.getValue().codigoProducto);
		}
        pw.println("FIN CAT�LOGO\n");
		
		//Escritura de elementos nuevos
        pw.println("INICIO VENDEDORES\n");
        for (Map.Entry <Integer, Vendedor> entry : HM.entrySet()) {
            val = entry.getValue();
            i = entry.getKey();
            pw.println("VENDEDOR " + i + "\n");
    		pw.println("nombre: " + val.getNombre());
    		pw.println("correo: " + val.getCorreo());
    		pw.println("contrase�a: " + val.getPassword());
    		pw.println("c�dula: " + val.getCedula());
    		pw.println("cuenta bancaria #: " + val.getCuentaBancaria().getId());
            pw.println("VENDEDOR " + i + " FIN" +"\n");
        }
        pw.println("FIN VENDEDORES\n");
	}
	
	private static void EscrituraAdministradores(PrintWriter pw, HashMap<Integer, Administrador> HM) {
		
		Administrador val;
		int i;		
		
        pw.println("INICIO ADMINISTRADORES\n");
        for (Map.Entry <Integer, Administrador> entry : HM.entrySet()) {
            val = entry.getValue();
            i = entry.getKey();
            pw.println("ADMINISTRADOR " + i + "\n");
    		pw.println("nombre: " + val.getNombre());
    		pw.println("correo: " + val.getCorreo());
    		pw.println("contrase�a: " + val.getPassword());
    		pw.println("c�dula: " + val.getCedula());
            pw.println("ADMINISTRADOR " + i + " FIN" +"\n");
        }
        pw.println("FIN ADMINISTRADORES\n");
	}

	private static void EscrituraCuentasBancarias(PrintWriter pw, HashMap<Integer, CuentaBancaria> HM) {
		CuentaBancaria val;
		int i;
		
        pw.println("INICIO CUENTAS BANCARIAS\n");
        for (Map.Entry <Integer, CuentaBancaria> entry : HM.entrySet()) {
            val = entry.getValue();
            i = entry.getKey();
            pw.println("CUENTA BANCARIA " + i + "\n");
    		pw.println("titular: " + val.getPropietario());
    		pw.println("saldo: " + val.getSaldo());
            pw.println("CUENTA BANCARIA " + i + " FIN" +"\n");
        }
        pw.println("FIN CUENTAS BANCARIAS\n");
	}
	
	private static void EscrituraCarritos(PrintWriter pw, HashMap <Integer, CarritoDeCompras> HM) {
		
		CarritoDeCompras val;
		int i, j;
		
        pw.println("INICIO CARRITOS\n");
        for (Map.Entry <Integer, CarritoDeCompras> entry : HM.entrySet()) {
            val = entry.getValue();
            i = entry.getKey();
            pw.println("CARRITO " + i + "\n");
            pw.println("CODIGOS PRODUCTOS\n");
    		for (j = 1; j < val.productos.size(); j++) {
        		pw.println("producto #: " + val.productos.get(j).codigoProducto);
    		}
            pw.println("CODIGOS PRODUCTOS FIN\n");
    		pw.println("total de productos: " + val.getTotalproductos());
    		pw.println("precio total: " + val.getPrecioTotal());
            pw.println("CARRITO " + i + " FIN" +"\n");
        }
        pw.println("FIN CARRITOS\n");
	}
	
	private static void EscrituraProductos(PrintWriter pw, HashMap <Integer, Producto> HM) {
		// TODO Auto-generated method stub
		
	}
	private static void EscrituraRese�as(PrintWriter pw, HashMap <Integer, Rese�a> HM) {
		// TODO Auto-generated method stub
		
	}
}