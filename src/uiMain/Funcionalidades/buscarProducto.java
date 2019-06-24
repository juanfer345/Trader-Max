package uiMain.Funcionalidades;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class buscarProducto extends OpcionDeMenu { // opcion 2

	@Override
	public void ejecutar() { //pa la logica
		System.out.println("Ingrese el c�digo del producto: ");
		int codigo = scn.nextInt();
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