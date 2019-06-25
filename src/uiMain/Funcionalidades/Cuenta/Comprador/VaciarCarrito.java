package uiMain.Funcionalidades.Cuenta.Comprador;

import gestorAplicacion.Usuarios.Comprador;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class VaciarCarrito extends OpcionDeMenu { // opcion 8

	@Override
	public void ejecutar() {
		Comprador comp = (Comprador) MenuDeConsola.usuarioActivo;
		String str = comp.getCarrito().vaciarCarrito();
		System.out.println(str);
	}

	@Override
	public String toString() {
		return "Vaciar carrito";
	}
}