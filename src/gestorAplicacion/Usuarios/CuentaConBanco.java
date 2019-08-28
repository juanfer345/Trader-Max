/* 
   Clase CuentaConBanco (pública abstracta, hereda de CuentaUsuario)

   Propósito:
   Se liga la Cuenta Bancaria con la Cuenta

   Estructuras de datos relevantes:
 */

package gestorAplicacion.Usuarios;

import gestorAplicacion.Materiales.CuentaBancaria;
import uiMain.InicializacionAplicacion;

public abstract class CuentaConBanco extends CuentaUsuario {

	// Atributos
	private CuentaBancaria cuentaBancaria;

	// Constructor para usuarios existentes (Llama al super)
	public CuentaConBanco(int idCuenta, String nombre, String correo, String password, int cedula, boolean activa) {
		super(idCuenta, nombre, correo, password, cedula, activa);
	}

	// Constructor para usuarios nuevos (Llama al super)
	public CuentaConBanco(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
		cuentaBancaria = new CuentaBancaria(10000000, this);
	}

	// Constructor para usuarios con dos cuentas (Llama al super)
	public CuentaConBanco(int idCuenta, String nombre, String correo, String password, int cedula, int idCuentaBancaria) {
		super(idCuenta, nombre, correo, password, cedula, true);
		setMenuPredeterminado();
		cuentaBancaria = InicializacionAplicacion.getBDCuentasBancarias().get(idCuentaBancaria);
	}

	//Constructor vacío
	public CuentaConBanco() {}

	public CuentaBancaria getCuentaBancaria() {return cuentaBancaria;}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {this.cuentaBancaria = cuentaBancaria;}

	@Override
	public String toString() {
		return super.toString() + ", Código cuenta bancaria: " + cuentaBancaria.getId();
	}
}