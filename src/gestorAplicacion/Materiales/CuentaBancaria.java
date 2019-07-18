package gestorAplicacion.Materiales;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.*;

public class CuentaBancaria {
	private double saldo;
	private int id;
	private CuentaConBanco propietario;
	private static int contador;
	
	//Constructor para usuarios existentes	
	public CuentaBancaria(int id, double saldo) {
		this.saldo = saldo;
		this.id = id;
	}
	
	//Constructor para usuarios nuevos
	public CuentaBancaria(double saldo, CuentaConBanco cuenta) {
		this.saldo = saldo;
		this.id = contador++;
		this.propietario = cuenta;
		InicializacionAplicacion.getBDCuentasBancarias().put(id, this);
	}
	
	public double Transaccion(CuentaBancaria cb1, CuentaBancaria cb2, double precio) {
		cb2.setSaldo(cb2.getSaldo() + precio);
		cb1.setSaldo(cb1.getSaldo() - precio);
		return cb1.getSaldo();
	}

	public double getSaldo() {return saldo;}
	public void setSaldo(double saldo) {this.saldo = saldo;}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public CuentaConBanco getPropietario() {return propietario;}
	public void setPropietario(CuentaConBanco propietario) {this.propietario = propietario;}
	
	public static void setMaxID(int contador) {
		CuentaBancaria.contador = contador + 1;
	}
}