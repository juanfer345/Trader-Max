package gestorAplicación.Usuarios;


public abstract class Cuenta {
	
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

}
