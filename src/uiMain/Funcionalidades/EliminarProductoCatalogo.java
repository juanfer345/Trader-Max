package uiMain.Funcionalidades;

import java.io.IOException;
import gestorAplicaci�n.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class EliminarProductoCatalogo extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {
		System.out.println("Ingrese el c�digo del producto a eliminar ");
		int cod = Integer.parseInt(br.readLine().trim());
		Vendedor comp = (Vendedor)usuario;
		String str = comp.eliminarProductoCatalogo(cod);
		System.out.println(str);
	}

	public String toString() {
		return "Eliminar producto";
	}

}