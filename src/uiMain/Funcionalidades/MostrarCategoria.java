package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class MostrarCategoria extends OpcionDeMenu { // opcion 3

	@Override
	public void ejecutar() throws NumberFormatException, IOException { //pa la logica
		Producto.getCategorias();
		System.out.println("Ingrese la posición de la categoria  ");
		int pos = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		if (pos>0 && pos<Producto.categorias.length) {
				Comprador.buscarCategoria(pos);
		} else {
			System.out.println("Categoria invalida");
		}
	}

	@Override
	public String toString() {
		return "Buscar Categoria";
	}

}