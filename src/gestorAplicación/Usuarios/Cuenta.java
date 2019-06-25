package gestorAplicación.Usuarios;

import java.util.ArrayList;

import gestorAplicación.Materiales.Producto;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public abstract class Cuenta {
	
	protected static MenuDeConsola menu;
	private String nombre, correo, password;
	public int id;
	private int cedula;
	static protected int contador;
	static int totalCuentas;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCedula() {
		return cedula;
	}
	
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void borrarHistorial() {
		//Para poder llamar al metodo borrarHistorial desde el apuntador Cuenta
	}
	
	public void agregarACarrito(Producto p) {
		//Para poder llamar al metodo agregarACarrito desde el apuntador Cuenta
	}

	abstract void setMenuPredeterminado();
	abstract void setMenu(ArrayList <OpcionDeMenu> opcionesActivas);
}