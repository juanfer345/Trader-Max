package uiMain.Funcionalidades.Cuenta.Comprador;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class BorrarHistorial extends OpcionDeMenu { // opcion 5

	public void ejecutar() {
		Comprador x = (Comprador) InicializacionAplicacion.usuarioActivo;
		String str = x.borrarHistorial();
		System.out.println(str);
	}

	public String toString() {
		return "Borrar Historial";
	}

}