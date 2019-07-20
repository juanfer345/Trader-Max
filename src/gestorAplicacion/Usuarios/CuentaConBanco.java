/* 
   Clase CuentaConBanco (pública abstracta, hereda de CuentaUsuario)
   
   Propósito:
   Se liga la Cuenta Bancaria con la Cuenta
   
   Estructuras de datos relevantes:
 */

package gestorAplicacion.Usuarios;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.CuentaBancaria;

public abstract class CuentaConBanco extends CuentaUsuario {

	// Atributos
	private CuentaBancaria cuentaBancaria;

	// Constructor para usuarios existentes (Llama al super)
	public CuentaConBanco(int idCuenta, String nombre, String correo, String password, int cedula) {
		super(idCuenta, nombre, correo, password, cedula);
	}

	// Constructor para usuarios nuevos (Llama al super)
	public CuentaConBanco(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
		cuentaBancaria = new CuentaBancaria(10000000, this);
	}

	// Constructor para usuarios con dos cuentas (Llama al super)
	public CuentaConBanco(String nombre, String correo, String password, int cedula, int idCuentaBancaria) {
		super(nombre, correo, password, cedula);
		cuentaBancaria = InicializacionAplicacion.getBDCuentasBancarias().get(idCuentaBancaria);
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	@Override
	public String toString() {
		return super.toString() + ", cuentaBancaria=" + cuentaBancaria.getId();
	}
}