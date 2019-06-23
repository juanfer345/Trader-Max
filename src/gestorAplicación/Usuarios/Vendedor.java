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

}