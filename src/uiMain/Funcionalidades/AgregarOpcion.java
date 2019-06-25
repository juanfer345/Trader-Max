package uiMain.Funcionalidades;

import java.io.IOException;

import uiMain.OpcionDeMenu;

public class AgregarOpcion extends OpcionDeMenu { // opcion 13

	public void ejecutar() throws NumberFormatException, IOException {
		for (int i = 0; i < opcionesActivas.size(); i++) {
			System.out.println(opcionesActivas.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int agregar = Integer.parseInt(br.readLine().trim());
		opcionesActivas.add(opcionesActivas.get(agregar));

		//boolean b = activo.add(opciones.get(agregar));
		//if(b)
		//	System.out.println("Se agregó la opción exitosamente");
		//else
		//	System.out.println("No se pudo agregar la opción");
	}
	
	public String toString() {
		return "Agregar opción";
	}

}