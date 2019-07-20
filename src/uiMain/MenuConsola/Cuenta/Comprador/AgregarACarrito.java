/*	Clase AgregarACarrito (pública)        
	
	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class AgregarACarrito extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {
		/*
		 Propósito: Ejecutar el metodo agregarACarrito() haciendo los respectivos
		            controles de error del ingreso de datos
		 */
		sb.append("\nUsted ha elegido la opcion para agregar un producto a su carrito. \n");

		controlError = false;
		String codigo, cantidad;
		int compCod, compCant;

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;

		while (true) {
			// Ingreso de datos por parte del usuario
			System.out.print(sb);
			System.out.print("\nIngrese el codigo del producto que desea agregar => ");
			codigo = br.readLine().trim();
			compCod = esInt(codigo);

			if (compCod!=0) {
				/*
					  Ciclo de control de error para el código del producto, pide un número
					 (código) hasta que sea válido (puede ingresar el 0 para salir)
				 */
				if(compCod != -1) {
					break;
				}
				else {
					System.out.print("\nEl dato que ingreso como codigo es invalido, vuelva a intentarlo.\n"+
							"\nNOTA: se puede cancelar la operación el número '0'");
				}
			}
			else {System.out.println(); return;}
		}

		while (true) {
			// Ingreso de datos por parte del usuario
			System.out.print("\nIngrese la cantidad de elementos que desea agregar => ");
			cantidad = br.readLine().trim();
			compCant = esInt(cantidad);

			if (compCod!=0) {
				/*
					  Ciclo de control de error para el código del producto, pide un número
					 (código) hasta que sea válido (puede ingresar el 0 para salir)
				 */
				if(compCod != -1) {
					break;
				}
				else {
					System.out.print("\nEl dato que ingreso como cantidad es invalido, vuelva a intentarlo.\n"+
							"\nNOTA: se puede cancelar la operación el número '0'");
				}
			}
			else {System.out.println(); return;}
		}

		//ejecución del método 
		while (!controlError) {
			// Si el usuario no quiere salir, continua el proceso
			System.out.println(comp.agregarACarrito(compCod, compCant));
			if (!controlError) {
				System.out.println("NOTA: se puede cancelar la operación el número '0'\n");
			}
		}
	}

	public String toString() {
		return "Agregar a carrito";
	}
}