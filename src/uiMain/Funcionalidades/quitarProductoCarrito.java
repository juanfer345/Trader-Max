package uiMain.Funcionalidades;

import gestorAplicaci�n.Usuarios.Comprador;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.*;
public class quitarProductoCarrito extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() {
		Comprador comp  = (Comprador)usuario;
		System.out.println("Ingresa el c�digo del producto: ");
		int cod = scn.nextInt();				
		String str = comp.getCarrito().quitarProducto(cod);
		System.out.println(str);
	}
	@Override
	public String toString() {
		return "Quitar Producto del carrito";
	}
}