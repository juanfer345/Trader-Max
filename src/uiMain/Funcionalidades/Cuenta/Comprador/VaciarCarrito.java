package uiMain.Funcionalidades.Cuenta.Comprador;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class VaciarCarrito extends OpcionDeMenu { // opcion 8

	@Override
	public void ejecutar() throws IOException {

		sb.append("\n Usted ha elegido la opcion para vaciar su carrito de compras");
		sb.append("\n Para regresar y cancelar el proceso ingrese el '0'");
		sb.append("\n Para continuar con el proceso ingrese '1'");

		controlError = false;
		String opcion;
		int comprobOpc;

		while (!controlError) {

			System.out.println(sb);
			opcion = br.readLine().trim();
			comprobOpc = (int) MenuDeConsola.esNumeroEntero(opcion);

			while (comprobOpc == -1) {
				System.out.println("El dato que ingreso es invalido, vuelva a intentarlo");
				opcion = br.readLine().trim();
				comprobOpc = (int) MenuDeConsola.esNumeroEntero(opcion);
			}
			if (comprobOpc == 0) {
				// ver si es un 0 para devolverse
				controlError = true;
			} else if (comprobOpc == 1) {
				Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
				System.out.println("Su carrito tiene " + comp.getCarrito().getTotalproductos() + " productos ");
				String str = comp.getCarrito().vaciarCarrito();
				System.out.println(str);
				controlError = true;
			} else {
				/*
				 * Si ingresa un numero diferente pero no es ninguna de las disponibles debe
				 * empezar de nuevo (Empezara de nuevo el control)
				 */
				System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo");
			}
		}
	}

	@Override
	public String toString() {
		return "Vaciar carrito";
	}
}