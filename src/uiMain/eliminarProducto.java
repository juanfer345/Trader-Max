package uiMain;


class eliminarProducto extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el código del producto a eliminar ");
		int cod = e.nextInt();

	}

	@Override
	public String toString() {
		return "Eliminar producto";
	}

}