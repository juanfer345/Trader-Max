package uiMain.Funcionalidades;

import java.util.Map;
import uiMain.*;
import gestorAplicación.Materiales.Producto;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.CuentaUsuarios;

class mostrarHistorial extends OpcionDeMenu { // opcion 6

	@Override
	public void ejecutar() {//esto se pasa a la logica
		Comprador comp = (Comprador) usuario;
		for (Map.Entry<Integer, Producto> entry : comp.getHistorial().entrySet()) {
			Producto P = entry.getValue();
			System.out.println(P);
		}//comprobar si se borra el comp		
		}	
	@Override
	public String toString() {
		return "Mostrar historial";
	}

}
