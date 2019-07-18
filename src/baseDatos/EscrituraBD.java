/*
	Clase EscrituraBD (p�blica)

	Prop�sito: Realizar toda la escritura de datos necesaria para preservar 
	  		   una base de datos del �ltimo estado de la aplicaci�n, guardando
	  		   los datos de los usuarios y los dem�s objetos respectivos.
 */

package baseDatos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.CuentaBancaria;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class EscrituraBD {

	static BufferedWriter bw = null;
	static StringBuilder sb = new StringBuilder();
	static String BDactual;

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

		try {
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
			escrituraResenas(BDRes, InicializacionAplicacion.getBDResenas());

		} catch (IOException ex) {
			mensajeError(ex, "Error al intentar guardar la base de datos \"" + BDactual + ".txt\"");
		}
        finally {
        	try {
        		bw.close();
        	}
        	catch (IOException ex) {
            	mensajeError(ex, "No fue posible cerrar (escritura) la base de datos \"" + BDactual + ".txt\"");
        	}
        }
	}

	private static void escrituraCompradores(String NombreBD, HashMap <Integer, Comprador> HM) throws IOException {

		Comprador val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Comprador> entry : HM.entrySet()) {
			val = entry.getValue();								//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey() + ';'); 					//Identificador �nico
			sb.append(val.getNombre() + ';');					//Nombre
			sb.append(val.getCorreo() + ';');					//Correo
			sb.append(val.getPassword() + ';');					//Contrase�a
			sb.append(val.getCedula() + ';');					//C�dula
			sb.append(val.getCuentaBancaria().getId() + ';');	//Referencia a la cuenta bancaria
			sb.append(val.getCarrito().getId() + ';');			//Referencia a carrito de compras y salto de rengl�n

			//Referencias a los productos del historial
			if (!val.getHistorial().isEmpty()){
				for (Map.Entry <Integer, Producto> his: val.getHistorial().entrySet()) {
					sb.append(his.getValue().getId() + ',');
				}
			} else {sb.append("#");}
			sb.append(';');
			
			//Referencias a las opciones de menu
			if (!val.getMenu().isEmpty()){
				ArrayList <OpcionDeMenu> menuTotal = OpcionDeMenu.getTodasLasOpciones();
				ArrayList <OpcionDeMenu> menu = val.getMenu();
				for (OpcionDeMenu opcion: menu) {
					if (menuTotal.contains(opcion)) {
						sb.append(menuTotal.indexOf(opcion));
					}
				}
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		bw.write(sb.toString());	//Impresi�n de informaci�n en el archivo
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Mensaje de confirmaci�n
		System.out.println("Base de datos \"" + NombreBD + ".txt" + "\" guardada exitosamente");
	}

	private static void escrituraVendedores(String NombreBD, HashMap <Integer, Vendedor> HM) throws IOException {

		Vendedor val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Vendedor> entry : HM.entrySet()) {
			val = entry.getValue();									//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey() + ';'); 						//Identificador �nico
			sb.append(val.getNombre() + ';');						//Nombre
			sb.append(val.getCorreo() + ';');						//Correo
			sb.append(val.getPassword() + ';');						//Contrase�a
			sb.append(val.getCedula() + ';');						//C�dula
			sb.append(val.getCuentaBancaria().getId() + ';');		//Referencia a la cuenta bancaria
			
			//Referencias a las opciones de menu
			if (!val.getMenu().isEmpty()){
				ArrayList <OpcionDeMenu> menuTotal = OpcionDeMenu.getTodasLasOpciones();
				ArrayList <OpcionDeMenu> menu = val.getMenu();
				for (OpcionDeMenu opcion: menu) {
					if (menuTotal.contains(opcion)) {
						sb.append(menuTotal.indexOf(opcion));
					}
				}
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		bw.write(sb.toString());	//Impresi�n de informaci�n en el archivo
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Mensaje de confirmaci�n
		System.out.println("Base de datos \"" + NombreBD + ".txt" + "\" guardada exitosamente");
	}

	private static void escrituraAdministradores(String NombreBD, HashMap <Integer, Administrador> HM) throws IOException {

		Administrador val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Administrador> entry : HM.entrySet()) {
			val = entry.getValue();						//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey() + ';'); 			//Identificador �nico
			sb.append(val.getNombre() + ';');			//Nombre
			sb.append(val.getCorreo() + ';');			//Correo
			sb.append(val.getPassword() + ';');			//Contrase�a
			sb.append(val.getCedula());					//C�dula
			
			//Referencias a las opciones de menu
			if (!val.getMenu().isEmpty()){
				ArrayList <OpcionDeMenu> menuTotal = OpcionDeMenu.getTodasLasOpciones();
				ArrayList <OpcionDeMenu> menu = val.getMenu();
				for (OpcionDeMenu opcion: menu) {
					if (menuTotal.contains(opcion)) {
						sb.append(menuTotal.indexOf(opcion));
					}
				}
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		bw.write(sb.toString());	//Impresi�n de informaci�n en el archivo
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Mensaje de confirmaci�n
		System.out.println("Base de datos \"" + NombreBD + ".txt" + "\" guardada exitosamente");
	}

	private static void escrituraCuentasBancarias(String NombreBD, HashMap <Integer, CuentaBancaria> HM) throws IOException {

		CuentaBancaria val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, CuentaBancaria> entry : HM.entrySet()) {
			val = entry.getValue();									//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey() + ';'); 						//Identificador �nico
			sb.append(val.getSaldo()+ ';'+ '\n');					//Saldo de la cuenta bancaria y salto de rengl�n
		}
		bw.write(sb.toString());	//Impresi�n de informaci�n en el archivo
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Mensaje de confirmaci�n
		System.out.println("Base de datos \"" + NombreBD + ".txt" + "\" guardada exitosamente");
	}

	private static void escrituraCarritos(String NombreBD, HashMap <Integer, CarritoDeCompras> HM) throws IOException {

		CarritoDeCompras val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, CarritoDeCompras> entry : HM.entrySet()) {
			val = entry.getValue();							//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey() + ';'); 				//Identificador �nico
			sb.append(val.getTotalproductos() + ';');		//Total de productos
			sb.append(val.getPrecioTotal() + ';');			//Precio total de los productos en el carrito

			//Referencias a los productos del carrito y su cantidad
			if (!val.getProductos().isEmpty()){
				for (Map.Entry <Integer, Integer> prod : val.getProductos().entrySet()) {
					sb.append(prod.getKey() + ',' + prod.getValue() + ',');
				}
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		bw.write(sb.toString());	//Impresi�n de informaci�n en el archivo
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Mensaje de confirmaci�n
		System.out.println("Base de datos \"" + NombreBD + ".txt" + "\" guardada exitosamente");
	}

	private static void escrituraCatalogo(String NombreBD, HashMap <Integer, Producto> HM) throws IOException {

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Producto> entry : HM.entrySet()) {
			sb.append(entry.getKey() + '\n'); 						//Referencia al producto del cat�logo
		}
		bw.write(sb.toString());	//Impresi�n de informaci�n en el archivo
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Mensaje de confirmaci�n
		System.out.println("Base de datos \"" + NombreBD + ".txt" + "\" guardada exitosamente");
	}

	private static void escrituraProductos(String NombreBD, HashMap <Integer, Producto> HM) throws IOException {
		
		Producto val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Producto> entry : HM.entrySet()) {
			val = entry.getValue();							//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey() + ';'); 				//Identificador �nico
			sb.append(val.getNombreProducto() + ';');		//Nombre
			sb.append(val.getCategoria() + ';');			//Categor�a
			sb.append(val.getPrecio() + ';');				//Precio
			sb.append(val.getCantidad()+ ';');				//Cantidad
			sb.append(val.getVendedor().getId() + ';');		//Referencia al vendedor

			//Referencias a las rese�as del producto
			if (!entry.getValue().getResenas().isEmpty()){
				for (Map.Entry <Integer, Resena> res: entry.getValue().getResenas().entrySet()) {
					sb.append(res.getKey() + ',');
				}
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		bw.write(sb.toString());	//Impresi�n de informaci�n en el archivo
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Mensaje de confirmaci�n
		System.out.println("Base de datos \"" + NombreBD + ".txt" + "\" guardada exitosamente");
	}

	private static void escrituraResenas(String NombreBD, HashMap <Integer, Resena> HM) throws IOException {

		Resena val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Resena> entry : HM.entrySet()) {
			val = entry.getValue();					//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey() + ';'); 		//Identificador �nico
			sb.append(val.getComentario() + ';');	//Comentario
			sb.append(val.getEstrellas() + ';');	//Estrellas
			sb.append(val.getComprador().getId());	//Identificador �nico comprador
		}
		bw.write(sb.toString());				//Impresi�n de informaci�n en el archivo
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Mensaje de confirmaci�n
		System.out.println("Base de datos \"" + NombreBD + ".txt" + "\" guardada exitosamente");
	}

	private static void mensajeError(Exception ex, String mensaje) {
		System.out.println(ex.getMessage() + '\n' + mensaje);
		System.exit(0);
	}
}