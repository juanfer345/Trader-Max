package gestorAplicación.Usuarios;

import java.util.ArrayList;

import uiMain.OpcionDeMenu;

/*PROPUESTA por juanfer: ya que administrador debería heredar algunos atributos de cuenta (pero no todos), 
						 que les parece si se quita cuenta y en su remplazo creamos dos interfaces, de tal manera que una interfaz tenga todo lo de cuenta, pero sin 
						 ciertos atributos y otra interfaz tenga todo lo que le falte (además de esta manera vamos llenando los requisitos del trabajo)
*/

public class Administrador extends Cuenta {
	
	public static int getNumeroCuentas(){
		return totalCuentas;
		
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