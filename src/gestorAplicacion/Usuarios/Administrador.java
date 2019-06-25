package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.*;
import uiMain.Funcionalidades.Cuenta.CerrarSesion;
import uiMain.Funcionalidades.Cuenta.Administrador.AgregarOpcion;
import uiMain.Funcionalidades.Cuenta.Administrador.CuentasAdmin;
import uiMain.Funcionalidades.Cuenta.Administrador.EliminarCuenta;
import uiMain.Funcionalidades.Cuenta.Administrador.EliminarOpcion;

/*PROPUESTA por juanfer: ya que administrador debería heredar algunos atributos de cuenta (pero no todos), 
						 que les parece si se quita cuenta y en su remplazo creamos dos interfaces, de tal manera que una interfaz tenga todo lo de cuenta, pero sin 
						 ciertos atributos y otra interfaz tenga todo lo que le falte (además de esta manera vamos llenando los requisitos del trabajo)
*/

public class Administrador extends Cuenta {
	
	public static int getNumeroCuentas() {return Cuenta.totalCuentas;}

	public Administrador(String nombre, String correo, String password, int cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		setMenuPredeterminado();
	}
	
	public void setMenuPredeterminado() {
		Cuenta.menu.setOpcionesActivas(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new EliminarOpcion(), new AgregarOpcion(), 
										  new EliminarCuenta(), new CuentasAdmin(), new CerrarSesion(), new Salir()})));
	}
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public static String numeroCuentas() {
		int cuentas =Administrador.getNumeroCuentas();
		return"Actualmente hay "+cuentas+" cuentas";
	}
	
	public String eliminarOpcion(int Aeliminar) {
//		ArrayList<OpcionDeMenu>elim = OpcionDeMenu.usuarioActivo;
//		activo.remove(Aeliminar);
		return "Se ha eliminado la opción";
	}

	@Override
	public ArrayList <OpcionDeMenu> getOpcionesDeMenu() {
		return menu.getOpcionesActivas();
	}
}