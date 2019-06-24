package uiMain.Funcionalidades;

import java.util.Deque;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class BuscarCategoria extends OpcionDeMenu { // opcion 3

	@Override
	public void ejecutar() { //pa la logica
		Producto.getCategorias();
		System.out.println("Ingrese la posici�n de la categoria  ");
		int pos = scn.nextInt();
			if(pos>0 && pos<Producto.categorias.length) {
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