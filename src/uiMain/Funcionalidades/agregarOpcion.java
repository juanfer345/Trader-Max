package uiMain.Funcionalidades;

import java.io.IOException;

import uiMain.OpcionDeMenu;

public class agregarOpcion extends OpcionDeMenu { // opcion 13

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		for (int i = 0; i < opcionesActivas.size(); i++) {
			System.out.println(opcionesActivas.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int agregar = Integer.parseInt(br.readLine().trim());
		opcionesActivas.add(opcionesActivas.get(agregar));

	}
	@Override
	public String toString() {
		return "Agregar opción";
	}

}