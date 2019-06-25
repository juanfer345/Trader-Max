package uiMain.Funcionalidades;

import java.util.Map;

import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.CuentaUsuario;
import uiMain.OpcionDeMenu;

public class MostrarCatalogo extends OpcionDeMenu{
	//Recorre toda la tabla Hash mostrando los productos

	@Override
	public void ejecutar() {
		for (Map.Entry<Integer, Producto> entry : CuentaUsuario.catalogo.entrySet()) {
			Producto P = entry.getValue();
			System.out.println(P);
		}
	}

	@Override
	public String toString() {
		return "Mostrar Productos";
	}

}
