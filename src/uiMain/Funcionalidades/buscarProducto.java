package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class buscarProducto extends OpcionDeMenu { // opcion 2

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		System.out.println("Ingrese el c�digo del producto: ");
		int codigo = Integer.parseInt(br.readLine().trim());
		Producto prod;
		prod = Comprador.buscar(codigo); 
		if(prod != null) {
			System.out.println(prod);
		} else {
			System.out.println("Producto no encontrado");
		}
	}

	public String toString() {
		return "Buscar Producto";
	}

}