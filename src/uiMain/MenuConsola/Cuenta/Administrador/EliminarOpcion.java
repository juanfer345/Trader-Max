package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.ControlErrorDatos;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class EliminarOpcion extends OpcionDeMenu  {
	
	public void ejecutar() throws NumberFormatException, IOException {
		
		Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
		String menuOpcionesDisponibles;
		int idUsuario = 0;
		byte tipoDeCuenta = 0, opcionUsuario = 0;

	    //Guardado de mensaje principal
		System.out.println();
		sb.append("Elija el tipo de cuenta a la cual se le desea agregar la opci�n\n");
		sb.append("1: Comprador.\n");
		sb.append("2: Vendedor.\n");
		sb.append("=> ");

		//Control de ingreso tipo de usuario
		tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un n�mero entero");
		if (controlError) {System.out.println(); return;}

		//Control de ingreso de identificaci�n de usuario
		idUsuario = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Por favor ingrese el n�mero identificador del usuario", "El identificador del usuario debe ser un n�mero entero");
		if (controlError) {System.out.println(); return;}

		//Guardado de las opciones disponibles a agregar
		menuOpcionesDisponibles = usuario.getMenuDeConsola().comprobarCantidadOpciones(idUsuario, tipoDeCuenta, (byte) 2);

		//Agregado de la opci�n seleccionada
		while (!controlError) {

			System.out.println(menuOpcionesDisponibles);

			//Elecci�n de la opci�n por parte del usuario
			opcionUsuario = ControlErrorDatos.controlByte((byte) 1, MenuDeConsola.getsizeOpcionesComp(), 
					"Ingrese el indice de la opci�n que desea agregar \n", "Por favor ingrese un n�mero entero");
			if (controlError) {System.out.println(); return;}

			//Ejecuci�n del m�todo principal
			System.out.println(usuario.getMenuDeConsola().eliminarOpcion(idUsuario, tipoDeCuenta, (byte) (opcionUsuario - 1)));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
		}
	}
	
	@Override
	public String toString() {return "Eliminar opci�n de men�";}
}