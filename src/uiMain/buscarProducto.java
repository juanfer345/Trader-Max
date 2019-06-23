package uiMain;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Comprador;

class buscarProducto extends OpcionDeMenu { // opcion 2
	Producto prod;

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el código del producto: ");
		int codigo = e.nextInt();
		prod = Comprador.buscar(codigo); 
		System.out.println("Nombre: " + prod.getNombreProducto() + "Código: " + prod.getCodigoProducto());

	}

	public String toString() {
		return "Buscar Producto";
	}

}