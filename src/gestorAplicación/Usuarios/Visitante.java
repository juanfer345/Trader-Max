package gestorAplicación.Usuarios;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Vendedor;

public class Visitante extends Cuenta {
	
	
	public HashMap <Integer,Producto> verProductos() {
		return Vendedor.catalogo;
	}
	
	/*public Deque<Producto> buscarCategoria(String cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		Iterator<Producto> it = Vendedor.catalogo.iterator();
		while (it.hasNext()) {
			Producto p = it.next();
			if (p.categoria == cat) {
				colaProd.add(p);
			}
		}
		return colaProd;
	}*/
	
	public Deque<Producto> buscarCategoria(String cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		(Vendedor.catalogo).forEach((k,v)-> {
			Producto p = Vendedor.catalogo.get(k);
			if (p.categoria == cat) {
				colaProd.add(p);}
		});
		
		return colaProd; 

	}

}
