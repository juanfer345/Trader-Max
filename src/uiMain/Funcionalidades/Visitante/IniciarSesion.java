package uiMain.Funcionalidades.Visitante;

import java.io.IOException;
import uiMain.OpcionDeMenu;

public class IniciarSesion extends OpcionDeMenu { // opcion 1
	
	public void ejecutar() throws IOException {
		
		System.out.println("Correo: ");
		String correo = br.readLine().trim();
		System.out.println("Contraseña: ");
		String password = br.readLine().trim();
	}
	
	public String toString() {
		return "Iniciar sesión";
	}
}