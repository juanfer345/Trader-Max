package gestorAplicación.Materiales;

import gestorAplicación.Usuarios.Cuenta;

public class CuentaBancaria extends Cuenta {
    private double saldo;

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double Transaccion(CuentaBancaria cb1, CuentaBancaria cb2, double precio) {
		cb2.setSaldo(cb2.getSaldo()+precio);
		cb1.setSaldo(cb1.getSaldo()-precio);
		return cb1.getSaldo();
	}
    
}
