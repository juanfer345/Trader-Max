/*	Clase QuitarProductoCarrito (pública)        
	
	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class QuitarProductoCarrito extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		/*
		 Propósito: Ejecutar el metodo quitarProducto() haciendo los respectivos 
		            controles de error del ingreso de datos
		*/
		System.out.println("\nUsted ha elegido la opción para quitar un producto de su carrito. ");

		controlError = false;
		String codigo, cantidad;
		int compCod, compCant;

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		if (!comp.getCarrito().getProductos().isEmpty()) {
			// Primero se mira si el carrito está vacio

			sb.append("\nNOTA: se puede cancelar la operación ingresando en cualquiera de los dos datos el número '0'");

			while (!controlError) {
				
				// Ingreso de datos por parte del usuario
				System.out.println(sb);
				System.out.print("\nIngrese el codigo del producto que desea eliminar \n=> ");
				codigo = br.readLine().trim();
				compCod = esInt(codigo);
				System.out.print("\nIngrese la cantidad de elementos que desea quitar \n=> ");
				cantidad = br.readLine().trim();
				compCant = esInt(cantidad);

				/*
				  Ciclo de control de error para el código del producto, pide un número
				 (código) hasta que sea válido (puede ingresar el 0 para salir)
				*/
				while (compCod == -1) {
					System.out.println("\nEl dato que ingresó como código es inválido, vuelva a intentarlo.");
					System.out.print("Ingrese el código del producto que desea eliminar \n=> ");
					codigo = br.readLine().trim();
					compCod = esInt(codigo);
				}
				
				/*
				 Ciclo de control de error para la cantidad del producto, pide un número
				 (cantidad) hasta que sea válido (puede ingresar el 0 para salir)
				*/
				while (compCant == -1) {
					System.out.println("\nEl dato que ingresó como cantidad es inválido, vuelva a intentarlo.");
					System.out.print("Ingrese la cantidad de elementos que desea quitar \n=> ");
					cantidad = br.readLine().trim();
					compCant = esInt(cantidad);
				}
				
				// Verifica si alguno es cero para salirse de la opcion
				if (compCod == 0 || compCant == 0) {
					controlError = true;
					System.out.println(" ");
				} else {
					// Si el usuario no quiere salir, continua el proceso
					String str = comp.getCarrito().quitarProducto(compCod, compCant);

					// Si el usuario tuvo otros errores en el ingreso de los datos le permite repetir el proceso
					if (str.equals("La cantidad ingresada excede la existente.")
							|| str.equals("El producto no está en el carrito.")
							|| str.equals("Tanto la cantidad como el código ingresados deben ser mayores a cero.")) {
						System.out.println("\n" + str);
						System.out.println("Repita el proceso con datos correctos.");
						// Aquí vuelve al inicio, hace de nuevo el control :)
					} else {
						// Cuando el proceso es exitoso, imprime y vuelve al menú
						System.out.println("\n" + str + "\n");
						controlError = true;
					}
				}
			}
		} else {
			System.out.println("Su carrito de compras esta vacío, no puede quitar productos. \n");
			controlError = true;
		}

	}

	@Override
	public String toString() {
		return "Quitar producto del carrito";
	}
}