/*	Clase Salir(pública)        
	
	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;

public class Salir extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		/*
		 Propósito: Ejecutar el metodo Salir() haciendo los respectivos
		            controles de error del ingreso de datos
		 */
	    byte seleccion;
	    
	    //Guardado de mensaje principal
	    sb.append("\nEstá seguro que desea salir de la aplicación?\n");
		sb.append("1: Si\n");
		sb.append("2: No\n");
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!controlError) {
			
		    //Ingreso de valores y control de error de ingreso de valores no numéricos 
			System.out.print(sb);
			seleccion = esByte(br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			System.out.println(InicializacionAplicacion.usuarioActivo.salir(seleccion));
		}
	}
	
	@Override
	public String toString() {return "Salir";}
}