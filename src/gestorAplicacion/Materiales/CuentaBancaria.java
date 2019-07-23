/*	Clase CuentaBancaria (pública)    
	
	Propósito: Guardar dinero que permita la compra y venta de productos en TraderMax
*/
 
package gestorAplicacion.Materiales;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.*;

public class CuentaBancaria {
	
	private double saldo;
	private int id;
	private CuentaConBanco propietario;
	private static int contador;
	
	public CuentaBancaria(int id, double saldo) {
	/*
		Propósito: Constructor de cuentas bancarias para usuarios existentes			
		           
		Variables de entrada:
		- int id: Identificación de la cuenta
		- double saldo: Dinero que se le asigna a la cuenta
    */
		this.saldo = saldo;
		this.id = id;
	}
	
	public CuentaBancaria(double saldo, CuentaConBanco cuenta) {
	/*
		Propósito: Constructor de cuentas bancarias para usuarios nuevos		
		           
		Variables de entrada:
		- double saldo: Dinero que se le asigna a la cuenta 
		- CuentaConBanco cuenta: Usuario al cual se vincula la cuenta bancaria {Comprador, Vendedor}

    */
		this.saldo = saldo;
		this.id = contador++;
		this.propietario = cuenta;
		InicializacionAplicacion.getBDCuentasBancarias().put(id, this);
	}
	
	public void Transaccion(CuentaConBanco cuentaDestino, double valor) {
		/*
			Propósito: Realizar la transacción de dinero de una cuenta a otra cuando se haya  
			           comprado un producto
	
			Variables de entrada:
			- CuentaBancaria cuentaDestino: Cuenta bancaria del usuario que recibe el dinero
			- double precio: Valor de la transacción, precio del producto
		 */

		cuentaDestino.getCuentaBancaria().setSaldo(cuentaDestino.getCuentaBancaria().getSaldo() + valor);
		this.setSaldo(saldo - valor);
	}

	// Devuelve el saldo actual de la cuenta bancaria
	public double getSaldo() {return saldo;}
	
	// Cambio en el saldo de la cuenta bancaria
	public void setSaldo(double saldo) {this.saldo = saldo;}
	
	// Devuelve identificador de la cuenta bancaria
	public int getId() {return id;}
	
	//Cambio identificador de la cuenta bancaria
	public void setId(int id) {this.id = id;}

	// Devuelve el propietario de la cuenta (Que será tipo Comprador o Vendedor)
	public CuentaConBanco getPropietario() {return propietario;}
	
	// Cambio de propietario de la cuenta bancaria
	public void setPropietario(CuentaConBanco propietario) {this.propietario = propietario;}
	
	public static void setMaxID(int contador) {
		CuentaBancaria.contador = contador + 1;
	}
}