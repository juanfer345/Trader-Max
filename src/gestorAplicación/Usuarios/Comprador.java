package gestorAplicaci�n.Usuarios;

import java.util.HashMap;

import gestorAplicaci�n.Materiales.Producto;

class Comprador extends Cuenta {
	private HashMap<Integer, Producto> historial = new HashMap<>();

	public void agregarACarrito(Producto producto) {
		// pendiente
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