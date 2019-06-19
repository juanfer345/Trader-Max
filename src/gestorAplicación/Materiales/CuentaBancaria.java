package gestorAplicación.Materiales;

import gestorAplicación.Usuarios.Cuenta;

public class CuentaBancaria {
    private double saldo;
    private int id;
    private String propietario;
    
    public CuentaBancaria(Cuenta cuenta) {
    	this(0, cuenta);
    }
    
    public CuentaBancaria(int saldo,Cuenta cuenta) { //Si es vendedor o comprador al aceptarlo como un objeto cuenta, me puedo referir normalmente a sus atributos?
    	this.saldo=saldo;
    	this.id=cuenta.getId();
    	this.propietario=cuenta.getNombre();
    }

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
