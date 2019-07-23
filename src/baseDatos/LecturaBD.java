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

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.CuentaBancaria;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Vendedor;

public class LecturaBD {

    private static BufferedReader br = null;
    private static String BDactual;
    private static int maxID = 0;
    private static boolean cnConfirmacion = false;
    
	public static void PrincipalLecturaBD(String BDComp, String BDVend, String BDAdm, String BDCuentBanc, String BDCat, 
										  String BDProd, String BDRes) {
		/*
	  		M�todo PrincipalLecturaBD (p�blico)
		   	
	   		Prop�sito: Ejecutar el proceso de lectura de todas las bases de datos utilizadas en el programa.
	   		
	   		Variables de Entrada:
	   		
	   		- BDComp: Nombre de la base de datos de los compradores.
	   		- BDVend: Nombre de la base de datos de los vendedores.
	   		- BDAdm: Nombre de la base de datos de los administradores.
	   		- BDCuentBanc: Nombre de la base de datos de las cuentas bancarias.
	   		- BDCat: Nombre de la base de datos del cat�logo.
	   		- BDProd: Nombre de la base de datos de los productos.
	   		- BDRes: Nombre de la base de datos de las rese�as.
	   	*/
		HashMap <Integer, Deque <Integer>> auxComp = new HashMap<>();
		Deque <Integer> cnProdComp = new LinkedList <>();
		HashMap <Integer, Deque <Integer>> auxVend = new HashMap<>();
		HashMap <Integer, Deque <Integer>> auxAdmi = new HashMap<>();
		Deque <Integer> auxCat = new LinkedList<>();
		HashMap <Integer, Deque <Integer>> auxProd = new HashMap<>();
		HashMap <Integer, Integer> auxRes = new HashMap<>();

		if (cnConfirmacion) System.out.println("LECTURA DE BASE DE DATOS - [INICIO]\n");
        
        try {
    		// Lectura de las cuentas
        	lecturaCompradores(BDComp, InicializacionAplicacion.getBDCompradores(), auxComp, cnProdComp);
    		lecturaVendedores(BDVend, InicializacionAplicacion.getBDVendedores(), auxVend);
    		lecturaAdministradores(BDAdm, InicializacionAplicacion.getBDAdministradores(), auxAdmi);
    		
    		// Lectura de las cuentas bancarias
    		lecturaCuentasBancarias(BDCuentBanc, InicializacionAplicacion.getBDCuentasBancarias());
    		
    		//Lectura del cat�logo
    		lecturaCatalogo(BDCat, auxCat);
    		
    		// Lectura de los productos
    		lecturaProductos(BDProd, InicializacionAplicacion.getBDProductos(), auxProd);
    		
    		// Lectura de las rese�as
    		lecturaResenas(BDRes, InicializacionAplicacion.getBDResenas(), auxRes);
        }
        catch (FileNotFoundException ex){
        	mensajeError(ex, "Base de datos \"" + BDactual + ".txt\" no encontrada");
        }
        catch (IOException ex) {
        	mensajeError(ex, "No fue posible leer la base de datos \"" + BDactual + ".txt\"");
        }
        finally {
        	try {
        		br.close();
        	}
        	catch (IOException ex) {
            	mensajeError(ex, "No fue posible cerrar (lectura) la base de datos \"" + BDactual + ".txt\"");
        	}
        }
        
		// Asignando los elementos restantes utilizando las colas auxiliares
		complementoLectura(InicializacionAplicacion.getBDCompradores(), InicializacionAplicacion.getBDVendedores(),
				  		   InicializacionAplicacion.getBDAdministradores(), Cuenta.getCatalogo(), 
				  		   InicializacionAplicacion.getBDCuentasBancarias(), InicializacionAplicacion.getBDProductos(), 
				  		   InicializacionAplicacion.getBDResenas(), auxComp, cnProdComp,  auxVend, auxAdmi, auxCat, 
				  		   auxProd, auxRes);

		if (cnConfirmacion) System.out.println("\nLECTURA DE BASE DE DATOS - [FIN]\n");
	}
	
	private static void lecturaCompradores(String NombreBD, HashMap <Integer, Comprador> HM, HashMap <Integer, Deque <Integer>> mapAux, Deque <Integer> colaAuxProd) throws IOException {
		
		Deque <Integer> colaAux;
		Comprador usuario;
	    String [] dat;
	    
	    BDactual = NombreBD;	// Asignaci�n de nombre de base de datos para control de error
	    
		// Apertura de la base de datos
        br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" + NombreBD + ".txt"));

	    // Ciclo para obtener la informaci�n
        while (!(dat = br.readLine().split(";"))[0].equals("#")) {

    		// Ejemplo de datos: ID;Nombre;Correo;Contrase�a;Cedula;IDCuentaBancaria;Avtivo;(IDprodhist1,Cantprodhist1),...,(IDprodhistN,CantprodhistN);IDopmen1,...,IDopmenN
        	
        	// Creaci�n del Comprador
        	usuario = new Comprador(Integer.parseInt(dat[0]), dat[1], dat[2], dat[3], Integer.parseInt(dat[4]), Boolean.parseBoolean(dat[5]));
        	
        	if (Boolean.parseBoolean(dat[5])) {Cuenta.setTotalCuentasActivas(1);}	//Sumando al total de cuentas activas
        	
	        colaAux = new LinkedList<>();               //Creaci�n de cola auxiliar para guardar referencias
        	colaAux.add(Integer.parseInt(dat[6]));		//Referencia a la cuenta bancaria
        	subDatos(dat[7], colaAux);					//Referencias a los productos del historial
        	
        	// Condicional para guardar la condici�n de que se tienen productos en el historial
        	if (colaAux.size() > 1) {
            	colaAuxProd.add(colaAux.size() - 1);
        	} else {
            	colaAuxProd.add(0);
        	}
        	subDatos(dat[8], colaAux);		//Referencias a las opciones de men�
	    	
	        HM.put(usuario.getId(), usuario);			//Asignaci�n del comprador a la estructura de datos correspondiente
	        mapAux.put(usuario.getId(), colaAux);		//Guardado de las referencias en el mapa auxiliar
	        if (Integer.parseInt(dat[0]) > maxID) maxID = Integer.parseInt(dat[0]);
	    }
        if (cnConfirmacion) mensajeConfirmacion(!HM.isEmpty(), NombreBD); 	//Mensaje de confirmaci�n
	}
	
	private static void lecturaVendedores(String NombreBD, HashMap <Integer, Vendedor> HM, HashMap <Integer, Deque <Integer>> mapAux) throws IOException {

		Deque <Integer> colaAux;
		Vendedor usuario;
	    String [] dat;

	    BDactual = NombreBD;	// Asignaci�n de nombre de base de datos para control de error

		// Apertura de la base de datos
        br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" + NombreBD + ".txt"));

	    // Ciclo para obtener la informaci�n
        while (!(dat = br.readLine().split(";"))[0].equals("#")) {
        	
    		// Ejemplo de datos: ID;Nombre;Correo;Contrase�a;Cedula;IDCuentaBancaria;Activo;IDopmen1,...,IDopmenN
        	
        	// Creaci�n del vendedor
	    	usuario = new Vendedor(Integer.parseInt(dat[0]), dat[1], dat[2], dat[3], Integer.parseInt(dat[4]), Boolean.parseBoolean(dat[5]));

        	if (Boolean.parseBoolean(dat[5])) {Cuenta.setTotalCuentasActivas(1);}	//Sumando al total de cuentas activas
        	
	        colaAux = new LinkedList<>();               //Creaci�n de cola auxiliar para guardar referencias
	    	colaAux.add(Integer.parseInt(dat[6]));		//Referencia a la cuenta bancaria
        	subDatos(dat[7], colaAux);					//Referencias a las opciones de men�
        	
    		HM.put(usuario.getId(), usuario);			//Asignaci�n del vendedor a la estructura de datos correspondiente
	        mapAux.put(usuario.getId(), colaAux);		//Guardado de las referencias en el mapa auxiliar
	        if (Integer.parseInt(dat[0]) > maxID) maxID = Integer.parseInt(dat[0]);
	    }
        if (cnConfirmacion) mensajeConfirmacion(!HM.isEmpty(), NombreBD); 	//Mensaje de confirmaci�n
	}
	
	private static void lecturaAdministradores(String NombreBD, HashMap <Integer, Administrador> HM, HashMap <Integer, Deque <Integer>> mapAux) throws IOException {

		Deque <Integer> colaAux;
		Administrador usuario;
	    String [] dat;
	    
	    BDactual = NombreBD;	// Asignaci�n de nombre de base de datos para control de error
	    
		// Apertura de la base de datos
        br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" + NombreBD + ".txt"));
        
	    // Ciclo para obtener la informaci�n
        while (!(dat = br.readLine().split(";"))[0].equals("#")) {
        	
    		// Ejemplo de datos: ID;Nombre;Correo;Contrase�a;Cedula;Activo;IDopmen1,...,IDopmenN

        	//Creaci�n del administrador
	    	usuario = new Administrador(Integer.parseInt(dat[0]), dat[1], dat[2], dat[3], Integer.parseInt(dat[4]), Boolean.parseBoolean(dat[5]));

        	if (Boolean.parseBoolean(dat[5])) {Cuenta.setTotalCuentasActivas(1);}	//Sumando al total de cuentas activas
        	
	        colaAux = new LinkedList<>();               //Creaci�n de cola auxiliar para guardar referencias
        	subDatos(dat[6], colaAux);					//Referencias a las opciones de men�
	    	HM.put(usuario.getId(), usuario);			//Asignaci�n del administrador a la estructura de datos correspondiente
	        mapAux.put(usuario.getId(), colaAux);		//Guardado de las referencias en el mapa auxiliar
	        if (Integer.parseInt(dat[0]) > maxID) maxID = Integer.parseInt(dat[0]);
	    }
        Cuenta.setMaxID(maxID); maxID = 0;				//Asignaci�n de ID para las cuentas
        if (cnConfirmacion) mensajeConfirmacion(!HM.isEmpty(), NombreBD); 	//Mensaje de confirmaci�n
	}
	
	private static void lecturaCuentasBancarias(String NombreBD, HashMap <Integer, CuentaBancaria> HM) throws NumberFormatException, IOException {
		
		CuentaBancaria cuenta;
	    String [] dat;

	    BDactual = NombreBD;	//Asignaci�n de nombre de base de datos para control de erro

		// Apertura de la base de datos
        br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" + NombreBD + ".txt"));
        
	    // Ciclo para obtener la informaci�n
        while (!(dat = br.readLine().split(";"))[0].equals("#")) {
        	
    		// Ejemplo de datos: ID;Saldo
        	
        	// Creaci�n de una nueva cuenta bancaria
        	cuenta = new CuentaBancaria(Integer.parseInt(dat[0]), Double.parseDouble(dat[1]));
	    	HM.put(cuenta.getId(), cuenta);			//Asignaci�n de la cuenta bancaria a la estructura de datos correspondiente
	        if (Integer.parseInt(dat[0]) > maxID) maxID = Integer.parseInt(dat[0]);
	    }
        CuentaBancaria.setMaxID(maxID); maxID = 0;							//Asignaci�n de ID para las cuentas bancarias
        if (cnConfirmacion) mensajeConfirmacion(!HM.isEmpty(), NombreBD); 	//Mensaje de confirmaci�n
	}

	private static void lecturaCatalogo(String NombreBD, Deque <Integer> colaAux) throws IOException {

	    String dat;

	    BDactual = NombreBD;	//Asignaci�n de nombre de base de datos para control de error

		//Apertura de la base de datos
        br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" + NombreBD + ".txt"));
        
	    // Ciclo para obtener la informaci�n
        while (!(dat = br.readLine()).equals("#")) {
    		// Ejemplo de datos: IDProducto (por cada fila)
        	colaAux.add(Integer.parseInt(dat));	//Referencias a los productos del cat�logo
	    }
        if (cnConfirmacion) mensajeConfirmacion(!colaAux.isEmpty(), NombreBD); 	//Mensaje de confirmaci�n
	}
	
	private static void lecturaProductos(String NombreBD, HashMap <Integer, Producto> HM, HashMap <Integer, Deque <Integer>> mapAux) throws NumberFormatException, IOException {

		Deque <Integer> colaAux;
		Producto prod;
	    String [] dat;
	    
	    BDactual = NombreBD;	//Asignaci�n de nombre de base de datos para control de error
	    
		// Apertura de la base de datos
        br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" + NombreBD + ".txt"));
        
	    // Ciclo para obtener la informaci�n
        while (!(dat = br.readLine().split(";"))[0].equals("#")) {
        	
    		// Ejemplo de datos: ID;Nombre;Categoria;Precio;Cantidad;IDVendedor;IDresprod1,...,IDresprodN
        	
        	// Creaci�n del producto
	    	prod = new Producto(Integer.parseInt(dat[0]), dat[1], dat[2], Double.parseDouble(dat[3]), Integer.parseInt(dat[4]));
	    	
	        colaAux = new LinkedList<>();               //Creaci�n de cola auxiliar para guardar referencias
	    	colaAux.add(Integer.parseInt(dat[5]));		//Referencia al vendedor del producto
        	subDatos(dat[6], colaAux);					//Referencia a las rese�as del producto
        	
	        HM.put(prod.getId(), prod);					//Asignaci�n del producto a la estructura de datos correspondiente
	        mapAux.put(prod.getId(), colaAux);			//Guardado de las referencias en el mapa auxiliar
	        if (Integer.parseInt(dat[0]) > maxID) maxID = Integer.parseInt(dat[0]);
	    }
        Producto.setMaxID(maxID); maxID = 0;								//Asignaci�n de ID para los productos
        if (cnConfirmacion) mensajeConfirmacion(!HM.isEmpty(), NombreBD); 	//Mensaje de confirmaci�n
	}
	
	private static void lecturaResenas(String NombreBD, HashMap <Integer, Resena> HM, HashMap <Integer, Integer> mapAux) throws NumberFormatException, IOException {
		
		Resena res;
	    String [] dat;

	    BDactual = NombreBD;	// Asignaci�n de nombre de base de datos para control de error

		// Apertura de la base de datos
        br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" + NombreBD + ".txt"));
        
	    // Ciclo para obtener la informaci�n
        while (!(dat = br.readLine().split(";"))[0].equals("#")) {

    		// Ejemplo de datos: ID;Comentario;Estrellas;IDcomprador
        	
        	// Creaci�n de la rese�a
	    	res = new Resena(Integer.parseInt(dat[0]), dat[1], Integer.parseInt(dat[2]));
	    	
	    	mapAux.put(res.getId(), Integer.parseInt(dat[3]));	//Referencia al usuario comprador, autor de la rese�a
	        HM.put(res.getId(), res);							//Asignaci�n de la rese�a a la estructura de datos correspondiente
	        if (Integer.parseInt(dat[0]) > maxID) maxID = Integer.parseInt(dat[0]);
	    }
        Resena.setMaxID(maxID); maxID = 0;									//Asignaci�n de ID para las rese�as
        if (cnConfirmacion) mensajeConfirmacion(!HM.isEmpty(), NombreBD); 	//Mensaje de confirmaci�n
	}
	
	private static void complementoLectura(HashMap <Integer, Comprador> BDCompradores, HashMap <Integer, Vendedor> BDVendedores, 
										   HashMap <Integer, Administrador> BDAdministradores, HashMap <Integer, Producto> catalogo, 
										   HashMap <Integer, CuentaBancaria> BDCuentasBancarias, HashMap <Integer, Producto> BDProductos, 
										   HashMap <Integer, Resena> BDResenas, HashMap<Integer, Deque<Integer>> auxComp, 
										   Deque<Integer> cnProdComp, HashMap<Integer, Deque<Integer>> auxVend, 
										   HashMap<Integer, Deque<Integer>> auxAdmi, Deque <Integer> auxCat, HashMap<Integer, 
										   Deque<Integer>> auxProd, HashMap<Integer, Integer> auxRes) {
		
		int i, j, n, aux;
		
		// Asignando el total de las cuentas
		Cuenta.setTotalCuentas(BDCompradores.size() + BDVendedores.size() + BDAdministradores.size());
		
		// Completando la informaci�n de los compradores
        for (Map.Entry <Integer, Comprador> entry : BDCompradores.entrySet()) {
         	// Asignaci�n de cuenta bancaria a comprador y viceversa
        	aux = auxComp.get(entry.getKey()).poll();
            entry.getValue().setCuentaBancaria(BDCuentasBancarias.get(aux));
            BDCuentasBancarias.get(aux).setPropietario(entry.getValue());
            
            // Asignaci�n de productos al historial del comprador
            if ((n = cnProdComp.poll()) > 0) {
                for (i = 0; i < n / 2; i++) {
                	entry.getValue().getHistorial().put((auxComp.get(entry.getKey())).poll(), (auxComp.get(entry.getKey())).poll());
                }
            }
            
            // Asignaci�n de las opciones de men�
            if (!(auxComp.get(entry.getKey())).isEmpty()) {
            	entry.getValue().setMenu(auxComp.get(entry.getKey()));
            }
        }

		// Completando la informaci�n de los vendedores
        for (Map.Entry <Integer, Vendedor> entry : BDVendedores.entrySet()) {
        	//Asignaci�n de cuenta bancaria al vendedor y viceversa
        	aux = auxVend.get(entry.getKey()).poll();
            entry.getValue().setCuentaBancaria(BDCuentasBancarias.get(aux));
            BDCuentasBancarias.get(aux).setPropietario(entry.getValue());
            
            // Asignaci�n de las opciones de men�
            if (!(auxVend.get(entry.getKey())).isEmpty()) {
            	entry.getValue().setMenu(auxVend.get(entry.getKey()));
            }
        }
        
        // Completando la informaci�n de los administradores
        for (Map.Entry <Integer, Administrador> entry : BDAdministradores.entrySet()) {
            // Asignaci�n de las opciones de men�
            if (!(auxAdmi.get(entry.getKey())).isEmpty()) {
            	entry.getValue().setMenu(auxAdmi.get(entry.getKey()));
            }
        }
        
        // Completando la informaci�n del cat�logo
        while (!auxCat.isEmpty()) {
        	j = auxCat.poll();
        	catalogo.put(j, BDProductos.get(j));
        }
        
		// Completando la informaci�n de los productos
        for (Map.Entry <Integer, Producto> entry : BDProductos.entrySet()) {
        	entry.getValue().setVendedor(BDVendedores.get((auxProd.get(entry.getKey()).poll())));	//Asignaci�n del vendedor
        	entry.getValue().getVendedor().setTotalDeProductosSubidos(1);
        	entry.getValue().setResenas(auxProd.get(entry.getKey()));								//Asignaci�n de rese�as al producto
        }
        
        // Completando la informaci�n de las rese�as
        for (Map.Entry <Integer, Resena> entry : BDResenas.entrySet()) {
        	entry.getValue().setComprador(BDCompradores.get((auxRes.get(entry.getKey()))));
        }
	}
	
	private static Deque <Integer> subDatos (String dat, Deque <Integer> colaAux){
		
		String subDat[];
		
		// Condicional para el caso donde no existen elementos en el subconjunto de datos
		if (!dat.equals("#")) {
			subDat = dat.split(",");
	    	for (int i = 0; i < subDat.length; i++) {
	    		colaAux.add(Integer.parseInt(subDat[i]));	//Asignaci�n de referencias
	    	}
		}
		return colaAux;
	}
	
	private static void mensajeConfirmacion(boolean BDvacia, String NombreBD) {
        if (BDvacia) {
        	// Caso A: La base de datos se carg� correctamente
        	System.out.println("Base de datos \"" + NombreBD + ".txt\"" + " cargada exitosamente");
        	
        } else {
        	// Caso B: La base de datos se encontraba vac�a
        	System.out.println("Advertencia: la base de datos \"" + NombreBD + ".txt\"" + " se encuentra vac�a");
        }
	}
	
	private static void mensajeError(Exception ex, String mensaje) {
        System.err.println(ex.getMessage() + '\n' + mensaje);
        System.exit(0);
	}
}