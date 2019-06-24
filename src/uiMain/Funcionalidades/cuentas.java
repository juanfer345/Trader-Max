package uiMain.Funcionalidades;

import gestorAplicación.Usuarios.Administrador;
import uiMain.OpcionDeMenu;

public class cuentas extends OpcionDeMenu { // opcion 15

	@Override
	public void ejecutar() {//sera que esto va en la logica?
		int cuentas =Administrador.getNumeroCuentas();
		System.out.println("Actualmente hay "+cuentas+" cuentas");
	}

	@Override
	public String toString() {
		return "Numero de cuentas ";
	}

}