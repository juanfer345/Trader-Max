package uiMain.MenuConsola.Cuenta.Administrador;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.OpcionDeMenu;

public class CuentasAdmin extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		System.out.println(((Administrador) InicializacionAplicacion.usuarioActivo).numeroCuentas());
	}

	@Override
	public String toString() {return "Numero de cuentas";}
}