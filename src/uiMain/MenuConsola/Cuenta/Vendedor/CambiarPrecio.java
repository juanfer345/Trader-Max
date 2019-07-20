/* 
   Clase CambiarPrecio (pública, hereda de OpcionDeMenu)
   
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

public class CambiarPrecio extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		
		/*
		   Propósito: Ejecutar el método cambiarPrecio() haciendo los respectivos 
		              controles de error del ingreso de datos
		 */
		
		// Atributos
		String nom;
		long comprobNom;
		long pre;
		int cantidadDeproductos = 0;
		
		// Imprimir la lista de sus productos
		System.out.println("Sus productos en el catalogo: ");
		System.out.println();
		for (Map.Entry<Integer, Producto> entry : Vendedor.catalogo.entrySet()) {
			Producto iteradorCatalogo = entry.getValue();
			if (iteradorCatalogo.getVendedor().getId() == InicializacionAplicacion.usuarioActivo.getId()) {
				System.out.println(
						"-" + iteradorCatalogo.getNombreProducto() + "/n Precio: " + iteradorCatalogo.getPrecio());
				cantidadDeproductos++;
			}

		}
		
		// Comprobar que si tenga productos propios en el catálogo
		if (cantidadDeproductos == 0) {
			System.out.println("Usted no tiene producos en el catalogo");
			System.out.println();
			return;
		}
		System.out.println();
		System.out.println("Ingrese 0 para volver\nIngrese el nombre del producto");
		nom = br.readLine();
		comprobNom = esLong(nom); // Ver si es un número el nombre
		
		// Control de ingreso nombre
		while (comprobNom != -1) {
			// Ver si es un 0 para devolverse
			if (comprobNom == 0) {
				return; //
			} else {
				System.out.println("Ingresar un nombre valido");
				nom = br.readLine().trim();
				comprobNom = esLong(nom);
			}
		}
		System.out.println("Ingrese el nuevo precio");
		pre = esLong(br.readLine().trim());
		while (pre == -1) {
			System.out.println("Ingresar un precio valido: ");
			pre = esLong(br.readLine().trim());
		}
		
		// Ver si es un 0 para devolverse
		if (pre == 0) {
			return;
		}
		String str = Vendedor.cambiarPrecio(nom, (double) pre);
		System.out.println(str);
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}