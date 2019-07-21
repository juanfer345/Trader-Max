/*	Clase Salir(p�blica)        
	
	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class Salir extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		/*
		 Prop�sito: Ejecutar el metodo Salir() haciendo los respectivos
		            controles de error del ingreso de datos
		 */
	    byte seleccion;
	    
	    //Guardado de mensaje principal
	    sb.append("\n�Est� seguro que desea salir de la aplicaci�n?\n");
		sb.append("1: Si.\n");
		sb.append("2: No.\n");
		
	    //Ingreso de valores y control de error
		System.out.print(sb);
		seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
		if (controlError) {System.out.println(); return;}
		
		//Ejecuci�n del m�todo e impresi�n de respuesta
		System.out.println(InicializacionAplicacion.usuarioActivo.salir(seleccion));
	}
	
	@Override
	public String toString() {return "Salir. ";}
}