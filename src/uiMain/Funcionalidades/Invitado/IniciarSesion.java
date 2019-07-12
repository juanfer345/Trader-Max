package uiMain.Funcionalidades.Invitado;

import java.io.IOException;
import java.util.Map;

import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import baseDatos.LecturaBD;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.CuentaUsuario;

public class IniciarSesion extends OpcionDeMenu { // opcion 1
	
	public void ejecutar() throws IOException {
		
		System.out.println("Correo: ");
		String correo = MenuDeConsola.br.readLine().trim();
		System.out.println("Contraseña: ");
		String password = MenuDeConsola.br.readLine().trim();
		
		
	}
	
	public String toString() {
		return "Iniciar Sesión";
	}

}
