package gestorAplicacion.Usuarios;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.CuentaBancaria;
import uiMain.OpcionDeMenu;

abstract public class CuentaUsuario extends Cuenta {

	private CuentaBancaria cuentaBancaria;

	public CuentaUsuario(String nombre, String correo, String password, int cedula) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setCedula(cedula);
		this.id = contador++;
		totalCuentas++;
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

	// M�todo para cerrar sesi�n
	public String cerrarSesion(byte seleccion) {
		if (seleccion == 1) {
			InicializacionAplicacion.usuarioActivo = new Visitante();
			OpcionDeMenu.controlError = true;
			return "\nSe ha cerrado sesi�n correctamente mijin\n";
		} else if (seleccion == 2) {
			OpcionDeMenu.controlError = true;
			return "";
		} else {
			OpcionDeMenu.controlError = false;
			return "\nPor favor ingrese un n�mero v�lido\n";
		}
	}

	@Override
	public String toString() {
		return super.toString() + ", cuentaBancaria=" + cuentaBancaria;
	}
}