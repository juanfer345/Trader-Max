package uiMain.Funcionalidades;

import gestorAplicación.Usuarios.Comprador;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.*;
public class QuitarProductoCarrito extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() {
		Comprador comp  = (Comprador)usuario;
		System.out.println("Ingresa el código del producto: ");
		int cod = scn.nextInt();
		System.out.println("Ingrese cantidad que desea quitar: ");
		int c = scn.nextInt();
		String str = comp.getCarrito().quitarProducto(cod, c);
		System.out.println(str);
	}
	@Override
	public String toString() {
		return "Quitar Producto del carrito";
	}
}