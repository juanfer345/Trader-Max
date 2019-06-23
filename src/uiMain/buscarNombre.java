package uiMain;

import java.util.Deque;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Comprador;

class buscarNombre extends OpcionDeMenu { // opcion 3

	@Override
	public void ejecutar() {
		System.out.println("Ingrese la categoria:");
		String nom = e.next();
		Deque<Producto> nombre;
		nombre = Comprador.buscar(nom);
		for (int i = 0; i < nombre.size(); i++) {
			Producto prod = nombre.poll();
			System.out.println(i+"Nombre: "+prod.getNombreProducto()+"\nPrecio: "+prod.getPrecio()+"\nCodigo: "+prod.getCodigoProducto());
		}

	}

	@Override
	public String toString() {
		return "Buscar Categoria";
	}

}