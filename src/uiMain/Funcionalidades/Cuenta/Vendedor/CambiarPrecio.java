package uiMain.Funcionalidades.Cuenta.Vendedor;

import java.io.IOException;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class CambiarPrecio extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		System.out.println("Ingrese el nombre del producto");
		String nom = MenuDeConsola.br.readLine();
		System.out.println("Ingrese el nuevo precio");
		double pre = Double.parseDouble(MenuDeConsola.br.readLine().trim());
		String str = Vendedor.cambiarPrecio(nom, pre);
		System.out.println(str);
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}