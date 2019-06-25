package gestorAplicación.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import gestorAplicación.Materiales.Producto;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.*;

public class Vendedor extends CuentaUsuario {
	

	public void setMenu() {
		new MenuDeConsola(new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] {new iniciarSesion(), new registrar(), new buscarProducto(),
														  			new buscarCategoria(),new salir()})), this);
	}
	
	public void setMenuPredeterminado() {
		Cuenta.menu.cambiarMenu(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new subirProducto(), new eliminarProducto(), 
										  new cerrarSesion(), new salir()})), this);
	}
	
	public void setMenu(ArrayList <OpcionDeMenu> opcionesActivas) {
		Cuenta.menu.cambiarMenu(opcionesActivas, this);
	}
	
	public Vendedor(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
		Cuenta.menu = new MenuDeConsola(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new iniciarSesion(), new registrar(), 
				  		new buscarProducto(), new buscarCategoria(),new salir()})), this);
	}
	
	public Vendedor() {
		super();
	}

	public static void subirProducto(Vendedor vendedor, String nombreProducto, String categoria, double precio, int cantidad) {
		Producto p = new Producto(vendedor, precio, cantidad, nombreProducto, categoria);
		catalogo.put(p.getCodigoProducto(), p);
	}

	public static void cambiarPrecio(String nombre, double precio) {
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getNombreProducto() == nombre) {
				mens = p;
				break;
			}
		}
		mens.setPrecio(precio);
	}
	
	public static void aumentarCantidad(String nombre, int aumento) {
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getNombreProducto() == nombre) {
				mens = p;
				break;
			}
		}
		mens.setCantidad(mens.getCantidad() + aumento);
	}
	
/*	public static void AumentarCantidad(int codigo, int aumento) {
		Producto P = null;
		P = Vendedor.catalogo.get(codigo);
		if(P!=null) {
			P.setCantidad(P.getCantidad() + aumento);
		}
	}
*/
}