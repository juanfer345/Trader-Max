package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.Salir;
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
	
	private static ArrayList <OpcionDeMenu> opcionComp;
	
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
	
	//Mostrado de las opciones de men� ingresando el id del usuario
	public String mostrarOpcionesDeMenu(int idUsuario, byte tipoUsuario) {
		
		HashMap <Integer, CuentaUsuario> aux = null;
		ArrayList <OpcionDeMenu> menu;
	    StringBuilder sb = new StringBuilder();
	    String usuario = null;
	    int i;

    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	aux = InicializacionAplicacion.getBDCompradores();
	    	usuario = "comprador";
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	aux = InicializacionAplicacion.getBDVendedores();
	    	usuario = "vendedor";
	    }
	    
    	if (aux.containsKey(idUsuario)) {
    		menu = aux.get(idUsuario).getOpcionesDeMenu();
    		sb.append("A continuaci�n se muestra el men� del " + usuario + "\n");
    		for (i = 0; i < menu.size(); i++) {
    			sb.append((i + 1) + ". " + menu.get(i).toString() + "\n");
    		}
    		OpcionDeMenu.controlError = true;
    	}
    	else {
    		sb.append("El " + usuario + " no fue encontrado, por favor revise el c�digo ingresado");
    	}
		return sb.toString();
	}

	//M�todo para comprobar la cantidad de opciones de men� que tiene un usuario, como un paso previo
	//para cuando se desee agregar o eliminar opciones
	public String comprobarCantidadOpciones(int idUsuario, byte tipoUsuario, byte borradoAgregado) {
		
		HashMap <Integer, CuentaUsuario> aux = null;
		ArrayList <OpcionDeMenu> menu;
	    StringBuilder sb = new StringBuilder();
	    int i;

    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	aux = InicializacionAplicacion.getBDCompradores();
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	aux = InicializacionAplicacion.getBDVendedores();
	    }
    	menu = aux.get(idUsuario).getOpcionesDeMenu();	//Obtenci�n de opciones de men� del usuario
	    
	    //Condicional para identificar si es el caso de agregado o eliminaci�n de opciones
	    if (borradoAgregado == 1) {
	    	
	    	//Caso A: Se est� agregando una opci�n - [Inicio]
    		
    		//Resultado seg�n cantidad de opciones del usuario seleccionado
    		if (menu.size() < aux.get(idUsuario).getTotalDeOpcionesDefault()) {
    			
    			//Caso A.a: El men� del usuario no tiene la cantidad m�xima posible de opciones
    			opcionComp = aux.get(idUsuario).getOpcionesDeMenuPredeterminadas();
	    		
    			//Ciclo para descartar las opciones que ya posee el men� del usuario
    			for (i = 0; i < menu.size(); i++) {
    				if (opcionComp.contains(menu.get(i))){
    					opcionComp.remove(menu.get(i));
    				}
    			}
				Cuenta.setCambioOpDeMen(opcionComp);	//Guardado de las opciones que no posee el men� del usuario
    			
    			//Ciclo para retornar la como string cada opci�n disponible
    			sb.append("\nA continuaci�n se muestran las opciones disponibles que pueden agregarse:\n");
	    		for (i = 0; i < opcionComp.size(); i++) {
	    			sb.append((i + 1) + ". " + opcionComp.get(i).toString() + "\n");
	    		}
    			sb.append("Ingrese el indice de la opci�n que desea agregar \n");
    			sb.append("=> ");
	    		OpcionDeMenu.controlError = true;
    		}
    		else if (menu.size() == aux.get(idUsuario).getTotalDeOpcionesDefault()) {

    			//Caso A.b: El men� del usuario tiene la cantidad m�xima posible de opciones
    			sb.append("\nEsta cuenta ya posee la m�xima cantidad de opciones de men�\n");
    		}
	    	//Caso A: Se est� agregando una opci�n - [Fin]
	    }
	    else if (borradoAgregado == 2) {
	    	
	    	//Caso B: Se est� eliminando una opci�n - [Inicio]
    		
    		//Resultado seg�n cantidad de opciones del usuario seleccionado
    		if (menu.size() > 0) {
    			
    			//Caso B.a: El men� del usuario tiene al menos una opci�n disponible
    			sb.append("Ingrese el indice de la opci�n que desea eliminar \n");
    			sb.append("=> ");
	    		OpcionDeMenu.controlError = true;
    		}
    		else if (menu.size() == aux.get(idUsuario).getTotalDeOpcionesDefault()) {

    			//Caso B.b: El men� del usuario se encuentra vac�o
    			sb.append("\nEsta cuenta ya no posee ninguna opci�n de men�, no es posible borrar m�s\n");
    		}
	    	//Caso B: Se est� eliminando una opci�n - [Fin]
	    }
		return sb.toString();
	}
	
	//M�todo para agregarle una opci�n al men� de un usuario
	public String agregarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
		
		HashMap <Integer, CuentaUsuario> aux = null;
		ArrayList <OpcionDeMenu> menu;
	    StringBuilder sb = new StringBuilder();
	    
    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	aux = InicializacionAplicacion.getBDCompradores();
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	aux = InicializacionAplicacion.getBDVendedores();
	    }
    	menu = aux.get(idUsuario).getOpcionesDeMenu();	//Obtenci�n de opciones de men� del usuario
    	
    	try {
    		menu.add(opcionComp.get(indice));				//Agregado de la opci�n correspondiente
        	opcionComp.clear();								//Eliminaci�n de las opciones de comparaci�n para evitar errores
        	
        	sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario));	//Guardado del mensaje mostrando el nuevo men�
    		OpcionDeMenu.controlError = true;
    		return sb.append("/nSe ha agregado la opci�n correctamente/n").toString();
    	}
    	catch(IndexOutOfBoundsException e){
    		return "Por favor elija un �ndice dentro del rango mostrado anteriormente";
    	}
	}
	
	public String eliminarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
		HashMap <Integer, CuentaUsuario> aux = null;
		ArrayList <OpcionDeMenu> menu;
	    StringBuilder sb = new StringBuilder();
	    
    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	aux = InicializacionAplicacion.getBDCompradores();
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	aux = InicializacionAplicacion.getBDVendedores();
	    }
    	menu = aux.get(idUsuario).getOpcionesDeMenu();	//Obtenci�n de opciones de men� del usuario
    	
    	try {
    		menu.remove(menu.get(indice));				//Agregado de la opci�n correspondiente
        	
        	sb.append(mostrarOpcionesDeMenu(idUsuario, tipoUsuario));	//Guardado del mensaje mostrando el nuevo men�
    		OpcionDeMenu.controlError = true;
    		sb.append("/nSe ha eliminado la opci�n correctamente/n");
    	}
    	catch(IndexOutOfBoundsException e){
    		sb.append("Por favor elija un �ndice dentro del rango mostrado anteriormente");
    	}
    	return sb.toString();
	}
	
	public String numeroCuentas() {
		int cuentas = Administrador.getNumeroCuentas();
		return "Actualmente hay " + cuentas + " cuentas";
	}
	
	public String mostrarUsuario(int idUsuario, byte tipoUsuario) {

		HashMap <Integer, CuentaUsuario> aux = null;
	    StringBuilder sb = new StringBuilder();
	    String usuario = null;
	    
    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	aux = InicializacionAplicacion.getBDCompradores();
	    	usuario = "comprador";
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	aux = InicializacionAplicacion.getBDVendedores();
	    	usuario = "vendedor";
	    }
	    
    	if (aux.containsKey(idUsuario)) {
    		sb.append(aux.get(idUsuario).toString());
    		OpcionDeMenu.controlError = true;
    	}
    	else {
    		sb.append("El " + usuario + " no fue encontrado, por favor revise el c�digo ingresado");
    	}
		return sb.toString();
	}

	public String eliminarCuenta(int idUsuario, byte tipoUsuario) {

		HashMap <Integer, CuentaUsuario> aux = null;
	    StringBuilder sb = new StringBuilder();
	    String usuario = null;
	    
    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	aux = InicializacionAplicacion.getBDCompradores();
	    	usuario = "comprador";
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	aux = InicializacionAplicacion.getBDVendedores();
	    	usuario = "vendedor";
	    }
	    
    	if (aux.containsKey(idUsuario)) {
    		aux.remove(idUsuario);
    		sb.append("Se ha removido la cuenta correctamente");
    		OpcionDeMenu.controlError = true;
    	}
    	else {
    		sb.append("El " + usuario + " no fue encontrado, por favor revise el c�digo ingresado");
    	}
		return sb.toString();
	}
}