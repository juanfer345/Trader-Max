package gestorAplicaci�n.Usuarios;

import java.util.HashMap;
import gestorAplicaci�n.Materiales.CarritoDeCompras;
import gestorAplicaci�n.Materiales.Producto;

public class Comprador extends Cuenta {

	public CarritoDeCompras carrito;
	private HashMap<Integer, Producto> historial = new HashMap<>();

	public void agregarACarrito(Producto producto) {
		if (producto.getCantidad() > 0) {
			carrito.productos.add(producto);
		}
	}

	public void buscarProducto(int codigoProducto) {

		Producto resultado;

		resultado = Vendedor.catalogo.get(codigoProducto);

		// rutina de impresi�n del resultado encontrado
	}

	public void buscarCategoria(String categoria) {
		// pendiente
	}

	public void borrarHistorial() {
		historial.clear();
	}

	public void mostrarHistorial() {
		// rutina de impresi�n
	}
}