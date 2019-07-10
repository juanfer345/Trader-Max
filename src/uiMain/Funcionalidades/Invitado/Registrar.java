package uiMain.Funcionalidades.Invitado;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Visitante;
public class Registrar extends OpcionDeMenu { // opcion 0
	boolean x = false;
	Integer key;
	public void ejecutar() throws IOException{
		System.out.println("Tipo de cuenta: \n1.Vendedor\n2.Comprador");
		short t = Short.parseShort(MenuDeConsola.br.readLine().trim());
		System.out.println("Nombre: ");
		String n = MenuDeConsola.br.readLine().trim();
		System.out.println("Correo: ");
		String c = MenuDeConsola.br.readLine().trim();
		System.out.println("Cedula: ");
		int cc = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		System.out.println("Contraseña: ");
		String p = MenuDeConsola.br.readLine().trim();
		
		Visitante x = (Visitante) InicializacionAplicacion.usuarioActivo;
		String str = x.Registrarse(t,n,c,cc,p);
        System.out.println(str);

		

	}

	public String toString() {
		return "Registrar";
	}
}
