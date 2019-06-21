/*
	Clase LecturaBD (p�blica)
	
	Prop�sito: Leer la base de datos seleccionada e inicializar las estructuras
	           de datos correspondientes donde se van a guardar todos los objetos
	           contenidos en ella.
*/
package baseDatos;

import java.io.BufferedReader;
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
		Deque <Integer> auxCarr = new LinkedList <>();
		Deque <Integer> auxCat = new LinkedList <>();
		Deque <Integer> auxProd = new LinkedList <>();
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
		lecturaCompradores(Br, InicializacionAplicacion.getBDCompradores(), auxComp);
		lecturaVendedores(Br, InicializacionAplicacion.getBDVendedores(), auxVend);
		lecturaAdministradores(Br, InicializacionAplicacion.getBDAdministradores());
		
		//Lectura de las cuentas bancarias
		lecturaCuentasBancarias(Br, InicializacionAplicacion.getBDCuentasBancarias());

		//Lectura de los carritos de compras
		lecturaCarritos(Br, InicializacionAplicacion.getBDCarritos(), auxCarr);
		
		//Lectura del cat�logo
		lecturaCatalogo(Br, auxCat);
		
		//Lectura de los productos
		lecturaProductos(Br, InicializacionAplicacion.getBDProductos(), auxProd);
		
		//Lectura de las rese�as
		lecturaRese�as(Br, InicializacionAplicacion.getBDRese�as());
		
		//Asignando los elementos restantes utilizando las colas auxiliares
		complementoLectura(InicializacionAplicacion.getBDCompradores(), InicializacionAplicacion.getBDVendedores(),
				  		   InicializacionAplicacion.getBDAdministradores(), Vendedor.catalogo, 
				  		   InicializacionAplicacion.getBDCuentasBancarias(), InicializacionAplicacion.getBDCarritos(), 
				  		   InicializacionAplicacion.getBDProductos(), InicializacionAplicacion.getBDRese�as(), 
				  		   auxComp, auxVend, auxCarr, auxCat, auxProd);
		
		//Cerrado de la base de datos
		Br.close();
	}

	private static void lecturaCompradores(BufferedReader Br, HashMap <Integer, Comprador> HM, Deque <Integer> aux) throws IOException {
		
		Comprador val;
		
		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n
	    do {
	    	val = new Comprador();
	    	val.setId(Integer.parseInt(Br.readLine().split(" ")[1])); Br.readLine();	//ID
	    	val.setNombre(Br.readLine().split(" ")[1]);									//Nombre
	    	val.setCorreo(Br.readLine().split(" ")[1]);									//Correo
	    	val.setPassword(Br.readLine().split(" ")[1]);								//Contrase�a
	    	val.setCedula(Br.readLine().split(" ")[1]);									//C�dula
	    	aux.add(Integer.parseInt(Br.readLine().split(" ")[3]));						//Apuntador a cuenta bancaria
	    	aux.add(Integer.parseInt(Br.readLine().split(" ")[4]));						//Apuntador a carrito de compras
			while (!Br.readLine().equals("HISTORIAL FIN")) {
				aux.add(Integer.parseInt(Br.readLine().split(" ")[2]));					//Apuntadores a productos del historial
			}
	        HM.put(val.getId(), val);													//Asignaci�n a la estructura de datos correspondiente
	    } while (!Br.readLine().equals("FIN COMPRADORES"));
	}
	
	private static void lecturaVendedores(BufferedReader Br, HashMap <Integer, Vendedor> HM, Deque <Integer> aux) throws IOException {
		
		Vendedor val;

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
	
	private static void lecturaAdministradores(BufferedReader Br, HashMap <Integer, Administrador> HM) throws IOException {

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
	
	private static void lecturaCuentasBancarias(BufferedReader Br, HashMap <Integer, CuentaBancaria> HM) throws NumberFormatException, IOException {
		
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
	
	private static void lecturaCarritos(BufferedReader Br, HashMap <Integer, CarritoDeCompras> HM, Deque <Integer> aux) throws IOException {
		
		CarritoDeCompras val;

		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n
	    do {
	    	val = new CarritoDeCompras();
	    	val.setId(Integer.parseInt(Br.readLine().split(" ")[1])); Br.readLine();
			while (!Br.readLine().equals("CODIGOS PRODUCTOS FIN")) {
				aux.add(Integer.parseInt(Br.readLine().split(" ")[2]));					//Apuntadores a productos del carrito
			}
	    	val.setTotalproductos(Integer.parseInt(Br.readLine().split(" ")[3]));
	    	val.setPrecioTotal(Double.parseDouble(Br.readLine().split(" ")[2]));
	        HM.put(val.getId(), val);
	    } while (!Br.readLine().equals("FIN CARRITOS"));
	}
	
	private static void lecturaCatalogo(BufferedReader Br, Deque <Integer> aux) throws IOException {
		
		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n
	    do {
	    	aux.add(Integer.parseInt(Br.readLine().split(" ")[2]));
	    } while (!Br.readLine().equals("FIN CAT�LOGO"));
	}
	
	private static void lecturaProductos(BufferedReader Br, HashMap <Integer, Producto> HM, Deque <Integer> aux) throws NumberFormatException, IOException {
		
		Producto val;

		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n
	    do {
	    	val = new Producto();
	    	val.setCodigoProducto(Integer.parseInt(Br.readLine().split(" ")[1])); Br.readLine();
	    	val.setNombreProducto(Br.readLine().split(" ")[1]);
	    	val.setPrecio(Double.parseDouble(Br.readLine().split(" ")[1]));
	    	val.setCategoria(Br.readLine().split(" ")[1]);
	    	val.setCantidad(Integer.parseInt(Br.readLine().split(" ")[1]));
			while (!Br.readLine().equals("CODIGOS RESE�AS FIN")) {
				aux.add(Integer.parseInt(Br.readLine().split(" ")[2]));					//Apuntadores a rese�as del producto
			}
	        HM.put(val.getCodigoProducto(), val);
	    } while (!Br.readLine().equals("FIN PRODUCTOS"));
	}
	private static void lecturaRese�as(BufferedReader Br, HashMap <Integer, Rese�a> HM) throws NumberFormatException, IOException {
		
		Rese�a val;

		//Ciclo para saltarse las l�neas en blanco
	    while (!Br.readLine().split(" ")[0].equals("INICIO")) {}
	    
	    //Ciclo para obtener la informaci�n
	    do {
	    	val = new Rese�a();
	    	val.setId(Integer.parseInt(Br.readLine().split(" ")[1])); Br.readLine();
	    	val.setEstrellas(Integer.parseInt(Br.readLine().split(" ")[1]));
	    	val.setComentario(Br.readLine().split(" ")[1]);
	        HM.put(val.getId(), val);
	    } while (!Br.readLine().equals("FIN RESE�AS"));
	}
	
	private static void complementoLectura(HashMap <Integer, Comprador> bdCompradores, HashMap <Integer, Vendedor> bdVendedores, 
										   HashMap <Integer, Administrador> BDAdministradores, HashMap <Integer, Producto> catalogo, 
										   HashMap <Integer, CuentaBancaria> BDCuentasBancarias, HashMap <Integer, CarritoDeCompras> bdCarritos, 
										   HashMap <Integer, Producto> BDProductos, HashMap <Integer, Rese�a> BDRese�as, 
										   Deque <Integer> auxComp, Deque <Integer> auxVend, Deque <Integer> auxCarr, Deque <Integer> auxCat, 
										   Deque <Integer> auxProd) {
		int i, j;
		
		//Completando la informaci�n de los compradores
        for (Map.Entry <Integer, Comprador> entry : bdCompradores.entrySet()) {
            entry.getValue().setCuentaBancaria(BDCuentasBancarias.get(auxComp.poll())); //Asignaci�n de cuenta bancaria
            entry.getValue().setCarrito(bdCarritos.get(auxComp.poll()));				//Asignaci�n de carrito
            
            //Asignaci�n de productos al historial del comprador
            for (i = 0; i < auxComp.size(); i++) {
            	j = auxComp.poll();
            	entry.getValue().getHistorial().put(j, BDProductos.get(j));
            }
        }

		//Completando la informaci�n de los vendedores
        for (Map.Entry <Integer, Vendedor> entry : bdVendedores.entrySet()) {
            entry.getValue().setCuentaBancaria(BDCuentasBancarias.get(auxVend.poll())); //Asignaci�n de cuenta bancaria
        }

		//Completando la informaci�n de los carritos
        for (Map.Entry <Integer, CarritoDeCompras> entry : bdCarritos.entrySet()) {
            //Asignaci�n de productos al carrito
            for (i = 0; i < auxCarr.size(); i++) {
            	entry.getValue().productos.add(BDProductos.get(auxCarr.poll()));
            }
        }
        
		//Completando la informaci�n de los productos
        for (Map.Entry <Integer, Producto> entry : BDProductos.entrySet()) {
            //Asignaci�n de productos al carrito
            for (i = 0; i < auxProd.size(); i++) {
            	j = auxProd.poll();
            	entry.getValue().getRese�as().put(j, BDRese�as.get(j));
            }
        }
	}
}