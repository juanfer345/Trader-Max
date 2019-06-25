package uiMain.Funcionalidades.Cuenta.Vendedor;

import java.io.IOException;

import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class SubirProducto extends OpcionDeMenu { // opcion 11

	@Override
	public void ejecutar() throws IOException {
		System.out.println("Ingrese el nombre del producto");
		String nombre = MenuDeConsola.br.readLine();
		System.out.println("Ingrese la cantidad ");
		int cant = Integer.parseInt(MenuDeConsola.br.readLine());
		System.out.println("Ingrese el precio ");
		double precio = Double.parseDouble(MenuDeConsola.br.readLine());
		//hay que esperar a que sara y juan manuel resuelvan las categorias
	}

	@Override
	public String toString() {
		return "Subir producto";
	}

}