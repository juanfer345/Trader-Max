package uiMain;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Usuarios.Comprador;

class buscarProducto extends OpcionDeMenu { // opcion 2
	Producto prod;

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el c�digo del producto: ");
		int codigo = e.nextInt();
		prod = Comprador.buscar(codigo); 
		System.out.println("Nombre: " + prod.getNombreProducto() + "C�digo: " + prod.getCodigoProducto());

	}

	public String toString() {
		return "Buscar Producto";
	}

}