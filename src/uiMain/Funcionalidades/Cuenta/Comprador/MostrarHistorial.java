package uiMain.Funcionalidades.Cuenta.Comprador;

import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class MostrarHistorial extends OpcionDeMenu { // opcion 6

	@Override
	public void ejecutar() {
		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
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