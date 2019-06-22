package gestorAplicación.Usuarios;

import java.util.HashMap;
import java.util.LinkedList;
import gestorAplicación.Materiales.Producto;

public class Vendedor extends Cuenta {
    public static HashMap <Integer, Producto> catalogo = new HashMap<>();
	//public static LinkedList<Producto> catalogo = new LinkedList<>();

	public Vendedor(String nombre, String correo, String password, String cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		this.id = contador++;
		totalCuentas++;
	}
	
	public Vendedor() {
		totalCuentas++;
	}

	public void subirProducto(Producto p) {
		catalogo.add(p);
	}
    
	public LinkedList<Producto> verProductos() {
		return Vendedor.catalogo;
	}
}