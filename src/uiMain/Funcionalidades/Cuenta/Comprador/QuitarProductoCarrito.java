package uiMain.Funcionalidades.Cuenta.Comprador;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class QuitarProductoCarrito extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() throws NumberFormatException, IOException {

		System.out.println("\nUsted ha elegido la opcion para quitar un producto de su carrito. ");

		controlError = false;
		String codigo, cantidad;
		int compCod, compCant;

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		if (!comp.getCarrito().productos.isEmpty()) {
			
			sb.append("\nNOTA: se puede cancelar la operación ingresando en cualquiera de los dos datos el número '0'");

			while (!controlError) {
				System.out.println(sb);
				System.out.print("\nIngrese el codigo del producto que desea eliminar => ");
				codigo = br.readLine().trim();
				compCod = MenuDeConsola.esInt(codigo);
				System.out.print("\nIngrese la cantidad de elementos que desea quitar => ");
				cantidad = br.readLine().trim();
				compCant = (int) MenuDeConsola.esInt(cantidad);

				while (compCod == -1) {
					System.out.println("\nEl dato que ingreso como codigo es invalido, vuelva a intentarlo.");
					System.out.print("Ingrese el codigo del producto que desea eliminar => ");
					codigo = br.readLine().trim();
					compCod = (int) MenuDeConsola.esInt(codigo);
				}
				while (compCant == -1) {
					System.out.println("\nEl dato que ingreso como cantidad es invalido, vuelva a intentarlo.");
					System.out.print("Ingrese la cantidad de elementos que desea quitar => ");
					cantidad = br.readLine().trim();
					compCant = (int) MenuDeConsola.esInt(cantidad);
				}
				if (compCod == 0 || compCant == 0) {
					// ver si alguna de las dos es 0 para devolverse
					controlError = true;
					System.out.println(" ");
				} else {
					// Si el usuario no quiere salir, continua el proceso
					String str = comp.getCarrito().quitarProducto(compCod, compCant);

					if (str.equals("La cantidad ingresada excede la existente")
							|| str.equals("El producto no está en el carrito")
							|| str.equals("Tanto la cantidad como el codigo ingresado deben ser mayor a cero")) {
						System.out.println("\n" + str);
						System.out.println("Repita el proceso con datos correctos");
						// Aquí vuelve al inicio, hace de nuevo el control :)
					} else {
						System.out.println("\n" + str + "\n");
						controlError = true;
					}
				}
			}
		} else {
			System.out.println("Su carrito de compras esta vacio, no puede quitar productos. \n");
			controlError = true;
		}

	}

	@Override
	public String toString() {
		return "Quitar producto del carrito";
	}
}