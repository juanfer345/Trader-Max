package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class QuitarProductoCarrito extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() throws NumberFormatException, IOException {

		sb.append("\n Para devolverse al menú, ingrese el numero '0'");
		sb.append("\n Si alguno de los 2 datos ingresados es '0', se saldrá de esta opcion");

		controlError = false;
		String codigo, cantidad;
		int compCod, compCant;

		while (!controlError) {

			System.out.println(sb);
			System.out.println("Ingrese el codigo del producto que desea eliminar: ");
			codigo = br.readLine().trim();
			compCod = esInt(codigo);
			System.out.println("Ingrese la cantidad de elementos que desea quitar: ");
			cantidad = br.readLine().trim();
			compCant = esInt(cantidad);

			while (compCod == -1) {
				System.out.println("El dato que ingreso como codigo es invalido, vuelva a intentarlo");
				System.out.println("Ingrese el codigo del producto que desea eliminar: ");
				codigo = br.readLine().trim();
				compCod = esInt(codigo);
			}
			while (compCant == -1) {
				System.out.println("El dato que ingreso como cantidad es invalido, vuelva a intentarlo");
				System.out.println("Ingrese la cantidad de elementos que desea quitar: ");
				cantidad = br.readLine().trim();
				compCant = esInt(cantidad);
			}
			if (compCod == 0 || compCant == 0) {
				// ver si alguna de las dos es 0 para devolverse
				controlError = true;
			} else {
				// Si el usuario no quiere salir, continua el proceso
				Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
				String str = comp.getCarrito().quitarProducto(compCod, compCant);

				if (str.equals("La cantidad ingresada excede la existente")
						|| str.equals("El producto no está en el carrito")
						|| str.equals("La cantidad ingresada debe ser mayor a cero")) {
					System.out.println(str);
					System.out.println("Repita el proceso con datos correctos");
					// Aquí vuelve al inicio, hace de nuevo el control :)
				} else {
					System.out.println(str);
					controlError = true;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Quitar producto del carrito";
	}
}