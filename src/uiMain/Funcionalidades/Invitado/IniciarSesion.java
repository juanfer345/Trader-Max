package uiMain.Funcionalidades.Invitado;

import java.io.IOException;

import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class IniciarSesion extends OpcionDeMenu { // opcion 1
	
	public void ejecutar() throws IOException {
		
		System.out.println("Correo: ");
		String c = MenuDeConsola.br.readLine().trim();
		System.out.println("Contrase�a: ");
		String p = MenuDeConsola.br.readLine().trim();
		
		
	}
	
	public String toString() {
		return "Iniciar Sesi�n";
	}

}
