package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarUsuario extends OpcionDeMenu {
	public void ejecutar() throws NumberFormatException, IOException {
		
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
	    int idCuenta;
	    byte tipoDeCuenta;

	    //Guardado de mensaje principal
		sb.append("\nPor favor elija su tipo de usuario:\n");
		sb.append("1: Comprador\n");
		sb.append("2: Vendedor\n");
		sb.append("3: Administrador\n");
		sb.append("=> ");

	    while (!controlError) {
		    //Control de ingreso tipo de usuario
			tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un número entero positivo");
			if (controlError) {System.out.println(); return;}
			
		    //Control de ingreso de identificación de usuario
		    idCuenta = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "ID de usuario", "Por favor ingrese un número entero positivo");
			if (controlError) {System.out.println(); return;}
			
			//Ejecución del método
			System.out.println(usuario.mostrarUsuario(idCuenta, tipoDeCuenta));
	    }
	}
	
	@Override
	public String toString() {return "Mostrar información de usuario";}
}