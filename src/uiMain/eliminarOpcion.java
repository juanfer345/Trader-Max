package uiMain;


class eliminarOpcion extends OpcionDeMenu { // opci gestorAplicación.Usuarios.Vendedoron 12
	@Override
	public void ejecutar() {
		for (int i = 0; i < activo.size(); i++) {
			System.out.println(activo.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int Aeliminar = scn.nextInt();
		activo.remove(Aeliminar);
	}

	@Override
	public String toString() {
		return "Eliminar opción";
	}

}