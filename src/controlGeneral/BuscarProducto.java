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
		 Propósito: Ejecutar el metodo buscarProducto() haciendo los respectivos
		            controles de error del ingreso de datos
		            (Dependiendo del parámetro se ejecuta el método que corresponde)
		 */

		String nombreProducto;
		int idProducto;
		byte seleccion;

		// Verificación de catalogo no vacío
		if (!Cuenta.getCatalogo().isEmpty()) {
			
			//Selección por parte del usuario
			if (controlError) {System.out.println(); return;}

			//Condicional según selección
			if (seleccion == 1) {

				// Selección 1: Búsqueda del producto por código
				while (!controlError) {

					//Control del ingreso de datos
					idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto", "El dato que ingresó como código es invalido, vuelva a intentarlo");
					if (controlError) {System.out.println(); return;}

					//Búsqueda por código
					System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(idProducto));
					if (!OpcionDeMenu.controlError)
						System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
				}
			}
			else if (seleccion == 2) {
				// Selección 2: Búsqueda del producto por nombre
				while (!controlError) {

					//Control del ingreso de datos
					nombreProducto = ControlErrorDatos.controlString("Ingrese el nombre del producto", "Ha ingresado un número en lugar de texto");
					if (controlError) {System.out.println(); return;}

					//Búsqueda por nombre
					System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(nombreProducto));
					if (!OpcionDeMenu.controlError)
						System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
				}
			}
		}
		else {
			System.out.println("El catálogo se encuentra vacío.\n");
		}
	}
	
	@Override
	public String toString() {return "Buscar producto";}
}
