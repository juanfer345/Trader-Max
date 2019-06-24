package uiMain.Funcionalidades;

import java.util.Map;
import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.CuentaUsuarios;
import uiMain.OpcionDeMenu;

public class mostrarProductos extends OpcionDeMenu{
	//Recorre toda la tabla Hash mostrando los productos

	@Override
	public void ejecutar() { //esto lo tienen que pasar a la logica
		for (Map.Entry<Integer, Producto> entry : CuentaUsuarios.catalogo.entrySet()) {
			Producto P = entry.getValue();
			System.out.println(P);
		}
	}

	@Override
	public String toString() {
		return "Mostrar Productos";
	}

}
