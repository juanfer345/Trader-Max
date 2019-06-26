package uiMain.Funcionalidades;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;

public class MostrarCatalogo extends OpcionDeMenu{
	//Recorre toda la tabla Hash mostrando los productos

	@Override
	public void ejecutar() {
		System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
	}

	@Override
	public String toString() {
		return "Mostrar todos los productos.";
	}

}
