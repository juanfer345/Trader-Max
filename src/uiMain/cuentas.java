package uiMain;

import gestorAplicación.Usuarios.Administrador;

class cuentas extends OpcionDeMenu { // opcion 15

	@Override
	public void ejecutar() {
		Administrador.getNumeroCuentas();

	}

	@Override
	public String toString() {
		return "Numero de cuentas ";
	}

}