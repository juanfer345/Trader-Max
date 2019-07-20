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
	}

	private static void escrituraCompradores(String NombreBD, HashMap <Integer, Comprador> HM) throws IOException {

		Comprador val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Comprador> entry : HM.entrySet()) {
			val = entry.getValue();								//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey()).append(';'); 					//Identificador �nico
			sb.append(val.getNombre()).append(';');					//Nombre
			sb.append(val.getCorreo()).append(';');					//Correo
			sb.append(val.getPassword()).append(';');					//Contrase�a
			sb.append(val.getCedula()).append(';');					//C�dula
			sb.append(val.getCuentaBancaria().getId()).append(';');	//Referencia a la cuenta bancaria
			sb.append(val.getCarrito().getId()).append(';');			//Referencia a carrito de compras y salto de rengl�n

			//Referencias a los productos del historial
			if (!val.getHistorial().isEmpty()){
				for (Map.Entry <Integer, Producto> his: val.getHistorial().entrySet()) {
					sb.append(his.getValue().getId()).append(',');
				}
				sb.delete(sb.length() - 1, sb.length());
			} else {sb.append("#");}
			sb.append(';');
			
			//Referencias a las opciones de menu
			if (!val.getMenu().isEmpty()){
				ArrayList <OpcionDeMenu> menuTotal = OpcionDeMenu.getTodasLasOpciones();
				ArrayList <OpcionDeMenu> menu = val.getMenu();
				for (OpcionDeMenu opcionMenu: menu) {
					for (OpcionDeMenu opcionTotal : menuTotal) {
						if (opcionTotal.getClass().equals(opcionMenu.getClass())) {
							sb.append(menuTotal.indexOf(opcionTotal)).append(','); break;
						}}}
				sb.delete(sb.length() - 1, sb.length());
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		sb.append("#");				//Indicador de fin de archivo
		bw.append(sb);	//Impresi�n de informaci�n en el archivo
		mensajeConfirmacion(sb.length() != 1, NombreBD); 	//Mensaje de confirmaci�n
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder
		
		//Cerrado y guardado del archivo
    	try {bw.close();}
    	catch (IOException ex) {mensajeError(ex, "No fue posible cerrar (escritura) la base de datos \"" + BDactual + ".txt\"");}
	}

	private static void escrituraVendedores(String NombreBD, HashMap <Integer, Vendedor> HM) throws IOException {

		Vendedor val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Vendedor> entry : HM.entrySet()) {
			val = entry.getValue();									//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey()).append(';'); 						//Identificador �nico
			sb.append(val.getNombre()).append(';');						//Nombre
			sb.append(val.getCorreo()).append(';');						//Correo
			sb.append(val.getPassword()).append(';');						//Contrase�a
			sb.append(val.getCedula()).append(';');						//C�dula
			sb.append(val.getCuentaBancaria().getId()).append(';');		//Referencia a la cuenta bancaria
			
			//Referencias a las opciones de menu
			if (!val.getMenu().isEmpty()){
				ArrayList <OpcionDeMenu> menuTotal = OpcionDeMenu.getTodasLasOpciones();
				ArrayList <OpcionDeMenu> menu = val.getMenu();
				for (OpcionDeMenu opcionMenu: menu) {
					for (OpcionDeMenu opcionTotal : menuTotal) {
						if (opcionTotal.getClass().equals(opcionMenu.getClass())) {
							sb.append(menuTotal.indexOf(opcionTotal)).append(','); break;
						}}}
				sb.delete(sb.length() - 1, sb.length());
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		sb.append("#");				//Indicador de fin de archivo
		bw.append(sb);	//Impresi�n de informaci�n en el archivo
		mensajeConfirmacion(sb.length() != 1, NombreBD); 	//Mensaje de confirmaci�n
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder
		
		//Cerrado y guardado del archivo
    	try {bw.close();}
    	catch (IOException ex) {mensajeError(ex, "No fue posible cerrar (escritura) la base de datos \"" + BDactual + ".txt\"");}
	}

	private static void escrituraAdministradores(String NombreBD, HashMap <Integer, Administrador> HM) throws IOException {

		Administrador val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Administrador> entry : HM.entrySet()) {
			val = entry.getValue();						//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey()).append(';'); 			//Identificador �nico
			sb.append(val.getNombre()).append(';');			//Nombre
			sb.append(val.getCorreo()).append(';');			//Correo
			sb.append(val.getPassword()).append(';');			//Contrase�a
			sb.append(val.getCedula()).append(';');					//C�dula
			
			//Referencias a las opciones de menu
			if (!val.getMenu().isEmpty()){
				ArrayList <OpcionDeMenu> menuTotal = OpcionDeMenu.getTodasLasOpciones();
				ArrayList <OpcionDeMenu> menu = val.getMenu();
				for (OpcionDeMenu opcionMenu: menu) {
					for (OpcionDeMenu opcionTotal : menuTotal) {
						if (opcionTotal.getClass().equals(opcionMenu.getClass())) {
							sb.append(menuTotal.indexOf(opcionTotal)).append(','); break;
						}}}
				sb.delete(sb.length() - 1, sb.length());
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		sb.append("#");				//Indicador de fin de archivo
		bw.append(sb);	//Impresi�n de informaci�n en el archivo
		mensajeConfirmacion(sb.length() != 1, NombreBD); 	//Mensaje de confirmaci�n
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Cerrado y guardado del archivo
    	try {bw.close();}
    	catch (IOException ex) {mensajeError(ex, "No fue posible cerrar (escritura) la base de datos \"" + BDactual + ".txt\"");}
	}

	private static void escrituraCuentasBancarias(String NombreBD, HashMap <Integer, CuentaBancaria> HM) throws IOException {

		CuentaBancaria val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, CuentaBancaria> entry : HM.entrySet()) {
			val = entry.getValue();									//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey()).append(';'); 						//Identificador �nico
			sb.append(val.getSaldo()).append('\n');					//Saldo de la cuenta bancaria y salto de rengl�n
		}
		sb.append("#");				//Indicador de fin de archivo
		bw.append(sb);	//Impresi�n de informaci�n en el archivo
		mensajeConfirmacion(sb.length() != 1, NombreBD); 	//Mensaje de confirmaci�n
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Cerrado y guardado del archivo
    	try {bw.close();}
    	catch (IOException ex) {mensajeError(ex, "No fue posible cerrar (escritura) la base de datos \"" + BDactual + ".txt\"");}
	}

	private static void escrituraCarritos(String NombreBD, HashMap <Integer, CarritoDeCompras> HM) throws IOException {

		CarritoDeCompras val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, CarritoDeCompras> entry : HM.entrySet()) {
			val = entry.getValue();							//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey()).append(';'); 				//Identificador �nico
			sb.append(val.getTotalproductos()).append(';');		//Total de productos
			sb.append(val.getPrecioTotal()).append(';');			//Precio total de los productos en el carrito

			//Referencias a los productos del carrito y su cantidad
			if (!val.getProductos().isEmpty()){
				for (Map.Entry <Integer, Integer> prod : val.getProductos().entrySet()) {
					sb.append(prod.getKey()).append(',').append(prod.getValue()).append(',');
				}
				sb.delete(sb.length() - 1, sb.length());
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		sb.append("#");				//Indicador de fin de archivo
		bw.append(sb);	//Impresi�n de informaci�n en el archivo
		mensajeConfirmacion(sb.length() != 1, NombreBD); 	//Mensaje de confirmaci�n
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Cerrado y guardado del archivo
    	try {bw.close();}
    	catch (IOException ex) {mensajeError(ex, "No fue posible cerrar (escritura) la base de datos \"" + BDactual + ".txt\"");}
	}

	private static void escrituraCatalogo(String NombreBD, HashMap <Integer, Producto> HM) throws IOException {

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Producto> entry : HM.entrySet()) {
			sb.append(entry.getKey()).append('\n'); 						//Referencia al producto del cat�logo
		}
		sb.append("#");				//Indicador de fin de archivo
		bw.append(sb);	//Impresi�n de informaci�n en el archivo
		mensajeConfirmacion(sb.length() != 1, NombreBD); 	//Mensaje de confirmaci�n
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Cerrado y guardado del archivo
    	try {bw.close();}
    	catch (IOException ex) {mensajeError(ex, "No fue posible cerrar (escritura) la base de datos \"" + BDactual + ".txt\"");}
	}

	private static void escrituraProductos(String NombreBD, HashMap <Integer, Producto> HM) throws IOException {
		
		Producto val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Producto> entry : HM.entrySet()) {
			val = entry.getValue();							//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey()).append(';'); 				//Identificador �nico
			sb.append(val.getNombreProducto()).append(';');		//Nombre
			sb.append(val.getCategoria()).append(';');			//Categor�a
			sb.append(val.getPrecio()).append(';');				//Precio
			sb.append(val.getCantidad()).append(';');				//Cantidad
			sb.append(val.getVendedor().getId()).append(';');		//Referencia al vendedor

			//Referencias a las rese�as del producto
			if (!entry.getValue().getResenas().isEmpty()){
				for (Map.Entry <Integer, Resena> res: entry.getValue().getResenas().entrySet()) {
					sb.append(res.getKey()).append(',');
				}
				sb.delete(sb.length() - 1, sb.length());
			} else {sb.append("#");}
			sb.append('\n');	//salto de rengl�n
		}
		sb.append("#");				//Indicador de fin de archivo
		bw.append(sb);	//Impresi�n de informaci�n en el archivo
		mensajeConfirmacion(sb.length() != 1, NombreBD); 	//Mensaje de confirmaci�n
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Cerrado y guardado del archivo
    	try {bw.close();}
    	catch (IOException ex) {mensajeError(ex, "No fue posible cerrar (escritura) la base de datos \"" + BDactual + ".txt\"");}
	}

	private static void escrituraResenas(String NombreBD, HashMap <Integer, Resena> HM) throws IOException {

		Resena val;

		//Creaci�n o sobreescritura de la base de datos
		bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" +  NombreBD + ".txt"));

		for (Map.Entry <Integer, Resena> entry : HM.entrySet()) {
			val = entry.getValue();					//Extracci�n de valores de la tabla hash
			sb.append(entry.getKey()).append(';'); 		//Identificador �nico
			sb.append(val.getComentario()).append(';');	//Comentario
			sb.append(val.getEstrellas()).append(';');	//Estrellas
			sb.append(val.getComprador().getId());	//Identificador �nico comprador
			sb.append('\n');//salto de rengl�n
		}
		sb.append("#");				//Indicador de fin de archivo
		bw.append(sb);	//Impresi�n de informaci�n en el archivo
		mensajeConfirmacion(sb.length() != 1, NombreBD); 	//Mensaje de confirmaci�n
		sb.delete(0, sb.length());	//Borrado del contenido del StringBuilder

		//Cerrado y guardado del archivo
    	try {bw.close();}
    	catch (IOException ex) {mensajeError(ex, "No fue posible cerrar (escritura) la base de datos \"" + BDactual + ".txt\"");}
	}
	
	private static void mensajeConfirmacion(boolean BDvacia, String NombreBD) {
        if (BDvacia) {
        	//Caso A: La base de datos se carg� correctamente
        	System.out.println("Base de datos \"" + NombreBD + ".txt\"" + " guardada exitosamente");
        	
        } else {
        	//Caso B: La base de datos se encontraba vac�a
        	System.out.println("Advertencia: la base de datos \"" + NombreBD + ".txt\"" + " se ha guardado vac�a");
        }
	}

	private static void mensajeError(Exception ex, String mensaje) {
		System.out.println(ex.getMessage() + '\n' + mensaje);
		System.exit(0);
	}
}