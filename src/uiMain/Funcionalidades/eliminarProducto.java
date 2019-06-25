package uiMain.Funcionalidades;

import java.io.IOException;

import uiMain.OpcionDeMenu;

public class eliminarProducto extends OpcionDeMenu {

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		System.out.println("Ingrese el código del producto a eliminar ");
		int cod = Integer.parseInt(br.readLine().trim());
	}

	@Override
	public String toString() {
		return "Eliminar producto";
	}

}