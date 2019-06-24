package uiMain.Funcionalidades;

import gestorAplicación.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class eliminarProductoCatalogo extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el código del producto a eliminar ");
		int cod = scn.nextInt();
		Vendedor comp = (Vendedor)usuario;
		String str = comp.eliminarProductoCatalogo(cod);
		System.out.println(str);
	}

	@Override
	public String toString() {
		return "Eliminar producto";
	}

}