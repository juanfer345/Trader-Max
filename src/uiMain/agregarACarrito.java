package uiMain;

import gestorAplicación.Usuarios.Vendedor;

class agregarACarrito extends OpcionDeMenu { // opcion 4

	@Override
	public void ejecutar() {
		for (int i = 0; i < Vendedor.catalogo.size(); i++) {

		}
		System.out.println("Ingrese el código del producto a agregar");

	}

	@Override
	public String toString() {
		return "Agregar a Carrito";
	}

}