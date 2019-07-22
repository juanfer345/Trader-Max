/*	Clase MostrarCatalogo (p�blica)        

	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
		 Prop�sito: Ejecutar el m�todo mostrarCatalogo() haciendo los respectivos
		            controles de error del ingreso de datos
		 */
		
		sb.append("\nUsted ha elegido la opci�n para mostrar el cat�logo de productos. �Qu� desea hacer?");
		sb.append("\n0. Volver al men� y cancelar el proceso. ");
		sb.append("\n1. Continuar con el proceso. ");

		if (!Cuenta.getCatalogo().isEmpty()) {
			
			//Selecci�n por parte del usuario
			ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "Por favor ingrese un n�mero entero");
			if (controlError) {System.out.println(); return;}
			
			System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
		}
		else {
			System.out.println("El cat�logo se encuentra vac�o.\n");
		}
	}

	@Override
	public String toString() {return "Mostrar todos los productos";}
}