/* 
   Clase CambiarPrecio (pública, hereda de OpcionDeMenu) 
   
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

public class CambiarPrecio extends OpcionDeMenu {

	public void ejecutar() throws IOException {

		/*
		 * Propósito: Ejecutar el método cambiarPrecio() haciendo los respectivos
		 * controles de error del ingreso de datos
		 */

		sb.append("\nEsta opción es para cambiar el precio de un producto del catálogo");
		sb.append("\nRecuerde que el producto a eliminar debe ser de su propiedad \n");

		// Atributos
		String nom;
		long comprobNom;
		long pre;
		int cantidadDeproductos = 0;

		System.out.println(sb);

		// Imprimir la lista de sus productos
		System.out.println("Sus productos en el catalogo: ");
		System.out.println();
		for (Map.Entry<Integer, Producto> entry : Vendedor.catalogo.entrySet()) {
			Producto iteradorCatalogo = entry.getValue();
			if (iteradorCatalogo.getVendedor().getId() == InicializacionAplicacion.usuarioActivo.getId()) {
				System.out.println(
						"- " + iteradorCatalogo.getNombreProducto() + ". Precio: " + iteradorCatalogo.getPrecio());
				cantidadDeproductos++;
			}
		}

		// Comprobar que si tenga productos propios en el catálogo
		if (cantidadDeproductos == 0) {
			System.out.println("Usted no tiene producos en el catalogo");
			System.out.println();
			return;
		}

		while (!controlError) {

			System.out.println();
			System.out.print("Ingrese 0 para volver\nIngrese el nombre del producto => ");
			nom = br.readLine();
			comprobNom = esLong(nom); // Ver si es un número el nombre

			// Control de ingreso nombre
			while (comprobNom != -1) {
				// Ver si es un 0 para devolverse
				if (comprobNom == 0) {
					controlError = true;
				} else {
					System.out.print("Ingresar un nombre valido => ");
					nom = br.readLine().trim();
					comprobNom = esLong(nom);
				}
			}
			System.out.print("Ingrese el nuevo precio => ");
			pre = esLong(br.readLine().trim());
			while (pre == -1) {
				System.out.print("Ingresar un precio valido => ");
				pre = esLong(br.readLine().trim());
			}

			// Ver si es un 0 para devolverse
			if (pre == 0) {
				controlError = true;
			} else {
				String str = Vendedor.cambiarPrecio(nom, (double) pre);
				if (str.equals("El producto no existe, no se puede cambiar el precio") 
						|| str.equals("El precio debe ser mayor a cero")) {
					System.out.println("\n" + str);
				}else {
					System.out.println("\n" + str);
					controlError = true;
				}
			}
		}
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}