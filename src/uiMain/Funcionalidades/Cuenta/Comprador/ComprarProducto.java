package uiMain.Funcionalidades.Cuenta.Comprador;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class ComprarProducto extends OpcionDeMenu { // opcion 7

	@Override
	public void ejecutar() throws NumberFormatException, IOException {

		StringBuilder sb = new StringBuilder();

		sb.append("\n Usted ha elegido la opcion para comprar los productos de su carrito");
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
				} else if(opcion == 1) {
					Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
					System.out.println("Su carrito tiene " + comp.getCarrito().getTotalproductos() + " productos ");
					System.out.println("El costo total es: " + comp.getCarrito().getPrecioTotal());
					System.out.println("Su saldo actual es: " + comp.getCuentaBancaria().getSaldo());
					String str = comp.getCarrito().comprarProductos();
					System.out.println(str);
					OpcionDeMenu.controlError = true;
				}else {
					System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo");
				}
			}

			catch (NumberFormatException nfe) {
				//Por si se ingresa un tipo de dato diferente
				System.out.println("\n El dato que ingreso es invalido ");
			}

		}

	}

	@Override
	public String toString() {
		return "Comprar productos en el carrito";
	}

}