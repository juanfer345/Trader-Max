package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.*;
import uiMain.Funcionalidades.Cuenta.CerrarSesion;
import uiMain.Funcionalidades.Cuenta.Administrador.AgregarOpcion;
import uiMain.Funcionalidades.Cuenta.Administrador.CuentasAdmin;
import uiMain.Funcionalidades.Cuenta.Administrador.EliminarCuenta;
import uiMain.Funcionalidades.Cuenta.Administrador.EliminarOpcion;

/*PROPUESTA por juanfer: ya que administrador deber�a heredar algunos atributos de cuenta (pero no todos), 
						 que les parece si se quita cuenta y en su remplazo creamos dos interfaces, de tal manera que una interfaz tenga todo lo de cuenta, pero sin 
						 ciertos atributos y otra interfaz tenga todo lo que le falte (adem�s de esta manera vamos llenando los requisitos del trabajo)
*/

public class Administrador extends CuentaUsuario {
	
	public static int getNumeroCuentas() {return Cuenta.totalCuentas;}

	public Administrador(String nombre, String correo, String password, int cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		this.totalDeOpcionesDefault = 6;
		setOpcionesDeMenuPredeterminadas();
	}
	
	public Administrador() { }
	
	public void setOpcionesDeMenuPredeterminadas() {
		Cuenta.menu.setOpcionesActivas(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new EliminarOpcion(), new AgregarOpcion(), 
										  new EliminarCuenta(), new CuentasAdmin(), new CerrarSesion(), new Salir()})));
	}
	
	public ArrayList <OpcionDeMenu> getOpcionesDeMenuPredeterminadas() {
		return new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new EliminarOpcion(), new AgregarOpcion(), 
										  new EliminarCuenta(), new CuentasAdmin(), new CerrarSesion(), new Salir()}));
	}

	public ArrayList <OpcionDeMenu> getOpcionesDeMenu() {return menu.getOpcionesActivas();}
	
	public String agregarOpcion(int indice) {
//		ArrayList<OpcionDeMenu>elim = OpcionDeMenu.usuarioActivo;
//		activo.remove(Aeliminar);
		return "Se ha agregado la opci�n correctamente";
	}
	
	public StringBuilder comprobarCantidadOpciones(int idUsuario, byte tipoUsuario, byte borradoAgregado) {

		ArrayList <OpcionDeMenu> menu, menuPredem;
	    StringBuilder sb = new StringBuilder();
	    int i;
	    
	    //Condicional para identificar si es el caso de agregado o eliminaci�n de opciones
	    if (borradoAgregado == 1) {
	    	
	    	//Caso A: Se est� agregando una opci�n - [Inicio]
	    	
	    	//Condicional para distinguir entre comprador y vendedor
		    if (tipoUsuario == 1) {
		    	
		    	//Caso A.a: Comprador - [Inicio]
		    	HashMap <Integer, Comprador> aux = InicializacionAplicacion.getBDCompradores();
	    		menu = aux.get(idUsuario).getOpcionesDeMenu();
	    		
	    		//Resultado seg�n cantidad de opciones del usuario seleccionado
	    		if (menu.size() < aux.get(idUsuario).getTotalDeOpcionesDefault()) {
	    			
	    			//Caso A.a.a: El men� del usuario no tiene la cantidad m�xima posible de opciones
	    			menuPredem = aux.get(idUsuario).getOpcionesDeMenuPredeterminadas();
		    		
	    			//Ciclo para descartar las opciones que ya posee el men� del usuario
	    			for (i = 0; i < menu.size(); i++) {
	    				if (menuPredem.contains(menu.get(i))){
	    					menuPredem.remove(menu.get(i));
	    				}
	    			}
					Cuenta.setCambioOpDeMen(menuPredem);	//Guardado de las opciones que no posee el men� del usuario
	    			
	    			//Ciclo para retornar la como string cada opci�n disponible
	    			sb.append("\nA continuaci�n se muestran las opciones disponibles que pueden agregarse:\n");
		    		for (i = 0; i < menuPredem.size(); i++) {
		    			sb.append((i + 1) + ". " + menuPredem.get(i).toString() + "\n");
		    		}
	    			sb.append("Ingrese el indice de la opci�n que desea agregar \n");
	    			sb.append("=> ");
		    		OpcionDeMenu.controlError = true;
	    		}
	    		else if (menu.size() == aux.get(idUsuario).getTotalDeOpcionesDefault()) {

	    			//Caso A.a.b: El men� del usuario tiene la cantidad m�xima posible de opciones
	    			sb.append("\nEsta cuenta ya posee la m�xima cantidad de opciones de men�\n");
	    		}
		    	//Caso A.a: Comprador - [Fin]
		    }
		    else if (tipoUsuario == 2) {
		    	
		    	//Caso A.b: Vendedor - [Inicio]
		    	HashMap <Integer, Vendedor> aux = InicializacionAplicacion.getBDVendedores();
	    		menu = aux.get(idUsuario).getOpcionesDeMenu();
	    		
	    		//Resultado seg�n cantidad de opciones del usuario seleccionado
	    		if (menu.size() < aux.get(idUsuario).getTotalDeOpcionesDefault()) {
	    			
	    			//Caso A.b.a: El men� del usuario no tiene la cantidad m�xima posible de opciones
	    			menuPredem = aux.get(idUsuario).getOpcionesDeMenuPredeterminadas();
		    		
	    			//Ciclo para descartar las opciones que ya posee el men� del usuario
	    			for (i = 0; i < menu.size(); i++) {
	    				if (menuPredem.contains(menu.get(i))){
	    					menuPredem.remove(menu.get(i));
	    				}
	    			}
					Cuenta.setCambioOpDeMen(menuPredem);	//Guardado de las opciones que no posee el men� del usuario
	    			
	    			//Ciclo para retornar la como string cada opci�n disponible
	    			sb.append("\nA continuaci�n se muestran las opciones disponibles que pueden agregarse:\n");
		    		for (i = 0; i < menuPredem.size(); i++) {
		    			sb.append((i + 1) + ". " + menuPredem.get(i).toString() + "\n");
		    		}
	    			sb.append("Ingrese el indice de la opci�n que desea agregar \n");
	    			sb.append("=> ");
		    		OpcionDeMenu.controlError = true;
	    		}
	    		else if (menu.size() == aux.get(idUsuario).getTotalDeOpcionesDefault()) {

	    			//Caso A.b.b: El men� del usuario tiene la cantidad m�xima posible de opciones
	    			sb.append("\nEsta cuenta ya posee la m�xima cantidad de opciones de men�\n");
	    		}
		    	//Caso A.b: Vendedor - [Fin]
		    }
	    	//Caso A: Se est� agregando una opci�n - [Fin]
	    }
	    else if (borradoAgregado == 2) {
	    	
	    	//Caso B: Se est� eliminando una opci�n - [Inicio]
	    	
	    	//Condicional para distinguir entre comprador y vendedor
		    if (tipoUsuario == 1) {
		    	
		    	//Caso B.a: Comprador
		    	HashMap <Integer, Comprador> aux = InicializacionAplicacion.getBDCompradores();
	    		menu = aux.get(idUsuario).getOpcionesDeMenu();
	    		
	    		//Resultado seg�n cantidad de opciones del usuario seleccionado
	    		if (menu.size() > 0) {
	    			
	    			//Caso B.a.a: El men� del usuario tiene al menos una opci�n disponible
	    			sb.append("Ingrese el indice de la opci�n que desea borrar \n");
	    			sb.append("=> ");
		    		OpcionDeMenu.controlError = true;
	    		}
	    		else if (menu.size() == aux.get(idUsuario).getTotalDeOpcionesDefault()) {

	    			//Caso B.a.b: El men� del usuario se encuentra vac�o
	    			sb.append("\nEsta cuenta no posee ninguna opci�n de men�\n");
	    		}
		    }
		    else if (tipoUsuario == 2) {
		    	
		    	//Caso B.b: Vendedor
		    	HashMap <Integer, Vendedor> aux = InicializacionAplicacion.getBDVendedores();
	    		menu = aux.get(idUsuario).getOpcionesDeMenu();
	    		
	    		//Resultado seg�n cantidad de opciones del usuario seleccionado
	    		if (menu.size() > 0) {
	    			
	    			//Caso B.b.a: El men� del usuario tiene al menos una opci�n disponible
	    			sb.append("Ingrese el indice de la opci�n que desea borrar \n");
	    			sb.append("=> ");
		    		OpcionDeMenu.controlError = true;
	    		}
	    		else if (menu.size() == aux.get(idUsuario).getTotalDeOpcionesDefault()) {

	    			//Caso B.a.b: El men� del usuario se encuentra vac�o
	    			sb.append("\nEsta cuenta no posee ninguna opci�n de men�\n");
	    		}
		    }
	    	//Caso A: Se est� agregando una opci�n - [Fin]
	    }
		return sb;
	}
	
	public String eliminarOpcion(int Aeliminar) {
//		ArrayList<OpcionDeMenu>elim = OpcionDeMenu.usuarioActivo;
//		activo.remove(Aeliminar);
		return "Se ha eliminado la opci�n";
	}
	
	//Mostrado de las opciones de men� ingresando el id del usuario
	public StringBuilder mostrarOpcionesDeMenu(int idUsuario, byte tipoUsuario) {
		
		ArrayList <OpcionDeMenu> menu;
	    StringBuilder sb = new StringBuilder();
	    int i;
		
	    if (tipoUsuario == 1) {
	    	HashMap <Integer, Comprador> aux = InicializacionAplicacion.getBDCompradores();
	    	if (aux.containsKey(idUsuario)) {
	    		menu = aux.get(idUsuario).getOpcionesDeMenu();
	    		sb.append("A continuaci�n se muestra el men� del comprador \n");
	    		for (i = 0; i < menu.size(); i++) {
	    			sb.append((i + 1) + ". " + menu.get(i).toString() + "\n");
	    		}
	    		OpcionDeMenu.controlError = true;
	    	}
	    	else {
	    		sb.append("El comprador no fue encontrado, revise el c�digo ingresado");
	    	}
	    }
	    else if (tipoUsuario == 2) {
	    	HashMap <Integer, Vendedor> aux = InicializacionAplicacion.getBDVendedores();
	    	if (aux.containsKey(idUsuario)) {
	    		menu = aux.get(idUsuario).getOpcionesDeMenu();
	    		sb.append("A continuaci�n se muestra el men� del vendedor \n");
	    		for (i = 0; i < menu.size(); i++) {
	    			sb.append((i + 1) + ". " + menu.get(i).toString() + "\n");
	    		}
	    		OpcionDeMenu.controlError = true;
	    	}
	    	else {
	    		sb.append("El vendedor no fue encontrado, revise el c�digo ingresado");
	    	}
	    }
		return sb;
	}
	
	public static String numeroCuentas() {
		int cuentas = Administrador.getNumeroCuentas();
		return"Actualmente hay "+cuentas+" cuentas";
	}
}