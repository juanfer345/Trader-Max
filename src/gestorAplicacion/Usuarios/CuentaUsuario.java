package gestorAplicacion.Usuarios;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.CuentaBancaria;
import uiMain.OpcionDeMenu;

abstract public class CuentaUsuario extends Cuenta {

	private CuentaBancaria cuentaBancaria;

	public CuentaUsuario(String nombre, String correo, String password, int cedula) {
		//Cambiar, para que use el super()
		super(nombre, correo, password, cedula);
		cuentaBancaria = new CuentaBancaria(1000000, this);
	}
	
	public CuentaUsuario() {
		totalCuentas++;
	}
	
	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	// Método para cerrar sesión
	public String cerrarSesion(byte seleccion) {
		if (seleccion == 1) {
			InicializacionAplicacion.usuarioActivo = new Visitante();
			OpcionDeMenu.controlError = true;
			return "\nSe ha cerrado sesión correctamente mijin\n";
		} else if (seleccion == 2) {
			OpcionDeMenu.controlError = true;
			return "";
		} else {
			OpcionDeMenu.controlError = false;
			return "\nPor favor ingrese un número válido\n";
		}
	}

	@Override
	public String toString() {
		return super.toString() + ", cuentaBancaria=" + cuentaBancaria;
	}
}