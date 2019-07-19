/*	Clase BuscarProducto (pública)        
	
	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
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
		 Propósito: Ejecutar el metodo buscarProducto() haciendo los respectivos
		            controles de error del ingreso de datos
		            (Dependiendo del parámetro se ejecuta el método que corresponde)
		 */

	    String selecc;
	    byte seleccion;
	    
	    //Guardado de mensaje principal
		sb.append("\nPor favor elija el método de búsqueda:\n");
		sb.append("1: Por código\n");
		sb.append("2: Por nombre\n");
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!controlError) {
			
			//Impresión de mensaje y recepción de datos
			System.out.print(sb);
			seleccion = esByte(br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			if (seleccion == 0) {System.out.println(); return;}
			
			if (seleccion != -1) {
				
				// Selección 1: Búsqueda del producto por código
				if (seleccion == 1) {
					while (!controlError) {
						// Ingreso de datos por parte del usuario
						System.out.print("Ingrese el código del producto => ");
						seleccion = (byte) esByte(br.readLine().trim());
						
						if (seleccion != 0) {
							if (seleccion != -1) {
								System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(seleccion));
							}
							else {
								System.out.println("\nPor favor ingrese un número entero mayor a 0.");
							}
							if (!controlError) System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
						}
						else {System.out.println(); return;}
					}
				}
				// Selección 2: Búsqueda del producto por nombre
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
								System.out.println("\nSe está ingresando un número en lugar de un nombre.");
							}
							if (!controlError) System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
						}
						else {System.out.println(); return;}
					}
				}
			}
			else {
				//Impresión de mensaje de cancelación en caso de que se haya producido un error
				System.out.println("Por favor ingrese un número entero en el rango [1,2].\n" + 
						"Nota: Se puede cancelar la operación ingresando el número '0'.");
			}
		}
	}
	
	@Override
	public String toString() {return "Buscar producto";}
}