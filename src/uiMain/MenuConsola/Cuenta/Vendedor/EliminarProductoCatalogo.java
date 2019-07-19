/* 
   Clase EliminarProductoCatalogo (pública, hereda de OpcionDeMenu)
   
   Propósito:
   Opción de menú del usuario, le permite realizar acciones en el programa 
   manipulando sus atributos y elementos
   
   Estructuras de datos relevantes:
 */

package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class EliminarProductoCatalogo extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {
		
		/*
		   Propósito: Ejecutar el método eliminarProductoCatalogo() haciendo los respectivos 
		              controles de error del ingreso de datos
		 */

		// Atributos
		StringBuilder sb = new StringBuilder();
		int cod;
		int cantidadDeproductos = 0;

		sb.append("\n Esta opción es para eliminar un producto de tu catalogo");
		sb.append("\n Recuerde que el producto a eliminar debe ser de su propiedad");
		sb.append("\n Para devolverse al menú anterior, ingrese el número '0' /n");
		sb.append("\n Ingrese el código del producto a eliminar o el número '0': ");

		System.out.println("Sus productos en el catalogo: ");
		System.out.println();
		for (Map.Entry<Integer, Producto> entry : Vendedor.catalogo.entrySet()) {
			Producto iteradorCatalogo = entry.getValue();
			if (iteradorCatalogo.getVendedor().getId() == InicializacionAplicacion.usuarioActivo.getId()) {
				System.out
						.println("-" + iteradorCatalogo.getNombreProducto() + "/n Codigo: " + iteradorCatalogo.getId());
				cantidadDeproductos++;
			}

		}
		if (cantidadDeproductos == 0) {
			System.out.println("Usted no tiene producos en el catalogo");
			System.out.println();
			return;
		} else {

			while (!controlError) {

				System.out.print(sb);

				try {
					cod = Integer.parseInt(br.readLine().trim()); // Puede que se genere un error (depende del dato)

					// Apartir de aquí no se generan errores
					if (cod == 0) { // Por si se quiere salir el usuario
						controlError = true;
					} else {
						// Si el usuario no quiere salir, continua el proceso
						// Analiza el codigo introducido para eliminar producto
						Vendedor comp = (Vendedor) InicializacionAplicacion.usuarioActivo;
						String str = comp.eliminarProductoCatalogo(cod);

						if (str.equals("No existe el producto")
								|| str.equals("No es un producto propio, no puede ser eliminado")) {
							System.out.println(str);
						} else {
							System.out.println(str + "/n");
							controlError = true;
						}

					}

				} catch (NumberFormatException nfe) {
					System.out.println("\n El codigo que ingreso es invalido");
				}
			}
		}
	}

	public String toString() {
		return "Eliminar producto";
	}
}