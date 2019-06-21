package gestorAplicación.Usuarios;

import java.util.LinkedList;
import gestorAplicación.Materiales.Producto;

public class Vendedor extends Cuenta {

	public static LinkedList<Producto> catalogo = new LinkedList<>();

	public Vendedor(String nombre, String correo, String password, String cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		this.id = contador++;
	}
	
	public Vendedor() {
		
	}

	public void subirProducto(Producto p) {
		catalogo.add(p);
	}
    
	public LinkedList<Producto> verProductos() {
		return Vendedor.catalogo;
	}
}