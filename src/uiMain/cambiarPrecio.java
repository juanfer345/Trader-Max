package uiMain;

import gestorAplicación.Usuarios.Vendedor;

class cambiarPrecio extends OpcionDeMenu {

	public void ejecutar() {
		System.out.println("Ingrese el nombre del producto");
		String nom = e.next();
		System.out.println("Ingrese el nuevo precio");
		double pre = e.nextDouble();
		Vendedor.cambiarPrecio(nom, pre);
		
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}

}
