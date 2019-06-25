package uiMain.Funcionalidades;

import java.io.IOException;
import java.util.Deque;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class buscarCategoria extends OpcionDeMenu { // opcion 3

	@Override
	public void ejecutar() throws IOException {
		System.out.println("Ingrese la categoria: ");
		String nom = br.readLine().trim();
		boolean aux = Producto.existeCategoria(nom);
		if(aux == true) {
			Deque<Producto> cola;
			cola = Comprador.buscar(nom);
			for (int i = 0; i < cola.size(); i++) {
				Producto prod = cola.poll();
				System.out.println(prod);
			}
		} else {
			System.out.println("Categoria invalida");
		}
	}

	@Override
	public String toString() {
		return "Buscar Categoria";
	}

}