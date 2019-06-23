package uiMain;


class eliminarOpcion extends OpcionDeMenu { // opci gestorAplicación.Usuarios.Vendedoron 12
	@Override
	public void ejecutar() {
		for (int i = 0; i < opciones.size(); i++) {
			System.out.println(opciones.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int Aeliminar = e.nextInt();
		activo.remove(Aeliminar);
	}

	@Override
	public String toString() {
		return "Eliminar opción";
	}

}