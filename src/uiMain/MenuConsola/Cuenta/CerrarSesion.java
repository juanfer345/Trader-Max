package uiMain.MenuConsola.Cuenta;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.CuentaUsuario;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class CerrarSesion extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		
		CuentaUsuario usuario = (CuentaUsuario) InicializacionAplicacion.usuarioActivo;
	    byte seleccion;

	    //Guardado de mensaje principal
		sb.append("\n¿Desea cerrar sesión?\n");
		sb.append("1: Si.\n");
		sb.append("2: No.\n");
		
	    //Ingreso de valores y control de error
		System.out.print(sb);
		seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un número entero");
		if (controlError) {System.out.println(); return;}
		
		//Ejecución del método e impresión de respuesta
		System.out.println(usuario.cerrarSesion(seleccion));
	}
	
	@Override
	public String toString() {return "Cerrar sesión.";}
}