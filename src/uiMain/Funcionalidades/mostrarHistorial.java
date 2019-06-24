package uiMain.Funcionalidades;

import java.util.Map;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.CuentaUsuarios;
import uiMain.OpcionDeMenu;

public class mostrarHistorial extends OpcionDeMenu { // opcion 6

	@Override
	public void ejecutar() {
		for (Map.Entry<Integer, Producto> entry : Comprador.historial/*Comprador.getHistorial()*/.entrySet()) {
			Producto P = entry.getValue();
			System.out.println(P);
		}
	}

	@Override
	public String toString() {
		return "Mostrar historial";
	}

}
