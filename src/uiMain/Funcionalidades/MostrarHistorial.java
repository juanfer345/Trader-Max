package uiMain.Funcionalidades;

import java.util.Map;
import uiMain.*;
import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Comprador;

class MostrarHistorial extends OpcionDeMenu { // opcion 6

	@Override
	public void ejecutar() {
		Comprador comp = (Comprador) usuario;
		for (Map.Entry<Integer, Producto> entry : comp.getHistorial().entrySet()) {
			Producto P = entry.getValue();
			System.out.println(P);
		}
		comp = null;//comprobar si se borra el comp		
		}	
	@Override
	public String toString() {
		return "Mostrar historial";
	}

}
