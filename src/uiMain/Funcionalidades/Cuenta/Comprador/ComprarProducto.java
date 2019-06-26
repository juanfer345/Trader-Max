package uiMain.Funcionalidades.Cuenta.Comprador;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class ComprarProducto extends OpcionDeMenu { // opcion 7

	@Override
	public void ejecutar() {
		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		String str = comp.getCarrito().comprarProductos();
		System.out.println(str);
	}

	@Override
	public String toString() {
		return "Comprar productos en el carrito";
	}

}