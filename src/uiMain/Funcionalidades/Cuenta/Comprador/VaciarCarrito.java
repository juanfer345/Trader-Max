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

		int opcion;
		OpcionDeMenu.controlError = false;

		while (!OpcionDeMenu.controlError) {

			System.out.println(sb);

			try {
				opcion = Integer.parseInt(br.readLine().trim());
				
				if (opcion == 0) {
					OpcionDeMenu.controlError = true;
				} else if (opcion == 1) {
					Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
					System.out.println("Su carrito tiene " + comp.getCarrito().getTotalproductos() + " productos ");
					String str = comp.getCarrito().vaciarCarrito();
					System.out.println(str);
					OpcionDeMenu.controlError = true;
				}else {
					System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo");
				}
				
			} catch (NumberFormatException nfe) {
				// Por si se ingresa un tipo de dato diferente
				System.out.println("\n El dato que ingreso es invalido ");
			}

		}
	}

	@Override
	public String toString() {
		return "Vaciar carrito";
	}
}