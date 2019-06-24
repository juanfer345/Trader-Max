package uiMain;


class subirProducto extends OpcionDeMenu { // opcion 11

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el nombre del producto");
		String nombre = scn.next();
		System.out.println("Ingrese la cantidad ");
		int cant = scn.nextInt();
		System.out.println("Ingrese el precio ");
		double precio = scn.nextDouble();
		//hay que esperar a que sara y juan manuel resuelvan las categorias

	}

	@Override
	public String toString() {
		return "Subir producto";
	}

}