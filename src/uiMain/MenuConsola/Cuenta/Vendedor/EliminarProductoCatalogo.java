/* 
   Clase EliminarProductoCatalogo (pública, hereda de OpcionDeMenu) 
   
   Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
              manipulando sus atributos y elementos
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
		  Propósito: Ejecutar el método eliminarProductoCatalogo() haciendo los
		             respectivos controles de error del ingreso de datos
		 */

		// Atributos
		StringBuilder sb = new StringBuilder();
		String cod;
		int comproCod;
		int cantidadDeproductos = 0;

		sb.append("\nEsta opción es para eliminar un producto del cátalogo");
		sb.append("\nRecuerde que el producto a eliminar debe ser de su propiedad");

		System.out.println("Sus productos en el catalogo: ");
		System.out.println();
		for (Map.Entry<Integer, Producto> entry : Vendedor.catalogo.entrySet()) {
			Producto iteradorCatalogo = entry.getValue();
			if (iteradorCatalogo.getVendedor().getId() == InicializacionAplicacion.usuarioActivo.getId()) {
				System.out
						.println("-" + iteradorCatalogo.getNombreProducto() + ". Codigo: " + iteradorCatalogo.getId());
				cantidadDeproductos++;
			}
		}
		if (cantidadDeproductos == 0) {
			System.out.println("Usted no tiene producos en el catalogo");
			System.out.println();
			return;
		}
		System.out.print(sb);
		while (!controlError) {

			System.out.println();
			System.out.print("Ingrese 0 para volver\nIngrese el código del producto => ");
			cod = br.readLine();
			comproCod = esInt(cod); // Ver si es un número el nombre

			// Control de ingreso código
			while (comproCod == -1) {
				System.out.print("Ingresar un codigo válido => ");
				cod = br.readLine().trim();
				comproCod = esInt(cod);
			}

			// Ver si es un 0 para devolverse
			if (comproCod == 0) {
				return;
				
			} else { // Si el usuario no quiere salir, continua el proceso
				// Analiza el codigo introducido para eliminar producto
				Vendedor comp = (Vendedor) InicializacionAplicacion.usuarioActivo;
				String str = comp.eliminarProductoCatalogo(comproCod);

				if (str.equals("No existe el producto con ese código, ingrese un código correcto")
						|| str.equals("No es un producto propio, no puede ser eliminado")) {
					System.out.println("\n" + str);
					System.out.println("Repita el proceso con datos correctos");
				} else {
					System.out.println("\n" + str + "\n");
					controlError = true;
				}
			}
		}
	}

	public String toString() {
		return "Eliminar producto";
	}
}