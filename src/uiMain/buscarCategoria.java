package uiMain;

import java.util.Deque;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Usuarios.Comprador;

class buscarCategoria extends OpcionDeMenu { // opcion 3

	@Override
	public void ejecutar() {
		System.out.println("Ingrese la categoria:");
		String cat = e.next();
		Deque<Producto> categoria;
		categoria = Comprador.buscar(cat);

	}

	@Override
	public String toString() {
		return "Buscar Categoria";
	}

}