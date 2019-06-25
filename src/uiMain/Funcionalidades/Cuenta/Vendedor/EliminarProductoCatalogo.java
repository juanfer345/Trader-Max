package uiMain.Funcionalidades.Cuenta.Vendedor;

import java.io.IOException;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class EliminarProductoCatalogo extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {
		System.out.println("Ingrese el código del producto a eliminar ");
		int cod = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		Vendedor comp = (Vendedor) MenuDeConsola.usuarioActivo;
		String str = comp.eliminarProductoCatalogo(cod);
		System.out.println(str);
	}

	public String toString() {
		return "Eliminar producto";
	}

}