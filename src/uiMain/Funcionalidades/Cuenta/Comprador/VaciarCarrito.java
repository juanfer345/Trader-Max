package uiMain.Funcionalidades.Cuenta.Comprador;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class VaciarCarrito extends OpcionDeMenu { // opcion 8

	@Override
	public void ejecutar() {
		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		String str = comp.getCarrito().vaciarCarrito();
		System.out.println(str);
	}

	@Override
	public String toString() {
		return "Vaciar carrito";
	}
}