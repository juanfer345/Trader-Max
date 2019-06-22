package uiMain;

import java.util.Deque;

import gestorAplicación.Materiales.Producto;

class buscarCategoria extends OpcionDeMenu { // opcion 3

	@Override
	public void ejecutar() {
		System.out.println("Ingrese la categoria:");
		String cat = e.next();
		Deque<Producto> categoria;
		//categoria = Comprador.buscar(cat);// la misma vaina de arriba

	}

	@Override
	public String toString() {
		return "Buscar Categoria";
	}

}