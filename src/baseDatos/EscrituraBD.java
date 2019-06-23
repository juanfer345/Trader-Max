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
import gestorAplicaci�n.Materiales.CarritoDeCompras;
import gestorAplicaci�n.Materiales.CuentaBancaria;
import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Materiales.Rese�a;
import gestorAplicaci�n.Usuarios.Administrador;
import gestorAplicaci�n.Usuarios.Comprador;
import gestorAplicaci�n.Usuarios.Vendedor;

public class EscrituraBD {
	public static void PrincipalEscrituraBD(String BDComp, String BDVend, String BDAdm, String BDCuentBanc, String BDCarr, 
											String BDCat, String BDProd, String BDRes) {
		/*
	  		M�todo PrincipalEscrituraBD (p�blico)
		   	
	   		Prop�sito: Ejecutar el proceso de guardado de todas las bases de datos utilizadas en el programa.
	   		
	   		Variables de Entrada:
	   		
	   		- BDComp: Nombre de la base de datos de los compradores.
	   		- BDVend: Nombre de la base de datos de los vendedores.
	   		- BDAdm: Nombre de la base de datos de los administradores.
	   		- BDCuentBanc: Nombre de la base de datos de las cuentas bancarias.
	   		- BDCarr: Nombre de la base de datos de los carritos de compras.
	   		- BDCat: Nombre de la base de datos del cat�logo.
	   		- BDProd: Nombre de la base de datos de los productos.
	   		- BDRes: Nombre de la base de datos de las rese�as.
	   	*/
		
		//Escritura de las cuentas
		escrituraCompradores(BDComp, InicializacionAplicacion.getBDCompradores());
		escrituraVendedores(BDVend, InicializacionAplicacion.getBDVendedores());
		escrituraAdministradores(BDAdm, InicializacionAplicacion.getBDAdministradores());
		
		//Escritura de las cuentas bancarias
		escrituraCuentasBancarias(BDCuentBanc, InicializacionAplicacion.getBDCuentasBancarias());

		//Escritura de los carritos de compras
		escrituraCarritos(BDCarr, InicializacionAplicacion.getBDCarritos());
		
		//Escritura del cat�logo
		escrituraCatalogo(BDCat, Vendedor.catalogo);
		
		//Escritura de los productos
		escrituraProductos(BDProd, InicializacionAplicacion.getBDProductos());
		
		//Escritura de las rese�as
		escrituraRese�as(BDRes, InicializacionAplicacion.getBDRese�as());
	}
	
	private static void escrituraCompradores(String NombreBD, HashMap <Integer, Comprador> HM) {

		File BD;
		PrintWriter pw = null;
		Comprador val;
        StringBuilder sb = new StringBuilder();
		
		//Creaci�n o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creaci�n de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creaci�n de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignaci�n del objeto que imprime
	        
	        for (Map.Entry <Integer, Comprador> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracci�n de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador �nico de comprador
	            sb.append(val.getNombre() + ';');						//Nombre comprador
	            sb.append(val.getCorreo() + ';');						//Correo comprador
	            sb.append(val.getPassword() + ';');						//Contrase�a comprador
	            sb.append(val.getCedula() + ';');						//C�dula comprador
	            sb.append(val.getCuentaBancaria().getId() + ';');		//Apuntador a cuenta bancaria del comprador
	        	sb.append(val.getCarrito().getId() + ';' + '\n');		//Apuntador a carrito de compras y salto de rengl�n
	        	
	        	//Apuntadores a los productos del historial del comprador
	        	if (!val.getHistorial().isEmpty()){
		    		for (Map.Entry <Integer, Producto> his: val.getHistorial().entrySet()) {
		    			sb.append(his.getValue().getCodigoProducto() + ',');
		    		}
	        	} else {
	        		sb.append("##");
	        	}
    			sb.append(';' + '\n');	//salto de rengl�n
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresi�n de informaci�n en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmaci�n
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}
	
	private static void escrituraVendedores(String NombreBD, HashMap <Integer, Vendedor> HM) {
		
		File BD;
		PrintWriter pw = null;
		Vendedor val;
        StringBuilder sb = new StringBuilder();
		
		//Creaci�n o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creaci�n de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creaci�n de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignaci�n del objeto que imprime
	        
	        for (Map.Entry <Integer, Vendedor> entry : HM.entrySet()) {
	        	val = entry.getValue();										//Extracci�n de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 							//Identificador �nico de vendedor
	            sb.append(val.getNombre() + ';');							//Nombre vendedor
	            sb.append(val.getCorreo() + ';');							//Correo vendedor
	            sb.append(val.getPassword() + ';');							//Contrase�a vendedor
	            sb.append(val.getCedula() + ';');							//C�dula vendedor
	            sb.append(val.getCuentaBancaria().getId() + ';' + '\n');	//Apuntador a cuenta bancaria del vendedor y salto de rengl�n
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresi�n de informaci�n en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmaci�n
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}
	
	private static void escrituraAdministradores(String NombreBD, HashMap <Integer, Administrador> HM) {
		
		File BD;
		PrintWriter pw = null;
		Administrador val;
        StringBuilder sb = new StringBuilder();
		
		//Creaci�n o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creaci�n de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creaci�n de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignaci�n del objeto que imprime
	        
	        for (Map.Entry <Integer, Administrador> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracci�n de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador �nico de administrador
	            sb.append(val.getNombre() + ';');						//Nombre administrador
	            sb.append(val.getCorreo() + ';');						//Correo administrador
	            sb.append(val.getPassword() + ';');						//Contrase�a administrador
	            sb.append(val.getCedula() + '\n');						//C�dula administrador y salto de rengl�n
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresi�n de informaci�n en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmaci�n
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}

	private static void escrituraCuentasBancarias(String NombreBD, HashMap <Integer, CuentaBancaria> HM) {
		
		File BD;
		PrintWriter pw = null;
		CuentaBancaria val;
        StringBuilder sb = new StringBuilder();
		
		//Creaci�n o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creaci�n de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creaci�n de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignaci�n del objeto que imprime
	        
	        for (Map.Entry <Integer, CuentaBancaria> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracci�n de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador �nico de la cuenta bancaria
	            sb.append(val.getPropietario() + ';');					//Titular de la cuenta bancaria
	            sb.append(val.getSaldo()+ ';'+ '\n');					//Saldo de la cuenta bancaria y salto de rengl�n
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresi�n de informaci�n en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmaci�n
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}
	
	private static void escrituraCarritos(String NombreBD, HashMap <Integer, CarritoDeCompras> HM) {
		
		File BD;
		PrintWriter pw = null;
		CarritoDeCompras val;
        StringBuilder sb = new StringBuilder();
		
		//Creaci�n o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creaci�n de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creaci�n de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignaci�n del objeto que imprime
	        
	        for (Map.Entry <Integer, CarritoDeCompras> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracci�n de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador �nico del carrito
	            sb.append(val.getTotalproductos() + ';');				//Total de productos del carrito
	            sb.append(val.getPrecioTotal() + ';' + '\n');			//Precio total de los productos en el carrito y salto de rengl�n
	        	
	        	//Apuntadores a los productos del carrito
	        	if (!val.productos.isEmpty()){
		    		for (int j = 1; j < val.productos.size(); j++) {
		    			sb.append(val.productos.get(j).getCodigoProducto() + ',');
		    		}
	        	} else {
	        		sb.append("##");
	        	}
    			sb.append(';' + '\n');	//salto de rengl�n
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresi�n de informaci�n en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmaci�n
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}
	
	private static void escrituraCatalogo(String NombreBD, HashMap <Integer, Producto> HM) {

		File BD;
		PrintWriter pw = null;
        StringBuilder sb = new StringBuilder();
		
		//Creaci�n o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creaci�n de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creaci�n de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignaci�n del objeto que imprime
	        
	        for (Map.Entry <Integer, Producto> entry : HM.entrySet()) {
	            sb.append(entry.getKey() + ','); 						//Apuntador al producto del cat�logo
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresi�n de informaci�n en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmaci�n
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}
	
	private static void escrituraProductos(String NombreBD, HashMap <Integer, Producto> HM) {
		
		File BD;
		PrintWriter pw = null;
		Producto val;
        StringBuilder sb = new StringBuilder();
		
		//Creaci�n o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creaci�n de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creaci�n de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignaci�n del objeto que imprime
	        
	        for (Map.Entry <Integer, Producto> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracci�n de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador �nico del producto
	            sb.append(val.getNombreProducto() + ';');				//Nombre del producto
	            sb.append(val.getVendedor().getId() + ';');				//Apuntador al vendedor del producto
	            sb.append(val.getPrecio() + ';');						//Precio total del producto
	            sb.append(val.getCategoria() + ';');					//Categor�a del producto
	            sb.append(val.getCantidad()+ ';' + '\n');				//Cantidad del producto y salto de rengl�n
	        	
	        	//Apuntadores a las rese�as del producto
	        	if (!entry.getValue().getRese�as().isEmpty()){
		    		for (Map.Entry <Integer, Rese�a> res: entry.getValue().getRese�as().entrySet()) {
		    			sb.append(res.getValue().getId() + ',');
		    		}
	        	} else {
	        		sb.append("##");
	        	}
		        sb.append("#");				//Indicador de fin de datos
    			sb.append(';' + '\n');	//salto de rengl�n
	        }
	        pw.println(sb);				//Impresi�n de informaci�n en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmaci�n
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}
	
	private static void escrituraRese�as(String NombreBD, HashMap <Integer, Rese�a> HM) {
		
		File BD;
		PrintWriter pw = null;
		Rese�a val;
        StringBuilder sb = new StringBuilder();
		
		//Creaci�n o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creaci�n de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creaci�n de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignaci�n del objeto que imprime
	        
	        for (Map.Entry <Integer, Rese�a> entry : HM.entrySet()) {
	        	val = entry.getValue();							//Extracci�n de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 				//Identificador �nico de la rese�a
	            sb.append(val.getEstrellas() + ';');			//Estrellas de la rese�a
	            sb.append(val.getComentario() + ';' + '\n');	//Comentario de la rese�a y salto de rengl�n
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresi�n de informaci�n en el archivo
            
    		//Cerrado de la base de datos y mensaje de confirmaci�n
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}
}