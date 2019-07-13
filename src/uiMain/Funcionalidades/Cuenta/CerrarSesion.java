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
		sb.append("Desea cerrar sesi�n?\n");
		sb.append("1: Si\n");
		sb.append("2: No\n");
		sb.append("=> ");

		//Ciclo para control de error
		while (!controlError) {
			
		    //Ingreso de valores
			System.out.println(sb);
			seleccion = Byte.parseByte(br.readLine().trim());
			
			//Ejecuci�n del m�todo e impresi�n de respuesta
			System.out.println(usuario.cerrarSesion(seleccion));
		}
	}

	public String toString() {
		return "Cerrar sesi�n";
	}
}