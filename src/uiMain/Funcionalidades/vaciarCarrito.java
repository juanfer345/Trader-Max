package uiMain.Funcionalidades;

import gestorAplicación.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class vaciarCarrito extends OpcionDeMenu { // opcion 8

	@Override
	public void ejecutar() {
		Comprador comp = (Comprador)usuario;
		String str = comp.getCarrito().vaciarCarrito();
		System.out.println(str);
	}

	@Override
	public String toString() {
		return "Vaciar carrito";
	}
}