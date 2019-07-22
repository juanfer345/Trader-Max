/*	Clase MostrarCatalogo (pública)        

	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
 */
package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class MostrarCatalogo extends OpcionDeMenu {
	// Recorre toda la tabla Hash mostrando los productos

	@Override
	public void ejecutar() throws IOException {
		/*
		 Propósito: Ejecutar el método mostrarCatalogo() haciendo los respectivos
		            controles de error del ingreso de datos
		 */
		
		sb.append("\nUsted ha elegido la opción para mostrar el catálogo de productos. ¿Qué desea hacer?");
		sb.append("\n0. Volver al menú y cancelar el proceso. ");
		sb.append("\n1. Continuar con el proceso. ");

		if (!Cuenta.getCatalogo().isEmpty()) {
			
			//Selección por parte del usuario
			ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "Por favor ingrese un número entero");
			if (controlError) {System.out.println(); return;}
			
			System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
		}
		else {
			System.out.println("El catálogo se encuentra vacío.\n");
		}
	}

	@Override
	public String toString() {return "Mostrar todos los productos";}
}