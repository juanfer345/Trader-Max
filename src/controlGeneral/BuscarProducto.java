package controlGeneral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class BuscarProducto implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 Prop�sito: Ejecutar el metodo buscarProducto() haciendo los respectivos
		            controles de error del ingreso de datos
		            (Dependiendo del par�metro se ejecuta el m�todo que corresponde)
		 */

		String nombreProducto;
		int idProducto;
		byte seleccion;

		// Verificaci�n de catalogo no vac�o
		if (!Cuenta.getCatalogo().isEmpty()) {
			
			//Selecci�n por parte del usuario
			if (controlError) {System.out.println(); return;}

			//Condicional seg�n selecci�n
			if (seleccion == 1) {

				// Selecci�n 1: B�squeda del producto por c�digo
				while (!controlError) {

					//Control del ingreso de datos
					idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto", "El dato que ingres� como c�digo es invalido, vuelva a intentarlo");
					if (controlError) {System.out.println(); return;}

					//B�squeda por c�digo
					System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(idProducto));
					if (!OpcionDeMenu.controlError)
						System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
				}
			}
			else if (seleccion == 2) {
				// Selecci�n 2: B�squeda del producto por nombre
				while (!controlError) {

					//Control del ingreso de datos
					nombreProducto = ControlErrorDatos.controlString("Ingrese el nombre del producto", "Ha ingresado un n�mero en lugar de texto");
					if (controlError) {System.out.println(); return;}

					//B�squeda por nombre
					System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(nombreProducto));
					if (!OpcionDeMenu.controlError)
						System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
				}
			}
		}
		else {
			System.out.println("El cat�logo se encuentra vac�o.\n");
		}
	}
	
	@Override
	public String toString() {return "Buscar producto";}
}
