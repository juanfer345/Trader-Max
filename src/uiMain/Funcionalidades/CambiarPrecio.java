package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicación.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class CambiarPrecio extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		System.out.println("Ingrese el nombre del producto");
		String nom = br.readLine();
		System.out.println("Ingrese el nuevo precio");
		double pre = scn.nextDouble();
		String str = Vendedor.cambiarPrecio(nom, pre);
		System.out.println(str);
		
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}

}
