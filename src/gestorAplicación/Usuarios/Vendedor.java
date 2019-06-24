package gestorAplicación.Usuarios;

import java.util.Map;
import gestorAplicación.Materiales.Producto;

public class Vendedor extends CuentaUsuarios {

	public Vendedor(String nombre, String correo, String password, String cedula) {
		super(nombre, correo, password, cedula);
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