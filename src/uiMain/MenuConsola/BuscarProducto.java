/*	Clase BuscarProducto (p�blica)        
	
	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;

public class BuscarProducto extends OpcionDeMenu {

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		/*
		 Prop�sito: Ejecutar el metodo buscarProducto() haciendo los respectivos
		            controles de error del ingreso de datos
		            (Dependiendo del par�metro se ejecuta el m�todo que corresponde)
		 */

	    String selecc;
	    byte seleccion;
	    
	    //Guardado de mensaje principal
		sb.append("\nPor favor elija el m�todo de b�squeda:\n");
		sb.append("1: Por c�digo\n");
		sb.append("2: Por nombre\n");
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!controlError) {
			
			//Impresi�n de mensaje y recepci�n de datos
			System.out.print(sb);
			seleccion = esByte(br.readLine().trim());
			
			//Ejecuci�n del m�todo e impresi�n de respuesta
			if (seleccion == 0) {System.out.println(); return;}
			
			if (seleccion != -1) {
				
				// Selecci�n 1: B�squeda del producto por c�digo
				if (seleccion == 1) {
					while (!controlError) {
						// Ingreso de datos por parte del usuario
						System.out.print("Ingrese el c�digo del producto => ");
						seleccion = (byte) esByte(br.readLine().trim());
						
						if (seleccion != 0) {
							if (seleccion != -1) {
								System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(seleccion));
							}
							else {
								System.out.println("\nPor favor ingrese un n�mero entero mayor a 0.");
							}
							if (!controlError) System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
						}
						else {System.out.println(); return;}
					}
				}
				// Selecci�n 2: B�squeda del producto por nombre
				else if (seleccion == 2) {
					while (!controlError) {
						// Ingreso de datos por parte del usuario
						System.out.print("Ingrese el nombre del producto => ");
						selecc = br.readLine().trim();
						seleccion = (byte) esByte(selecc);

						if (seleccion != 0) {
							if (seleccion == -1) {
								System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(selecc));
							}
							else {
								System.out.println("\nSe est� ingresando un n�mero en lugar de un nombre.");
							}
							if (!controlError) System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
						}
						else {System.out.println(); return;}
					}
				}
			}
			else {
				//Impresi�n de mensaje de cancelaci�n en caso de que se haya producido un error
				System.out.println("Por favor ingrese un n�mero entero en el rango [1,2].\n" + 
						"Nota: Se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
		}
	}
	
	@Override
	public String toString() {return "Buscar producto";}
}