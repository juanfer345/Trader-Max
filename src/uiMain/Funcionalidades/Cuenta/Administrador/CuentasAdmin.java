package uiMain.Funcionalidades.Cuenta.Administrador;

import gestorAplicacion.Usuarios.Administrador;
import uiMain.OpcionDeMenu;

public class CuentasAdmin extends OpcionDeMenu { // opcion 15

	@Override
	public void ejecutar() {//sera que esto va en la logica?
		String cuentas = Administrador.numeroCuentas();
		System.out.println(cuentas);
	}

	@Override
	public String toString() {
		return "Numero de cuentas ";
	}
}