/*	Clase AgregarACarrito (pública)        
	
	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola.Cuenta.Comprador;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.*;
import java.io.IOException;

public class AgregarACarrito extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {
		/*
		 Propósito: Ejecutar el metodo agregarACarrito() haciendo los respectivos
		            controles de error del ingreso de datos
		 */
		System.out.println("\nUsted ha elegido la opcion para agregar un producto a su carrito. ");

		controlError = false;
		String codigo, cantidad;
		int compCod, compCant;

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		if (!Cuenta.catalogo.isEmpty()) {
			// Debe verificar primero si el catálogo está vacío

			sb.append("\nNOTA: se puede cancelar la operación ingresando en cualquiera de los dos datos el número '0'");

			while (!controlError) {

				// Ingreso de datos por parte del usuario
				System.out.println(sb);
				System.out.print("\nIngrese el codigo del producto que desea agregar => ");
				codigo = br.readLine().trim();
				compCod = esInt(codigo);
				System.out.print("\nIngrese la cantidad de elementos que desea agregar => ");
				cantidad = br.readLine().trim();
				compCant = esInt(cantidad);
				/*
				  Ciclo de control de error para el código del producto, pide un número
				 (código) hasta que sea válido (puede ingresar el 0 para salir)
				 */
				while (compCod == -1) {
					System.out.println("\nEl dato que ingreso como codigo es invalido, vuelva a intentarlo.");
					System.out.print("Ingrese el codigo del producto que desea eliminar => ");
					codigo = br.readLine().trim();
					compCod = esInt(codigo);
				}
				/*
				 Ciclo de control de error para la cantidad del producto, pide un número
				 (cantidad) hasta que sea válido (puede ingresar el 0 para salir)
				*/
				while (compCant == -1) {
					System.out.println("\nEl dato que ingreso como cantidad es invalido, vuelva a intentarlo.");
					System.out.print("Ingrese la cantidad de elementos que desea quitar => ");
					cantidad = br.readLine().trim();
					compCant = esInt(cantidad);
				}

				// Verifica si alguno es cero para salirse de la opcion
				if (compCod == 0 || compCant == 0) {
					controlError = true;
					System.out.println(" ");
				} else {
					// Si el usuario no quiere salir, continua el proceso
					String str = comp.agregarACarrito(compCod, compCant);

					// Si el usuario tuvo otros errores en el ingreso de los datos le permite repetir el proceso
					if (str.equals("La cantidad ingresada es mayor a la existente en el catálogo.")
							|| str.equals("El producto no existe, código inválido.")
							|| str.equals("Tanto la cantidad como el codigo ingresado deben ser mayor a cero.")) {
						System.out.println("\n" + str);
						System.out.println("Repita el proceso con datos correctos");
						// Aquí vuelve al inicio, hace de nuevo el control :)
					} else {
						// Cuando el proceso es exitoso, imprime y vuelve al menú
						System.out.println("\n" + str + "\n");
						controlError = true;
					}
				}
			}
		} else {
			System.out.println("El catalogo está vacío, no puede agregar productos");
			controlError = true;
		}

	}

	public String toString() {
		return "Agregar a carrito";
	}
}