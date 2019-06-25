package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicación.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class cambiarPrecio extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		System.out.println("Ingrese el nombre del producto");
		String nom = br.readLine();
		System.out.println("Ingrese el nuevo precio");
		double pre = Double.parseDouble(br.readLine().trim());
		Vendedor.cambiarPrecio(nom, pre);
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}

}
