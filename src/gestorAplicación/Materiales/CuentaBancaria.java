package gestorAplicación.Materiales;

import gestorAplicación.Usuarios.*;

public class CuentaBancaria {
    private double saldo;
    private int id;
    private String propietario;
    
    public CuentaBancaria(Comprador cuenta) {
    	this(0, cuenta);
    }
    
    public CuentaBancaria(Vendedor cuenta) {
    	this(0, cuenta);
    }
    
    public CuentaBancaria(int saldo,Comprador cuenta) { 
    	this.saldo=saldo;
    	this.id=cuenta.getId();
    	this.propietario=cuenta.getNombre();
    }
    
    public CuentaBancaria(int saldo,Vendedor cuenta) { 
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
