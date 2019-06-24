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
		}
		else {
			mens.setPrecio(precio);
			return "Se ha cambiado el precio del producto: " + mens.getNombreProducto() +
					". Precio actual: " + mens.getPrecio();
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
		}
		else {
			int can_final = mens.getCantidad() + aumento;
			mens.setCantidad(mens.getCantidad() + aumento);
			return "Se aumentó la cantidad del producto: " + mens.getNombreProducto() +
					"cantidad actual: " + can_final;
		}
		
	}

	public String  eliminarProductoCatalogo(int prod) {
		
		(CuentaUsuarios.catalogo).forEach((k,v)->
		{
			if ((v.getCodigoProducto()==prod)) {
				catalogo.remove(k);
			}
		});
		return "Eliminó el producto exitosamente";
	}
	
}