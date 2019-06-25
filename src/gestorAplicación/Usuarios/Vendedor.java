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

	public static void subirProducto(Vendedor vendedor, String nombreProducto, String categoria, double precio,
			int cantidad) {
		Producto p = new Producto(vendedor, precio, cantidad, nombreProducto, categoria);
		catalogo.put(p.getCodigoProducto(), p);
	}

	public static String cambiarPrecio(String nombre, double precio) {
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getNombreProducto() == nombre) {
				mens = p;
				break;
			}
		}
		if (mens == null) {
			return "El producto no existe, no se puede cambiar el precio";
		} else {
			mens.setPrecio(precio);
			return "Se ha cambiado el precio del producto: " + mens.getNombreProducto() + ". Precio actual: "
					+ mens.getPrecio();
		}
	}

	public static String aumentarCantidad(String nombre, int aumento) {
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getNombreProducto() == nombre) {
				mens = p;
				break;
			}
		}
		if (mens == null) {
			return "El producto no existe, no se puede aumentar la cantidad";
		} else {
			int can_final = mens.getCantidad() + aumento;
			mens.setCantidad(mens.getCantidad() + aumento);
			return "Se aumentó la cantidad del producto: " + mens.getNombreProducto() + "cantidad actual: " + can_final;
		}
	}

	public static String disminuirCantidad(String nombre, int resta) {
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getNombreProducto() == nombre) {
				mens = p;
				break;
			}
		}
		if (mens == null) {
			return "El producto no existe, no se puede disminuir la cantidad";
		} else {
			int can_final = mens.getCantidad() - resta;
			if (can_final >= 0) {
				mens.setCantidad(mens.getCantidad() - resta);
				return "Se redujo la cantidad del producto: " + mens.getNombreProducto() + "cantidad actual: "
						+ can_final;
			} else {
				return "No hay suficientes productos, no se puede disminuir su cantidad";
			}
		}
	}

	public String eliminarProductoCatalogo(int cod) {
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getCodigoProducto() == cod) {
				mens = p;
				break;
			}
		}
		if (mens == null) {
			return "No existe el producto";
		}else {
			int id = this.id;
			int id_mens = mens.getVendedor().getId();
			if(id == id_mens) {
				catalogo.remove(cod);
				return "Se eliminó el producto exitosamente";
			} else {
				return "No es un producto propio, no puede ser eliminado";
			}
		}
	}
	
	
}