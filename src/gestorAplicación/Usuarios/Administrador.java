package gestorAplicación.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.*;

/*PROPUESTA por juanfer: ya que administrador debería heredar algunos atributos de cuenta (pero no todos), 
						 que les parece si se quita cuenta y en su remplazo creamos dos interfaces, de tal manera que una interfaz tenga todo lo de cuenta, pero sin 
						 ciertos atributos y otra interfaz tenga todo lo que le falte (además de esta manera vamos llenando los requisitos del trabajo)
*/

public class Administrador extends Cuenta {
	
	public static int getNumeroCuentas(){totalCuentas;}
	
	public void setMenuPredeterminado() {
		Cuenta.menu.cambiarMenu(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new eliminarOpcion(), new agregarOpcion(), 
										  new eliminarCuenta(), new cuentas(), new cerrarSesion(), new salir()})), this);
	}
	
	public void setMenu(ArrayList <OpcionDeMenu> opcionesActivas) {
		Cuenta.menu.cambiarMenu(opcionesActivas, this);
	}
	
	public Administrador(String nombre, String correo, String password, int cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		
		Cuenta.menu = new MenuDeConsola(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new iniciarSesion(), new registrar(), 
				  		new buscarProducto(), new buscarCategoria(),new salir()})), this);
	}
	public static String numeroCuentas() {
		int cuentas =Administrador.getNumeroCuentas();
		return"Actualmente hay "+cuentas+" cuentas";
	}
	/*public String eliminarOpcion(int Aeliminar) {
		ArrayList<OpcionDeMenu>elim = OpcionDeMenu.activo<>();
		activo.remove(Aeliminar);
		return "Se ha eliminado la opción";
	}*/
}