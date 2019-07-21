package uiMain.MenuConsola.Cuenta;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.CuentaUsuario;
import uiMain.OpcionDeMenu;

public class CerrarSesion extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		
		CuentaUsuario usuario = (CuentaUsuario) InicializacionAplicacion.usuarioActivo;
	    byte seleccion;

	    //Guardado de mensaje principal
		sb.append("\n¿Desea cerrar sesión?\n");
		sb.append("1: Si.\n");
		sb.append("2: No.\n");
		sb.append("=> ");

		//Ciclo para control de error
		while (!controlError) {
			
		    //Ingreso de valores
			System.out.print(sb);
			seleccion = esByte(br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			System.out.println(usuario.cerrarSesion(seleccion));
		}
	}
	
	@Override
	public String toString() {return "Cerrar sesión.";}
}