package gestorAplicación.Usuarios;

import gestorAplicación.Materiales.CuentaBancaria;

public class Cuenta {
    private CuentaBancaria cuentaBancaria; //otra variable de # usuarios registrados para usar el satatic?
    private String nombre, correo, password; //Y si creamos una variable edad?
    private int id; //Como añadirle el final a id?
    private int cedula; //Y si se pone cedula en CuentaBancaria?
    
	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}
	
	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
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

}


