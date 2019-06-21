package gestorAplicación.Usuarios;

import java.util.HashMap;

import gestorAplicación.Materiales.Producto;

public class Vendedor extends Cuenta{
    
    public static HashMap <Integer, Producto> catalogo = new HashMap <> ();

    public Vendedor(String nombre, String correo, String password, String cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		this.setId(contador++);
	}
    
	// Se necesita el constructor por default para la BD (Juanfer)
	public Vendedor() {
		// TODO Auto-generated constructor stub
	}
}