package uiMain.Funcionalidades.Cuenta.Vendedor;

import java.io.IOException;

import gestorAplicacion.Usuarios.Vendedor;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class AumentarCantidad extends OpcionDeMenu{

	public void ejecutar() throws IOException {
		System.out.println("Ingrese el nombre del producto: ");
		String nombre = MenuDeConsola.br.readLine();
		System.out.println("Ingrese la cantidad a agregar: ");
		int cantidad = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		String str = Vendedor.aumentarCantidad(nombre, cantidad);
		System.out.println(str);
	}

	public String toString() {
		return "Aumentar cantidad de producto";
	}

}
