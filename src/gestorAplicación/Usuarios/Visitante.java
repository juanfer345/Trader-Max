package gestorAplicación.Usuarios;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Vendedor;

public class Visitante extends Cuenta {
	
	
	public LinkedList<Producto> verProductos() {
		return Vendedor.catalogo;
	}
	
	public Deque<Producto> buscarCategoria(String cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		Iterator<Producto> it = Vendedor.catalogo.iterator();
		while (it.hasNext()) {
			Producto p = it.next();
			if (p.categoria == cat) {
				colaProd.add(p);
			}
		}
		return colaProd;
	}

}
