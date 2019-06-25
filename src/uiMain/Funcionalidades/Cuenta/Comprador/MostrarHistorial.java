package uiMain.Funcionalidades.Cuenta.Comprador;

import java.util.Map;

import gestorAplicacion.Materiales.Producto;
import uiMain.*;
import gestorAplicacion.Usuarios.Comprador;

public class MostrarHistorial extends OpcionDeMenu { // opcion 6

	@Override
	public void ejecutar() {
		Comprador comp = (Comprador) MenuDeConsola.usuarioActivo;
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