package uiMain.Funcionalidades;

import gestorAplicación.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class comprarProductos extends OpcionDeMenu { // opcion 7

	@Override
	public void ejecutar() {
		Comprador comp = (Comprador)usuario;
		String str = comp.getCarrito().comprarProductos();
		System.out.println(str);
	}

	@Override
	public String toString() {
		return "Comprar productos en el carrito";
	}

}