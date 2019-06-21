/*
	Clase LecturaBD (p�blica)
	
	Prop�sito: Leer la base de datos seleccionada e inicializar las estructuras
	           de datos correspondientes donde se van a guardar todos los objetos
	           contenidos en ella.
*/
package baseDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import gestorAplicaci�n.InicializacionAplicacion;
import gestorAplicaci�n.Materiales.CarritoDeCompras;
import gestorAplicaci�n.Materiales.CuentaBancaria;
import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Materiales.Rese�a;
import gestorAplicaci�n.Usuarios.Administrador;
import gestorAplicaci�n.Usuarios.Comprador;
import gestorAplicaci�n.Usuarios.Vendedor;

public class LecturaBD {
    
	public static void PrincipalLecturaBD(String NombreBD) throws IOException {
		/*
	  		M�todo PrincipalLecturaBD (p�blico)
		   	
	   		Prop�sito: Ejecutar el proceso de lectura paso a paso.
	   	*/

		Deque <Integer> auxComp = new LinkedList <>();
		Deque <Integer> auxVend = new LinkedList <>();
	    BufferedReader Br = null;
		
		//Intento de abrir la base de datos
        try{
            Br = new BufferedReader(new FileReader("/temp" + NombreBD));            
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage() + " Error al leer la base de datos");
            System.exit(0);
        }
		
        //PENDIENTE: CONSIDERAR LOS CASOS EN QUE SE GUARDEN SESIONES VACIAS (P EJ. NO HAY NADA EN EL CAT�LOGO)
        
		//Lectura de las cuentas
		LecturaCompradores(Br, InicializacionAplicacion.getBDCompradores(), auxComp);
		LecturaVendedores(Br, InicializacionAplicacion.getBDVendedores(), auxVend);					//En este m�todo se lee tambi�n el cat�logo
		LecturaAdministradores(Br, InicializacionAplicacion.getBDAdministradores());
		
		//Lectura de los carritos de compras
		
		//Lectura de las cuentas bancarias
		LecturaCuentasBancarias(Br, InicializacionAplicacion.getBDCuentasBancarias());
		
		//Lectura de los productos
		LecturaCarritos(Br, InicializacionAplicacion.getBDCarritos());
		
		//Lectura de los productos
		LecturaProductos(Br, InicializacionAplicacion.getBDProductos());
		
		//Lectura de las rese�as
		LecturaRese�as(Br, InicializacionAplicacion.getBDRese�as());
		
		//Asignando los elementos restantes utilizando las listas auxiliares
		
		//Cerrado de la base de datos
		Br.close();
	}
	
	private static void LecturaCompradores(BufferedReader Br, HashMap <Integer, Comprador> HM, Deque <Integer> aux) throws IOException {
		
		Comprador val;
		
		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n
	    do {
	    	val = new Comprador();
	    	val.setId(Integer.parseInt(Br.readLine().split(" ")[1])); Br.readLine();
	    	val.setNombre(Br.readLine().split(" ")[1]);
	    	val.setCorreo(Br.readLine().split(" ")[1]);
	    	val.setPassword(Br.readLine().split(" ")[1]);
	    	val.setCedula(Br.readLine().split(" ")[1]);
	    	aux.add(Integer.parseInt(Br.readLine().split(" ")[3]));
			while (!Br.readLine().equals("HISTORIAL FIN")) {
				aux.add(Integer.parseInt(Br.readLine().split(" ")[2]));
			}
	        HM.put(val.getId(), val);
	    } while (!Br.readLine().equals("FIN COMPRADORES"));
	}
	
	private static void LecturaVendedores(BufferedReader Br, HashMap <Integer, Vendedor> HM, Deque <Integer> aux) throws IOException {
		
		Vendedor val;

		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n del cat�logo
	    do{
	    	aux.add(Integer.parseInt(Br.readLine().split(" ")[2]));
	    } while (!Br.readLine().equals("FIN CAT�LOGO"));

		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n de los vendedores
	    do {
	    	val = new Vendedor();
	    	val.setId(Integer.parseInt(Br.readLine().split(" ")[1])); Br.readLine();
	    	val.setNombre(Br.readLine().split(" ")[1]);
	    	val.setCorreo(Br.readLine().split(" ")[1]);
	    	val.setPassword(Br.readLine().split(" ")[1]);
	    	val.setCedula(Br.readLine().split(" ")[1]);
	    	aux.add(Integer.parseInt(Br.readLine().split(" ")[3]));
	        HM.put(val.getId(), val);
	    } while (!Br.readLine().equals("FIN VENDEDORES"));
	}
	
	private static void LecturaAdministradores(BufferedReader Br, HashMap <Integer, Administrador> HM) throws IOException {

		Administrador val;
		
		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n
	    do {
	    	val = new Administrador();
	    	val.setId(Integer.parseInt(Br.readLine().split(" ")[1])); Br.readLine();
	    	val.setNombre(Br.readLine().split(" ")[1]);
	    	val.setCorreo(Br.readLine().split(" ")[1]);
	    	val.setPassword(Br.readLine().split(" ")[1]);
	    	val.setCedula(Br.readLine().split(" ")[1]);
	        HM.put(val.getId(), val);
	    } while (!Br.readLine().equals("FIN ADMINISTRADORES"));
	}
	
	private static void LecturaCuentasBancarias(BufferedReader Br, HashMap <Integer, CuentaBancaria> HM) throws NumberFormatException, IOException {
		
		CuentaBancaria val;

		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n
	    do {
	    	val = new CuentaBancaria();
	    	val.setId(Integer.parseInt(Br.readLine().split(" ")[2])); Br.readLine();
	    	val.setPropietario(Br.readLine().split(" ")[1]);
	    	val.setSaldo(Double.parseDouble(Br.readLine().split(" ")[1]));
	        HM.put(val.getId(), val);
	    } while (!Br.readLine().equals("FIN CUENTAS BANCARIAS"));
	}
	
	private static void LecturaCarritos(BufferedReader Br, HashMap <Integer, CarritoDeCompras> HM) {
		
		CarritoDeCompras val;

		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n
	    do {
	    	val = new CarritoDeCompras();
	    	val.setId(Integer.parseInt(Br.readLine().split(" ")[1])); Br.readLine();
	    	val.setPropietario(Br.readLine().split(" ")[1]);
	    	val.setSaldo(Double.parseDouble(Br.readLine().split(" ")[1]));
	        HM.put(val.getId(), val);
	    } while (!Br.readLine().equals("FIN CUENTAS BANCARIAS"));
		
	    Br.println("INICIO CARRITOS\n");
	    for (Map.Entry <Integer, CarritoDeCompras> entry : HM.entrySet()) {
	        val = entry.getValue();
	        i = entry.getKey();
	        Br.println("CARRITO " + i + "\n");
	        Br.println("CODIGOS PRODUCTOS\n");
			for (j = 1; j < val.productos.size(); j++) {
	    		Br.println("producto #: " + val.productos.get(j).codigoProducto);
			}
	        Br.println("CODIGOS PRODUCTOS FIN\n");
			Br.println("total de productos: " + val.getTotalproductos());
			Br.println("precio total: " + val.getPrecioTotal());
	        Br.println("CARRITO " + i + " FIN" +"\n");
	    }
	    Br.println("FIN CARRITOS\n");
	}
	
	private static void LecturaProductos(BufferedReader Br, HashMap <Integer, Producto> HM) {
		
		Producto val;
		int i;
		
	    Br.println("INICIO PRODUCTOS\n");
	    for (Map.Entry <Integer, Producto> entry : HM.entrySet()) {
	        val = entry.getValue();
	        i = entry.getKey();
	        Br.println("PRODUCTO " + i + "\n");
			Br.println("nombre: " + val.getNombreProducto());
			Br.println("vendedor: " + val.getVendedor().getNombre());
			Br.println("precio: " + val.getPrecio());
			Br.println("categoria: " + val.getCategoria());
			Br.println("cantidad: " + val.getCantidad());
	        
	        Br.println("CODIGOS RESE�AS\n");
			for (Map.Entry <Integer, Rese�a> cat: entry.getValue().getRese�as().entrySet()) {
	    		Br.println("rese�a #: " + cat.getValue().getId());
			}
	        Br.println("CODIGOS RESE�AS FIN\n");
	        Br.println("PRODUCTO " + i + " FIN" +"\n");
	    }
	    Br.println("FIN PRODUCTOS\n");
	}
	private static void LecturaRese�as(BufferedReader Br, HashMap <Integer, Rese�a> HM) {
		
		Rese�a val;
		int i;
		
	    Br.println("INICIO RESE�AS\n");
	    for (Map.Entry <Integer, Rese�a> entry : HM.entrySet()) {
	        val = entry.getValue();
	        i = entry.getKey();
	        Br.println("RESE�A " + i + "\n");
			Br.println("estrellas: " + val.getEstrellas());
			Br.println("comentario: " + val.getComentario());
	        Br.println("RESE�A " + i + " FIN" +"\n");
	    }
	    Br.println("FIN RESE�AS\n");	
	}
}