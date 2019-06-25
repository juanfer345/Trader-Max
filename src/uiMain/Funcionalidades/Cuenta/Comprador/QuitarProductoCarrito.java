package uiMain.Funcionalidades.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.Usuarios.Comprador;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class QuitarProductoCarrito extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		Comprador comp = (Comprador) MenuDeConsola.usuarioActivo;
		System.out.println("Ingresa el código del producto: ");
		int cod = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		System.out.println("Ingrese cantidad que desea quitar: ");
		int c = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		String str = comp.getCarrito().quitarProducto(cod, c);
		System.out.println(str);
	}
	@Override
	public String toString() {
		return "Quitar Producto del carrito";
	}
}