package uiMain.Funcionalidades;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicaci�n.Usuarios.Cuenta;
import uiMain.OpcionDeMenu;

public class IniciarSesion extends OpcionDeMenu { // opcion 1
	
	public void ejecutar() {
		
		System.out.println("Correo: ");
		String c = scn.next();
		System.out.println("Contrase�a: ");
		String p = scn.next();
		
		
	}
	
	public String toString() {
		return "Iniciar Sesi�n";
	}

}
