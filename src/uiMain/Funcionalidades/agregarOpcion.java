package uiMain.Funcionalidades;

import uiMain.OpcionDeMenu;

public class agregarOpcion extends OpcionDeMenu { // opcion 13

	@Override
	public void ejecutar() {
		for (int i = 0; i < opciones.size(); i++) {
			System.out.println(opciones.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int agregar = scn.nextInt();
		activo.add(opciones.get(agregar));

	}
	@Override
	public String toString() {
		return "Agregar opción";
	}

}