package gestorAplicacion.Materiales;

import gestorAplicacion.Usuarios.*;

public class CuentaBancaria {
	private double saldo;
	private int id;		// El id de cuenta bancaria si debería ser el mismo del usuario??
	private CuentaUsuario propietario;

	public CuentaBancaria(Comprador cuenta) {
		this(0, cuenta);
	}

	public CuentaBancaria(Vendedor cuenta) {
		this(0, cuenta);
	}

	public CuentaBancaria(int saldo, CuentaUsuario cuenta) {
		this.saldo = saldo;
		this.id = cuenta.getId();
		this.propietario = cuenta;
	}

	// Se necesita el constructor por default para la BD (Juanfer)
	public CuentaBancaria() {}

	public double getSaldo() {return saldo;	}

	public void setSaldo(double saldo) {this.saldo = saldo;}

	public double Transaccion(CuentaBancaria cb1, CuentaBancaria cb2, double precio) {
		cb2.setSaldo(cb2.getSaldo() + precio);
		cb1.setSaldo(cb1.getSaldo() - precio);
		return cb1.getSaldo();
	}

	// Generado los set y get de ID y propietario para la base de datos (Juanfer)
	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public CuentaUsuario getPropietario() {return propietario;}

	public void setPropietario(CuentaUsuario propietario) {this.propietario = propietario;}
}