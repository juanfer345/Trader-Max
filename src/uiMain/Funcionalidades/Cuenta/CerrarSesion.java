package uiMain.Funcionalidades.Cuenta;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.CuentaUsuario;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class CerrarSesion extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		
		CuentaUsuario usuario = (CuentaUsuario) InicializacionAplicacion.usuarioActivo;
	    byte seleccion;

	    //Guardado de mensaje principal
		sb.append("Desea cerrar sesión?\n");
		sb.append("1: Si\n");
		sb.append("2: No\n");
		sb.append("=> ");

		//Ciclo para control de error
		while (!controlError) {
			
		    //Ingreso de valores
			System.out.println(sb);
			seleccion = Byte.parseByte(br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			System.out.println(usuario.cerrarSesion(seleccion));
		}
	}

	public String toString() {
		return "Cerrar sesión";
	}
}