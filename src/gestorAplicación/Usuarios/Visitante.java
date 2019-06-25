package gestorAplicación.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Vendedor;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.buscarCategoria;
import uiMain.Funcionalidades.buscarProducto;
import uiMain.Funcionalidades.iniciarSesion;
import uiMain.Funcionalidades.registrar;
import uiMain.Funcionalidades.salir;

public class Visitante extends Cuenta {
	
	
	public void setMenuPredeterminado() {
		Cuenta.menu.cambiarMenu(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new iniciarSesion(), new registrar(), 
										  new buscarProducto(), new buscarCategoria(), new salir()})), this);
	}
	
	public void setMenu(ArrayList <OpcionDeMenu> opcionesActivas) {
		Cuenta.menu.cambiarMenu(opcionesActivas, this);
	}
	
	public Visitante() {
		super();
		Cuenta.menu = new MenuDeConsola(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new iniciarSesion(), new registrar(), 
				  		new buscarProducto(), new buscarCategoria(),new salir()})), this);
	}
	
	public HashMap <Integer,Producto> verProductos() {
		return Vendedor.catalogo;
	}
	
	/*public Deque<Producto> buscarCategoria(String cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		Iterator<Producto> it = Vendedor.catalogo.iterator();
		while (it.hasNext()) {
			Producto p = it.next();
			if (p.getCategoria() == cat) {
				colaProd.add(p);
			}
		}
		return colaProd;
	}*/
	
	public static Deque<Producto> buscarCategoria(String cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		(Vendedor.catalogo).forEach((k,v)-> {
			Producto p = Vendedor.catalogo.get(k);
			if (p.getCategoria() == cat) {
				colaProd.add(p);}
		});
		
		return colaProd; 

	}

}
