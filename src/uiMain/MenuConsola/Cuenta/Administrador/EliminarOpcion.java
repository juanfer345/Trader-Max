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
		sb.append("Elija el tipo de cuenta a la cual se le desea agregar la opción\n");
		sb.append("1: Comprador.\n");
		sb.append("2: Vendedor.\n");
		sb.append("=> ");

		//Control de ingreso tipo de usuario
		tipoDeCuenta = ControlErrorDatos.controlByte((byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un número entero");
		if (controlError) {System.out.println(); return;}

		//Control de ingreso de identificación de usuario
		idUsuario = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Por favor ingrese el número identificador del usuario", "El identificador del usuario debe ser un número entero");
		if (controlError) {System.out.println(); return;}

		//Guardado de las opciones disponibles a agregar
		menuOpcionesDisponibles = usuario.getMenuDeConsola().comprobarCantidadOpciones(idUsuario, tipoDeCuenta, (byte) 2);

		//Agregado de la opción seleccionada
		while (!controlError) {

			System.out.println(menuOpcionesDisponibles);

			//Elección de la opción por parte del usuario
			opcionUsuario = ControlErrorDatos.controlByte((byte) 1, MenuDeConsola.getsizeOpcionesComp(), 
					"Ingrese el indice de la opción que desea agregar \n", "Por favor ingrese un número entero");
			if (controlError) {System.out.println(); return;}

			//Ejecución del método principal
			System.out.println(usuario.getMenuDeConsola().eliminarOpcion(idUsuario, tipoDeCuenta, (byte) (opcionUsuario - 1)));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
		}
	}
	
	@Override
	public String toString() {return "Eliminar opción de menú";}
}