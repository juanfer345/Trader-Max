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

import gestorAplicación.InicializacionAplicacion;
import gestorAplicación.Materiales.CarritoDeCompras;
import gestorAplicación.Materiales.CuentaBancaria;
import gestorAplicación.Materiales.Producto;
import gestorAplicación.Materiales.Reseña;
import gestorAplicación.Usuarios.Administrador;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.Vendedor;

public class EscrituraBD {
	public static void PrincipalEscrituraBD(String BDComp, String BDVend, String BDAdm, String BDCuentBanc, String BDCarr, 
											String BDCat, String BDProd, String BDRes) {
		/*
	  		Método PrincipalEscrituraBD (público)
		   	
	   		Propósito: Ejecutar el proceso de guardado de todas las bases de datos utilizadas en el programa.
	   		
	   		Variables de Entrada:
	   		
	   		- BDComp: Nombre de la base de datos de los compradores.
	   		- BDVend: Nombre de la base de datos de los vendedores.
	   		- BDAdm: Nombre de la base de datos de los administradores.
	   		- BDCuentBanc: Nombre de la base de datos de las cuentas bancarias.
	   		- BDCarr: Nombre de la base de datos de los carritos de compras.
	   		- BDCat: Nombre de la base de datos del catálogo.
	   		- BDProd: Nombre de la base de datos de los productos.
	   		- BDRes: Nombre de la base de datos de las reseñas.
	   	*/
		
		//Escritura de las cuentas
		escrituraCompradores(BDComp, InicializacionAplicacion.getBDCompradores());
		escrituraVendedores(BDVend, InicializacionAplicacion.getBDVendedores());
		escrituraAdministradores(BDAdm, InicializacionAplicacion.getBDAdministradores());
		
		//Escritura de las cuentas bancarias
		escrituraCuentasBancarias(BDCuentBanc, InicializacionAplicacion.getBDCuentasBancarias());

		//Escritura de los carritos de compras
		escrituraCarritos(BDCarr, InicializacionAplicacion.getBDCarritos());
		
		//Escritura del catálogo
		escrituraCatalogo(BDCat, Vendedor.catalogo);
		
		//Escritura de los productos
		escrituraProductos(BDProd, InicializacionAplicacion.getBDProductos());
		
		//Escritura de las reseñas
		escrituraReseñas(BDRes, InicializacionAplicacion.getBDReseñas());
	}
	
	private static void escrituraCompradores(String NombreBD, HashMap <Integer, Comprador> HM) {

		File BD;
		PrintWriter pw = null;
		Comprador val;
        StringBuilder sb = new StringBuilder();
		
		//Creación o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creación de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creación de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignación del objeto que imprime
	        
	        for (Map.Entry <Integer, Comprador> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracción de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador único de comprador
	            sb.append(val.getNombre() + ';');						//Nombre comprador
	            sb.append(val.getCorreo() + ';');						//Correo comprador
	            sb.append(val.getPassword() + ';');						//Contraseña comprador
	            sb.append(val.getCedula() + ';');						//Cédula comprador
	            sb.append(val.getCuentaBancaria().getId() + ';');		//Apuntador a cuenta bancaria del comprador
	        	sb.append(val.getCarrito().getId() + ';' + '\n');		//Apuntador a carrito de compras y salto de renglón
	        	
	        	//Apuntadores a los productos del historial del comprador
	        	if (!val.getHistorial().isEmpty()){
		    		for (Map.Entry <Integer, Producto> his: val.getHistorial().entrySet()) {
		    			sb.append(his.getValue().getCodigoProducto() + ',');
		    		}
	        	} else {
	        		sb.append("##");
	        	}
    			sb.append(';' + '\n');	//salto de renglón
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresión de información en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmación
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
		
		//Creación o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creación de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creación de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignación del objeto que imprime
	        
	        for (Map.Entry <Integer, Vendedor> entry : HM.entrySet()) {
	        	val = entry.getValue();										//Extracción de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 							//Identificador único de vendedor
	            sb.append(val.getNombre() + ';');							//Nombre vendedor
	            sb.append(val.getCorreo() + ';');							//Correo vendedor
	            sb.append(val.getPassword() + ';');							//Contraseña vendedor
	            sb.append(val.getCedula() + ';');							//Cédula vendedor
	            sb.append(val.getCuentaBancaria().getId() + ';' + '\n');	//Apuntador a cuenta bancaria del vendedor y salto de renglón
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresión de información en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmación
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
		
		//Creación o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creación de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creación de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignación del objeto que imprime
	        
	        for (Map.Entry <Integer, Administrador> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracción de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador único de administrador
	            sb.append(val.getNombre() + ';');						//Nombre administrador
	            sb.append(val.getCorreo() + ';');						//Correo administrador
	            sb.append(val.getPassword() + ';');						//Contraseña administrador
	            sb.append(val.getCedula() + '\n');						//Cédula administrador y salto de renglón
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresión de información en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmación
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
		
		//Creación o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creación de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creación de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignación del objeto que imprime
	        
	        for (Map.Entry <Integer, CuentaBancaria> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracción de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador único de la cuenta bancaria
	            sb.append(val.getPropietario() + ';');					//Titular de la cuenta bancaria
	            sb.append(val.getSaldo()+ ';'+ '\n');					//Saldo de la cuenta bancaria y salto de renglón
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresión de información en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmación
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
		
		//Creación o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creación de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creación de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignación del objeto que imprime
	        
	        for (Map.Entry <Integer, CarritoDeCompras> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracción de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador único del carrito
	            sb.append(val.getTotalproductos() + ';');				//Total de productos del carrito
	            sb.append(val.getPrecioTotal() + ';' + '\n');			//Precio total de los productos en el carrito y salto de renglón
	        	
	        	//Apuntadores a los productos del carrito
	        	if (!val.productos.isEmpty()){
		    		for (int j = 1; j < val.productos.size(); j++) {
		    			sb.append(val.productos.get(j).getCodigoProducto() + ',');
		    		}
	        	} else {
	        		sb.append("##");
	        	}
    			sb.append(';' + '\n');	//salto de renglón
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresión de información en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmación
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
		
		//Creación o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creación de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creación de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignación del objeto que imprime
	        
	        for (Map.Entry <Integer, Producto> entry : HM.entrySet()) {
	            sb.append(entry.getKey() + ','); 						//Apuntador al producto del catálogo
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresión de información en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmación
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
		
		//Creación o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creación de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creación de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignación del objeto que imprime
	        
	        for (Map.Entry <Integer, Producto> entry : HM.entrySet()) {
	        	val = entry.getValue();									//Extracción de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 						//Identificador único del producto
	            sb.append(val.getNombreProducto() + ';');				//Nombre del producto
	            sb.append(val.getVendedor().getId() + ';');				//Apuntador al vendedor del producto
	            sb.append(val.getPrecio() + ';');						//Precio total del producto
	            sb.append(val.getCategoria() + ';');					//Categoría del producto
	            sb.append(val.getCantidad()+ ';' + '\n');				//Cantidad del producto y salto de renglón
	        	
	        	//Apuntadores a las reseñas del producto
	        	if (!entry.getValue().getReseñas().isEmpty()){
		    		for (Map.Entry <Integer, Reseña> res: entry.getValue().getReseñas().entrySet()) {
		    			sb.append(res.getValue().getId() + ',');
		    		}
	        	} else {
	        		sb.append("##");
	        	}
		        sb.append("#");				//Indicador de fin de datos
    			sb.append(';' + '\n');	//salto de renglón
	        }
	        pw.println(sb);				//Impresión de información en el archivo
	        
    		//Cerrado de la base de datos y mensaje de confirmación
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}
	
	private static void escrituraReseñas(String NombreBD, HashMap <Integer, Reseña> HM) {
		
		File BD;
		PrintWriter pw = null;
		Reseña val;
        StringBuilder sb = new StringBuilder();
		
		//Creación o sobreescritura de la base de datos y control de errores
		try {
			BD = new File(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt");	//Creación de archivo (en java)
			if (BD.exists()) {BD.delete();}		//Borrado de antigua base de datos (si tiene el mismo nombre ingresado)
			BD.createNewFile();					//Creación de archivo (en el computador)
			pw = new PrintWriter(BD);			//Asignación del objeto que imprime
	        
	        for (Map.Entry <Integer, Reseña> entry : HM.entrySet()) {
	        	val = entry.getValue();							//Extracción de valores de la tabla hash
	            sb.append(entry.getKey() + ';'); 				//Identificador único de la reseña
	            sb.append(val.getEstrellas() + ';');			//Estrellas de la reseña
	            sb.append(val.getComentario() + ';' + '\n');	//Comentario de la reseña y salto de renglón
	        }
	        sb.append("#");				//Indicador de fin de datos
	        pw.println(sb);				//Impresión de información en el archivo
            
    		//Cerrado de la base de datos y mensaje de confirmación
    		pw.close(); System.out.println("Base de datos " + NombreBD + ".txt" + "guardada exitosamente");
    		
		} catch (IOException e) {
			//Mensaje de error
			e.printStackTrace();
            System.out.println(e.getMessage() + " Error al intentar guardar la base de datos" + NombreBD + ".txt");
            System.exit(0);
		}
	}
}