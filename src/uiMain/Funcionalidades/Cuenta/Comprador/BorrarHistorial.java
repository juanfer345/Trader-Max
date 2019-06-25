package uiMain.Funcionalidades.Cuenta.Comprador;

import gestorAplicacion.Usuarios.Comprador;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class BorrarHistorial extends OpcionDeMenu { // opcion 5

	public void ejecutar() {
		Comprador x = (Comprador) MenuDeConsola.usuarioActivo;
		String str = x.borrarHistorial();
		System.out.println(str);
	}

	public String toString() {
		return "Borrar Historial";
	}

}