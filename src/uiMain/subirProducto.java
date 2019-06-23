package uiMain;


class subirProducto extends OpcionDeMenu { // opcion 11

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el nombre del producto");
		String nombre = e.next();
		System.out.println("Ingrese la cantidad ");
		int cant = e.nextInt();
		System.out.println("Ingrese el precio ");
		double precio = e.nextDouble();
		//hay que esperar a que sara y juan manuel resuelvan las categorias

	}

	@Override
	public String toString() {
		return "Subir producto";
	}

}