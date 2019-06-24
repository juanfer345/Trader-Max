package uiMain;


class quitarProducto extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() {
		System.out.println("Ingresa el código del producto: ");
		int cod = scn.nextInt();
		//usuario.CarritoDeCompras.quitarProducto(cod);
	}
	@Override
	public String toString() {
		return "Quitar Producto del carrito";
	}
}