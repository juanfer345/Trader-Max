package gestorAplicación.Usuarios;

import java.util.HashMap;
import java.util.Map;

import gestorAplicación.Materiales.CuentaBancaria;
import gestorAplicación.Materiales.Producto;

public class CuentaUsuarios extends Cuenta {

	private CuentaBancaria cuentaBancaria;
	public static HashMap<Integer, Producto> catalogo = new HashMap<>();
	
	public CuentaUsuarios(String nombre, String correo, String password, String cedula){
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		this.id = contador++;
		totalCuentas++;
	}
	
	public CuentaUsuarios() {
		totalCuentas++;
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public HashMap<Integer, Producto> getCatalogo() {
		return catalogo;
	}

	public double obtenerPrecio(String nombre) {
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getNombreProducto() == nombre) {
				mens = p;
			}
		}
		return mens.getPrecio();
	}
}
