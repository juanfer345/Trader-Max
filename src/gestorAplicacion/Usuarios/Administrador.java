package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.Salir;
import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Administrador.AgregarOpcion;
import uiMain.MenuConsola.Cuenta.Administrador.CuentasAdmin;
import uiMain.MenuConsola.Cuenta.Administrador.EliminarCuenta;
import uiMain.MenuConsola.Cuenta.Administrador.EliminarOpcion;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarMenu;
import uiMain.MenuConsola.Cuenta.Administrador.MostrarUsuario;

/*PROPUESTA por juanfer: ya que administrador deber�a heredar algunos atributos de cuenta (pero no todos), 
						 que les parece si se quita cuenta y en su remplazo creamos dos interfaces, de tal manera que una interfaz tenga todo lo de cuenta, pero sin 
						 ciertos atributos y otra interfaz tenga todo lo que le falte (adem�s de esta manera vamos llenando los requisitos del trabajo)
*/

public class Administrador extends CuentaUsuario {
	
	private static String codigoSecreto = "Es un secretooo";
	private static ArrayList <OpcionDeMenu> opcionComp;
	private static final int totalDeOpcionesDefault = 6;

	//Constructor para usuarios existentes
	public Administrador(int idCuenta, String nombre, String correo, String password, int cedula) {
		super(idCuenta, nombre, correo, password, cedula);
	}
	
	public Administrador(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
		setMenuPredeterminado();
	}

	public Administrador() {}
	
	public ArrayList <OpcionDeMenu> getMenuPredeterminado() {
		return new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {
				   new MostrarUsuario(), new MostrarMenu(), new EliminarOpcion(), new AgregarOpcion(), 
				   new EliminarCuenta(), new CuentasAdmin(), new CerrarSesion(), new Salir()}));
	}
	
	public int getTotalDeOpcionesDefault() {
		return totalDeOpcionesDefault;
	}
	
	public static int getNumeroCuentas() {return Cuenta.totalCuentas;}
	
	//Mostrado de las opciones de men� ingresando el id del usuario
	public String mostrarOpcionesDeMenu(int idUsuario, byte tipoUsuario) {
		
		HashMap <Integer, ? extends CuentaUsuario> baseDeDatos = null;
		ArrayList <OpcionDeMenu> menu;
	    StringBuilder sb = new StringBuilder();
	    String usuario = null;
	    int i;

    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	baseDeDatos = InicializacionAplicacion.getBDCompradores();
	    	usuario = "comprador";
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	baseDeDatos = InicializacionAplicacion.getBDVendedores();
	    	usuario = "vendedor";
	    }
	    
    	if (baseDeDatos.containsKey(idUsuario)) {
    		menu = baseDeDatos.get(idUsuario).getMenu();
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
		
		HashMap <Integer, ? extends CuentaUsuario> baseDeDatos = null;
		ArrayList <OpcionDeMenu> menu;
	    StringBuilder sb = new StringBuilder();
	    int i;

    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	baseDeDatos = InicializacionAplicacion.getBDCompradores();
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	baseDeDatos = InicializacionAplicacion.getBDVendedores();
	    }
    	menu = baseDeDatos.get(idUsuario).getMenu();	//Obtenci�n de opciones de men� del usuario
	    
	    //Condicional para identificar si es el caso de agregado o eliminaci�n de opciones
	    if (borradoAgregado == 1) {
	    	
	    	//Caso A: Se est� agregando una opci�n - [Inicio]
    		
    		//Resultado seg�n cantidad de opciones del usuario seleccionado
    		if (menu.size() < baseDeDatos.get(idUsuario).getTotalDeOpcionesDefault()) {
    			
    			//Caso A.a: El men� del usuario no tiene la cantidad m�xima posible de opciones
    			opcionComp = baseDeDatos.get(idUsuario).getMenuPredeterminado();
	    		
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
    		else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDefault()) {

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
    		else if (menu.size() == baseDeDatos.get(idUsuario).getTotalDeOpcionesDefault()) {

    			//Caso B.b: El men� del usuario se encuentra vac�o
    			sb.append("\nEsta cuenta ya no posee ninguna opci�n de men�, no es posible borrar m�s\n");
    		}
	    	//Caso B: Se est� eliminando una opci�n - [Fin]
	    }
		return sb.toString();
	}
	
	//M�todo para agregarle una opci�n al men� de un usuario
	public String agregarOpcion(int idUsuario, byte tipoUsuario, byte indice) {
		
		HashMap <Integer, ? extends CuentaUsuario> baseDeDatos = null;
		ArrayList <OpcionDeMenu> menu;
	    StringBuilder sb = new StringBuilder();
	    
    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	baseDeDatos = InicializacionAplicacion.getBDCompradores();
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	baseDeDatos = InicializacionAplicacion.getBDVendedores();
	    }
    	menu = baseDeDatos.get(idUsuario).getMenu();	//Obtenci�n de opciones de men� del usuario
    	
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
		HashMap <Integer, ? extends CuentaUsuario> baseDeDatos = null;
		ArrayList <OpcionDeMenu> menu;
	    StringBuilder sb = new StringBuilder();
	    
    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	baseDeDatos = InicializacionAplicacion.getBDCompradores();
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	baseDeDatos = InicializacionAplicacion.getBDVendedores();
	    }
    	menu = baseDeDatos.get(idUsuario).getMenu();	//Obtenci�n de opciones de men� del usuario
    	
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

		HashMap <Integer, ? extends CuentaUsuario> baseDeDatos = null;
	    StringBuilder sb = new StringBuilder();
	    String usuario = null;
	    
    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	baseDeDatos = InicializacionAplicacion.getBDCompradores();
	    	usuario = "comprador";
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	baseDeDatos = InicializacionAplicacion.getBDVendedores();
	    	usuario = "vendedor";
	    }
	    
    	if (baseDeDatos.containsKey(idUsuario)) {
    		sb.append(baseDeDatos.get(idUsuario).toString());
    		OpcionDeMenu.controlError = true;
    	}
    	else {
    		sb.append("El " + usuario + " no fue encontrado, por favor revise el c�digo ingresado");
    	}
		return sb.toString();
	}

	public String eliminarCuenta(int idUsuario, byte tipoUsuario) {

		HashMap <Integer, ? extends CuentaUsuario> baseDeDatos = null;
	    StringBuilder sb = new StringBuilder();
	    String usuario = null;
	    
    	//Condicional para distinguir entre comprador y vendedor
	    if (tipoUsuario == 1) {
	    	//Caso A: Comprador
	    	baseDeDatos = InicializacionAplicacion.getBDCompradores();
	    	usuario = "comprador";
	    }
	    else if (tipoUsuario == 2) {
	    	//Caso B: Vendedor
	    	baseDeDatos = InicializacionAplicacion.getBDVendedores();
	    	usuario = "vendedor";
	    }
	    
    	if (baseDeDatos.containsKey(idUsuario)) {
    		baseDeDatos.remove(idUsuario);
    		sb.append("Se ha removido la cuenta correctamente");
    		OpcionDeMenu.controlError = true;
    	}
    	else {
    		sb.append("El " + usuario + " no fue encontrado, por favor revise el c�digo ingresado");
    	}
		return sb.toString();
	}
	
	//FALTA LO DE MOSTRAR TODAS LAS OPCIONES DE MENU y mostrar por tipo de usuario Y ADEM�S MODIFICAR PARA QUE SE PUEDA A�ADIR CUALQUIER OPCION A CUALQUIER CUENTA
	
	
	public static String getCodigoSecreto() {return codigoSecreto;}
}