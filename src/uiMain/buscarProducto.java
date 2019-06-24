package uiMain;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Comprador;

class buscarProducto extends OpcionDeMenu { // opcion 2

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el código del producto: ");
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